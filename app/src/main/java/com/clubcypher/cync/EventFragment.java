package com.clubcypher.cync;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


        String eventName = "";
        switch (eventID){
            case 1:
                eventName = "(c)ode";
                break;
            case 2:
                eventName = "Decypher";
                break;
            case 3:
                eventName = "(c)lick";
                break;
            case 4:
                eventName = "(c)reation";
                break;
            case 5:
                eventName = "Respawn";
                break;
            case 6:
                eventName = "(c)yptic crossword";
                break;
            case 7:
                eventName = "(c)ynth";
                break;
            case 8:
                eventName = "Suprise Event";
                break;

        }
        name.setText(eventName);


        return rootView;
    }


}
