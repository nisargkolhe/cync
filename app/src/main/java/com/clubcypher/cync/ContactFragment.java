package com.clubcypher.cync;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nisargkolhe on 5/29/15.
 */
public class ContactFragment extends Fragment {

    public ContactFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        final EditText subject = (EditText) rootView.findViewById(R.id.txtSubject);
        final EditText body = (EditText) rootView.findViewById(R.id.txtQuery);
        Button sendBtn = (Button) rootView.findViewById(R.id.button);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail(subject.getText().toString(),body.getText().toString());
                // after sending the email, clear the fields
            }
        });
            return rootView;
    }

    protected void sendEmail(String subject, String body) {
        String[] recipients = {"admin@clubcypher.com"};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        try {
            startActivity(Intent.createChooser(email, "Choose an email client from..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }
    }


}
