package com.example.ad8;

import com.example.ad8.util.HttpUtil;
import com.example.ad8.util.OkHttpUtil;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtilTest {
    String req = "{\n" +
            "    \"pointIds\": [\n" +
            "        3760250913948672,\n" +
            "        3649504736396288\n" +
            "    ],\n" +
            "    \"tenantId\": 222,\n" +
            "    \"startTime\": \"2020-08-01T01:55:47.620Z\",\n" +
            "    \"endTime\": \"2020-08-10T05:55:47.620Z\",\n" +
            "    \"aggregation\": \"PERCENT\",\n" +
            "    \"intervals\": [\n" +
            "        \"1\",\n" +
            "        \"h\"\n" +
            "    ]\n" +
            "}";

    @Test
    public void testSync() {

        JSONObject response = HttpUtil.postJsonRequest("http://localhost:8001/timeseries/aggregate/query/ids", req);
        System.out.println(response.toString());
    }

    @Test
    public void testASync() {
        List<String> resp = new ArrayList<>();
        okhttp3.Callback callback = new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String string = response.body().string();
                System.out.println(string);
                resp.add(string);
            }
        };

        HttpUtil.postJsonRequestAsync("http://localhost:8001/timeseries/aggregate/query/ids", req,callback);

        while (resp.size() == 0){
            System.out.println("wait");
        }

        System.out.println(resp);
    }

    @Test
    public void okHttpCallbackTest(){
        OkHttpUtil.ResultCallback resultCallback = new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        };
        OkHttpUtil.getDataAsync("http://localhost:8001/timeseries/aggregate/query/ids", resultCallback);
    }

}
