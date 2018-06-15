package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventsList extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

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
    }
}
