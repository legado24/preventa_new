package com.legado.ventagps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

import com.legado.ventagps.R;
import com.legado.ventagps.activity.base.BaseActivity;
import com.legado.ventagps.fragment.LoginFragment;
import com.legado.ventagps.fragment.RegistroFragment;

public class LoginRegistroActivity extends BaseActivity {
    LoginFragment loginFragment=new LoginFragment();
    RegistroFragment registroFragment=new RegistroFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registro);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, loginFragment).addToBackStack(null)
                    .commit();

        }
    }

    @Override
    public boolean providesActivityToolbar() {
        return false;
    }

    public void loadRegistroFragment() {
         if (registroFragment.isAdded()) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, registroFragment).addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, registroFragment).addToBackStack(null)
                    .commit();
        }
    }

    public void loadLoginFragment() {
         if (loginFragment.isAdded()) {
             getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, loginFragment).addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, loginFragment).addToBackStack(null)
                    .commit();
        }
    }
    public void loadLoginFragmentConParametros(Bundle argumentos) {
        loginFragment=new LoginFragment();
            loginFragment.setArguments(argumentos);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, loginFragment).addToBackStack(null)
                    .commit();

    }
}