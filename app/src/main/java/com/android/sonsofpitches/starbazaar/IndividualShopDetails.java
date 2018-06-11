package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IndividualShopDetails extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    @Override
    public void setHeaderText(TextView headerText) {
        //TODO: Header text needs to match user selection from EventDetails page once implemented.
        headerText.setText(R.string.temporaryText);
    }

    @Override
    public void revertToPreviousPage() {
        //TODO: Link to event details page once implemented.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_shop_details);


        ConstraintLayout individualShopDetails = (ConstraintLayout) findViewById(R.id.individualShopDetails);
        individualShopDetails.setBackgroundResource(R.drawable.svg_loginpage_background);

        Typeface quicksandFont = Typeface.createFromAsset(getAssets(), "fonts/font_quicksand_regular.ttf");
        TextView shopDescription = (TextView) findViewById(R.id.individualShopDetailsDescription);
        shopDescription.setTypeface(quicksandFont);

    }
}
