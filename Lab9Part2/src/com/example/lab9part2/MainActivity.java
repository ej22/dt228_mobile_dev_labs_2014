package com.example.lab9part2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends Activity {

private final static String My_TAG = "LifeCycleTag";
private EditText edit;
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		edit = (EditText)findViewById(R.id.editTxt);
		Log.i(My_TAG, "onCreate executes ...");
		setContentView(R.layout.activity_main);
	}

	protected void onRestart()
	{
		super.onRestart();
	        Log.i(My_TAG, "onRestart executes ...");
	}
	
	protected void onStart()
	{
		super.onStart();
		Log.i(My_TAG, "onStart executes ...");
	}
	
     protected void onResume() {
    	 super.onResume();
    	 Log.i(My_TAG, "onResume executes ...");
	}

     protected void onPause() {
    	 super.onPause();
    	 Log.i(My_TAG, "onPause executes ...");
	}

     protected void onStop() {
    	 super.onStop();
    	 Log.i(My_TAG, "onStop executes ...");
	}

     protected void onDestroy() {
    	 super.onDestroy();
    	 Log.i(My_TAG, "onDestroy executes ...");
	}

}
