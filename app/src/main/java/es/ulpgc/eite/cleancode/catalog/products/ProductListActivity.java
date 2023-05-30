package es.ulpgc.eite.cleancode.catalog.products;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.favourites.FavouriteListActivity;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailActivity;


public class ProductListActivity
    extends AppCompatActivity implements ProductListContract.View {

  public static String TAG = ProductListActivity.class.getSimpleName();

  ProductListContract.Presenter presenter;

  private ImageView imgFavorite;
  private ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_list);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the title in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(getString(R.string.title_product_list));
    }

    imgFavorite = (ImageView) findViewById(R.id.fav_btn);
    listView = findViewById(R.id.product_list);

    imgFavorite.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateToFavouritesScreen();
      }
    });

    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

    // do the setup
    ProductListScreen.configure(this);

    // do some work
    presenter.fetchProductListData();
  }

  public void navigateToFavouritesScreen() {
    Intent intent = new Intent(this, FavouriteListActivity.class);
    startActivity(intent);
  }
  @Override
  public void navigateToProductDetailScreen() {
    Intent intent = new Intent(this, ProductDetailActivity.class);
    startActivity(intent);
  }

  @Override
  public void displayProductListData(ProductListViewModel viewModel) {
    Log.e(TAG, "displayProductListData()");

    // deal with the data
    listView.setAdapter(new ProductListAdapter(
            this, viewModel.products, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            ProductItem item = (ProductItem) view.getTag();
            presenter.selectProductListData(item);
          }
        })
    );

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      NavUtils.navigateUpFromSameTask(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }


  @Override
  public void injectPresenter(ProductListContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
