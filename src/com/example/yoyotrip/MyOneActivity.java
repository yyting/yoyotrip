package com.example.yoyotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MyOneActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_my_one);
		
		
		
		ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);
		imageButton1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//�n�J���������U�e��
				Intent getmain=new Intent();
				getmain.setClass(MyOneActivity.this, MyActivity.class);
				startActivity(getmain);
				MyOneActivity.this.finish();
			}
		});
		

}
}