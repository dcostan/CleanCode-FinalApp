package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

interface ProductListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductListData(ProductListViewModel viewModel);
    void navigateToProductDetailScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchProductListData();
    void selectProductListData(ProductItem item);
  }

  interface Model {
    void fetchFinancialAssetsList(RepositoryContract.GetFinancialAssetsListCallback callback);
  }

  /*
  interface Router {

    void navigateToProductDetailScreen();

    //void passDataToProductDetailScreen(ProductItem item);
    void passDataToProductDetailScreen(Integer itemId);
  }
  */
}