package com.example.yoyotrip;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class main extends Activity{
	
	private ImageButton imageButton1;
	private Button Button03;
	private Button Button02;
	private Button button1;
	private Button Button04;
	private Button Button05;
	private ImageButton start;
	
	
	private ImageButton diary;
	
	private ImageButton imageButton5;
	
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		
		ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);

		imageButton1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//祅ち传爹礶
				Intent getmain=new Intent();
				getmain.setClass(main.this, MainActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});
		
		
		Button Button03=(Button)findViewById(R.id.Button03);

		Button03.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//ち传砞﹚ざ
				Intent getmain=new Intent();
				getmain.setClass(main.this, MyActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});
		
		
		Button Button02=(Button)findViewById(R.id.Button02);

		Button02.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//ち传砞﹚ざ
				Intent getmain=new Intent();
				getmain.setClass(main.this, SceneryActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});
		
		
		Button button1=(Button)findViewById(R.id.button1);

		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//ち传砞﹚ざ
				Intent getmain=new Intent();
				getmain.setClass(main.this, MapActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});
		
		
		
		Button Button04=(Button)findViewById(R.id.Button04);

		Button04.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//ち传砞﹚ざ
				Intent getmain=new Intent();
				getmain.setClass(main.this, GiftActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});
		
		
		Button Button05=(Button)findViewById(R.id.Button05);

		Button05.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//ち传砞﹚ざ
				Intent getmain=new Intent();
				getmain.setClass(main.this, FragmentTabs.class);
				startActivity(getmain);
				main.this.finish();
			}
		});
		

	}
	}
