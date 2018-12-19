package id.alo.sampledatabinding.view;

import id.alo.sampledatabinding.model.SearchResponse;

/**
 * Created by Andini Rachmah on 21/11/18.
 */
public interface SearchView {
    interface View extends BaseView {
        void onSuccessGetSearchResult(SearchResponse response);

        void onFailure(String s);
    }

    interface Presenter {
        void search(String keyword, String token);
    }


}
