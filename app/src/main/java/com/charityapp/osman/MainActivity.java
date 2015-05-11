package com.charityapp.osman;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.VideoCallbacks;


public class MainActivity extends ActionBarActivity {

    private TextView videoShow;
    boolean isAvailable=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoShow= (TextView) findViewById(R.id.videoShow);

        videoShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (Appodeal.isLoaded(Appodeal.VIDEO)) {

                    Appodeal.show(MainActivity.this, Appodeal.VIDEO);

                } else {

                    Toast.makeText(MainActivity.this, "Video is not loaded", Toast.LENGTH_LONG).show();

                }
            }

        });

        String appKey = "68ee5bc0d4314c7bc08a122b1d8c4b95b2dcebb2c37f3065";

        Appodeal.initialize(this, appKey);

        Appodeal.cache(this, Appodeal.VIDEO);

        Appodeal.setVideoCallbacks(new VideoCallbacks() {
            @Override
            public void onVideoLoaded() {

            }

            @Override
            public void onVideoFailedToLoad() {

            }

            @Override
            public void onVideoShown() {

            }

            @Override
            public void onVideoFinished() {

                Toast.makeText(MainActivity.this, "You got 1 point", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onVideoClosed() {

                isAvailable = false;

            }
        });

    }

}
