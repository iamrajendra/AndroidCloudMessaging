package io.github.iamrajendra.androidcloudmessaging.helper;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Date;

public class FirsebaseUpwardMessaging {
    private static FirsebaseUpwardMessaging messaging;
    private String senderId;
    private FirebaseMessaging firebaseMessaging;
    private String SENDER_ID = "84480201252";
    private RemoteMessage message;


    public FirsebaseUpwardMessaging() {
        firebaseMessaging = FirebaseMessaging.getInstance();

        firebaseMessaging = FirebaseMessaging.getInstance();


    }

    public void sendMessage(String msg, String action) {

        firebaseMessaging.send(new RemoteMessage.Builder(SENDER_ID + "@gcm.googleapis.com")
                .setMessageId(Integer.toString(getId()))
                .addData("message", msg)
                .addData("action", action)
                .build());
    }


    public int getId() {

        return (int) new Date().getTime();
    }
}
