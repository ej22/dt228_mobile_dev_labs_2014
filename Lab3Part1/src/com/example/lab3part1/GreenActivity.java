package com.example.lab3part1;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;


public class GreenActivity extends Activity{
	
	Button btn;
	TextView txt;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_green);
		
		txt = (TextView)findViewById(R.id.greenTxBx);
		
		btn = (Button)findViewById(R.id.greenActivityBtn);
		
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent actvSwitch = new Intent(GreenActivity.this, MainActivity.class);
				startActivity(actvSwitch);
				finish();
				
			}
			
		});
	}
	
	
}
