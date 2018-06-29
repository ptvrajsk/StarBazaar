package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        //Referencing Section
        ConstraintLayout loginPageView = findViewById(R.id.loginPage);

        Button userButton = findViewById(R.id.userButton);
        Button orgButton = findViewById(R.id.orgButton);

        //Logic Section
        loginPageView.setBackgroundResource(R.drawable.svg_loginpage_background);

        userButton.setBackgroundResource(R.drawable.loginpage_userbutton_background);
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(getApplicationContext(), EventsList.class);
                startActivity(m);
                finish();
            }
        });

        orgButton.setBackgroundResource(R.drawable.loginpage_orgbutton_background);
        orgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EventCreation.class);
                i.putExtra("HeaderTitle", "Create Event");
                startActivity(i);
            }
        });

        //Animation Section
        final ImageView stars = findViewById(R.id.stars);
        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Do nothing
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (animation == animationFadeIn) {
                    stars.startAnimation(animationFadeOut);
                } else {
                    stars.startAnimation(animationFadeIn);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //Do nothing
            }
        };

        animationFadeIn.setAnimationListener(animationListener);
        animationFadeOut.setAnimationListener(animationListener);
        stars.startAnimation(animationFadeIn);

    }
}
