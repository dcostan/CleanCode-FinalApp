package es.ulpgc.eite.cleancode.financialassets.favourites;

import android.util.Log;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;

public class FavouriteListModel implements FavouriteListContract.Model {

  public static String TAG = FavouriteListModel.class.getSimpleName();

  private RepositoryContract repository;

  public FavouriteListModel(RepositoryContract repository) {
    this.repository = repository;
  }
  @Override
  public void fetchFavouriteAssetsList(RepositoryContract.GetFavouriteAssetsListCallback callback) {
    Log.e(TAG, "fetchFinancialAssetsList()");
    repository.getFavouriteAssetsList(callback);
  }

}
