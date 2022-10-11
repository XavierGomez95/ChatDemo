package com.androidpprog2.chatdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidpprog2.chatdemo.tools.Constants;
import com.androidpprog2.chatdemo.R;

public class SplashScreenActicvity extends AppCompatActivity {

    private ImageView splashImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_scheen_activity);
        splashImage = findViewById(R.id.splash_image);
        //splashImage.getLayoutParams().height = 300;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadAnimation(); // TEMPORAL
                /*if (Internet.getInstance().hasInternet(getApplicationContext())) {
                    if (userLoged()) {
                        loadAnimation();
                    } else {
                        register();
                    }
                } else startNoInternetActivity();*/
            }
        }, Constants.SPLASH_SCREEN_TIME);
    }

    private boolean userLoged() {
        // TODO
        return false; // For the moment, set true or false to debug
    }

    private void loadAnimation() {
        Log.d(Constants.ANIMATION_TAG, "ÇÇÇÇ_ load animation method called");
        Animation animation = new TranslateAnimation(0, 0, 0, toYDelta());
        animation.setDuration(Constants.ANIMATION_TIME);
        animation.setFillAfter(true); // Avoid show the real position of the image
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(Constants.ANIMATION_TAG, "ÇÇÇÇ_ animation start listener called");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(Constants.ANIMATION_TAG, "ÇÇÇÇ_ animation end listener called");
                logIn();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        splashImage.startAnimation(animation);
    }

    private float toYDelta() {
        return getResources().getDimensionPixelOffset(R.dimen.splash_image_top_start) - splashImage.getY();
    }

    private void logIn() {
        Intent intent = new Intent(SplashScreenActicvity.this, LoginActivity.class);
        intent.putExtra(Constants.LOGIN_STATUS, true);
        startActivity(intent);
        //overridePendingTransition(Constants.FADE_IN_TIME, Constants.FADE_OUT_TIME); // TEMPORAL
        overridePendingTransition(R.anim.fade_in_animation, R.anim.fade_out_animation);
        finish();
    }

    private void register() {
        Intent intent = new Intent(SplashScreenActicvity.this, RegisterActivity.class);
        intent.putExtra(Constants.REGISTER_STATUS, false);
        startActivity(intent);
        finish();
    }

    private void startNoInternetActivity() {
        Intent intent = new Intent(SplashScreenActicvity.this, NoInternetActivity.class);
        intent.putExtra(Constants.INTERNET_CONNECTION, false);
        startActivity(intent);
        finish();
    }
}
