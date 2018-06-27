package com.android.sonsofpitches.starbazaar;

import android.os.Parcel;
import android.os.Parcelable;

public class EventsList_Event implements Parcelable {

    private String eventName;
    private String eventDate;
    private String location_full;
    private String eventTime;
    private String location_brief;
    private int thumbnail;

    public EventsList_Event(String eventName, String eventDate, String location_full, String eventTime, String location_brief, int thumbnail) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location_full = location_full;
        this.eventTime = eventTime;
        this.location_brief = location_brief;
        this.thumbnail = thumbnail;
    }

    public EventsList_Event(Parcel input) {
        this.eventName = input.readString();
        this.eventDate = input.readString();
        this.eventTime = input.readString();
        this.location_full = input.readString();
        this.location_brief = input.readString();
        this.thumbnail = input.readInt();
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getLocation_full() {
        return location_full;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getLocation_brief() {
        return location_brief;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    /**
     * Not entirely sure what this function is for.
     * @return 0.
     */
    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //NOTE: Writing to and Reading from Parcel follows a First in First Out model.
        //Writing in the thumbnail int first followed by "id" int means when doing a read from the
        //parcel, the thumbnail int will be retrieved first.
        dest.writeString(eventName);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(location_full);
        dest.writeString(location_brief);
        dest.writeInt(this.thumbnail);
    }

    public static final Parcelable.Creator<EventsList_Event> CREATOR = new Parcelable.Creator<EventsList_Event>() {
        @Override
        public EventsList_Event createFromParcel(Parcel source) {
            return new EventsList_Event(source);
        }

        @Override
        public EventsList_Event[] newArray(int size) {
            return new EventsList_Event[size];
        }
    };


}
