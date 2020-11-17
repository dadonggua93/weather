package com.example.ad8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ad8.activity.DrawerLayoutDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private LocationManager locationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.ad8_btn_draw_layout:
				Intent intent = new Intent(this, DrawerLayoutDemo.class);
				startActivity(intent);
				break;
			default:
				break;
		}
	}

	private void getLocation() {
		// 获取位置服务
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		double lat = location.getLatitude();
		double lng = location.getLongitude();
	}
}