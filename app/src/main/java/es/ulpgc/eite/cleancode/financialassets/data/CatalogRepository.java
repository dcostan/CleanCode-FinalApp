package es.ulpgc.eite.cleancode.financialassets.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.eite.cleancode.financialassets.database.CatalogDatabase;
import es.ulpgc.eite.cleancode.financialassets.database.UserProductJoinDao;


public class CatalogRepository implements RepositoryContract {

  public static String TAG = CatalogRepository.class.getSimpleName();
  private static CatalogRepository INSTANCE;


  public static final String DB_FILE = "catalog.db";
  public static final String JSON_FILE = "assets.json";
  public static final String JSON_ROOT = "assets";

  private CatalogDatabase database;
  private Context context;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new CatalogRepository(context);
    }

    return INSTANCE;
  }


  private CatalogRepository(Context context) {
    // Costruttore
    this.context = context;
    database = Room.databaseBuilder(
            context, CatalogDatabase.class, DB_FILE
    ).build();
  }

  @Override
  public void checkUser(final CheckUserCallback callback, UserItem user) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        UserItem dbUser = database.userDao().loadUser(user.username);
        if(dbUser != null && user.password.equals(dbUser.password))
          callback.onUserChecked(true);
        else
          callback.onUserChecked(false);
      }
    });
  }

  @Override
  public void addUser(final AddUserCallBack callback, UserItem user) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        database.userDao().addUser(user);
        callback.onUserCreated();
      }
    });
  }

  @Override
  public void loadCatalog(final FetchCatalogDataCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {

        boolean error = false;
        // Verifichiamo se il database contiene prodotti
        // Altrimenti li carichiamo dal JSON
        if(database.productDao().loadProducts().size() == 0 ) {
          error = !loadAssetsFromJSON(loadJSON());
        }

        if(callback != null) {
          callback.onCatalogDataFetched(error);
        }
      }
    });

  }

  public void getFinancialAssetsList(final RepositoryContract.GetFinancialAssetsListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        callback.setFinancialAssetsList(database.productDao().loadProducts());
      }
    });
  }
  public void getFavouriteAssetsList(final RepositoryContract.GetFavouriteAssetsListCallback callback, String username) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        callback.setFavouriteAssetsList(database.userProductJoinDao().getFavouriteForUser(username));
      }
    });
  }
  public void getFinancialAsset(final RepositoryContract.GetFinancialAssetCallback callback, final String username, final int id) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        ProductItem asset = database.productDao().loadProduct(id);
        boolean favourite = database.userProductJoinDao().checkFavourite(username, id).size() > 0;
        asset.favourite = favourite;
        callback.setFinancialAsset(asset);
      }
    });
  }
  public void setFavourite(final RepositoryContract.SetFavouriteCallback callback, final String username, final int prodId, final boolean favourite) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        UserProductJoin upj = new UserProductJoin(username, prodId);
        if(favourite)
          database.userProductJoinDao().insert(upj);
        else
          database.userProductJoinDao().delete(upj);
        callback.onFavouriteSetted(false);
      }
    });
  }

  private boolean loadAssetsFromJSON(String json) {
    Log.e(TAG, "loadAssetsFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

      if (jsonArray.length() > 0) {

        final List<ProductItem> assetList = Arrays.asList(
                gson.fromJson(jsonArray.toString(), ProductItem[].class)
        );

        // Inseriamo gli asset nel database
        for (ProductItem asset: assetList) {
          database.productDao().insertProduct(asset);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  private String loadJSON() {
    Log.e(TAG, "loadJSON()");

    String json = null;

    try {

      InputStream is = context.getAssets().open(JSON_FILE);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");

    } catch (IOException error) {
      Log.e(TAG, "error: " + error);
    }

    return json;
  }


}