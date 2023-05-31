package es.ulpgc.eite.cleancode.financialassets.app;

import es.ulpgc.eite.cleancode.financialassets.favourites.FavouriteListState;
import es.ulpgc.eite.cleancode.financialassets.login.LoginState;
import es.ulpgc.eite.cleancode.financialassets.product.ProductDetailState;
import es.ulpgc.eite.cleancode.financialassets.products.ProductListState;

public class CatalogMediator {

  private LoginState loginState = new LoginState();
  private ProductListState productListState = new ProductListState();
  private FavouriteListState favouriteListState = new FavouriteListState();
  private ProductDetailState productDetailState = new ProductDetailState();

  //private ProductItem product;
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
  public ProductListState getProductListState() {
    return productListState;
  }
  public FavouriteListState getFavouriteListState() {
    return favouriteListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  /*
  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }


  public void setProduct(ProductItem item) {
    product = item;
  }
  */

  public Integer getProductId() {
    Integer itemId = productId;
    //productId = null;
    return itemId;
  }

  public void setProductId(int itemId) {
    productId = itemId;
  }
}
