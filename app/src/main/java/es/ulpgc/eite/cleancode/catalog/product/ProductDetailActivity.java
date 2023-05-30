package es.ulpgc.eite.cleancode.catalog.product;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class ProductDetailActivity
    extends AppCompatActivity implements ProductDetailContract.View {

  public static String TAG = ProductDetailActivity.class.getSimpleName();

  ProductDetailContract.Presenter presenter;

  Button favouriteButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_detail);
    Toolbar toolbar = findViewById(R.id.detail_toolbar);
    setSupportActionBar(toolbar);
    favouriteButton = findViewById(R.id.set_fav_button);

    favouriteButton.setOnClickListener(v -> presenter.setFavouriteClicked());

    // Show the Up button and the title in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(getString(R.string.title_product_detail));
    }

    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

    // do the setup
    ProductDetailScreen.configure(this);

    // do some work
    presenter.fetchProductDetailData();
  }

  @Override
  public void injectPresenter(ProductDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayProductDetailData(ProductDetailViewModel viewModel) {
    Log.e(TAG, "displayProductDetailData()");

    // deal with the data
    final ProductItem product = viewModel.product;

    if (product != null) {
      runOnUiThread(new Runnable() {
        @Override
        public void run() {

          ActionBar actionBar = getSupportActionBar();
          if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(product.content);
          }

          Glide.with(ProductDetailActivity.this)
                  .load(product.picture)
                  .into((ImageView) findViewById(R.id.product_image));

          ((TextView) findViewById(R.id.product_type)).setText(product.type);
          ((TextView) findViewById(R.id.product_isin)).setText(product.isin);
          ((TextView) findViewById(R.id.product_currency)).setText(product.currency);
          ((TextView) findViewById(R.id.product_max_spread)).setText(Double.toString(product.max_spread) + "%");
          ((TextView) findViewById(R.id.product_value)).setText(Double.toString(product.value));

          if(product.favourite)
            ((Button) findViewById(R.id.set_fav_button)).setText(R.string.unset_favourite);
          else
            ((Button) findViewById(R.id.set_fav_button)).setText(R.string.set_favourite);

        }
      });
    }
  }



  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      navigateUpTo(new Intent(this, ProductListActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
