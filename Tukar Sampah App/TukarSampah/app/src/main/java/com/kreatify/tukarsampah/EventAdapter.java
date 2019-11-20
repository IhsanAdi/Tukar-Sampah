package com.kreatify.tukarsampah;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{

    Context context;
    List<Event> eventList;

    public EventAdapter(Context context, List<Event> eventList){
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.news_list, null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        Event event = eventList.get(i);
        eventViewHolder.event_title.setText(event.getEvent_title());
        eventViewHolder.event_category.setText(event.getEvent_category());
        eventViewHolder.event_pic.setImageDrawable(context.getResources().getDrawable(event.getEvent_pic()));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder{
        TextView event_title, event_category;
        ImageView event_pic;

        public EventViewHolder(@NonNull View itemView){
            super(itemView);

            event_title = itemView.findViewById(R.id.event_title);
            event_category = itemView.findViewById(R.id.event_category);
            event_pic = itemView.findViewById(R.id.event_pic);
        }
    }
}
