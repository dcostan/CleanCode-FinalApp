package es.ulpgc.eite.cleancode.catalog.favourites;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;


public class FavouriteListPresenter implements FavouriteListContract.Presenter {

  public static String TAG = FavouriteListPresenter.class.getSimpleName();

  private WeakReference<FavouriteListContract.View> view;
  private FavouriteListState state;
  private FavouriteListContract.Model model;
  private CatalogMediator mediator;


  public FavouriteListPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getFavouriteListState();
  }


  @Override
  public void injectView(WeakReference<FavouriteListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(FavouriteListContract.Model model) {
    this.model = model;
  }

  private void passDataToProductDetailScreen(Integer itemId) {
    mediator.setProductId(itemId);
  }

  @Override
  public void fetchProductListData() {

    model.fetchFavouriteAssetsList(new RepositoryContract.GetFavouriteAssetsListCallback() {
      @Override
      public void setFavouriteAssetsList(List<ProductItem> assets) {
        state.products = assets;
        view.get().displayProductListData(state);
      }
    });

  }


  @Override
  public void selectProductListData(ProductItem item) {
    passDataToProductDetailScreen(item.id);
    view.get().navigateToProductDetailScreen();
  }


}
