package com.example.quizapp;


import com.example.dao.StudentDao;
import com.example.dto.Student;
import com.example.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends Activity{
EditText t1,t2,t3,t4;
Spinner spn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	setContentView(R.layout.register);
	initView();
	
	}
	
	private void initView(){
	
	t1=(EditText)findViewById(R.id.regeditText1);
	t2=(EditText)findViewById(R.id.regeditText2);
	t3=(EditText)findViewById(R.id.regeditText3);
	t4=(EditText)findViewById(R.id.regeditText4);
	spn=(Spinner)findViewById(R.id.regspinner1);
	
	}
	
	public void submit(View v){
	if(v.getId()==R.id.regbutton1){
		//register code here
		if(valid()){
			String username=t1.getText().toString();
			String password=t2.getText().toString();
			String address=t3.getText().toString();
			String m=t4.getText().toString();
			long mobile=Long.parseLong(m);
			String subject=spn.getSelectedItem().toString();
		    
			Student s=new Student();
		    s.setAddress(address);
		    s.setMobile(mobile);
		    s.setPassword(password);
		    s.setSubject(subject);
		    s.setUsername(username);
		    
		    StudentDao sd=new StudentDao(this);
		    sd.open();
		    if(sd.insert(s)>0){
		    	Toast.makeText(getApplicationContext() , "Registered Successfully!",1000).show();
		    }
		    sd.close();
		    
		    
		
		}
		
	}else{
		//reset code here
		clear();
	}
	}
	
	
	private void clear(){
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");	
	}
	
	private boolean valid(){
		if(t1.getText().toString().equals("")){
			Utils.showError("please enter username", this);
			t1.requestFocus();
			return false;
			
		}else if(t2.getText().toString().equals("")){
			Utils.showError("please enter password", this);
			t2.requestFocus();
			return false;
		}else if(t3.getText().toString().equals("")){
			Utils.showError("please enter address", this);
			t3.requestFocus();
			return false;
		}else if(t4.getText().toString().equals("")){
			Utils.showError("please enter mobile", this);
			t4.requestFocus();
			return false;
		}else if(spn.getSelectedItem().toString().equals("subject")){
			Utils.showError("please select subject", this);
			spn.requestFocus();
			return false;
		}else{
			return true;
		}
	}
	
}
