package io.github.iamrajendra.androidcloudmessaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.firebase.messaging.FirebaseMessaging;

import io.github.iamrajendra.androidcloudmessaging.helper.FirebaseTopicManager;
import io.github.iamrajendra.androidcloudmessaging.helper.FirsebaseUpwardMessaging;
import io.github.iamrajendra.androidcloudmessaging.model.MsgModel;
import io.github.iamrajendra.androidcloudmessaging.rest.Api;
import io.github.iamrajendra.androidcloudmessaging.rest.Client;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<ResponseBody> {

    private String TAG = "MainActivity";
    private FirebaseTopicManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sendUpStreamMsg).setOnClickListener(this);
        findViewById(R.id.sendMsg).setOnClickListener(this);
        findViewById(R.id.subscribe).setOnClickListener(this);
        findViewById(R.id.unsubscribe).setOnClickListener(this);

        manager = new FirebaseTopicManager();
        manager.setCallback(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendUpStreamMsg:
                FirsebaseUpwardMessaging messaging = new FirsebaseUpwardMessaging();
                messaging.sendMessage("msg", "kill");
                break;
            case R.id.sendMsg:
                manager.sendMsg("Hi");

                break;
            case R.id.subscribe:

               manager.createEvent("raj","rajendra");
                break;

            case R.id.unsubscribe:
                manager.deleteEvent("raj","rajendra");
                break;


        }


    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }
}
