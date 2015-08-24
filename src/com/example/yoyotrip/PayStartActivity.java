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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PayStartActivity extends Activity{
	
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
		   setContentView(R.layout.activity_paystart);
		   
		   list1.add("大眾運輸");    
		   list1.add("汽車");    
		   list1.add("機車");    
		   list1.add("自行車");
		   spinner1 = (Spinner)findViewById(R.id.spinner1);
		   adapter1 = new ArrayAdapter<String>(this,R.layout.myspinner, list1);
		   adapter1.setDropDownViewResource(R.layout.myspinner);  //下拉選單的樣式
		   spinner1.setAdapter(adapter1);
		   

		   
		   
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

		   
		   list2.add("半小時");    
		   list2.add("一小時以內");    
		   list2.add("三小時以上");    
		   list2.add("一天");
		   spinner2 = (Spinner)findViewById(R.id.spinner2);
		   adapter2 = new ArrayAdapter<String>(this,R.layout.myspinner, list2);
		   adapter2.setDropDownViewResource(R.layout.myspinner);
		   spinner2.setAdapter(adapter2);
		  
		   
		   Button button3=(Button)findViewById(R.id.button3);
		   button3.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Spinner spinner1=(Spinner)findViewById(R.id.spinner1);
             	   String traiff=spinner1.getSelectedItem().toString();
             	   
             	   Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
             	   String time=spinner2.getSelectedItem().toString();
             	   
             	   EditText editText2=(EditText)findViewById(R.id.editText2);
           		Editable edit1;
           		edit1=editText2.getText();
           		String view=edit1.toString();
             	   //String view=editText2.getText().toString();
           		   
           		   EditText editText1=(EditText)findViewById(R.id.editText1);
           		   String me=editText1.getText().toString();
             		
             		
           		//new一個intent物件，並指定Activity切換的class
                     Intent intent=new Intent();
                     intent.setClass(getApplicationContext(), small.class);
                     
                     //new一個Bundle物件，並將要傳遞的資料傳入
                     Bundle bundle = new Bundle();
             	    bundle.putString("traiff", traiff);
             	    bundle.putString("time", time); 
             	    bundle.putString("view", view); 
             	    bundle.putString("me", me);
             	    
             	  //將Bundle物件assign給intent
             	    intent.putExtras(bundle);  
             	  //切換Activity
                     startActivity(intent);
            		
            		
            		//Intent intent=new Intent();
                   // intent.setClass(getApplicationContext(), MainActivity.class);
                   // startActivity(intent);
				}
			});
		   
		   
		   
		   Button button2=(Button)findViewById(R.id.button2);
		   button2.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
            	   Intent intent=new Intent();
                   intent.setClass(getApplicationContext(), MapActivity.class);
                   startActivity(intent);
				}
			});
	
	
	
	}
	
	   
	}
