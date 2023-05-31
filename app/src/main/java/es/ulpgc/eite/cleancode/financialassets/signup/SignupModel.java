package es.ulpgc.eite.cleancode.financialassets.signup;

import es.ulpgc.eite.cleancode.financialassets.data.RepositoryContract;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;

public class SignupModel implements SignupContract.Model {

  public static String TAG = SignupModel.class.getSimpleName();


  private RepositoryContract repository;

  /*
  public ProductDetailModel() {

  }
  */

  public SignupModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void addUser(RepositoryContract.AddUserCallBack callback, UserItem user) {
    //repository.checkUser(callback, user);
  }

}
