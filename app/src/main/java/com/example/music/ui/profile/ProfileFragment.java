package com.example.music.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private ImageView imageAvatar;
    private TextView textUsername;
    private RecyclerView recyclerFavorites;
    private FavoritesAdapter adapter;
    private List<FavoriteItem> favoriteSongs = new ArrayList<>();
    private Button buttonSettings;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        imageAvatar = root.findViewById(R.id.image_avatar);
        textUsername = root.findViewById(R.id.text_username);
        recyclerFavorites = root.findViewById(R.id.recycler_favorites);
        buttonSettings = root.findViewById(R.id.button_settings);

        // 设置 RecyclerView
        recyclerFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FavoritesAdapter(favoriteSongs);
        recyclerFavorites.setAdapter(adapter);

        // 加载用户信息和收藏的歌曲
        loadUserData();

        // 设置按钮点击事件
        buttonSettings.setOnClickListener(v -> {
            // TODO: 打开设置页面
        });

        return root;
    }

    private void loadUserData() {
        // TODO: 实现用户数据加载逻辑
        textUsername.setText("用户名");
        // 假设收藏列表
        favoriteSongs.clear();
        favoriteSongs.add(new FavoriteItem("收藏歌曲1", "歌手1"));
        favoriteSongs.add(new FavoriteItem("收藏歌曲2", "歌手2"));
        adapter.notifyDataSetChanged();
    }
}
