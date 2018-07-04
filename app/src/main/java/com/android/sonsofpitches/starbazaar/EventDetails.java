package com.android.sonsofpitches.starbazaar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class EventDetails extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener{

    private EventsList_Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        RelativeLayout eventOverview = findViewById(R.id.eventOverview);
        eventOverview.setBackgroundResource(R.drawable.svg_loginpage_background);
        TextView eventDate = this.findViewById(R.id.dateText);
        TextView eventTime = this.findViewById(R.id.timeText);
        TextView eventLocation = this.findViewById(R.id.addressText);

        this.event = this.getIntent().getParcelableExtra("Event");
        eventDate.setText(event.getEventDate());
        eventTime.setText(event.getEventTime());
        eventLocation.setText(event.getEventLocationFull());

    }

    public void onClickShop (View view) {
        Intent goToShop = new Intent(this, IndividualShopDetails.class);
        startActivity(goToShop);
    }

    public void onClickFloorPlan (View view) {
        Intent goToFloor = new Intent(this, FloorPlan.class);
        startActivity(goToFloor);
    }

    @Override
    public void setHeaderText(TextView headerText) {
        headerText.setText(this.getIntent().getStringExtra("EventName"));

    }



    @Override
    public void revertToPreviousPage() {
        this.finish();
    }
}
