package com.example.quizapp;

import com.example.dao.AnswerDao;
import com.example.dao.QuestionDao;
import com.example.dto.Answer;
import com.example.dto.Question;
import com.example.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Admin extends Activity{
EditText t1,t2,t3,t4,t5;
Spinner spn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		initView();
		
	}
	
	private void initView(){
		t1=(EditText)findViewById(R.id.admineditText1);
		t2=(EditText)findViewById(R.id.admineditText2);
		t3=(EditText)findViewById(R.id.admineditText3);
		t4=(EditText)findViewById(R.id.admineditText4);
		t5=(EditText)findViewById(R.id.admineditText5);
	    spn=(Spinner)findViewById(R.id.adminspinner1);
	
	}
	
	static int i=1;

	public void submit(View v){
		if(valid()){
			String q_name=t1.getText().toString();
			String a1=t2.getText().toString();
			String a2=t3.getText().toString();
			String a3=t4.getText().toString();
			String a4=t5.getText().toString();
			String correct=spn.getSelectedItem().toString();
			Question q=new Question();
			q.setQ_id(i);
			q.setQ_name(q_name);
			Answer a=new Answer();
			a.setA_id(i);
			a.setOpt1(a1);
			a.setOpt2(a2);
			a.setOpt3(a3);
			a.setOpt4(a4);
			a.setCorrect(correct);
			q.setAnswer(a);
			
			QuestionDao qd=new QuestionDao(this);
			qd.open();
			qd.insert(q);
			qd.close();
			AnswerDao td=new AnswerDao(this);
			td.open();
			td.insert(a, i);
			td.close();
			i++;
			clear();
			
		}
	}
	
	private boolean valid(){
		if(t1.getText().toString().equals("")){
			Utils.showError("please enter Question", this);
			t1.requestFocus();
			return false;
			
		}else if(t2.getText().toString().equals("")){
			Utils.showError("please enter Answer 1", this);
			t2.requestFocus();
			return false;
		}else if(t3.getText().toString().equals("")){
			Utils.showError("please enter Answer 2", this);
			t3.requestFocus();
			return false;
		}else if(t4.getText().toString().equals("")){
			Utils.showError("please enter Answer 3", this);
			t4.requestFocus();
			return false;
		}else if(spn.getSelectedItem().toString().equals("correct")){
			Utils.showError("please select correct answer", this);
			spn.requestFocus();
			return false;
		}else if(t5.getText().toString().equals("")){
			Utils.showError("please enter Answer 4", this);
			t5.requestFocus();
			return false;
		}
		else{
			return true;
		}
	}
	private void clear(){
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		
	}
	
}
