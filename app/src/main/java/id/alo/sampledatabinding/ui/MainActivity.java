package id.alo.sampledatabinding.ui;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.alo.sampledatabinding.R;
import id.alo.sampledatabinding.adapter.SearchResultAdapter;
import id.alo.sampledatabinding.databinding.ActivityMainBinding;
import id.alo.sampledatabinding.model.SearchItem;
import id.alo.sampledatabinding.model.SearchResponse;
import id.alo.sampledatabinding.presenter.SearchPresenter;
import id.alo.sampledatabinding.view.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.View, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private List<SearchItem> searchList = new ArrayList<>();
    private SearchPresenter presenter;
    private String token = "MyDoWb6HXo-vWPmXHwd3";
    private SearchResultAdapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.swipeRefreshLayout.setEnabled(false);
        binding.swipeRefreshLayout.setRefreshing(true);

        setRecyclerView();
        presenter = new SearchPresenter(this);
        presenter.search("sakit", token);
    }

    @Override
    public void onSuccessGetSearchResult(SearchResponse response) {
        searchList.clear();
        searchList.addAll(response.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void setRecyclerView() {
        recyclerView = binding.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new SearchResultAdapter(searchList, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        presenter.search("Sakit", token);
    }

    @Override
    public void onShowLoading() {
        binding.swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onRemoveLoading() {
        if (binding.swipeRefreshLayout.isRefreshing())
            binding.swipeRefreshLayout.setRefreshing(false);
    }
}
