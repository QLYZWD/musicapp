package com.example.music.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private List<FavoriteItem> mData;

    public FavoritesAdapter(List<FavoriteItem> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.ViewHolder holder, int position) {
        FavoriteItem item = mData.get(position);
        holder.textSongTitle.setText(item.getSongTitle());
        holder.textArtistName.setText(item.getArtistName());

        holder.itemView.setOnClickListener(v -> {
            // TODO: 点击播放歌曲
            Toast.makeText(v.getContext(), "播放：" + item.getSongTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textSongTitle;
        TextView textArtistName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textSongTitle = itemView.findViewById(R.id.text_song_title);
            textArtistName = itemView.findViewById(R.id.text_artist_name);
        }
    }
}
