package com.android.sonsofpitches.starbazaar;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoInformation extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_information);
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
