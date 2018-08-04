package ru.protasovdev.cadethandbook.news;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.protasovdev.cadethandbook.R;

public class NewsFragment extends Fragment implements NewsAdapter.NewsListener{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private NewsAdapter adapter;
    private NewsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        adapter = new NewsAdapter(this);
        recyclerView.setAdapter(adapter);
        getNews();
    }

    private void getNews() {
        viewModel.getLiveDataNews()
                .observe(this, page -> {
                        adapter.addItems(page);
                });
    }

    @Override
    public void onNewsClickListener(String url) {
        Uri uri = Uri.parse(getString(R.string.url_site_uvc) + url);
        System.out.println(uri);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
