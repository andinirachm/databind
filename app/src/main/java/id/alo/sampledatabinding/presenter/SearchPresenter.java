package id.alo.sampledatabinding.presenter;

import id.alo.sampledatabinding.MainApplication;
import id.alo.sampledatabinding.model.SearchResponse;
import id.alo.sampledatabinding.view.SearchView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andini Rachmah on 19/11/18.
 */
public class SearchPresenter implements SearchView.Presenter, BasePresenter {
    private SearchView.View view;

    public SearchPresenter(SearchView.View view) {
        this.view = view;
    }

    public void search(String keyword, String token) {
        view.onShowLoading();
        MainApplication.getInstance().getApiService().search(keyword, "Token token=" + token).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                view.onRemoveLoading();
                if (response.isSuccessful()) {
                    view.onSuccessGetSearchResult(response.body());
                } else {
                    view.onFailure("Failure " + response.message());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
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
