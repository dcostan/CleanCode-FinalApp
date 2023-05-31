package es.ulpgc.eite.cleancode.financialassets.login;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;

public class LoginModel implements LoginContract.Model {

  public static String TAG = LoginModel.class.getSimpleName();


  private RepositoryContract repository;

  /*
  public ProductDetailModel() {

  }
  */

  public LoginModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void checkUser(RepositoryContract.CheckUserCallback callback, UserItem user) {
    repository.checkUser(callback, user);
  }

}
