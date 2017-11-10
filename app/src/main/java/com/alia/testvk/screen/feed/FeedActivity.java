package com.alia.testvk.screen.feed;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alia.testvk.model.Item;
import com.alia.testvk.model.NewsfeedResponse;
import com.alia.testvk.model.Response;
import com.alia.testvk.network.RetrofitService;
import com.alia.testvk.network.VKApi;
import com.alia.testvk.screen.login.MainActivity;
import com.alia.testvk.R;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FeedActivity extends AppCompatActivity {
    private static final String TAG = "FeedActivity debug";
    private String accessToken;

    @Nullable
    private Subscription mVideosSubscription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        accessToken = getIntent().getStringExtra(MainActivity.EXTRA_TOKEN);

        VKApi api = RetrofitService.getInstance().getApi();
        mVideosSubscription = api.getNewsfeedVideo(accessToken, 2)
                .map(NewsfeedResponse::getResponse)
                .map(Response::getItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleData, this::showError);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideosSubscription != null){
            mVideosSubscription.unsubscribe();
        }
    }

    private void handleData(List<Item> postItems) {
        Log.i(TAG, "Success");
        for (int i = 0; i < postItems.size(); i++){
            postItems.get(i).getVideo().getVideoItems();
        }

    }

    private void showError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }

}
