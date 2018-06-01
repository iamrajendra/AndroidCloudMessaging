package io.github.iamrajendra.androidcloudmessaging.rest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL = "https://fcm.googleapis.com/";


    public static Retrofit getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()

                        .header("Authorization", "key=AAAAE6tpkiQ:APA91bFacdaRgud_FZq9Jp9FReXr20qtJh5RwQieVR6QF2TlUleUhiGctwrH9X2I-xZlXwnJ21zco4dUEHuvOTrACvT_axmmGIZPx5BPdRU0W0ckpdkWgI1sj7FHAeSLC1hMG_xx0np2")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}