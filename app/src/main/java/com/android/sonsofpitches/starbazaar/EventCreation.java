package com.android.sonsofpitches.starbazaar;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventCreation extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    EditText eventNameInput;
    EditText eventDateInput;
    EditText eventLocFullInput;
    EditText eventLocBrief;
    EditText eventTimeInput;
    Button saveButton;
    Button deleteButton;
    int thumbnail = R.drawable.svg_loginpage_background;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation);

        ConstraintLayout creationActivity = findViewById(R.id.eventCreationActivity);
        creationActivity.setBackgroundResource(R.drawable.svg_loginpage_background);


        eventNameInput = this.findViewById(R.id.eventsCreationEventNameInput);
        eventDateInput = this.findViewById(R.id.eventsCreationEventDateInput);
        eventLocFullInput = this.findViewById(R.id.eventsCreationEventLocationFullInput);
        eventLocBrief = this.findViewById(R.id.eventsCreationEventLocationBriefInput);
        eventTimeInput = this.findViewById(R.id.eventsCreationEventTimeInput);

        deleteButton = this.findViewById(R.id.eventsCreationClearEvents);
        saveButton = this.findViewById(R.id.eventsCreationSaveEventButton);
        db = new DBHandler(this, null, null, 1);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addEvent(new EventsList_Event(eventNameInput.getText().toString(), eventDateInput.getText().toString(), eventLocFullInput.getText().toString(),
                            eventTimeInput.getText().toString(), eventLocBrief.getText().toString(), R.drawable.test_image));
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                db.deleteEvents();
            }
        });
    }

    @Override
    public void setHeaderText(TextView headerText) {
        headerText.setText(this.getIntent().getStringExtra("HeaderTitle"));
    }

    @Override
    public void revertToPreviousPage() {
        this.finish();
    }
}
