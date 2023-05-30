package es.ulpgc.eite.cleancode.catalog.product;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;


public class ProductDetailPresenter implements ProductDetailContract.Presenter {

  public static String TAG = ProductDetailPresenter.class.getSimpleName();

  private WeakReference<ProductDetailContract.View> view;
  private ProductDetailState state;
  private ProductDetailContract.Model model;
  //private ProductDetailContract.Router router;
  private CatalogMediator mediator;

  public ProductDetailPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getProductDetailState();
  }

//  public ProductDetailPresenter(ProductDetailState state) {
//    this.state = state;
//  }

  @Override
  public void injectView(WeakReference<ProductDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductDetailContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(ProductDetailContract.Router router) {
//    this.router = router;
//  }

  private Integer getDataFromProductListScreen() {
    Integer productId = mediator.getProductId();
    return productId;
  }

  @Override
  public void fetchProductDetailData() {
    Log.e(TAG, "fetchProductDetailData()");

    // set passed state
    Integer productId = getDataFromProductListScreen();

    model.getFinancialAsset(new RepositoryContract.GetFinancialAssetCallback() {
      @Override
      public void setFinancialAsset(ProductItem asset) {
        state.product = asset;
        view.get().displayProductDetailData(state);
      }
    }, productId);
  }

}
