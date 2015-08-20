package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class TaskActivity  extends Activity{
	
		@Override  
		   public void onCreate(Bundle savedInstanceState) {  
		       super.onCreate(savedInstanceState);
		       requestWindowFeature(Window.FEATURE_NO_TITLE); 
		       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		       WindowManager.LayoutParams.FLAG_FULLSCREEN);
		       setContentView(R.layout.activity_task);  
		       //绑定XML中的ListView，作为Item的 容器  
		       ListView list = (ListView) findViewById(R.id.MyListView);  
		         
		       
		       //生成动态数组，并且转载数据  
		       ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		       
		      
		       for(int i=0;i<10;i++)  
		       {  
		        HashMap<String, Object> map = new HashMap<String, Object>();  
		        map.put("ItemImage", R.drawable.boy);//添加图像资源的ID  
		        map.put("ItemTitle", "標題");  
		        map.put("ItemText", "內容");
		        map.put("textView1", "人數");
		        lstImageItem.add(map);
		        
		       }  
		       
		       
		       //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
		       SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
		                                                lstImageItem,//数据来源   
		                                                R.layout.activity_task_one,//ListItem的XML实现  
		                                                  
		                                                //动态数组与ImageItem对应的子项          
		                                                new String[] {"ItemImage","ItemTitle", "ItemText","textView1"},   
		                                                  
		                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
		                                                new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.ItemText,R.id.textView1});  
		       //添加并且显示  
		       list.setAdapter(saImageItems);
		       list.setOnItemClickListener(ListLis);
		
		      
		       
		       
		       //回主畫面的按鈕
		       Button button1=(Button)findViewById(R.id.button1);

		       button1.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						
						Intent getmain=new Intent();
						getmain.setClass(TaskActivity.this, main.class);
						startActivity(getmain);
						TaskActivity.this.finish();
					}
				});
		       
		       //選項的按鈕
		       ImageButton imageButton2=(ImageButton)findViewById(R.id.imageButton2);

		       imageButton2.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						
						Intent getmain=new Intent();
						getmain.setClass(TaskActivity.this, main.class);
						startActivity(getmain);
						TaskActivity.this.finish();
					}
				});
		       
		     //回地圖的按鈕
		       ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);

		       imageButton1.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						
						Intent getmain=new Intent();
						getmain.setClass(TaskActivity.this, MapActivity.class);
						startActivity(getmain);
						TaskActivity.this.finish();
					}
				});
		       
		     //欣增任務的按鈕
		       ImageButton imageButton3=(ImageButton)findViewById(R.id.imageButton3);

		       imageButton3.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						
						Intent getmain=new Intent();
						getmain.setClass(TaskActivity.this, TaskPayStartActivity.class);
						startActivity(getmain);
						TaskActivity.this.finish();
					}
				});
		       
		       
		 }
		//選一條進入詳細
		 private OnItemClickListener ListLis=new OnItemClickListener(){
	    		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3){
	    			//按下切換到設定介面
					Intent getmain=new Intent();
					getmain.setClass(TaskActivity.this, TaskDtailActivity.class);
					startActivity(getmain);
					TaskActivity.this.finish();
	    		}
	    	};
	    	
	    	@Override
	        public boolean onCreateOptionsMenu(Menu menu) {
	            // TODO Auto-generated method stub
	            for(int i=0; i<10 ; i++){
	                menu.add(Menu.NONE, Menu.FIRST+i, Menu.NONE, "Item "+Integer.toString(i+1));
	            }
	            return super.onCreateOptionsMenu(menu);
	        }
	    	@Override
	        public boolean onOptionsItemSelected(MenuItem item) {
	            // TODO Auto-generated method stub
	            Toast.makeText(getApplicationContext(), 
	                    "你按下Item"+Integer.toString(item.getItemId()), 
	                    Toast.LENGTH_SHORT).show();
	            return super.onOptionsItemSelected(item);
	        }
	    	
	    	
		
}



