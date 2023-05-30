package es.ulpgc.eite.cleancode.catalog.favourites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailActivity;


public class FavouriteListActivity
    extends AppCompatActivity implements FavouriteListContract.View {

  public static String TAG = FavouriteListActivity.class.getSimpleName();

  FavouriteListContract.Presenter presenter;

  private ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favourite_list);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the title in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(getString(R.string.title_favourite_list));
    }

    listView = findViewById(R.id.product_list);

    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

    // do the setup
    FavouriteListScreen.configure(this);

    // do some work
    presenter.fetchProductListData();
  }

  @Override
  public void navigateToProductDetailScreen() {
    Intent intent = new Intent(this, ProductDetailActivity.class);
    startActivity(intent);
  }

  @Override
  public void displayProductListData(FavouriteListViewModel viewModel) {
    Log.e(TAG, "displayProductListData()");

    // deal with the data
    listView.setAdapter(new FavouriteListAdapter(
            this, viewModel.products, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            ProductItem item = (ProductItem) view.getTag();
            presenter.selectProductListData(item);
          }
        })
    );

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      NavUtils.navigateUpFromSameTask(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }


  @Override
  public void injectPresenter(FavouriteListContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
