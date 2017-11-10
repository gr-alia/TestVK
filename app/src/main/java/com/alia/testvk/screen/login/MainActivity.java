package com.alia.testvk.screen.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alia.testvk.R;
import com.alia.testvk.screen.feed.FeedActivity;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TOKEN = "MainActivity.EXTRA_TOKEN";
    private LoginController mLoginController;
    private String scopes[] = {"video", "wall", "friends"};

    @BindView(R.id.login)
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginController = new LoginController(this);
        if (!VKSdk.isLoggedIn()) {
            mLoginController.deleteToken();
        }
        if (mLoginController.getToken() != null) {
            openFeed();
            finish();
        }
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VKSdk.login(MainActivity.this, scopes);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                mLoginController.persistToken(res);
                openFeed();

            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this, String.valueOf(error), Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void openFeed() {
        String token = mLoginController.getToken().accessToken;
        Intent intent = new Intent(MainActivity.this, FeedActivity.class);
        intent.putExtra(EXTRA_TOKEN, token);
        startActivity(intent);
    }


}
