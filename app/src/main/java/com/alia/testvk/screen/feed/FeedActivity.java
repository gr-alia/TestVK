package com.alia.testvk.screen.feed;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alia.testvk.model.Item;
import com.alia.testvk.model.NewsfeedResponse;
import com.alia.testvk.model.Response;
import com.alia.testvk.model.Video;
import com.alia.testvk.model.VideoItem;
import com.alia.testvk.model.VideoResponse;
import com.alia.testvk.network.RetrofitService;
import com.alia.testvk.network.VKApi;
import com.alia.testvk.screen.login.MainActivity;
import com.alia.testvk.R;
import com.alia.testvk.screen.player.PlayerActivity;
import com.vk.sdk.VKSdk;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FeedActivity extends AppCompatActivity implements VideoAdapter.OnItemClickListener {
    public static final String EXTRA_PLAYER = "FeedActivity.EXTRA_PLAYER";
    private static final String TAG = "FeedActivity debug";
    private String accessToken;
    private VideoAdapter mAdapter;
    private VKApi api;

    @Nullable
    private Subscription mNewsfeedSubscription;
    private Subscription mVideoSubscription;


    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.video_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        accessToken = getIntent().getStringExtra(MainActivity.EXTRA_TOKEN);

        mAdapter = new VideoAdapter(this, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        api = RetrofitService.getInstance().getApi();
        mNewsfeedSubscription = api.getNewsfeedVideos(accessToken, 5)
                .map(NewsfeedResponse::getResponse)
                .map(Response::getItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleData, this::showError);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mNewsfeedSubscription != null) {
            mNewsfeedSubscription.unsubscribe();
        } else if (mVideoSubscription != null) {
            mVideoSubscription.unsubscribe();
        }
    }

    private void handleData(List<Item> postItems) {
        Log.i(TAG, "Success");
        List<VideoItem> videos = new ArrayList<>();
        for (int i = 0; i < postItems.size(); i++) {
            videos.addAll(postItems.get(i).getVideo().getVideoItems());
        }
        mAdapter.changeDataSet(videos);
    }

    private void createIntent(List<Item> videos) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra(EXTRA_PLAYER, videos.get(0).getPlayer());
        startActivity(intent);
    }

    private void showError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(@NonNull View view, @NonNull VideoItem video) {
        mVideoSubscription = api.getVideo(accessToken, video.getCombId())
                .map(VideoResponse::getResponse)
                .map(Response::getItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::createIntent, this::showError);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_exit:
                Boolean is = VKSdk.isLoggedIn();
                VKSdk.logout();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
