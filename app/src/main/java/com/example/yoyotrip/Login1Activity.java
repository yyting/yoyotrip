package com.example.yoyotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login1Activity extends Activity {
	private Button sign_in;
	private EditText account;
	private EditText password;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login1);
		account=(EditText)findViewById(R.id.email_phone);
		password=(EditText)findViewById(R.id.passwd);
		sign_in=((Button)findViewById(R.id.next));
		sign_in.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {
						Bundle set_info=new Bundle();
						set_info.putString("account",account.getText().toString());
						set_info.putString("password",password.getText().toString());
				    	//登入後切換到主畫面
						Intent getmain=new Intent();
						getmain.setClass(Login1Activity.this, Login2Activity.class);
						getmain.putExtras(set_info);
						startActivity(getmain);
						Login1Activity.this.finish();
				  
				    }}); 
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login1, menu);
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
