package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



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

	
	private Button button1;
	private Button Button01;
    private Calendar calendar;
    private int mYear, mMonth, mDay;
    private TextView textView12;
    private TextView TextView12;
    private DatePickerDialog datePickerDialog;
    private DatePickerDialog datePickerDialog1;
	
	
	public void onCreate(Bundle savedInstanceState) {    
	       super.onCreate(savedInstanceState);
	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		   setContentView(R.layout.activity_taskpaystart);
		   
		   //日期
		   calendar = Calendar.getInstance();
	        mYear = calendar.get(Calendar.YEAR);
	        mMonth = calendar.get(Calendar.MONTH);
	        mDay = calendar.get(Calendar.DAY_OF_MONTH);
	        
	        textView12 = (TextView)findViewById(R.id.textView12);
	        TextView12 = (TextView)findViewById(R.id.TextView12);
	        button1 = (Button)findViewById(R.id.button1);
	        
	        button1.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                showDialog(0);
	                datePickerDialog.updateDate(mYear, mMonth, mDay);
	            }
	            
	        });
	        Button01 = (Button)findViewById(R.id.Button01);
		   
	        Button01.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                showDialog(0);
	                datePickerDialog1.updateDate(mYear, mMonth, mDay);
	            }
	            
	        });
		   
		   
		   
		   //下拉選單
		   list1.add("國語");    
		   list1.add("英語");    
		   list1.add("台語");    
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

		   
		   Button button3=(Button)findViewById(R.id.button3);
		   button3.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					TextView textView12=(EditText)findViewById(R.id.textView12);
          		   String playdate=textView12.getText().toString();
          		   
          		 TextView TextView12=(EditText)findViewById(R.id.TextView12);
          		   String exitdate=TextView12.getText().toString();
          		   
          		  EditText editText2=(EditText)findViewById(R.id.editText2);
          		   String place=editText2.getText().toString();
          		   
          		  EditText EditText01=(EditText)findViewById(R.id.EditText01);
          		   String peoplecount=EditText01.getText().toString();
             		
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
	
	@Override
    protected Dialog onCreateDialog(int id) {
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePicker view, int year, int month,
                       int day) {
                   mYear = year;
                   mMonth = month;
                   mDay = day;
                   textView12.setText(setDateFormat(year,month,day));
                   
               }
               
           }, mYear,mMonth, mDay);
   //要回傳兩個!!!!
        
        datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month,
                    int day) {
                mYear = year;
                mMonth = month;
                mDay = day;
                TextView12.setText(setDateFormat(year,month,day));
                
            }
            
        }, mYear,mMonth, mDay);
        
     return datePickerDialog1;
    
    }
	
	
    private String setDateFormat(int year,int monthOfYear,int dayOfMonth){
        return String.valueOf(year) + "-"
        + String.valueOf(monthOfYear + 1) + "-"
        + String.valueOf(dayOfMonth);
    }
	       
	}
