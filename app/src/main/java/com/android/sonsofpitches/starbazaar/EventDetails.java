package com.android.sonsofpitches.starbazaar;


import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import java.net.URI;


public class EventDetails extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener{

    private EventsList_Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Typeface quicksandBold = Typeface.createFromAsset(getAssets(), "fonts/font_quicksand_bold.otf");

        RelativeLayout eventOverview = findViewById(R.id.eventOverview);
        eventOverview.setBackgroundResource(R.drawable.svg_loginpage_background);

        TextView eventDate = this.findViewById(R.id.dateText);
        TextView eventDateTitle = this.findViewById(R.id.dateMarket);
        TextView eventTime = this.findViewById(R.id.timeText);
        TextView eventTimeTitle = this.findViewById(R.id.timeMarket);
        TextView eventLocation = this.findViewById(R.id.addressText);
        TextView eventLocationTitle = this.findViewById(R.id.marketAddress);
        TextView participants = this.findViewById(R.id.participatingShops);


        Button floorPlan = eventOverview.findViewById(R.id.floorplanbutton);
        floorPlan.setBackgroundResource(R.drawable.individualdetails_floorplanbutton_background);
        floorPlan.setTypeface(quicksandBold);

        ScrollView participantsList = this.findViewById(R.id.individualEventScrollView);

        this.event = this.getIntent().getParcelableExtra("Event");
        eventDate.setText(event.getEventDate());
        eventDate.setTypeface(quicksandBold);
        eventDateTitle.setTypeface(quicksandBold);
        eventTime.setText(event.getEventTime());
        eventTime.setTypeface(quicksandBold);
        eventTimeTitle.setTypeface(quicksandBold);
        eventLocation.setText(event.getEventLocationFull());
        eventLocation.setTypeface(quicksandBold);
        eventLocationTitle.setTypeface(quicksandBold);
        participants.setTypeface(quicksandBold);

    }
    public void onClickGoMaps (View view) {
        TextView location = this.findViewById(R.id.addressText);
        String address = location.getText().toString();
        String wholeSyntax = "geo:0,0?q=" + address;
        Uri intentMaps = Uri.parse(wholeSyntax);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, intentMaps);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


    public void onClickBaskinRobbins (View view) {
        String description = "Baskin-Robbins offers over 1000 flavors of ice cream, including Sugar " +
                "Free, Fat Free and Light choices. Our menu also includes frozen " +
                "yogurt, sorbets, sherbets";
        int id = R.drawable.baskinrobbins;
        Shop currentShop = new Shop (id, description, "Baskin Robbins" );
        goToShop(currentShop);
    }
    public void onClickPopbar (View view) {
        String description = "Popbar introduces handcrafted gelato on a stick made with only real " +
                "fruit and a handful of all natural ingredients. All our popbars are gluten and " +
                "preservative free with no artificial colouring. Our pop Sorbettos are lactose free " +
                "and vegan friendly.";
        int id = R.drawable.popbar;
        Shop currentShop = new Shop (id, description, "Popbar" );
        goToShop(currentShop);
    }

    public void onClickChippy (View view) {
        String description = "Experience the British street food right here in Singapore now! Don't " +
                "miss out on our B.B.F. (British Battered Fish) served with salt and vinegar. " +
                "Quality battered fish doused in malt vinegar at an irresistible value of just $5, " +
                "sink your teeth into soft, juicy fish fried to crisp golden perfection.";
        int id = R.drawable.chippy;
        Shop currentShop = new Shop (id, description, "Chippy" );
        goToShop(currentShop);
    }

    public void onClickIrvins (View view) {
        String description = "Salted Egg Snacks - " +
                "Packaged in resealable packages to preserve freshness, enjoy Salted Egg everything " +
                "- from potato chips to crispy fish skin!";
        int id = R.drawable.irvings;
        Shop currentShop = new Shop (id, description, "IRVINS SALTED EGG");
        goToShop(currentShop);
    }

    public void onClickBeardPapa (View view) {
        String description = "Beard Papa bakes impossibly fragrant cream puffs bursting with" +
                " flavored custard filling including unique flavors like Melon, Hazelnut " +
                "Marshmallow and Peach Melba.";
        int id = R.drawable.beardpapa;
        Shop currentShop = new Shop (id, description, "BEARD PAPA");
        goToShop(currentShop);
    }

    public void onClickWoow(View view) {
        String description = "If you are curious how unicorns taste like, then Woow's Unicorn " +
                "Swirl is the closest you are going to get. Serving to you shaved ice dessert " +
                "milked straight from the rainbow, feast your sweet tooth and your eyes at Woow.";
        int id = R.drawable.woow;
        Shop currentShop = new Shop (id, description, "WOOW");
        goToShop(currentShop);
    }

    public void onClickWowTako(View view) {
        String description = "Wow Tako is dedicated to sharing the great taste of takoyaki with " +
                "you. We have added prawn, bacon cheese and many delicious new tastes to the " +
                "original \"octopus ball\" to offer you a delectable convenient snack anytime of " +
                "the day! Add your favourite toppings for greater taste or have it with omu rice or " +
                "noodle for a more wholesome meal.";
        int id = R.drawable.tako;
        Shop currentShop = new Shop (id, description, "WOW TAKO");
        goToShop(currentShop);
    }

    public void onClickFruits(View view) {
        String description = "SF fruits delivers superior quality cut fruits and fruit juices at a " +
                "value-for-money price positioning. We have also come up with wide range of fruit " +
                "juice combination that focuses on body wellness by selecting fruits with " +
                "antioxidant properties and packed with vitamins.";
        int id = R.drawable.fruits;
        Shop currentShop = new Shop (id, description, "SF FRUITS");
        goToShop(currentShop);
    }

    public void onClickSaybons(View view) {
        String description = "Using the freshest of food ingredients and classical French culinary" +
                " techniques, Saybons serves a range of delectable French delights. Specialties " +
                "include freshly cooked soups, variety of sweet and savoury crepes and freshly " +
                "toasted bread spread with homemade butters. We have over 6 different flavours of " +
                "escargots baked in our secret butter receipes.";
        int id = R.drawable.saybons;
        Shop currentShop = new Shop (id, description, "SAYBONS FRENCH FOOD");
        goToShop(currentShop);
    }

    public void onClickSnackz(View view) {
        String description = "No more travelling to Taiwan just for their Giant Fried Chicken or" +
                " Oyster Mee Sua because Snackz It is bringing it right to Singapore for you. " +
                "Serving your favorite Taiwanese night market signatures and other snacks like" +
                " Tempura and Sweet Potato Fritters, Snackz It takes fried food to the next level.";
        int id = R.drawable.snackz;
        Shop currentShop = new Shop (id, description, "SNACKZ IT");
        goToShop(currentShop);
    }

    public void onClickTori(View view) {
        String description = "Tori Q transform a simple chicken chunks on stick into chargrilled " +
                "goodness on a stick with our Yakitori selection. Generously coated with our special" +
                " Tare sauce to give that savoury sweet caramelization, Tori Q is BBQ upgrade.";
        int id = R.drawable.tori;
        Shop currentShop = new Shop (id, description, "TORI-Q");
        goToShop(currentShop);
    }

    public void onClickYole(View view) {
        String description = "Yolé serves soft creamy frozen multi-flavoured yogurt with a wide " +
                "variety of toppings, blended smoothies and specialty dessert like coconut " +
                "soft-serve ice cream. This is the real yummy.";
        int id = R.drawable.yole;
        Shop currentShop = new Shop (id, description, "YOLE");
        goToShop(currentShop);
    }

    public void onClickNana(View view) {
        String description = "Nana's Green Tea exemplifies the health benefits and the exquisite" +
                " aroma of Uji tea by infusing it into our selection of both sweet and savory " +
                "dishes through unconventional culinary methods that still preserves the best of" +
                " Japan's culinary traditions. Enjoy our matcha latte together with our Donburi " +
                "or Udon to have a refreshing light meal.";
        int id = R.drawable.nana;
        Shop currentShop = new Shop (id, description, "NANA'S GREEN TEA");
        goToShop(currentShop);
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

    public void goToShop(Shop currentShop) {
        Intent goToShop = new Intent(this, IndividualShopDetails.class);
        goToShop.putExtra("currentShop", currentShop);
        startActivity(goToShop);
    }
}
