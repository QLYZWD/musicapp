package com.example.music.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.music.R;

public class SongDetailsFragment extends Fragment {

    private TextView textSongTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_details, container, false);
        textSongTitle = view.findViewById(R.id.text_song_title);

        if (getArguments() != null) {
            String songTitle = getArguments().getString("songTitle");
            textSongTitle.setText(songTitle);
        }

        return view;
    }
}
