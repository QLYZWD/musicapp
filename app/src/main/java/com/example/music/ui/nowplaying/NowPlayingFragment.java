package com.example.music.ui.nowplaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.music.R;

public class NowPlayingFragment extends Fragment {

    private ImageView albumCover;
    private TextView songTitle, artistName;
    private SeekBar progressBar;
    private ImageButton btnPrevious, btnPlayPause, btnNext;

    private boolean isPlaying = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_now_playing, container, false);

        // 初始化控件
        albumCover = root.findViewById(R.id.image_album_cover);
        songTitle = root.findViewById(R.id.text_song_title);
        artistName = root.findViewById(R.id.text_artist_name);
        progressBar = root.findViewById(R.id.seekbar_progress);
        btnPrevious = root.findViewById(R.id.button_previous);
        btnPlayPause = root.findViewById(R.id.button_play_pause);
        btnNext = root.findViewById(R.id.button_next);

        // 设置点击事件
        btnPlayPause.setOnClickListener(v -> {
            if (isPlaying) {
                pauseMusic();
            } else {
                playMusic();
            }
        });

        btnPrevious.setOnClickListener(v -> {
            // TODO: 播放上一首
        });

        btnNext.setOnClickListener(v -> {
            // TODO: 播放下一首
        });

        return root;
    }

    private void playMusic() {
        // TODO: 实现播放逻辑
        isPlaying = true;
        btnPlayPause.setImageResource(R.drawable.ic_pause);
    }

    private void pauseMusic() {
        // TODO: 实现暂停逻辑
        isPlaying = false;
        btnPlayPause.setImageResource(R.drawable.ic_play);
    }
}
