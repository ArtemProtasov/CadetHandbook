package ru.protasovdev.cadethandbook.common;

import android.graphics.pdf.PdfDocument;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/novosti/")
    Call<NewsPage> getNews();
}
