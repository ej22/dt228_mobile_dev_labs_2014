package com.example.lab2part3;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity{

	CheckBox chkBx;
	TextView txView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txView = (TextView)findViewById(R.id.txView);
		chkBx = (CheckBox)findViewById(R.id.chkBx);
		
	}
	
	public void onCheckBoxClicked(View v){
		if(chkBx.isChecked()){
			txView.setText("Checked");
		}
		else{
			txView.setText("Not Checked");
		}
	}

}
