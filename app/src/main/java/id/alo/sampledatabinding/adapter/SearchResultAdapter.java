package id.alo.sampledatabinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.alo.sampledatabinding.R;
import id.alo.sampledatabinding.databinding.ItemSearchResultBinding;
import id.alo.sampledatabinding.model.SearchItem;

/**
 * Created by Andini Rachmah on 19/11/18.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SearchItem> searchList = new ArrayList<>();
    private Context context;

    public SearchResultAdapter(List<SearchItem> searchList, Context context) {
        this.searchList = searchList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSearchResultBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.item_search_result, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        SearchItem item = searchList.get(i);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.binding.setItem(item);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemSearchResultBinding binding;

        ViewHolder(ItemSearchResultBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
