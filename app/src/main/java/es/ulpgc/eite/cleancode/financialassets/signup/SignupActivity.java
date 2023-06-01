package es.ulpgc.eite.cleancode.financialassets.signup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import es.ulpgc.eite.cleancode.financialassets.R;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;
import es.ulpgc.eite.cleancode.financialassets.signup.SignupContract;
import es.ulpgc.eite.cleancode.financialassets.signup.SignupScreen;

public class SignupActivity
        extends AppCompatActivity implements SignupContract.View {

    public static String TAG = es.ulpgc.eite.cleancode.financialassets.signup.SignupActivity.class.getSimpleName();

    SignupContract.Presenter presenter;

    EditText usr;
    EditText pwd;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        usr = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        signupButton = findViewById(R.id.login_button);

        signupButton.setOnClickListener(v -> presenter.signupClicked());

        // Show the Up button and the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.title_signup));
        }

        // do the setup
        SignupScreen.configure(this);
    }

    @Override
    public UserItem getCredentials() {
        return new UserItem(usr.getText().toString(), pwd.getText().toString());
    }

    @Override
    public void navigateBack() {
        finish();
    }

    @Override
    public void injectPresenter(SignupContract.Presenter presenter) {
        this.presenter = presenter;
    }
}