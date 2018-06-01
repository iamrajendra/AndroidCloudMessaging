package io.github.iamrajendra.androidcloudmessaging.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MsgModel {

    @Expose
    @SerializedName("data")
    public Data data;
    @Expose
    @SerializedName("to")
    public String to;

    public static class Data {
        @Expose
        @SerializedName("message")
        public String message;

        @Expose
        @SerializedName("action")
        public String action;

        @Expose
        @SerializedName("topic")
        public String topic;

        @Expose
        @SerializedName("topicid")
        public String topicId;

    }
}
