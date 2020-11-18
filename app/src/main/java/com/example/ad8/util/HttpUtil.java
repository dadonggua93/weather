package com.example.ad8.util;

import com.example.ad8.constant.HttpConstant;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.ad8.constant.HttpConstant.*;

public class HttpUtil {
    private HttpUtil() {
    }


    private static Headers jsonHeader(Map<String, String> headers) {
        headers.put(CONTENT_TYPE, JSON);
        return Headers.of(headers);
    }

    private static Headers jsonHeader() {
        return jsonHeader(new HashMap<>());
    }

    public static JSONObject postJsonRequest(String url, String requestStr) {
        return request(url, requestStr, jsonHeader());
    }

    public static void postJsonRequestAsync(String url, String requestStr,Callback callback) {
        requestAsync(url, requestStr, jsonHeader(),callback);
    }

    public static JSONObject request(String url, String requestStr, Headers headers) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url)
                .headers(headers)
                .post(RequestBody.create(requestStr.getBytes(StandardCharsets.UTF_8)))
                .build();
        try {
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                return new JSONObject(execute.body().string());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void requestAsync(String url, String requestStr, Headers headers, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url)
                .headers(headers)
                .post(RequestBody.create(requestStr.getBytes(StandardCharsets.UTF_8)))
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static JSONObject getRequest(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                return new JSONObject(execute.body().string());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
