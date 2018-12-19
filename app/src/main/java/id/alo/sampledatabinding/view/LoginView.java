package id.alo.sampledatabinding.view;

import id.alo.sampledatabinding.model.SearchResponse;
import id.alo.sampledatabinding.model.loginrequest.LoginRequest;
import id.alo.sampledatabinding.model.loginresponse.LoginResponse;

/**
 * Created by Andini Rachmah on 19/12/18.
 */
public interface LoginView {
    interface View extends BaseView {
        void onSuccessLogin(LoginResponse response);

        void onFailure(String s);
    }

    interface Presenter {
        void login(LoginRequest loginRequest);
    }
}
