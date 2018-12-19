package id.alo.sampledatabinding;

import android.app.Application;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import id.alo.sampledatabinding.service.APIService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andini Rachmah on 19/11/18.
 */
public class MainApplication extends Application {
    public static String BASE_URL = "https://dev-android.alodokter.com/api/v182/alodokter/";
    public APIService apiService;
    private static MainApplication instance;

    public static synchronized MainApplication getInstance() {
        return instance;
    }

    public MainApplication() {
        instance = this;
    }

    public APIService getApiService() {
        if (apiService == null) {
            apiService = provideRetrofit(BASE_URL).create(APIService.class);
        }
        return apiService;
    }

    private Retrofit provideRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okhttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();
                requestBuilder.header("Content-Type", "application/json");
                requestBuilder.method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        return okhttpClientBuilder.build();
    }

}
