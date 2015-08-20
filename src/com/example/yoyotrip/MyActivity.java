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

public class MyActivity extends Activity{
	
	private Button button2;
	
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_my);
		
		
		Button button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//登入後切換到註冊畫面
				Intent getmain=new Intent();
				getmain.setClass(MyActivity.this, main.class);
				startActivity(getmain);
				MyActivity.this.finish();
			}
		});
		
		
		ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);
		imageButton1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//登入後切換到註冊畫面
				Intent getmain=new Intent();
				getmain.setClass(MyActivity.this, MyOneActivity.class);
				startActivity(getmain);
				MyActivity.this.finish();
			}
		});

}
}
