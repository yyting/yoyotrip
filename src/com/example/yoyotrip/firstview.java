package com.example.yoyotrip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class firstview extends Activity{
	
	//private Button button1;
	//private VideoView videoView1;

	
	protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE); 
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.first_view);
	
	//VideoView videoView1=(VideoView)findViewById(R.id.videoView1);
	//String src="https://drive.google.com/drive/folders/0BykJ1YRFvW4pNFNXcjJ4MmF2cGs";
	//videoView1.setBackgroundResource(R.drawable.log); 
	//videoView1.setVideoURI(Uri.parse(src));
	//videoView1.setMediaController(new MediaController(this));
	//videoView1.requestFocus();
	//videoView1.start();
	
	
	
	
	
	
	//自動跳頁
		new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(2000);//這邊可以做你想預先載入的資料
                    //接下來轉跳到app的主畫面
                    startActivity(new Intent().setClass(firstview.this, MainActivity.class));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }).start();
	
	
	/*Button button1=(Button)findViewById(R.id.button1);

	button1.setOnClickListener(new OnClickListener(){
		public void onClick(View v){
			//登入後切換到註冊畫面
			Intent getmain=new Intent();
			getmain.setClass(firstview.this, MainActivity.class);
			startActivity(getmain);
			firstview.this.finish();
		}
	});*/
	

}
}
