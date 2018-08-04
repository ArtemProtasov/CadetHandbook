package ru.protasovdev.cadethandbook.news;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.protasovdev.cadethandbook.R;
import ru.protasovdev.cadethandbook.common.GlideApp;
import ru.protasovdev.cadethandbook.common.NewsPage;
import ru.protasovdev.cadethandbook.common.Post;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private NewsListener listener;
    private NewsPage page = new NewsPage();

    public interface NewsListener {
        void onNewsClickListener(String url);
    }

    public NewsAdapter(NewsListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Post post = page.posts.get(position);
        GlideApp.with(holder.itemView)
                .load(holder.itemView.getContext().getString(R.string.url_site_uvc) + post.imageUrl)
                .thumbnail(0.1f)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.newsImage);
        holder.newsTitle.setText(post.title);
        holder.newsBody.setText(post.body);
        holder.newsItem.setOnClickListener(view -> {
            if(listener != null) {
                listener.onNewsClickListener(post.fullNewsLink);
            }
        });
    }

    @Override
    public int getItemCount() {
        return page.posts.size();
    }

    public void addItems(NewsPage page) {
        this.page = page;
        notifyDataSetChanged();
    }


    static class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_image)
        ImageView newsImage;
        @BindView(R.id.news_title)
        TextView newsTitle;
        @BindView(R.id.news_body)
        TextView newsBody;
        @BindView(R.id.news_item)
        ConstraintLayout newsItem;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
