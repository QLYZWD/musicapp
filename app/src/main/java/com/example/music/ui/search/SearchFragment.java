package com.example.music.ui.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private EditText editSearch;
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<SearchItem> songList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        editSearch = root.findViewById(R.id.edit_search);
        recyclerView = root.findViewById(R.id.recycler_search_results);

        // 设置 RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SearchAdapter(songList);
        recyclerView.setAdapter(adapter);

        // 监听搜索输入
        editSearch.addTextChangedListener(new TextWatcher() {
            // 实现 TextWatcher 的方法
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 可以留空
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 可以留空
            }

            @Override
            public void afterTextChanged(Editable s) {
                String query = s.toString();
                // TODO: 执行搜索请求，更新 songList
                performSearch(query);
            }
        });

        return root;
    }

    private void performSearch(String query) {
        // TODO: 实现搜索逻辑，更新 songList，然后通知适配器刷新
        // 示例：
        songList.clear();
        // 假设搜索结果
        songList.add(new SearchItem("歌曲1", "歌手1"));
        songList.add(new SearchItem("歌曲2", "歌手2"));
        adapter.notifyDataSetChanged();
    }
}
