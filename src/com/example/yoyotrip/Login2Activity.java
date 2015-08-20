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
import android.widget.ImageButton;

public class Login2Activity extends Activity {
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login2);
		
		imageButton2=((ImageButton)findViewById(R.id.imageButton2));
		
		
		imageButton2.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

				    	//�n�J�������D�e��
						Intent getmain=new Intent();
						getmain.setClass(Login2Activity.this, Login4Activity.class);
						startActivity(getmain);
						Login2Activity.this.finish();
				  
				    }});
		
		imageButton1=((ImageButton)findViewById(R.id.imageButton1));
		
		
		imageButton1.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

				    	//�n�J�������D�e��
						Intent getmain=new Intent();
						getmain.setClass(Login2Activity.this, Login1Activity.class);
						startActivity(getmain);
						Login2Activity.this.finish();
				  
				    }});
		
		
	}
		

}