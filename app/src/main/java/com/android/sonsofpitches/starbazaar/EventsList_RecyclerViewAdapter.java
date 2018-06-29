package com.android.sonsofpitches.starbazaar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventsList_RecyclerViewAdapter extends RecyclerView.Adapter<EventsList_RecyclerViewAdapter.EventsList_ViewHolder>{

    private Context mContext;
    private List<EventsList_Event> mData;

    public EventsList_RecyclerViewAdapter(Context mContext, List<EventsList_Event> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public EventsList_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.cardview_events_prefab, parent, false);

        int cardWidth = ((Resources.getSystem().getDisplayMetrics().widthPixels) / 2) - 55;
        int cardHeight = ((Resources.getSystem().getDisplayMetrics().heightPixels) / 3) - 45;

        CardView cv = view.findViewById(R.id.eventsFullCardView);
        ViewGroup.LayoutParams layoutParams = cv.getLayoutParams();
        layoutParams.width = cardWidth;
        layoutParams.height = cardHeight;
        cv.setLayoutParams(layoutParams);

        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration((TextView)view.findViewById(R.id.eventLocation), 15, 25, 1, 2);

        return new EventsList_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsList_ViewHolder holder, final int position) {

        holder.eventLocation.setText(mData.get(position).getEventLocationBrief());
        holder.eventThumbnail.setImageResource(mData.get(position).getEventThumbnail());

        CardView cv = holder.eventsCardView;

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, EventDetails.class);
                i.putExtra("Event", mData.get(position));
                i.putExtra("EventName", mData.get(position).getEventName());
                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class EventsList_ViewHolder extends RecyclerView.ViewHolder {

        TextView eventLocation;
        ImageView eventThumbnail;
        CardView eventsCardView;

        public EventsList_ViewHolder(View itemView) {
            super(itemView);
            eventLocation = itemView.findViewById(R.id.eventLocation);
            eventThumbnail = itemView.findViewById(R.id.eventThumbnail);
            eventsCardView = itemView.findViewById(R.id.eventsFullCardView);
        }
    }

}
