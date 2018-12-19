package id.alo.sampledatabinding.service;

import java.util.HashMap;

import id.alo.sampledatabinding.model.SearchResponse;
import id.alo.sampledatabinding.model.loginrequest.LoginRequest;
import id.alo.sampledatabinding.model.loginresponse.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Andini Rachmah on 19/11/18.
 */
public interface APIService {
    @GET("general_search/{keyword}.json")
    public Call<SearchResponse> search(@Path("keyword") String keyword, @Header("Authorization") String auth);

    @POST("sessions/login.json")
    public Call<LoginResponse> login(@Body LoginRequest request);
}
