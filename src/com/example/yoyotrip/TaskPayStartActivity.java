package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class TaskPayStartActivity extends Activity{
	
	private List<String> list1 = new ArrayList<String>();
	private List<String> list2 = new ArrayList<String>();
	private Spinner spinner1;
	private Spinner spinner2;
	private ArrayAdapter<String> adapter1;
	private ArrayAdapter<String> adapter2;
	private Button button3;
	private Button button2;
	private EditText editText2;
	private EditText editText1;
	
	public void onCreate(Bundle savedInstanceState) {    
	       super.onCreate(savedInstanceState);
	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		   setContentView(R.layout.activity_taskpaystart);
		   
		   list1.add("國語");    
		   list1.add("英語");    
		   list1.add("台語");    
		   spinner1 = (Spinner)findViewById(R.id.spinner1);
		   adapter1 = new ArrayAdapter<String>(this,R.layout.myspinner, list1);
		   adapter1.setDropDownViewResource(R.layout.myspinner);  //下拉選單的樣式
		   spinner1.setAdapter(adapter1);
		   
		   list2.add("1人");    
		   list2.add("2人");    
		   list2.add("3人");
		   list2.add("4人");
		   list2.add("5人");
		   list2.add("6人");
		   list2.add("7人");
		   list2.add("8人");
		   list2.add("9人");
		   list2.add("10人以上");
		   spinner2 = (Spinner)findViewById(R.id.spinner2);
		   adapter2 = new ArrayAdapter<String>(this,R.layout.myspinner, list2);
		   adapter2.setDropDownViewResource(R.layout.myspinner);  //下拉選單的樣式
		   spinner2.setAdapter(adapter2);

		   
		   
			           /*下拉菜单弹出的内容选项触屏事件处理*/    
		//  spinner1.setOnTouchListener(new Spinner.OnTouchListener(){    
			              // public boolean onTouch(View v, MotionEvent event) {    
			                   // TODO Auto-generated method stub    
			                   /** 
			                    *  
			                    */  
			                 //  return false;    
			              // }  
			         //  });   
			           /*下拉菜单弹出的内容选项焦点改变事件处理*/    
		  // spinner1.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){    
			           //public void onFocusChange(View v, boolean hasFocus) {    
			               // TODO Auto-generated method stub    
			     
			         //  }    
			       //    });    

		   
		   Button button3=(Button)findViewById(R.id.button3);
		   button3.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					EditText EditText02=(EditText)findViewById(R.id.EditText02);
          		   String playdate=EditText02.getText().toString();
          		   
          		   EditText EditText04=(EditText)findViewById(R.id.EditText04);
          		   String exitdate=EditText04.getText().toString();
          		   
          		  EditText editText2=(EditText)findViewById(R.id.editText2);
          		   String place=editText2.getText().toString();
          		   
          		 Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
           	   String peoplecount=spinner2.getSelectedItem().toString();
             		
          		  Spinner spinner1=(Spinner)findViewById(R.id.spinner1);
             	   String la=spinner1.getSelectedItem().toString();
             	   
             	   EditText EditText03=(EditText)findViewById(R.id.EditText03);
          		   String main=EditText03.getText().toString();
             		
             		
                     Intent intent=new Intent();
                     intent.setClass(getApplicationContext(), tasksmall.class);
                     
                     Bundle bundle = new Bundle();
             	    bundle.putString("playdate", playdate);
             	    bundle.putString("exitdate", exitdate); 
             	    bundle.putString("place", place); 
             	    bundle.putString("peoplecount", peoplecount);
             	    bundle.putString("la", la);
             	    bundle.putString("main", main);
             	  //將Bundle物件assign給intent
             	    intent.putExtras(bundle);
                     startActivity(intent);
				}
			});
	}
	
	       
	}
