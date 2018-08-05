package ru.protasovdev.cadethandbook;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ru.protasovdev.cadethandbook.common.ViewPagerAdapter;
import ru.protasovdev.cadethandbook.news.NewsFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Integer> iconTab = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager();
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < iconTab.size(); i++) {
            tabLayout.getTabAt(i).setIcon(iconTab.get(i));
        }
    }

    private void setupViewPager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Новости
        adapter.addFragment(new NewsFragment(), getString(R.string.news));
        iconTab.add(R.drawable.newspaper_solid);
        //Учебные материалы
        adapter.addFragment(new NewsFragment(), getString(R.string.documents));
        iconTab.add(R.drawable.file_alt_solid);
        //Шпаргалки
        adapter.addFragment(new NewsFragment(), getString(R.string.cheat_sheets));
        iconTab.add(R.drawable.marker_solid);
        //
        adapter.addFragment(new NewsFragment(), getString(R.string.map));
        iconTab.add(R.drawable.map_marked_alt_solid);
        //Настройки
        adapter.addFragment(new NewsFragment(), getString(R.string.settings));
        iconTab.add(R.drawable.cog_solid);

        viewPager.setAdapter(adapter);
    }
}
