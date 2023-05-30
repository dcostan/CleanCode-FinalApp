package es.ulpgc.eite.cleancode.catalog.product;

import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

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
}
