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

public class Login4Activity extends Activity{
	private ImageButton imageButton1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login4);
		
		imageButton1=((ImageButton)findViewById(R.id.imageButton1));
		
		imageButton1.setOnClickListener(new OnClickListener() {
				    public void onClick(View arg0) {

				    	//登入後切換到主畫面
						Intent getmain=new Intent();
						getmain.setClass(Login4Activity.this, main.class);
						startActivity(getmain);
						Login4Activity.this.finish();
				  
				    }}); 
	}

}


