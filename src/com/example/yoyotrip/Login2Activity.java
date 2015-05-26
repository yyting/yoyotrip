package com.example.yoyotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Login2Activity extends Activity {
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login2);
		
		imageButton2=((ImageButton)findViewById(R.id.imageButton2));
		
		
		imageButton2.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

				    	//登入後切換到主畫面
						Intent getmain=new Intent();
						getmain.setClass(Login2Activity.this, Login3Activity.class);
						startActivity(getmain);
						Login2Activity.this.finish();
				  
				    }});
		
		imageButton1=((ImageButton)findViewById(R.id.imageButton1));
		
		
		imageButton1.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

				    	//登入後切換到主畫面
						Intent getmain=new Intent();
						getmain.setClass(Login2Activity.this, Login1Activity.class);
						startActivity(getmain);
						Login2Activity.this.finish();
				  
				    }});
		
		
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
