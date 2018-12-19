package id.alo.sampledatabinding.presenter;

import id.alo.sampledatabinding.MainApplication;
import id.alo.sampledatabinding.model.loginrequest.LoginRequest;
import id.alo.sampledatabinding.model.loginresponse.LoginResponse;
import id.alo.sampledatabinding.view.LoginView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andini Rachmah on 19/12/18.
 */
public class LoginPresenter implements LoginView.Presenter, BasePresenter {
    private LoginView.View view;

    public LoginPresenter(LoginView.View view) {
        this.view = view;
    }

    public void login(LoginRequest request) {
        view.onShowLoading();
        MainApplication.getInstance().getApiService().login(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                view.onRemoveLoading();
                if (response.isSuccessful()) {
                    view.onSuccessLogin(response.body());
                } else {
                    view.onFailure("Failure " + response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.onRemoveLoading();
                view.onFailure("Failure " + t.getMessage());
            }
        });
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }
}
