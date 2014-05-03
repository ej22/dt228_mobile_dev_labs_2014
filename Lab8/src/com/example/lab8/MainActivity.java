package com.example.lab8;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt = ((TextView)findViewById(R.id.txtVw));
	}
	
	private class PerformTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... urls) {
			String response="";
			for(String url:urls){
				DefaultHttpClient client = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(url);
				try{
					HttpResponse execute = client.execute(httpGet);
					InputStream content = execute.getEntity().getContent();
					
					BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
					String s="";
					while((s=buffer.readLine())!=null){
						response += s;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return response;
		}
		
		protected void onPostExecute(String results){
			txt.setText(results);
		}
		
	}
	
	public void readTask (View view){
		PerformTask task = new PerformTask();
		task.execute(new String[]{"http://www.google.ie"});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
