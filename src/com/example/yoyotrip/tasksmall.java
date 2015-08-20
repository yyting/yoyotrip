package com.example.yoyotrip;

import com.example.yoyotrip.small.ButtonListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class tasksmall extends Activity{
	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE); 
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.tasksmall);

	    Bundle bundle0311 =this.getIntent().getExtras();
	    String playdate = bundle0311.getString("playdate");
	    String exitdate = bundle0311.getString("exitdate");
	    String place = bundle0311.getString("place");
	    String peoplecount = bundle0311.getString("peoplecount");
	    String la = bundle0311.getString("la");
	    String main = bundle0311.getString("main");
	    
	    TextView textView2 = (TextView)findViewById(R.id.textView2);
	    TextView TextView01 = (TextView)findViewById(R.id.TextView01); 
	    TextView TextView04 = (TextView)findViewById(R.id.TextView04); 
	    TextView TextView05 = (TextView)findViewById(R.id.TextView05);
	    TextView TextView08 = (TextView)findViewById(R.id.TextView08);
	    TextView TextView10 = (TextView)findViewById(R.id.TextView10); 
	    
	    textView2.setText(playdate);
	    TextView01.setText(exitdate);
	    TextView04.setText(place); 
	    TextView05.setText(peoplecount); 
	    TextView08.setText(la);
	    TextView10.setText(main);

	    
	    ImageButton imageButton2=(ImageButton)findViewById(R.id.imageButton2);
	    imageButton2.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
        		Intent intent=new Intent();
                intent.setClass(getApplicationContext(), TaskPayStartActivity.class);
                startActivity(intent);
			}
		});
	    
	    
	    
	    
	    
	    
	       ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);
	    
		   imageButton1.setOnClickListener(new ButtonListener());
	    
	}
	class ButtonListener implements OnClickListener{
	 	   
        @Override
        public void onClick(View v) {
     	   
     	  
             
            // TODO Auto-generated method stub
            switch (v.getId()) {
            case R.id.imageButton1:
                 LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                // View view2=inflater.inflate(R.layout.activity_paperupdate, null); 
                AlertDialog.Builder builder2=new AlertDialog.Builder(tasksmall.this);
                 builder2.setMessage("確認後，將在列表上呈現!");
                // builder2.setView(view2);
                 builder2.setTitle("再次確認").setIcon(android.R.drawable.ic_dialog_info).setPositiveButton("确定", new DialogInterface.OnClickListener() {
	                     
                 	@Override
                     public void onClick(DialogInterface dialog, int which) {
                         //转跳到地圖畫面
                         // TODO Auto-generated method stub
 		
                         Intent intent=new Intent();
                         intent.setClass(getApplicationContext(), TaskActivity.class);
                         startActivity(intent);
                     }
                 }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                      
                      
                     public void onClick(DialogInterface dialog, int which) {
                         // TODO Auto-generated method stub
                         dialog.cancel();//取消弹出框
                     }
                 }).create().show();
                 break;
	
	
            }
        }
	}
}