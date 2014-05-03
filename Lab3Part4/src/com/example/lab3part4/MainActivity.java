package com.example.lab3part4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	RadioGroup rg1, rg2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rg1 = ((RadioGroup)findViewById(R.id.orientation));
		rg2 = ((RadioGroup)findViewById(R.id.gravity));
		
		rg1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId == R.id.horizontal){
					rg1.setOrientation(LinearLayout.HORIZONTAL);
				}
				else if(checkedId == R.id.vertical){
					rg1.setOrientation(LinearLayout.VERTICAL);
				}
				
			}
		});
		
		rg2.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId == R.id.left){
					rg2.setGravity(Gravity.LEFT);
				}
				if(checkedId == R.id.center){
					rg2.setGravity(Gravity.CENTER);
				}
				if(checkedId == R.id.right){
					rg2.setGravity(Gravity.RIGHT);
				}
				
			}
			
		});
	}

}
