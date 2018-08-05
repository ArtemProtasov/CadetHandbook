package ru.protasovdev.cadethandbook.common;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.protasovdev.cadethandbook.news.model.NewsPage;

public interface Api {

    @GET("/novosti/")
    Call<NewsPage> getNews();
}
