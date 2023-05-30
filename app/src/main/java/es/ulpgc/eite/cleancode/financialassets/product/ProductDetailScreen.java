package es.ulpgc.eite.cleancode.financialassets.product;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.app.CatalogMediator;
import es.ulpgc.eite.cleancode.financialassets.data.CatalogRepository;
import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;


public class ProductDetailScreen {

  public static void configure(ProductDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    //CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    CatalogMediator mediator = CatalogMediator.getInstance();
    //ProductDetailState state = mediator.getProductDetailState();
    RepositoryContract repository = CatalogRepository.getInstance(context.get());

    //ProductDetailContract.Router router = new ProductDetailRouter(mediator);
    //ProductDetailContract.Presenter presenter = new ProductDetailPresenter(state);
    ProductDetailContract.Presenter presenter=new ProductDetailPresenter(mediator);
    //ProductDetailModel model = new ProductDetailModel();
    ProductDetailModel model = new ProductDetailModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    //presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
