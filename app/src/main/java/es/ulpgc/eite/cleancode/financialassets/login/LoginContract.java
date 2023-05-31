package es.ulpgc.eite.cleancode.financialassets.login;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;

interface LoginContract {

  interface View {
    void injectPresenter(Presenter presenter);

    UserItem getCredentials();
    void displayError();
    void navigateToProductList();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void loginClicked();
  }

  interface Model {
    void checkUser(RepositoryContract.CheckUserCallback callback, UserItem user);
  }

//  interface Router {
//
//    //ProductItem getDataFromProductListScreen();
//    Integer getDataFromProductListScreen();
//  }
}