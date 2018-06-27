package com.android.sonsofpitches.starbazaar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class EventDetails extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener{

    private String eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        RelativeLayout eventOverview = findViewById(R.id.eventOverview);
        eventOverview.setBackgroundResource(R.drawable.svg_loginpage_background);
        TextView eventDate = this.findViewById(R.id.dateText);
        TextView eventTime = this.findViewById(R.id.timeText);
        TextView eventLocation = this.findViewById(R.id.addressText);


        Intent i = this.getIntent();
        EventsList_Event currentEvent = i.getParcelableExtra("Event");
        this.eventName = currentEvent.getEventName();
        Toast.makeText(this, eventName, Toast.LENGTH_LONG).show();
        eventDate.setText(currentEvent.getEventDate());
        eventTime.setText(currentEvent.getEventTime());
        eventLocation.setText(currentEvent.getLocation_full());

    }

    public void onClickShop (View view) {
        Intent goToShop = new Intent(this, IndividualShopDetails.class);
        startActivity(goToShop);
    }

    @Override
    public void setHeaderText(TextView headerText) {
        headerText.setText(eventName);

    }

    @Override
    public void revertToPreviousPage() {
        this.finish();
    }
}
