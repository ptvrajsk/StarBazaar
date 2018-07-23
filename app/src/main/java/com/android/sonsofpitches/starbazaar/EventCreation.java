package com.android.sonsofpitches.starbazaar;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class EventCreation extends AppCompatActivity implements HeaderFragment.HeaderFragmentListener {

    public static final int PICK_IMAGE = 1;
    EditText eventNameInput;
    EditText eventDateInput;
    EditText eventLocFullInput;
    EditText eventLocBrief;
    EditText eventTimeInput;
    Button saveButton;
    Button deleteButton;
    int thumbnail = R.drawable.svg_loginpage_background;
    String eventImage;
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
                            eventTimeInput.getText().toString(), eventLocBrief.getText().toString(), eventImage));
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                db.deleteEvents();
            }
        });


        Button chooseImage = this.findViewById(R.id.eventsCreationSelectImage);
        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {

            Uri imgData = data.getData();

            try {
/*                InputStream inputStream = getContentResolver().openInputStream(imgData);
                Bitmap photo = BitmapFactory.decodeStream(inputStream);*/

                this.eventImage = getImageFilePath(imgData);
                Toast.makeText(this, eventImage, Toast.LENGTH_SHORT).show();
            } catch (NullPointerException e) {
                Toast.makeText(this, "Image cannot be found", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


            /*Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");*/
        }
    }

    private byte[] bitmapToByte(Bitmap photo) {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] output = stream.toByteArray();
            stream.close();
            return output;
        } catch (IOException e) {
            Toast.makeText(this, "Issue with Image compression", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void setHeaderText(TextView headerText) {
        headerText.setText(this.getIntent().getStringExtra("HeaderTitle"));
    }

    @Override
    public void revertToPreviousPage() {
        this.finish();
    }

    public String getImageFilePath(Uri uri) {
        String path = null, image_id = null;

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            image_id = cursor.getString(0);
            image_id = image_id.substring(image_id.lastIndexOf(":") + 1);
            cursor.close();
        }

        cursor = getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + " = ? ", new String[]{image_id}, null);
        if (cursor!=null) {
            cursor.moveToFirst();
            path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            cursor.close();
        }
        return path;
    }

}
