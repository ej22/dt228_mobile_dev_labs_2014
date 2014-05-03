/*
 * Open
 * Insert
 * Close
 * 
 */
package com.example.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TaskListDBManager {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_TASKNAME = "task_name";
	public static final String KEY_TASKDESC = "task_description";
	public static final String KEY_COMPLETE = "complete";
	
	private static final String DATABASE_NAME = "TaskList";
	private static final String DATABASE_TABLE = "TaskList_Details";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = 
			"create table " + DATABASE_TABLE + " (" + KEY_ROWID + " integer primary key autoincrement, " +
													KEY_TASKNAME + " text not null, " + 
													KEY_TASKDESC + " text not null, " + 
													KEY_COMPLETE + " integer not null);";
	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public TaskListDBManager(Context ctx){
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context){
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
	}//end DatabaseHelper Nested Class
	
	public TaskListDBManager open() throws SQLException
	{
		try{
			db = DBHelper.getWritableDatabase();
		}
		catch(SQLException e)
		{
			Log.i("DB OPEN ERROR", e.toString());
		}
		
		return this;
		
	}
	
	public void close()
	{
		DBHelper.close();
	}
	
	public long insert(String taskName, String task_Desc, int complete){
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_TASKNAME, taskName);
		initialValues.put(KEY_TASKDESC, task_Desc);
		initialValues.put(KEY_COMPLETE, complete);
		
		return db.insert(DATABASE_TABLE, null, initialValues);
		
	}
}
