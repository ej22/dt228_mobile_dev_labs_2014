package com.example.lab3part1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	Button btn;
	TextView txt;
	
	//These four lines are only needed to test for one activity/xml file
//	RelativeLayout RL;
//	boolean isRed = true;
//	int red = getResources().getColor(R.color.redBackground);
//	int green = getResources().getColor(R.color.greenBackground);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txt= (TextView)findViewById(R.id.redTxBx);
//		RL = (RelativeLayout)findViewById(R.id.myLayout);
		btn = (Button)findViewById(R.id.mainActivityBtn);
		
		btn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent actvSwitch = new Intent(MainActivity.this, GreenActivity.class);
				startActivity(actvSwitch);
				finish();
				
				//lines 40-46 are for one Activity/XML file
//				if(isRed){
//					RL.setBackgroundColor(red);
//					txt.setText(R.string.green);
//				}
//				else{
//					RL.setBackgroundColor(green);
//					txt.setText(R.string.red);
//				}
			}
		});
	}
}
