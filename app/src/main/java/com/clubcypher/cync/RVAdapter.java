package com.clubcypher.cync;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nisargkolhe on 7/9/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {

    OnItemClickListener mItemClickListener;

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView name;
        public TextView desc;
        public ImageView poster;
        public View view;
        public Event currentEvent;

        public EventViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                    Toast.makeText(v.getContext(), currentEvent.name, Toast.LENGTH_SHORT).show();
                }
            });
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
        eventViewHolder.currentEvent = events.get(i);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name,desc;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            desc = (TextView)itemView.findViewById(R.id.desc);
            img = (ImageView)itemView.findViewById(R.id.poster);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(v, getPosition()); //OnItemClickListener mItemClickListener;
        }


    }

    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

}
