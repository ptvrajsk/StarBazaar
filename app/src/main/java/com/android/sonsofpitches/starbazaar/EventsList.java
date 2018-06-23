package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventsList extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    List<EventsList_Event> listOfEvents;

    @Override
    public void setHeaderText(TextView headerText) {
        headerText.setText("Events");
    }

    @Override
    public void revertToPreviousPage() {
        Intent i = new Intent(this, LoginPage.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        ConstraintLayout eventsList = findViewById(R.id.eventsList);
        eventsList.setBackgroundResource(R.drawable.svg_loginpage_background);


        listOfEvents = new ArrayList<>();
        listOfEvents.add(new EventsList_Event("Bedok", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Geylang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Bukit Panjang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Bukit Batok", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Pasir Panjang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Jurong East", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Marina Bay", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Choa Chu Kang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Payar Lebar", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Tampines", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Little India", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Chinatown", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("Botanic Gardens", R.drawable.test_image));

        RecyclerView myrv = findViewById(R.id.eventsListRecyclerView);
        EventsList_RecyclerViewAdapter myAdapter = new EventsList_RecyclerViewAdapter(this, listOfEvents);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);

    }
}
