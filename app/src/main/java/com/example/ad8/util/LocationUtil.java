package com.example.ad8.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ad8.db.Ad8City;
import com.example.ad8.db.Ad8County;
import com.example.ad8.db.Ad8Province;


public class LocationUtil {
    public static double lat = 0d;
    public static double lon = 0d;

    /**
     *
     */
    public static boolean handleTencentDistrictResponse(String response) {
        if (StringUtil.isNotBlank(response)) {
            JSONObject responseJson = JSONObject.parseObject(response);
            int status = responseJson.getInteger("status");
            if (status == 0) {
                JSONArray result = responseJson.getJSONArray("status");
                JSONArray provinces = result.getJSONArray(0);
                JSONArray cities = result.getJSONArray(1);
                JSONArray counties = result.getJSONArray(2);
                for (int i = 0; i < provinces.size(); i++) {
                    JSONObject province = provinces.getJSONObject(i);

                    Ad8Province pro = new Ad8Province();
                    pro.setId(province.getLong("id"));
                    pro.setProvinceCode(province.getString("id"));
                    pro.setProvinceName(province.getString("fullname"));
                    JSONArray cidx = province.getJSONArray("cidx");
                    if (cidx != null) {
                        // todo
                    }
                    pro.save();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 处理省
     */
    public static boolean handleProvinceResponse(String response) {
        if (StringUtil.isNotBlank(response)) {
            try {
                JSONArray provinces = new JSONArray(response);
                for (int i = 0; i < provinces.length(); i++) {
                    JSONObject province = provinces.getJSONObject(i);
                    Ad8Province pro = new Ad8Province();
                    pro.setId(province.getLong("id"));
                    pro.setProvinceCode(province.getString("id"));
                    pro.setProvinceName(province.getString("name"));
                    pro.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 处理市
     */
    public static boolean handleCityResponse(String response, long provinceId) {
        if (StringUtil.isNotBlank(response)) {
            try {
                JSONArray cities = new JSONArray(response);
                for (int i = 0; i < cities.length(); i++) {
                    JSONObject city = cities.getJSONObject(i);
                    Ad8City ci = new Ad8City();
                    ci.setId(city.getLong("id"));
                    ci.setCityCode(city.getString("id"));
                    ci.setCityName(city.getString("name"));
                    ci.setProvinceId(provinceId);
                    ci.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 处理区
     */
    public static boolean handleCountyResponse(String response, long provinceId, long cityId) {
        if (StringUtil.isNotBlank(response)) {
            try {
                JSONArray counties = new JSONArray(response);
                for (int i = 0; i < counties.length(); i++) {
                    JSONObject county = counties.getJSONObject(i);
                    Ad8County co = new Ad8County();
                    co.setId(county.getLong("id"));
                    co.setCountyCode(county.getString("id"));
                    co.setCountyName(county.getString("name"));
                    co.setProvinceId(provinceId);
                    co.setCityId(cityId);
                    co.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
