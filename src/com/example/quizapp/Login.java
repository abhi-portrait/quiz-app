package com.example.quizapp;

import java.util.Iterator;
import java.util.List;

import com.example.dao.QuestionDao;
import com.example.dao.StudentDao;
import com.example.dto.Answer;
import com.example.dto.Question;
import com.example.dto.Student;
import com.example.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
EditText t1,t2;
TextView tv;
Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
        QuestionDao qq=new QuestionDao(this);
        qq.open();
        List<Question> q=qq.getAllQuestions();
        Iterator it=q.iterator();
        while(it.hasNext()){
        	Question qqq=(Question)it.next();
        	Answer a=qqq.getAnswer();
        	String data=qqq.getQ_name()+"\n"+a.getCorrect()+"\n"+a.getOpt2();
        Toast.makeText(this, data, 1000).show();
        
        }
        
        		
        
        tv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				Intent in=new Intent(getApplicationContext(),Register.class);
				startActivity(in);
				finish();
				return false;
			}
		});
    }
    private void initView(){
    	
    	t1=(EditText)findViewById(R.id.maineditText1);
    	t2=(EditText)findViewById(R.id.maineditText2);
    	spn=(Spinner)findViewById(R.id.mainspinner1);
    	tv=(TextView)findViewById(R.id.maintextView1);
    	}

    public void submit(View v){
    	if(v.getId()==R.id.mainbutton1){
    		//login code here
    		if(valid()){
    			String role=spn.getSelectedItem().toString();
    		String username=t1.getText().toString();
    		String password=t2.getText().toString();
    			if(role.equalsIgnoreCase("admin")){
    			//admin code here
    			
    			if(username.equals("deep")&&password.equals("123")){
    				Intent in=new Intent(this,Admin.class);
    				startActivity(in);
    				finish();
    			}else{
    				Utils.showError("Access Denined !", this);
    			}
    			
    		}else{
    			//user code here
    			
    			StudentDao sd=new StudentDao(this);
    			sd.open();
    			Student std=sd.login(username, password);
    			if(std!=null){
    				Intent in=new Intent(this,Home.class);
    				startActivity(in);
    				finish();
    			}else{
    				Utils.showError("Invalid username or password !", this);
    			clear();
    			}
    			
    		}
    		
    		}
    		
    	}else{
    		//reset code here
    		clear();
    	}
    }
    private void clear(){
    	t1.setText("");
    	t2.setText("");
    	/*String t[]=spn.getResources().getStringArray(R.array.role);
        spn.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_item,t));*/
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
    	}else if(spn.getSelectedItem().toString().equals("select role")){
    		Utils.showError("please select role", this);
            spn.requestFocus();
            
    		return false;
    	}else{
    		return true;
    	}
    	
    }
   
    
}
