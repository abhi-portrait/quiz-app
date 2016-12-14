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

public class QuestionDao extends SQLiteOpenHelper {

	private final static String DATABASE_NAME="question.db";
	private final static String TABLE_NAME="question";
	private final static String Q_NAME="q_name";
	private final static String Q_ID="q_id";
	private final static String CREATE="create table question (q_id int primary key,q_name varchar(100));";
	
	private final static int VERSION=1;
	Context context;
	public QuestionDao(Context context) {
		super(context, DATABASE_NAME,null, VERSION);
		this.context=context;
	}
	private SQLiteDatabase sd;
	 
	public void open(){
    sd=getWritableDatabase();
	}
	public void close(){
	    sd.close();
	}
	
	public long insert(Question q){
		ContentValues cv=new ContentValues();
		cv.put(Q_ID,q.getQ_id());
		cv.put(Q_NAME,q.getQ_name());
		return sd.insert(TABLE_NAME, null, cv);
		
		
	}
	
	public List<Question> getAllQuestions(){
		Cursor c=sd.rawQuery("select * from question ",null);
	    AnswerDao aa=new AnswerDao(context);
		ArrayList<Question> questionlist=new ArrayList<Question>();
	    while(c.moveToNext()){
			Question q=new Question();
			q.setQ_name(c.getString(1));
			aa.open();
			Answer a=aa.getAllOptions(c.getInt(0));
			aa.close();
			q.setAnswer(a);
			questionlist.add(q);
		}
	    return questionlist;
		
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
