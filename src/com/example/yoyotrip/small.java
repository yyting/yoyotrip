package com.example.yoyotrip;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class small extends Activity{
	
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE); 
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.small);

	    Bundle bundle0311 =this.getIntent().getExtras();
	    String traiff = bundle0311.getString("traiff");
	    String time = bundle0311.getString("time");
	    String view = bundle0311.getString("view");
	    String me = bundle0311.getString("me");
	    
	    TextView textView7 = (TextView)findViewById(R.id.textView7);
	    TextView textView8 = (TextView)findViewById(R.id.textView8); 
	    TextView textView9 = (TextView)findViewById(R.id.textView9); 
	    TextView textView10 = (TextView)findViewById(R.id.textView10); 
	    
	    textView7.setText(traiff);
	    textView8.setText(time);
	    textView9.setText(view); 
	    textView10.setText(me);
	    
	    ImageButton imageButton2=(ImageButton)findViewById(R.id.imageButton2);
	    imageButton2.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
        		Intent intent=new Intent();
                intent.setClass(getApplicationContext(), PayStartActivity.class);
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
                AlertDialog.Builder builder2=new AlertDialog.Builder(small.this);
                 builder2.setMessage("確認後，將在地圖上呈現標記!");
                // builder2.setView(view2);
                 builder2.setTitle("再次確認").setIcon(android.R.drawable.ic_dialog_info).setPositiveButton("确定", new DialogInterface.OnClickListener() {
	                     
                 	@Override
                     public void onClick(DialogInterface dialog, int which) {
                         //转跳到地圖畫面
                         // TODO Auto-generated method stub
 		
                         Intent intent=new Intent();
                         intent.setClass(getApplicationContext(), MapActivity.class);
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