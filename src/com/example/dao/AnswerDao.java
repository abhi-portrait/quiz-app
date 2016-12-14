package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.Answer;
import com.example.dto.Question;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AnswerDao extends SQLiteOpenHelper {

	private final static String DATABASE_NAME="answer.db";
	private final static String TABLE_NAME="answer";
	private final static String A_ID="a_id";
	private final static String OPTION1="opt1";
	private final static String OPTION2="opt2";
	private final static String OPTION3="opt3";
	private final static String OPTION4="opt4";
	private final static String CORRECT="correct";
	private final static String Q_ID="q_id";
	private final static String CREATE="create table answer (a_id int primary key,opt1 varchar(50),opt2 varchar(50),opt3 varchar(50),opt4 varchar(50),correct varchar(10),q_id int);";
	
	private final static int VERSION=1;
	
	public AnswerDao(Context context) {
		super(context, DATABASE_NAME,null, VERSION);
	}
	private SQLiteDatabase sd;
	 
	public void open(){
    sd=getWritableDatabase();
	}
	public void close(){
	    sd.close();
	}
	 
	public long insert(Answer a,int q_id){
		ContentValues cv=new ContentValues();
		cv.put(A_ID,a.getA_id());
		cv.put(OPTION1,a.getOpt1());
		cv.put(OPTION2,a.getOpt2());
		cv.put(OPTION3,a.getOpt3());
		cv.put(OPTION4,a.getOpt4());
		cv.put(CORRECT,a.getCorrect());
		cv.put(Q_ID,q_id);
		
		return sd.insert(TABLE_NAME, null, cv);
		
		
	}
	public Answer getAllOptions(int q_id){
		Cursor c=sd.rawQuery("select * from answer where q_id = ? ",new String[]{String.valueOf(q_id)});
		Answer a=null;
		while(c.moveToNext()){
	    	a=new Answer();
	    	a.setOpt1(c.getString(1));
	    	a.setOpt2(c.getString(2));
	    	a.setOpt3(c.getString(3));
	    	a.setOpt4(c.getString(4));
	    	a.setCorrect(c.getString(5));
	    	
	    }
		return a;
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(CREATE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
