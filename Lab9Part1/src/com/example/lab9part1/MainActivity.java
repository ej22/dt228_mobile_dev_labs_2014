package com.example.lab9part1;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener{

	private TextView locationText;
	private LocationManager locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		locationText = (TextView)findViewById(R.id.txtVw);
		setUpLocation();
	}

	@Override
	public void onLocationChanged(Location location) {
		String latestLocation = "";
		
		if(location != null)
		{
			latestLocation = String.format("Current Location \n Longitude: %1$s \n Latitude %2$s",
					location.getLongitude(), location.getLatitude());
		}
		
		Toast.makeText(MainActivity.this, latestLocation, Toast.LENGTH_LONG).show();
		locationText.setText(latestLocation);
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
	private void setUpLocation() {
		locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 5, this);
	}
	
	@Override
	protected void onResume(){
		super.onResume();locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 5, this);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		locationManager.removeUpdates(this);
	}
}
