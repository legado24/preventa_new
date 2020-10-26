package com.legado.ventagps.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.legado.ventagps.R;
import com.legado.ventagps.activity.base.AppBaseActivity;
import com.legado.ventagps.activity.base.BaseActivity;
import com.legado.ventagps.fragment.AvanceFragment;
import com.legado.ventagps.fragment.CustomerListFragment;
import com.legado.ventagps.fragment.HomeFragment;
import com.legado.ventagps.fragment.HomeFragment_2;
import com.legado.ventagps.utils.ViewAnimation;

public class DashboardActivity extends AppBaseActivity {
    private TabLayout tab_layout;
    private ActionBar actionBar;
    private NestedScrollView nested_scroll_view;
    private BottomNavigationView navigation;
    private CardView cardViewBottomMenu;
    private View customToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_2);
        //initToolbar();
       initComponent();
       HomeFragment homeFragment = new HomeFragment();
          getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, homeFragment,"HomeFragment").
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

//    @Override
//    public boolean providesActivityToolbar() {
//        return false;
//    }

//    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       toolbar.setNavigationIcon(null);
////        //toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_ATOP);
//            setSupportActionBar(toolbar);
//            actionBar = getSupportActionBar();
////        actionBar.setTitle("Home");
////        actionBar.setDisplayHomeAsUpEnabled(true);
//       // Tools.setSystemBarColor(this, R.color.grey_20);
//    }
    private void initComponent() {
        customToolbar = (View) findViewById(R.id.customToolbar);
        cardViewBottomMenu=findViewById(R.id.cardViewBottomMenu);
        // mTextMessage = (TextView) findViewById(R.id.search_text);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                   case R.id.goHome:
                       HomeFragment homeFragment = new HomeFragment();
                       getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, homeFragment,"HomeFragment").
                               setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                         return true;
                   case R.id.goCustomer:
                     //  actionBar.setTitle("CLIENTES");
                         CustomerListFragment customerListFragment = new CustomerListFragment();
                         getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, customerListFragment,"CustomerListFragment").
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                            return true;
                    case R.id.goPerfil:
                        //  actionBar.setTitle("CLIENTES");
                        AvanceFragment avanceFragment = new AvanceFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, avanceFragment,"AvanceFragment").
                                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                        return true;
//                    case R.id.navigation_nearby:
//                        mTextMessage.setText(item.getTitle());
//                        return true;
                }
                return false;
            }
        });

        //NestedScrollView nested_content = (NestedScrollView) findViewById(R.id.nested_scroll_view);
//        nested_content.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY < oldScrollY) { // up
//                 animateNavigation(false);
//                 animateSearchBar(false);
//                }
//                if (scrollY > oldScrollY) { // down
//                   animateNavigation(true);
//                    animateSearchBar(true);
//                }
//            }
//        });

        // display image
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_1), R.drawable.image_8);
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_2), R.drawable.image_9);
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_3), R.drawable.image_15);
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_4), R.drawable.image_14);
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_5), R.drawable.image_12);
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_6), R.drawable.image_2);
//        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_7), R.drawable.image_5);


//        ((ImageButton) findViewById(R.id.bt_menu)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        Tools.setSystemBarColor(this, R.color.grey_5);
//        Tools.setSystemBarLight(this);
    }
//    private void initComponent() {
//        nested_scroll_view = (NestedScrollView)  findViewById(R.id.nested_scroll_view);
//        tab_layout =  (TabLayout) findViewById(R.id.tab_layout);
//      //  tab_layout.addTab(tab_layout.newTab(), 0);
//
//      tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_baseline_home), 0);
//      tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_baseline_customers), 1);
//      tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_precios), 2);
//       tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_bonif), 3);
////
////        // set icon color pre-selected
//      tab_layout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.deep_orange_500), PorterDuff.Mode.SRC_IN);
//      tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
//      tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
//          tab_layout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
////
//        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(getResources().getColor(R.color.deep_orange_500), PorterDuff.Mode.SRC_IN);
//                switch (tab.getPosition()) {
//                    case 0:
//                        actionBar.setTitle("Home");
//                        HomeFragment homeFragment = new HomeFragment();
//                        //customerListFragment.setArguments(args);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, homeFragment,"HomeFragment").
//                                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
//                        break;
//                    case 1:
//                        actionBar.setTitle("Clientes");
//                        CustomerListFragment customerListFragment = new CustomerListFragment();
//                        //customerListFragment.setArguments(args);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, customerListFragment,"CustomerListFragment").
//                                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
//                        break;
//                    case 2:
//                        actionBar.setTitle("Story");
//                        break;
//                    case 3:
//                        actionBar.setTitle("Activity");
//                        break;
//                    case 4:
//                        actionBar.setTitle("Profile");
//                        break;
//                }
//
//                ViewAnimation.fadeOutIn(nested_scroll_view);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        // display image
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_1), R.drawable.image_8);
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_2), R.drawable.image_9);
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_3), R.drawable.image_15);
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_4), R.drawable.image_14);
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_5), R.drawable.image_12);
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_6), R.drawable.image_2);
////        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_7), R.drawable.image_5);
////
////        Tools.setSystemBarColor(this, R.color.grey_5);
////        Tools.setSystemBarLight(this);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

//    boolean isNavigationHide = false;
//
//    private void animateNavigation(final boolean hide) {
//        if (isNavigationHide && hide || !isNavigationHide && !hide) return;
//        isNavigationHide = hide;
//        int moveY = hide ? (2 * cardViewBottomMenu.getHeight()) : 0;
//        cardViewBottomMenu.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
//    }
//
//    boolean isSearchBarHide = false;
//
//    private void animateSearchBar(final boolean hide) {
//        if (isSearchBarHide && hide || !isSearchBarHide && !hide) return;
//        isSearchBarHide = hide;
//        int moveY = hide ? -(2 * customToolbar.getHeight()) : 0;
//        customToolbar.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
//
//    }
}