package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

interface ProductDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductDetailData(ProductDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchProductDetailData();
  }

  interface Model {
    void getFinancialAsset(RepositoryContract.GetFinancialAssetCallback callback, int id);
  }

//  interface Router {
//
//    //ProductItem getDataFromProductListScreen();
//    Integer getDataFromProductListScreen();
//  }
}