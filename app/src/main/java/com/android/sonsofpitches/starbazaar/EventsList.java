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
        listOfEvents.add(new EventsList_Event("EventName1","10/10/18", "Bedok Street 42","4pm - 7pm","Bedok", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName2","11/11/18", "Geylang Street 42","4pm - 7pm","Geylang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName3","12/12/18", "Bukit Panjang Street 42","4pm - 7pm","Bukit Panjang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName4","13/1/18", "Bukit Batok Street 42","4pm - 7pm","Bukit Batok", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName5","14/2/18", "Pasir Panjang Street 42","4pm - 7pm","Pasir Panjang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName6","15/3/18", "Jurong East Street 42","4pm - 7pm","Jurong East", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName7","16/4/18", "Marina Bay Street 42","4pm - 7pm","Marina Bay", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName8","17/5/18", "Choa Chu Kang Street 42","4pm - 7pm","Choa Chu Kang", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName9","18/6/18", "Payar Lebar Street 42","4pm - 7pm","Payar Lebar", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName10","19/7/18", "Tampines Street 42","4pm - 7pm","Tampines", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName11","20/8/18", "Little India Street 42","4pm - 7pm","Little India", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName12","21/9/18", "Chinatown Street 42","4pm - 7pm","Chinatown", R.drawable.test_image));
        listOfEvents.add(new EventsList_Event("EventName13","22/10/18", "Botanic Gardens Street 42","4pm - 7pm","Botanic Gardens", R.drawable.test_image));

        RecyclerView myrv = findViewById(R.id.eventsListRecyclerView);
        EventsList_RecyclerViewAdapter myAdapter = new EventsList_RecyclerViewAdapter(this, listOfEvents);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);

    }
}
