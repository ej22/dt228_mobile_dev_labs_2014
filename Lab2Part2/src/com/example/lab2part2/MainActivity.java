package com.example.lab2part2;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener{

	Button btn;
	TextView textLbl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textLbl = (TextView)findViewById(R.id.timeLbl);
		
		btn = (Button)findViewById(R.id.timeBtn);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		updateTime();
	}

	private void updateTime() {
		textLbl.setText(new Date().toString());
		
	}

}
