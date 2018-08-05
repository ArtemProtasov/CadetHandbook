package ru.protasovdev.cadethandbook.news.model;

import pl.droidsonroids.jspoon.annotation.Selector;

public class Post {
    @Selector(".r > a") public String title = null;
    @Selector(".r > p") public String body = null;
    @Selector(".date") public String date = null;
    @Selector(value = ".left-r > a > img", attr = "src") public String imageUrl = null;
    @Selector(value = ".r > a", attr = "href") public String fullNewsLink = null;
}
