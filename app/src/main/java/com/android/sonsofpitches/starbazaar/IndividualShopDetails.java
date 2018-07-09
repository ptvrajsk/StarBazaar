package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IndividualShopDetails extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    private String headerShopName;

    @Override
    public void setHeaderText(TextView headerText) {
        //TODO: Header text needs to match user selection from EventDetails page once implemented.
        headerText.setText(headerShopName);
    }

    @Override
    public void revertToPreviousPage() {
        //TODO: Link to event details page once implemented.
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_shop_details);

        ConstraintLayout individualShopDetails = (ConstraintLayout) findViewById(R.id.individualShopDetails);
        individualShopDetails.setBackgroundResource(R.drawable.svg_loginpage_background);

        Intent intent = getIntent();
        Shop currentShop = intent.getParcelableExtra("currentShop");

        int imageID = currentShop.getShopLogo();
        String description = currentShop.getShopSummary();
        this.headerShopName = currentShop.getShopName();
        String name = currentShop.getShopName();

        ImageView logo = findViewById(R.id.individualShopDetailsImage);
        logo.setImageResource(imageID);

        TextView summary = findViewById(R.id.individualShopDetailsDescription);
        summary.setText(description);

        TextView shopName = findViewById(R.id.shopName);
        shopName.setText(name);

    }
}
