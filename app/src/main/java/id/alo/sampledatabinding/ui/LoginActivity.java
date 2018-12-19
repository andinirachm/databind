package id.alo.sampledatabinding.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.HashMap;

import id.alo.sampledatabinding.R;
import id.alo.sampledatabinding.databinding.ActivityLoginBinding;
import id.alo.sampledatabinding.model.loginrequest.LoginRequest;
import id.alo.sampledatabinding.model.loginresponse.LoginResponse;
import id.alo.sampledatabinding.presenter.LoginPresenter;
import id.alo.sampledatabinding.presenter.SearchPresenter;
import id.alo.sampledatabinding.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView.View {
    private HashMap<String, String> params;
    private ActivityLoginBinding binding;
    private LoginRequest loginRequest;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        presenter = new LoginPresenter(this);
        binding.setPresenter(presenter);


        setUserLogin();

        binding.editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginRequest.setEmail(binding.editTextEmail.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginRequest.setPassword(binding.editTextPassword.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void setUserLogin() {
        loginRequest = new LoginRequest();
        loginRequest.setEmail("");
        loginRequest.setPassword("");
        loginRequest.setVersion("1.8.2");
        loginRequest.setDeviceToken("Andini17");
        binding.setUser(loginRequest);
    }

    @Override
    public void onSuccessLogin(LoginResponse response) {
        System.out.println("HALO : " + response.getStatus());
    }

    @Override
    public void onFailure(String s) {
        System.out.println("HALOs : " + s);
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onRemoveLoading() {

    }
}
