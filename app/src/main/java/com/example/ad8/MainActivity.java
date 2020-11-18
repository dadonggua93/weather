package com.example.ad8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ad8.activity.AbstractBaseActivity;
import com.example.ad8.activity.DrawerLayoutDemo;
import com.example.ad8.activity.LocationActivity;
import com.example.ad8.util.LocationUtil;

import org.litepal.LitePal;

public class MainActivity extends AbstractBaseActivity {

	private LocationManager locationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LitePal.initialize(this);
		this.getLocation();
	}

	@SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View v) {

	}

	private void getLocation() {
		Intent intent = new Intent(MainActivity.this, LocationActivity.class);
		startActivity(intent);
	}
}