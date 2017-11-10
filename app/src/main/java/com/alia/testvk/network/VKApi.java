package com.alia.testvk.network;

import com.alia.testvk.model.NewsfeedResponse;
import com.alia.testvk.model.VideoResponse;

import retrofit2.http.Query;
import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by Alyona on 10.11.2017.
 */

public interface VKApi {
    String BASE_URL = "https://api.vk.com/method/";

    @GET("newsfeed.get?filters=video&v=5.69")
    Observable<NewsfeedResponse> getNewsfeedVideos(@Query("access_token") String token, @Query("count") Integer count);

    @GET("video.get?v=5.69")
    Observable<VideoResponse> getVideo(@Query("access_token") String token, @Query("videos") String ids);
}
