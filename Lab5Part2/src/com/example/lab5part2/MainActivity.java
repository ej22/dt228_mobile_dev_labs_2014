package com.example.lab5part2;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TaskListDBManager db = new TaskListDBManager(this);
	EditText taskNameTxBx, taskDescTxBx;
	TextView taskNameLbl, taskDescLbl, completedLbl;
	RadioGroup completedRG;
	Button btn;
	static int completed = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db.open();
		
		btn = (Button)findViewById(R.id.submitButton);
		taskNameTxBx = (EditText)findViewById(R.id.taskNameTxBx);
		taskDescTxBx = (EditText)findViewById(R.id.taskDescTxBx);
		taskNameLbl = (TextView)findViewById(R.id.taskNameLbl);
		taskDescLbl = (TextView)findViewById(R.id.taskDescLbl);
		completedLbl = (TextView)findViewById(R.id.completedLbl);
		completedRG = (RadioGroup)findViewById(R.id.completed);
		
		completedRG.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId == R.id.yes){
					completed = 1;
				}
				else if(checkedId == R.id.no){
					completed = 0;
				}
				
			}//end onCheckedChange method
			
		}); //end setOnCheckedChangeListener
		
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				String taskName = taskNameTxBx.getText().toString();
				String taskDesc = taskDescTxBx.getText().toString();
				
				db.insertPerson(taskName, taskDesc, completed);
				Toast.makeText(getApplicationContext(), "You created a " + taskName + " task", Toast.LENGTH_SHORT).show();
			}
			
		});
		
		
	}//end onCreate

}
