package es.ulpgc.eite.cleancode.catalog.data;

import java.util.List;

public interface RepositoryContract {
  interface FetchCatalogDataCallback {
    void onCatalogDataFetched(boolean error);
  }
  interface GetFinancialAssetsListCallback {
    void setFinancialAssetsList(List<ProductItem> assets);
  }
  interface GetFavouriteAssetsListCallback {
    void setFavouriteAssetsList(List<ProductItem> assets);
  }
  interface GetFinancialAssetCallback {
    void setFinancialAsset(ProductItem asset);
  }
  interface SetFavouriteCallback {
    void onFavouriteSetted(boolean error);
  }
  void loadCatalog(RepositoryContract.FetchCatalogDataCallback callback);
  void getFinancialAssetsList(RepositoryContract.GetFinancialAssetsListCallback callback);
  void getFavouriteAssetsList(RepositoryContract.GetFavouriteAssetsListCallback callback);
  void getFinancialAsset(RepositoryContract.GetFinancialAssetCallback callback, int id);
  void setFavourite(RepositoryContract.SetFavouriteCallback callback, int id, boolean favourite);
}
