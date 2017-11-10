package com.alia.testvk.network;

import com.alia.testvk.model.NewsfeedResponse;

import retrofit2.http.Query;
import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by Alyona on 10.11.2017.
 */

public interface VKApi {
    String BASE_URL = "https://api.vk.com/method/";

    @GET("newsfeed.get?filters=video&v=5.69")
   Observable<NewsfeedResponse> getNewsfeedVideo(@Query("access_token") String token, @Query("count") Integer count );
}
