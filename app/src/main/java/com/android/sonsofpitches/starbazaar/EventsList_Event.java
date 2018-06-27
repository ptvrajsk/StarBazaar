package com.android.sonsofpitches.starbazaar;

public class EventsList_Event {

    private String location;
    private int thumbnail;

    public EventsList_Event(String location, int thumbnail) {
        this.location = location;
        this.thumbnail = thumbnail;
    }


    public String getLocation() {
        return location;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
