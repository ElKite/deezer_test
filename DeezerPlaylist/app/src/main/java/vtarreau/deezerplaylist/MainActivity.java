package vtarreau.deezerplaylist;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vtarreau.deezerplaylist.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager myViewPager;
    TabLayout myTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager = (ViewPager) findViewById(R.id.view_pager);
        myTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fm);

        myViewPager.setAdapter(viewPagerAdapter);
        myTabLayout.setupWithViewPager(myViewPager);
    }
}
