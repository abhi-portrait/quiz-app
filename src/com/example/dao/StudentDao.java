package com.example.dao;

import com.example.dto.Student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class StudentDao extends SQLiteOpenHelper{

	private final static String DATABASE_NAME="student.db";
	private final static String TABLE_NAME="student";
	private final static String USERNAME="username";
	private final static String PASSWORD="password";
	private final static String MOBILE="mobile";
	private final static String ADDRESS="address";
	private final static String SUBJECT="subject";
	private final static String CREATE="create table student (username varchar(30) primary key,password varchar(10),mobile long ,address varchar(30),subject varchar(10));";
	
	private final static int VERSION=1;
	
	public StudentDao(Context context) {
		super(context, DATABASE_NAME,null, VERSION);
	}
	private SQLiteDatabase sd;
	 
	public void open(){
    sd=getWritableDatabase();
	}
	public void close(){
	    sd.close();
	}
	public long insert(Student user){
		ContentValues cv=new ContentValues();
		
		cv.put(USERNAME, user.getUsername());
		cv.put(PASSWORD, user.getPassword());
		cv.put(MOBILE, user.getMobile());
		cv.put(ADDRESS, user.getAddress());
		cv.put(SUBJECT, user.getSubject());
		return sd.insert(TABLE_NAME, null, cv);
	}
	
	
	
	public Student login(String username,String pass){
		Cursor c=sd.rawQuery("select * from student where username = ? and password = ? ",new String[]{username,pass});
		Student u=null;
		if(c.moveToNext()){
		u=new Student();
	 	
	    u.setUsername(c.getString(0));
	    u.setPassword(c.getString(1));
	    u.setMobile(c.getLong(2));
	    u.setAddress(c.getString(3));
	    u.setSubject(c.getString(4));
	}
		return u;
	}
		
		
	

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		
	}
	
	
	
}
