package es.ulpgc.eite.cleancode.financialassets.data;

import java.util.List;

public interface RepositoryContract {
  interface CheckUserCallback {
    void onUserChecked(boolean valid);
  }
  interface AddUserCallBack {
    void onUserCreated();
  }
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
  void checkUser(RepositoryContract.CheckUserCallback callback, UserItem user);
  void addUser(RepositoryContract.AddUserCallBack callback, UserItem user);
  void loadCatalog(RepositoryContract.FetchCatalogDataCallback callback);
  void getFinancialAssetsList(RepositoryContract.GetFinancialAssetsListCallback callback);
  void getFavouriteAssetsList(RepositoryContract.GetFavouriteAssetsListCallback callback, String username);
  void getFinancialAsset(RepositoryContract.GetFinancialAssetCallback callback, String username, int id);
  void setFavourite(RepositoryContract.SetFavouriteCallback callback, String username, int prodId, boolean favourite);
}
