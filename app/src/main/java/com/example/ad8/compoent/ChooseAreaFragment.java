package com.example.ad8.compoent;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ad8.R;
import com.example.ad8.constant.MapConstant;
import com.example.ad8.db.Ad8City;
import com.example.ad8.db.Ad8County;
import com.example.ad8.db.Ad8Province;
import com.example.ad8.util.ListUtil;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ChooseAreaFragment extends Fragment {

    private ProgressDialog progressDialog;
    private Button backButton;
    private TextView textView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataArray = new ArrayList<>();

    private List<Ad8Province> provinces;
    private List<Ad8City> cities;
    private List<Ad8County> counties;

    private Ad8Province currentProvince;
    private Ad8City currentCity;
    private Ad8County currentCounty;
    private int currentLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_area, container, false);
        this.textView = view.findViewById(R.id.weather_title_text);
        this.backButton = view.findViewById(R.id.weather_back);
        this.listView = view.findViewById(R.id.weather_choose_listview);
        this.adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataArray);
        listView.setAdapter(this.adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == MapConstant.LEVEL_PROVINCE) {
                    currentProvince = provinces.get(position);
                    queryCities();
                } else if (currentLevel == MapConstant.LEVEL_CITY) {
                    currentCity = cities.get(position);
                    queryCounties();
                } else if (currentLevel == MapConstant.LEVEL_COUNTY) {
                    currentCounty = counties.get(position);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentLevel ==  MapConstant.LEVEL_COUNTY){
                    queryCities();
                }else if(currentLevel == MapConstant.LEVEL_CITY){
                    queryProvinces();
                }
            }
        });
        this.queryProvinces();
    }

    private void queryProvinces(){
        List<Ad8Province> provinces = LitePal.findAll(Ad8Province.class);
        if(ListUtil.isNull(provinces)){

        }
    }

    private void queryCities(){

    }

    private void queryCounties(){

    }

    private void requestServer(String url,int level){

    }

}
