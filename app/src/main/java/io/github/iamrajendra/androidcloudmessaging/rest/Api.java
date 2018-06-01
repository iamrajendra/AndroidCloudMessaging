package io.github.iamrajendra.androidcloudmessaging.rest;

import io.github.iamrajendra.androidcloudmessaging.model.MsgModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @Headers({"Content-Type:application/json"})
    @POST("fcm/send")
    Call<ResponseBody> sendMsg(@Body MsgModel cx);
}
