package ru.protasovdev.cadethandbook.common;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

public class NewsPage {
    @Selector(".listing-news-row") public List<Post> posts = new ArrayList<>();
}
