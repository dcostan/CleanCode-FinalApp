package es.ulpgc.eite.cleancode.financialassets.signup;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.app.CatalogMediator;
import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;


public class SignupPresenter implements SignupContract.Presenter {

  public static String TAG = SignupPresenter.class.getSimpleName();

  private WeakReference<SignupContract.View> view;
  private SignupState state;
  private SignupContract.Model model;
  //private ProductDetailContract.Router router;
  private CatalogMediator mediator;

  public SignupPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getSignupState();
  }

  @Override
  public void injectView(WeakReference<SignupContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SignupContract.Model model) {
    this.model = model;
  }

  @Override
  public void signupClicked() {
    Log.e(TAG, "signupClicked()");

    UserItem user = view.get().getCredentials();
    /*model.checkUser(new RepositoryContract.CheckUserCallback() {
      @Override
      public void onUserChecked(boolean valid) {
        if(valid)
          view.get().navigateToProductList();
        else
          view.get().displayError();
      }
    }, user);*/
  }

}
