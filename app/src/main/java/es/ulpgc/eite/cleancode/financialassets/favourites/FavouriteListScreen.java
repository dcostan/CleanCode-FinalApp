package es.ulpgc.eite.cleancode.financialassets.favourites;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.app.CatalogMediator;
import es.ulpgc.eite.cleancode.financialassets.data.CatalogRepository;
import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;

public class FavouriteListScreen {

  public static void configure(FavouriteListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    //CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    CatalogMediator mediator = CatalogMediator.getInstance();
    //ProductListState state = mediator.getProductListState();
    RepositoryContract repository = CatalogRepository.getInstance(context.get());

    //ProductListContract.Router router = new ProductListRouter(mediator);
    //ProductListContract.Presenter presenter = new ProductListPresenter(state);
    FavouriteListContract.Presenter presenter= new FavouriteListPresenter(mediator);
    FavouriteListModel model = new FavouriteListModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    //presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
