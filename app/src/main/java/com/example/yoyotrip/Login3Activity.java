package com.example.yoyotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Login3Activity extends Activity {
	private ImageButton imageButton1;
	private ImageButton imageButton2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login3);
		
		imageButton2=((ImageButton)findViewById(R.id.imageButton2));
		
		
		imageButton2.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

						//登入後切換到主畫面
						Intent getmain=new Intent();
						getmain.setClass(Login3Activity.this, Login4Activity.class);
						startActivity(getmain);
						Login3Activity.this.finish();
				  
				    }});
		
		imageButton1=((ImageButton)findViewById(R.id.imageButton1));
		
		
		imageButton1.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

				    	//�n�J�������D�e��
						Intent getmain=new Intent();
						getmain.setClass(Login3Activity.this, Login2Activity.class);
						startActivity(getmain);
						Login3Activity.this.finish();
				  
				    }}); 
	}

	
}
