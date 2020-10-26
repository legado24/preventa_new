package com.legado.ventagps.activity.base;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.legado.ventagps.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by __Adrian__ on 20/03/2019.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar actionBarToolbar;
    protected static final int NAV_DRAWER_ITEM_INVALID = -1;
     private BroadcastReceiver br;
    public static final String CHANNEL_ID = "exampleServiceChannel";

    String fechaDevice;
    Dialog dialog ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(dialog==null) {
            dialog = new Dialog(this);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setTitle(null);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setCancelable(false);
        }



    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //setupNavDrawer();
    }
//
//    private void setupNavDrawer() {
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawerLayout == null) {
//            return;
//        }
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        if (navigationView != null) {
//            setupCardSelectListener();
//            setSelectedItem(navigationView);
//        }
//    }

    private void setSelectedItem(NavigationView navigationView) {
        int selectedItem = getSelfNavDrawerItem();
        navigationView.setCheckedItem(selectedItem);
    }

    private void onNavigationItemClicked(final int itemId) {
        if (itemId == getSelfNavDrawerItem()) {
            closeDrawer();
            return;
        }
        goToNavDrawerItem(itemId);
    }

    protected void openDrawer() {
        if (drawerLayout == null)
            return;
        ObjectAnimator.ofFloat(actionBarToolbar, View.ROTATION.getName(), 360).start();
        drawerLayout.openDrawer(GravityCompat.START);

    }

    protected void closeDrawer() {
        if (drawerLayout == null)
            return;
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    private void setupCardSelectListener() {

    }

    protected void goToNavDrawerItem(int item) {
    }

//    protected ActionBar getActionBarToolbar() {
//        if (actionBarToolbar == null) {
//            actionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
//            if (actionBarToolbar != null) {
//                setSupportActionBar(actionBarToolbar);
//            }
//        }
//        return getSupportActionBar();
//    }

    protected int getSelfNavDrawerItem() {
        return NAV_DRAWER_ITEM_INVALID;
    }

    public abstract boolean providesActivityToolbar();

    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showProgress(boolean band){
        if(band){
            if(!isFinishing()&& !dialog.isShowing() ){
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        }else {
            if(dialog.isShowing()&&!isFinishing()){
                dialog.dismiss();
            }

        }

    }





    @Override
    protected void onPause() {
        super.onPause();
     }

    @Override
    protected void onResume() {
        super.onResume();
     }


}
