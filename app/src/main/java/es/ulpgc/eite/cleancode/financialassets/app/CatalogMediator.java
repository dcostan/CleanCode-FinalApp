package es.ulpgc.eite.cleancode.financialassets.app;

import es.ulpgc.eite.cleancode.financialassets.favourites.FavouriteListState;
import es.ulpgc.eite.cleancode.financialassets.login.LoginState;
import es.ulpgc.eite.cleancode.financialassets.product.ProductDetailState;
import es.ulpgc.eite.cleancode.financialassets.products.ProductListState;
import es.ulpgc.eite.cleancode.financialassets.signup.SignupState;

public class CatalogMediator {

  private LoginState loginState = new LoginState();
  private SignupState signupState = new SignupState();
  private ProductListState productListState = new ProductListState();
  private FavouriteListState favouriteListState = new FavouriteListState();
  private ProductDetailState productDetailState = new ProductDetailState();

  private String currentUser;
  private Integer productId;


  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE ==null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }


  public LoginState getLoginState() { return loginState; }
  public SignupState getSignupState() { return signupState; }
  public ProductListState getProductListState() {
    return productListState;
  }
  public FavouriteListState getFavouriteListState() {
    return favouriteListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public void setCurrentUser(String username) {
    currentUser = username;
  }

  public String getCurrentUser() {
    return currentUser;
  }

  public Integer getProductId() {
    Integer itemId = productId;
    //productId = null;
    return itemId;
  }

  public void setProductId(int itemId) {
    productId = itemId;
  }
}
