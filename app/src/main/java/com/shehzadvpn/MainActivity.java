package com.shehzadvpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(30, 30, 30, 30);
        layout.setBackgroundColor(Color.rgb(12, 20, 38));

        TextView title = new TextView(this);
        title.setText("SHEHZAD VPN");
        title.setTextSize(30);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("My Personal VPN");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        layout.addView(subtitle);

        Spinner countries = new Spinner(this);
        String[] list = {
            "Select Country",
            "Bangladesh",
            "Malaysia",
            "Singapore",
            "India",
            "Pakistan",
            "United States",
            "United Kingdom"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item);
        countries.setAdapter(adapter);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 120);
        params.topMargin = 50;
        layout.addView(countries, params);

        Button connect = new Button(this);
        connect.setText("CONNECT");
        layout.addView(connect);

        TextView status = new TextView(this);
        status.setText("Status: Not Connected");
        status.setTextColor(Color.WHITE);
        status.setGravity(Gravity.CENTER);
        status.setTextSize(16);
        layout.addView(status);

        connect.setOnClickListener(v -> {
            if (countries.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Select a country first",
                    Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                    "VPN server configuration is not added yet",
                    Toast.LENGTH_LONG).show();
            }
        });

        setContentView(layout);
    }
}
