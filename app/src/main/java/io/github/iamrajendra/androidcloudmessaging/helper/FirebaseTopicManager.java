package io.github.iamrajendra.androidcloudmessaging.helper;

import com.google.firebase.messaging.FirebaseMessaging;

import io.github.iamrajendra.androidcloudmessaging.model.MsgModel;
import io.github.iamrajendra.androidcloudmessaging.rest.Api;
import io.github.iamrajendra.androidcloudmessaging.rest.Client;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class FirebaseTopicManager {
    Api api;
    MsgModel msgModel;
    Callback<ResponseBody> callback;
    private String TAG = "FirebaseTopicManager";

    public FirebaseTopicManager() {
        api = Client.getClient().create(Api.class);
        msgModel = new MsgModel();
        FirebaseMessaging.getInstance().subscribeToTopic("all");
    }

    public void setCallback(Callback<ResponseBody> callback) {
        this.callback = callback;
    }

   public void sendMsg(String msg) {
        msgModel.data = new MsgModel.Data();
        msgModel.data.message = msg;

    }

     public void createEvent(String eventId, String eventName) {
        msgModel.data = new MsgModel.Data();
        msgModel.data.message = eventName + "event is created";
        msgModel.data.action = "subscribe";
        msgModel.data.topicId = eventId;
    }

    public  void deleteEvent(String eventId, String eventName) {
        msgModel.data = new MsgModel.Data();
        msgModel.data.message = eventName + " event is delete";
        msgModel.data.action = "unsubscribe";
        msgModel.data.topic = eventName;
        msgModel.data.topicId = eventId;

    }

   public void build() {
        Call<ResponseBody> call = api.sendMsg(msgModel);
        call.enqueue(callback);
    }

}
