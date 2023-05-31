package es.ulpgc.eite.cleancode.financialassets.signup;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;

interface SignupContract {

  interface View {
    void injectPresenter(Presenter presenter);

    UserItem getCredentials();
    void navigateBack();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void signupClicked();
  }

  interface Model {
    void addUser(RepositoryContract.AddUserCallBack callback, UserItem user);
  }

}