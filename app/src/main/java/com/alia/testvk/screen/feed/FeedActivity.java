package com.alia.testvk.screen.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alia.testvk.screen.login.MainActivity;
import com.alia.testvk.R;

public class FeedActivity extends AppCompatActivity {
    private static final String TAG = "FeedActivity debug";
    private String accessToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        accessToken = getIntent().getStringExtra(MainActivity.EXTRA_TOKEN);
    }
}
