package com.android.sonsofpitches.starbazaar;

import android.os.Parcel;
import android.os.Parcelable;

public class EventsList_Event implements Parcelable {

    private String eventName;
    private String eventDate;
    private String eventLocationFull;
    private String eventTime;
    private String eventLocationBrief;
    private int eventThumbnail;

    public EventsList_Event(String eventName, String eventDate, String eventLocationFull, String eventTime, String eventLocationBrief, int eventThumbnail) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocationFull = eventLocationFull;
        this.eventTime = eventTime;
        this.eventLocationBrief = eventLocationBrief;
        this.eventThumbnail = eventThumbnail;
    }

    public EventsList_Event(Parcel input) {
        this.eventName = input.readString();
        this.eventDate = input.readString();
        this.eventTime = input.readString();
        this.eventLocationFull = input.readString();
        this.eventLocationBrief = input.readString();
        this.eventThumbnail = input.readInt();
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocationFull() {
        return eventLocationFull;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLocationBrief() {
        return eventLocationBrief;
    }

    public int getEventThumbnail() {
        return eventThumbnail;
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
        //Writing in the eventThumbnail int first followed by "id" int means when doing a read from the
        //parcel, the eventThumbnail int will be retrieved first.
        dest.writeString(eventName);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(eventLocationFull);
        dest.writeString(eventLocationBrief);
        dest.writeInt(this.eventThumbnail);
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
