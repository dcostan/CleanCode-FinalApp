package es.ulpgc.eite.cleancode.financialassets.favourites;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.data.ProductItem;
import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;

interface FavouriteListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductListData(FavouriteListViewModel viewModel);
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
    void fetchFavouriteAssetsList(RepositoryContract.GetFavouriteAssetsListCallback callback, String username);
  }

  /*
  interface Router {

    void navigateToProductDetailScreen();

    //void passDataToProductDetailScreen(ProductItem item);
    void passDataToProductDetailScreen(Integer itemId);
  }
  */
}