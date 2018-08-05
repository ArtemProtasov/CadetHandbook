package ru.protasovdev.cadethandbook.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import ru.protasovdev.cadethandbook.news.model.NewsPage;
import ru.protasovdev.cadethandbook.common.Repository;

public class NewsViewModel extends ViewModel {
    private LiveData<NewsPage> liveDataNews;
    private Repository repository = new Repository();

    public LiveData<NewsPage> getLiveDataNews() {
        if(liveDataNews == null) {
            liveDataNews = repository.getNews();
        }
        return liveDataNews;
    }
}
