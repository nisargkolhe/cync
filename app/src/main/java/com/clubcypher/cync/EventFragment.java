package com.clubcypher.cync;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nisargkolhe on 5/29/15.
 */
public class EventFragment extends Fragment {

    public EventFragment(){}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event, container, false);
        Bundle bundle=getArguments();
        int eventID = (int) bundle.getFloat("eventid");



        TextView name = (TextView) rootView.findViewById(R.id.eventName);
        ImageView img = (ImageView) rootView.findViewById(R.id.logo);

        String eventName = "";
        switch (eventID){
            case 1:
                eventName = "(c)ode";
                img.setImageResource(R.drawable.code);
                break;
            case 2:
                eventName = "Decypher";
                img.setImageResource(R.drawable.decypher);
                break;
            case 3:
                eventName = "(c)lick";
                img.setImageResource(R.drawable.click);
                break;
            case 4:
                eventName = "(c)reation";
                img.setImageResource(R.drawable.creation);
                break;
            case 5:
                eventName = "Respawn";
                img.setImageResource(R.drawable.respawn);
                break;
            case 6:
                eventName = "(c)yptcross";
                img.setImageResource(R.drawable.code);
                break;
            case 7:
                eventName = "(c)ynth";
                img.setImageResource(R.drawable.cynth);
                break;
            case 8:
                eventName = "Suprise Event";
                img.setImageResource(R.drawable.code);
                break;

        }
        name.setText(eventName);


        return rootView;
    }


}
