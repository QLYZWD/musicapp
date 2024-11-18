package com.example.music.ui.charts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.music.R;
import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    private final List<String> songs;
    private final OnSongClickListener listener;

    public interface OnSongClickListener {
        void onSongClick(String songTitle);
    }

    public SongListAdapter(List<String> songs, OnSongClickListener listener) {
        this.songs = songs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String songInfo = songs.get(position);
        String[] songParts = songInfo.split(" - "); // 假设格式为 "歌曲名 - 歌手名"
        if (songParts.length == 2) {
            holder.songTitle.setText(songParts[0]);
            holder.artistName.setText(songParts[1]);
        } else {
            holder.songTitle.setText(songInfo);
            holder.artistName.setText("未知艺术家");
        }

        holder.itemView.setOnClickListener(v -> listener.onSongClick(songParts[0]));
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView songTitle;
        TextView artistName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.text_song_title);
            artistName = itemView.findViewById(R.id.text_artist_name);
        }
    }
}
