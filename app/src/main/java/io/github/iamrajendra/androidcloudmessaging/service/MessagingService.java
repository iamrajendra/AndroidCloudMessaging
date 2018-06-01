package io.github.iamrajendra.androidcloudmessaging.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MessagingService extends FirebaseMessagingService {
    public static final String CONSTANT_SUBSCRIBE = "subscribe";
    public static final String CONSTANT_UNSUBSCRIBE = "unsubscribe";
    private String TAG = MessagingService.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i(TAG, "onMessageReceived: " + remoteMessage);

        Map<String, String> datamap = remoteMessage.getData();
        Log.i(TAG, "msg " + datamap.get("message"));
        if (!datamap.containsKey("action") || datamap.get("action") == null) {
            return;
        }
        switch (datamap.get("action")) {
            case CONSTANT_SUBSCRIBE:
                FirebaseMessaging.getInstance().subscribeToTopic(datamap.get("topic"));
                break;
            case CONSTANT_UNSUBSCRIBE:
                FirebaseMessaging.getInstance().unsubscribeFromTopic(datamap.get("topic"));
                break;
        }


    }

    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
        Log.i(TAG, "onMessageSent: " + s);
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
        Log.i(TAG, "onDeletedMessages: ");
    }

    @Override
    public void onSendError(String s, Exception e) {
        super.onSendError(s, e);
        Log.e(TAG, "onSendError: " + e);
    }
}
