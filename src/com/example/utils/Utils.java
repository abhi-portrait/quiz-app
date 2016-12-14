package com.example.utils;

import com.example.quizapp.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

public class Utils {

	public static void showError(String msg,Context context){
		AlertDialog.Builder a=new AlertDialog.Builder(context);
		a.setIcon(R.drawable.error);
		a.setTitle("Error Message");
		a.setMessage(msg);
		a.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				arg0.dismiss();
				
			}
		});
		a.show();
		
	}
	
}
