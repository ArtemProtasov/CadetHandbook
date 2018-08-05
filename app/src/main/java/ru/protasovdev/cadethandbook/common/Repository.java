package ru.protasovdev.cadethandbook.common;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.protasovdev.cadethandbook.news.model.NewsPage;

public class Repository {
    private static final String BASE_URL = "http://uvc.tti.sfedu.ru";
    private static Retrofit retrofit = null;

    private static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JspoonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public LiveData<NewsPage> getNews() {
        final MutableLiveData<NewsPage> news = new MutableLiveData<>();
        getRetrofitClient().create(Api.class).getNews()
                .enqueue(new Callback<NewsPage>() {
                    @Override
                    public void onResponse(Call<NewsPage> call, Response<NewsPage> response) {
                        if(response.body() != null) {
                            news.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsPage> call, Throwable t) {
                        Log.i("NEWS", "onFailure: " + t);
                    }
                });
        return news;
    }
}
