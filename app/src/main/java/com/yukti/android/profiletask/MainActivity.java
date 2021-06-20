package com.yukti.android.profiletask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;
    FloatingActionsMenu fam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout fl =(LinearLayout)findViewById(R.id.linear_lay);
        final FloatingActionsMenu fam = (FloatingActionsMenu) fl.findViewById(R.id.fab_menu);

        tabLayout = findViewById(R.id.tab_layout);
        pager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Requests(0)"));
        tabLayout.addTab(tabLayout.newTab().setText("Offerings(0)"));
        tabLayout.addTab(tabLayout.newTab().setText("Recommends(0)"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


        fam.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {

            @Override
            public void onMenuExpanded() {
                // TODO Auto-generated method stub
                fl.setBackgroundColor(Color.parseColor("#BF000000"));

            }

            @Override
            public void onMenuCollapsed() {
                // TODO Auto-generated method stub
                fl.setBackgroundColor(Color.TRANSPARENT);
            }
        });


    }
}