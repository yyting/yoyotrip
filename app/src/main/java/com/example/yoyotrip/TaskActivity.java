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
		       //requestWindowFeature(Window.FEATURE_NO_TITLE); 
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
	            menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "地圖呈現");
	            menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "新增任務");
	            menu.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "回主畫面");

	            return super.onCreateOptionsMenu(menu);
	        }
	        @Override
	        public boolean onOptionsItemSelected(MenuItem item) {
	            // TODO Auto-generated method stub
	            switch(item.getItemId()){
	                case Menu.FIRST:
	                	Intent getmain=new Intent();
						getmain.setClass(TaskActivity.this, MapActivity.class);
						startActivity(getmain);
						TaskActivity.this.finish();
	                    break;
	                case Menu.FIRST+1:
	                	Intent getmain1=new Intent();
					getmain1.setClass(TaskActivity.this, TaskPayStartActivity.class);
					startActivity(getmain1);
					TaskActivity.this.finish();
	                    break;
	                case Menu.FIRST+2:
	                	Intent getmain2=new Intent();
					getmain2.setClass(TaskActivity.this, main.class);
					startActivity(getmain2);
					TaskActivity.this.finish();
	                    break;
	            }
	            return super.onOptionsItemSelected(item);
	        }
	    	
	    	
		
}



