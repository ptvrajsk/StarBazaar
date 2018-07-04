package com.android.sonsofpitches.starbazaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FloorPlan extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);
    }
    @Override
    public void setHeaderText(TextView headerText) {
        headerText.setText(this.getIntent().getStringExtra("Floor Plan"));

    }
    @Override
    public void revertToPreviousPage() {
        this.finish();
    }
}
