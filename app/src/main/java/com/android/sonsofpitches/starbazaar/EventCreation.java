package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventCreation extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation);

        ConstraintLayout creationActivity = findViewById(R.id.eventCreationActivity);
        creationActivity.setBackgroundResource(R.drawable.svg_loginpage_background);

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
