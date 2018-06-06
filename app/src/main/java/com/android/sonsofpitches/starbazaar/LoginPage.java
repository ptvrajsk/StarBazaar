package com.android.sonsofpitches.starbazaar;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        ConstraintLayout loginPageView = findViewById(R.id.loginPage);
        Button userButton = findViewById(R.id.userButton);
        Button orgButton = findViewById(R.id.orgButton);

        loginPageView.setBackgroundResource(R.drawable.loginpagebackground);
        userButton.setBackgroundResource(R.drawable.loginpage_userbutton_background);
        orgButton.setBackgroundResource(R.drawable.loginpage_orgbutton_background);

    }
}
