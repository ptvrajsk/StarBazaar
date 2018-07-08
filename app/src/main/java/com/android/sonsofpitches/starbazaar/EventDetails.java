package com.android.sonsofpitches.starbazaar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
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

    public void onClickBaskinRobbins (View view) {
        String description = "Baskin-Robbins offers over 1000 flavors of ice cream, including Sugar " +
                "Free, Fat Free and Light choices. Our menu also includes frozen " +
                "yogurt, sorbets, sherbets";
        int id = R.drawable.baskinrobbins;
        Shop currentShop = new Shop (id, description, "Baskin Robbins" );
        Intent goToShop = new Intent(this, IndividualShopDetails.class);
        goToShop.putExtra("currentShop", currentShop);
        startActivity(goToShop);
        //ImageView logo = new ImageView(this);
        //logo.setImageResource(R.drawable.br);
        //TextView description = new TextView(this);





    }

    public void onClickFloorPlan (View view) {
        Intent goToFloor = new Intent(this, FloorPlan.class);
        goToFloor.putExtra("Floor Plan", "Floor Plan");
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
