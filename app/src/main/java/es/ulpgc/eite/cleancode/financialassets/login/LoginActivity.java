package es.ulpgc.eite.cleancode.financialassets.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import es.ulpgc.eite.cleancode.financialassets.R;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;
import es.ulpgc.eite.cleancode.financialassets.login.LoginContract;
import es.ulpgc.eite.cleancode.financialassets.login.LoginScreen;
import es.ulpgc.eite.cleancode.financialassets.login.LoginActivity;
import es.ulpgc.eite.cleancode.financialassets.products.ProductListActivity;

public class LoginActivity
        extends AppCompatActivity implements LoginContract.View {

    public static String TAG = es.ulpgc.eite.cleancode.financialassets.login.LoginActivity.class.getSimpleName();

    LoginContract.Presenter presenter;

    EditText usr;
    EditText pwd;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usr = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> presenter.loginClicked());

        // Show the Up button and the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_login));
        }

        // do the setup
        LoginScreen.configure(this);
    }

    @Override
    public UserItem getCredentials() {
        return new UserItem(usr.getText().toString(), pwd.getText().toString());
    }

    @Override
    public void displayError() {
        Context context = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Access denied");
                builder.setMessage("Combination of username and password was not found");
                builder.setNegativeButton("Close", (dialog, which) -> dialog.cancel());
                builder.show();
            }
        });
    }

    @Override
    public void navigateToProductList() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}