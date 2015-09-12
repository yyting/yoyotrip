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
import android.widget.EditText;
import android.widget.ImageButton;

public class Login1Activity extends Activity {

	private ImageButton imageButton1;
	private ImageButton sign_in;
	private EditText account;
	private EditText password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login1);
		account=(EditText)findViewById(R.id.email_phone);
		password=(EditText)findViewById(R.id.passwd);
		sign_in=((ImageButton)findViewById(R.id.next));



		sign_in.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

						//登入後切換到主畫面
						Bundle set_info=new Bundle();
						set_info.putString("account",account.getText().toString());
						set_info.putString("password",password.getText().toString());
						//�n�J�������D�e��
						Intent getmain=new Intent();
						getmain.setClass(Login1Activity.this, Login2Activity.class);
						getmain.putExtras(set_info);
						startActivity(getmain);
						Login1Activity.this.finish();

				    }});
	}




}
