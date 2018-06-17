package com.android.sonsofpitches.starbazaar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;


public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        RelativeLayout eventOverview = findViewById(R.id.eventOverview);
        eventOverview.setBackgroundResource(R.drawable.svg_loginpage_background);
    }

    public void onClickShop (View view) {
        Intent goToShop = new Intent(this, IndividualShopDetails.class);
        startActivity(goToShop);
    }

    // TODO: Fill in the events list class name (Back button functionality?)
    public void backButton (View view) {
        Intent goBackToEvents = new Intent(this,LoginPage.class ); // FILL IN EVENTS LIST CLASS INSTEAD. JUST PUT THIS AS A
                                                                                // FILLER FOR THE TIME BEING.
        startActivity(goBackToEvents);
    }
}
