package dev.hunteraffiras.mativegentlre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView on = findViewById(R.id.switcher_on);
        ImageView off = findViewById(R.id.switcher_off);

        off.setOnClickListener(v -> {
            off.setVisibility(View.INVISIBLE);
            on.setVisibility(View.VISIBLE);
        });

        on.setOnClickListener(v -> {
            on.setVisibility(View.INVISIBLE);
            off.setVisibility(View.VISIBLE);
        });
    }
}