package es.ulpgc.eite.cleancode.financialassets.login;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.app.CatalogMediator;
import es.ulpgc.eite.cleancode.financialassets.data.ProductItem;
import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;


public class LoginPresenter implements LoginContract.Presenter {

  public static String TAG = LoginPresenter.class.getSimpleName();

  private WeakReference<LoginContract.View> view;
  private LoginState state;
  private LoginContract.Model model;
  //private ProductDetailContract.Router router;
  private CatalogMediator mediator;

  public LoginPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getLoginState();
  }

  @Override
  public void injectView(WeakReference<LoginContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(LoginContract.Model model) {
    this.model = model;
  }

  @Override
  public void loginClicked() {
    Log.e(TAG, "loginClicked()");

    UserItem user = view.get().getCredentials();
    model.checkUser(new RepositoryContract.CheckUserCallback() {
      @Override
      public void onUserChecked(boolean valid) {
        if(valid) {
          mediator.setCurrentUser(user.username);
          view.get().navigateToProductList();
        } else {
          view.get().displayError();
        }
      }
    }, user);
  }

}
