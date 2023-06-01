package es.ulpgc.eite.cleancode.financialassets.product;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;

public class ProductDetailModel implements ProductDetailContract.Model {

  public static String TAG = ProductDetailModel.class.getSimpleName();


  private RepositoryContract repository;

  /*
  public ProductDetailModel() {

  }
  */

  public ProductDetailModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void getFinancialAsset(RepositoryContract.GetFinancialAssetCallback callback, int id) {
    repository.getFinancialAsset(callback, id);
  }

  public void setFavourite(RepositoryContract.SetFavouriteCallback callback, String username, int prodId, boolean favourite) {
    repository.setFavourite(callback, username, prodId, favourite);
  }
}
