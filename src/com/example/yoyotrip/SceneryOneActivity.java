package com.example.yoyotrip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SceneryOneActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_scenery_one);
		
	    final Button button1 = (Button) findViewById(R.id.button1); 

		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
	            button1.setBackgroundResource(R.drawable.next);//响应开抽屉事件 ，把图片设为向下的

				
			}
		});
		
	   

}
}
