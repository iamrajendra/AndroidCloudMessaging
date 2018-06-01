package io.github.iamrajendra.androidcloudmessaging.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class IdService extends FirebaseInstanceIdService{
    private String TAG = IdService.class.getSimpleName();
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.i(TAG, "onTokenRefresh: "+ FirebaseInstanceId.getInstance().getToken());
    }
}
