package com.clubcypher.cync;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nisargkolhe on 7/9/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {
    public static class EventViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView desc;
        ImageView poster;

        EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.title);
            desc = (TextView)itemView.findViewById(R.id.desc);
            poster = (ImageView)itemView.findViewById(R.id.poster);
        }
    }

    List<Event> events;

    RVAdapter(List<Event> events){
        this.events = events;
    }

    @Override
    public int getItemCount(){
        return events.size();
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        EventViewHolder evh = new EventViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventViewHolder, int i) {
        eventViewHolder.name.setText(events.get(i).name);
        eventViewHolder.desc.setText(events.get(i).desc);
        eventViewHolder.poster.setImageResource(events.get(i).imgid);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
