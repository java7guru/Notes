package com.levup.notes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.levup.notes.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by java on 31.10.2016.A
 *
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<String> dataSource = null;

    public void setDataSource(List<String> dataSource) {
        this.dataSource = dataSource;
        notifyDataSetChanged();
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_notes_item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        String title = dataSource.get(position);
        holder.bindView(title);
    }

    @Override
    public int getItemCount() {
        if(dataSource == null)
            return 0;

        return dataSource.size();
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_text_view)
        protected TextView titleTextView;

        public NotesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(String title) {
            titleTextView.setText(title);
        }
    }

}
