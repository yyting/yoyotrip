package com.example.yoyotrip;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.yoyotrip.GCM.MagicLenGCM;

public class main extends Activity{


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

		MagicLenGCM register = new MagicLenGCM(main.this);
		/**@檢查GCM狀態*/
		register.openGCM();
		Log.i("regid", register.getRegistrationId() + "");

		Button Button03=(Button)findViewById(R.id.Button03);

		Button03.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//按下切換到設定介面
				Intent getmain=new Intent();
				getmain.setClass(main.this, MyActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});


		Button Button02=(Button)findViewById(R.id.Button02);

		Button02.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//按下切換到設定介面
				Intent getmain=new Intent();
				getmain.setClass(main.this, SceneryActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});


		Button button1=(Button)findViewById(R.id.date);

		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//按下切換到設定介面
				Intent getmain=new Intent();
				getmain.setClass(main.this, MapActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});

		Button grp_chat=(Button)findViewById(R.id.chat);

		grp_chat.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//按下切換到設定介面
				Intent getmain=new Intent();
				getmain.setClass(main.this, chatroom.class);
				startActivity(getmain);
				main.this.finish();
			}
		});

		Button Button04=(Button)findViewById(R.id.Button04);

		Button04.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//按下切換到設定介面
				Intent getmain=new Intent();
				getmain.setClass(main.this, GiftActivity.class);
				startActivity(getmain);
				main.this.finish();
			}
		});


		Button Button05=(Button)findViewById(R.id.Button05);

		Button05.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//按下切換到設定介面
				Intent getmain=new Intent();
				getmain.setClass(main.this, FragmentTabs.class);
				startActivity(getmain);
				main.this.finish();
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "返回登入畫面");
		menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "離開程式");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case Menu.FIRST:
				Intent getmain=new Intent();
				getmain.setClass(main.this, MainActivity.class);
				startActivity(getmain);
				main.this.finish();
				break;
			case Menu.FIRST+1:
				new AlertDialog.Builder(main.this)
						.setTitle("離開此程式")
						.setMessage("你確定要離開？")
						.setPositiveButton("是", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								finish();
							}
						})
						.setNegativeButton("否", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub

							}
						})
						.show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
