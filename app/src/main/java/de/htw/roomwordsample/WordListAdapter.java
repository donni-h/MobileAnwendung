package de.htw.roomwordsample;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class WordListAdapter extends ListAdapter<Package, WordViewHolder> {

    public WordListAdapter(@NonNull DiffUtil.ItemCallback<Package> diffCallback) {
        super(diffCallback);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Package current = getItem(position);
        holder.bind(current.getTrackingNumber());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Package> {

        @Override
        public boolean areItemsTheSame(@NonNull Package oldItem, @NonNull Package newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Package oldItem, @NonNull Package newItem) {
            return oldItem.getTrackingNumber().equals(newItem.getTrackingNumber());
        }
    }
}
