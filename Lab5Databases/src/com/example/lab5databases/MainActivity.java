package com.example.lab5databases;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity
{
	//instantiate an object of type TaskListDatabase
	TaskListDatabase task = new TaskListDatabase(this); 
	
	public EditText editTextTaskName, editTextTaskDesc;
	public RadioGroup radioGroupComplete;
	public Button buttonAddToDatabase;
	public String taskName, taskDesc, complete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//calling method to open database
		task.open();	
		
		editTextTaskName = (EditText)findViewById(R.id.editTextTaskName);
		editTextTaskDesc = (EditText)findViewById(R.id.editTextTaskDescription);
		radioGroupComplete = (RadioGroup)findViewById(R.id.radioGroup);
		buttonAddToDatabase = (Button)findViewById(R.id.button);
		
		radioGroupComplete.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup arg0, int checkedId) {
				if(checkedId == R.id.radioBtnYes)
					complete = "Yes";
				else
					complete = "No";
				
			}
			
		});
		
		buttonAddToDatabase.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view) 
			{
				//insertToDatabase();
				
				taskName = editTextTaskName.getText().toString();
				taskDesc = editTextTaskDesc.getText().toString();
				task.insertTask(taskName, taskDesc, complete);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
