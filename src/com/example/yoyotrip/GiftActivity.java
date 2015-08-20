package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.HashMap;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class GiftActivity extends Activity{
	@Override  
	   public void onCreate(Bundle savedInstanceState) {  
	       super.onCreate(savedInstanceState);
	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	       WindowManager.LayoutParams.FLAG_FULLSCREEN);
	       setContentView(R.layout.activity_gift);  
	       //绑定XML中的ListView，作为Item的 容器  
	       ListView list = (ListView) findViewById(R.id.MyListView1);  
	         
	       
	       //生成动态数组，并且转载数据  
	       ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
	       
	      
	       
	       
	       for(int i=0;i<10;i++)  
	       {  
	        HashMap<String, Object> map = new HashMap<String, Object>();  
	        map.put("ItemImage", R.drawable.boy);//添加图像资源的ID  
	        //map.put("ItemTitle", "標題");  
	        //map.put("ItemText", "內容");
	        //map.put("textView1", "人數");
	        lstImageItem.add(map);
	        
	       }  
	       
	       
	       
	       
	       //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
	       SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
	                                                lstImageItem,//数据来源   
	                                                R.layout.activity_gift_one,//ListItem的XML实现  
	                                                  
	                                                //动态数组与ImageItem对应的子项          
	                                                new String[] {"ItemImage"},   
	                                                  
	                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
	                                                new int[] {R.id.ItemImage});  
	       //添加并且显示  
	       list.setAdapter(saImageItems);
	       list.setOnItemClickListener(ListLis);
	       
	       
	       //返回主畫面
	       Button button1=(Button)findViewById(R.id.button1);

	       button1.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Intent getmain=new Intent();
					getmain.setClass(GiftActivity.this, main.class);
					startActivity(getmain);
					GiftActivity.this.finish();
				}
			});
	       
	       
	       
	 }
	
	//選一條進入詳細
	 private OnItemClickListener ListLis=new OnItemClickListener(){
   		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3){
   			LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.activity_giftdtail, null); 
            AlertDialog.Builder builder2=new AlertDialog.Builder(GiftActivity.this);
            builder2.setView(view);
            builder2.setTitle("優惠卷").setIcon(android.R.drawable.btn_star_big_on).setPositiveButton("兌換", new DialogInterface.OnClickListener() {
                 
            	@Override
                public void onClick(DialogInterface dialog, int which) {
                    //转跳到地圖畫面
                    // TODO Auto-generated method stub
	
                    Intent intent=new Intent();
                    intent.setClass(getApplicationContext(), GiftActivity.class);
                    startActivity(intent);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                 
                 
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    dialog.cancel();//取消弹出框
                }
            }).create().show();
   		}
   	};
	
	
}


