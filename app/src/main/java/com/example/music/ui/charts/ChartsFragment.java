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
import java.util.Arrays;
import java.util.List;

public class ChartsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChartsCategoryAdapter adapter;
    private List<String> categories = Arrays.asList("流行", "新歌", "经典");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charts, container, false);
        recyclerView = view.findViewById(R.id.recycler_charts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 配置适配器并设置点击事件
        adapter = new ChartsCategoryAdapter(categories, this::onCategoryClick);
        recyclerView.setAdapter(adapter);
        return view;
    }

    // 当点击某个排行榜类别时，导航到排行榜列表页面
    private void onCategoryClick(String category) {
        Bundle bundle = new Bundle();
        bundle.putString("category", category);
        Navigation.findNavController(requireView()).navigate(R.id.action_charts_to_chartsList, bundle);
    }
}
