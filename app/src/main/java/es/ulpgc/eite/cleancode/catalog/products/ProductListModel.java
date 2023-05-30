package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  private RepositoryContract repository;

  public ProductListModel(RepositoryContract repository) {
    this.repository = repository;
  }
  @Override
  public void fetchFinancialAssetsList(final RepositoryContract.GetFinancialAssetsListCallback callback) {
    Log.e(TAG, "fetchFinancialAssetsList()");
    repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {
      @Override
      public void onCatalogDataFetched(boolean error) {
        if(!error)
          repository.getFinancialAssetsList(callback);
      }
    });

    repository.setFavourite(new RepositoryContract.SetFavouriteCallback() {
      @Override
      public void onFavouriteSetted(boolean error) {
        Log.e(TAG, "Fav error: " + Boolean.toString(error));
      }
    }, 2, true);
  }

}
