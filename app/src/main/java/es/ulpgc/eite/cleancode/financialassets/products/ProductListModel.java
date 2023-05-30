package es.ulpgc.eite.cleancode.financialassets.products;

import android.util.Log;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;

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
  }

}
