package com.example.countdowntimerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView=findViewById(R.id.tview);

        long duration = TimeUnit.MINUTES.toMillis(1);

        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String sDuration=String.format(Locale.ENGLISH,"%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l),
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                tView.setText(sDuration);
            }

            @Override
            public void onFinish() {
                tView.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Countdown timer has ended",Toast.LENGTH_LONG).show();

            }
        }.start();

    }
}