package com.android.sonsofpitches.starbazaar;

import android.content.Context;
import android.support.annotation.NonNull;
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
        return new EventsList_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsList_ViewHolder holder, int position) {

        

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class EventsList_ViewHolder extends RecyclerView.ViewHolder {

        TextView eventLocation;
        ImageView eventThumbnail;

        public EventsList_ViewHolder(View itemView) {
            super(itemView);
            eventLocation = itemView.findViewById(R.id.eventLocation);
            eventThumbnail = itemView.findViewById(R.id.eventThumbnail);
        }
    }

}
