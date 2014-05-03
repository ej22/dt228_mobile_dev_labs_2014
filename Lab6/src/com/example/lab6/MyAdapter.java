package com.example.lab6;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MyAdapter extends ListActivity {

	TaskListDBManager db;
	Cursor myCursor;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = new TaskListDBManager(this);
		db.open();
		String[] cols = new String[]{"task_name","task_description","completed"};
		int to[] = new int[]{R.id.taskName,R.id.taskDesc,R.id.completed};
		SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.row, myCursor, cols, to);
		this.setListAdapter(mAdapter);
		}

}
