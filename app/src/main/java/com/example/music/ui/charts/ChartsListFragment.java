package com.example.music.ui.charts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.music.R;
import java.util.ArrayList;
import java.util.List;

public class ChartsListFragment extends Fragment {

    private RecyclerView recyclerView;
    private SongListAdapter adapter;
    private String category;
    private List<String> songs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charts_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_charts_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            category = getArguments().getString("category");
            songs = getSongsForCategory(category); // 根据类别加载对应歌曲列表
        }

        adapter = new SongListAdapter(songs, this::onSongClick);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<String> getSongsForCategory(String category) {
        List<String> songList = new ArrayList<>();
        if (category.equals("流行")) {
            songList.add("夜曲 - 周杰伦");
            songList.add("演员 - 薛之谦");
            songList.add("喜欢你 - 邓紫棋");
            songList.add("告白气球 - 周杰伦");
            songList.add("光年之外 - 邓紫棋");
        } else if (category.equals("新歌")) {
            songList.add("想见你想见你想见你 - 八三夭");
            songList.add("起风了 - 买辣椒也用券");
            songList.add("无人之岛 - 任然");
            songList.add("生而为人 - 薛之谦");
            songList.add("我们很好 - 王源");
        } else if (category.equals("经典")) {
            songList.add("童话 - 光良");
            songList.add("传奇 - 王菲");
            songList.add("月亮代表我的心 - 邓丽君");
            songList.add("那些花儿 - 朴树");
            songList.add("漂洋过海来看你 - 李宗盛");
        }
        return songList;
    }

    private void onSongClick(String songTitle) {
        Bundle bundle = new Bundle();
        bundle.putString("songTitle", songTitle);
        Navigation.findNavController(requireView()).navigate(R.id.action_chartsList_to_songDetails, bundle);
    }
}
