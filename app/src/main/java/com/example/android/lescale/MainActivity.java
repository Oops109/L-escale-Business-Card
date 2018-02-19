package com.example.android.lescale;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView eMailButton = findViewById(R.id.mail_icon);
        ImageView phoneButton = findViewById(R.id.phone_icon);
        ImageView locationButton = findViewById(R.id.location_icon);
        ImageView webButton = findViewById(R.id.web_icon);

        eMailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //send an email
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + getString(R.string.mail_link))); // only email apps should handle this
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        phoneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //call number
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + getString(R.string.phone_number))); // only email apps should handle this
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        locationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // display on Google maps
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=48.763979, 7.850917(L'Escale+Bischwiller)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);

                }
            }
        });
        webButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Display website
                String url = getString(R.string.web_link);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

    }
}