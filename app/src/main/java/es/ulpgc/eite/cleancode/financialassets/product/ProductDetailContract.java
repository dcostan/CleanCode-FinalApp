package es.ulpgc.eite.cleancode.financialassets.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;

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
    void setFavouriteClicked();
  }

  interface Model {
    void getFinancialAsset(RepositoryContract.GetFinancialAssetCallback callback, int id);
    void setFavourite(RepositoryContract.SetFavouriteCallback callback, String username, int prodId, boolean favourite);
  }

//  interface Router {
//
//    //ProductItem getDataFromProductListScreen();
//    Integer getDataFromProductListScreen();
//  }
}