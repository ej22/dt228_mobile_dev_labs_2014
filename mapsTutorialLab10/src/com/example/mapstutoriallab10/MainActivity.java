package com.example.mapstutoriallab10;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	static final LatLng DIT = new LatLng(53.336914, -6.267967);
	static final LatLng PUB = new LatLng(53.337285, -6.262967);
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		Marker dit = map.addMarker(new MarkerOptions().position(DIT)
				.title("DIT"));
		
		Marker pub = map.addMarker(new MarkerOptions()
				.position(PUB)
				.title("Pub")
				.snippet("DRINK!")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.drink)));
		
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(DIT, 15));
		
		map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
	}
	
}
