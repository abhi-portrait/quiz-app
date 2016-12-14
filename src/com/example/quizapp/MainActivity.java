package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
EditText t1,t2;
TextView tv;
Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        
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

   
    
}
