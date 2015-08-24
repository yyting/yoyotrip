package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SlidingDrawer;
import android.widget.Spinner;

public class SceneryActivity extends Activity {

	  private LinearLayout gv;
	  private SlidingDrawer sd;
	  private ImageView iv;
	  private Spinner spinner1;
	  private Spinner spinner2;
	private ArrayAdapter<String> adapter1;
	private ArrayAdapter<String> adapter2;
	private List<String> list2 = new ArrayList<String>();
	private List<String> list1 = new ArrayList<String>();


	  //private int[] icons={R.drawable.ic_launcher,R.drawable.ic_launcher,
	                       // R.drawable.ic_launcher,R.drawable.ic_launcher,
	                       // R.drawable.ic_launcher,R.drawable.ic_launcher,
	                      //  R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	 // private String[] items={"浏览器","图片","相机","时钟","音乐","市场","拨号","信息","地图"};

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE); 
		    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.activity_scenery);
	        gv = (LinearLayout)findViewById(R.id.myContent); 
	        sd = (SlidingDrawer)findViewById(R.id.sd);
	        iv=(ImageView)findViewById(R.id.iv);
	        spinner1=(Spinner)findViewById(R.id.spinner1);
	        spinner2=(Spinner)findViewById(R.id.spinner2);
		    ListView list = (ListView) findViewById(R.id.listView1);  
	     //  Adapter MyGridViewAdapter=new Adapter(gv);//自定义MyAdapter来实现图标加item的显示效果
	     //   gv.setAdapter(adapter);
	        
		    
		    ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		       
		      
		       
		       for(int i=0;i<10;i++)  
		       {  
		        HashMap<String, Object> map = new HashMap<String, Object>();  
		        map.put("imageView1", R.drawable.a);//添加图像资源的ID  
		        //map.put("ItemTitle", "標題");  
		        //map.put("ItemText", "內容");
		        map.put("button1", "");
		        map.put("textView1", "景點名稱：");
		        map.put("textView2", "地址：");
		        lstImageItem.add(map);
		        
		       }  
		       
		     
		       
		       //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
		       SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
		                                                lstImageItem,//数据来源   
		                                                R.layout.activity_scenery_one,//ListItem的XML实现  
		                                                  
		                                                //动态数组与ImageItem对应的子项          
		                                                new String[] {"imageView1","textView1","textView2","button1"},   
		                                                  
		                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
		                                                new int[] {R.id.imageView1,R.id.textView1,R.id.textView2,R.id.button1});  
		    
		    
		     //添加并且显示  
		       list.setAdapter(saImageItems);
		    
		    
		    
		    
	        
	           list1.add("台北市");    
			   list1.add("新北市");    
			   list1.add("桃園市");    
			   adapter1 = new ArrayAdapter<String>(this,R.layout.myspinner, list1);
			   adapter1.setDropDownViewResource(R.layout.myspinner);  //下拉選單的樣式
			   spinner1.setAdapter(adapter1);
	        
	        
			   list2.add("新店區");    
			   list2.add("大同區");    
			   list2.add("萬華區");    
			   adapter2 = new ArrayAdapter<String>(this,R.layout.myspinner, list2);
			   adapter2.setDropDownViewResource(R.layout.myspinner);  //下拉選單的樣式
			   spinner2.setAdapter(adapter2);
	        
	        
	        
	        sd.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener()//开抽屉
	        {
	          @Override
	          public void onDrawerOpened()
	          {
	            iv.setImageResource(R.drawable.next1);//响应开抽屉事件 ，把图片设为向下的
	          }
	        });
	        sd.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener()
	        {
	          @Override
	          public void onDrawerClosed()
	          {
	            iv.setImageResource(R.drawable.next);//响应关抽屉事件
	          }
	        });
	        
	        
	        ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);
			imageButton1.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					//登入後切換到註冊畫面
					Intent getmain=new Intent();
					getmain.setClass(SceneryActivity.this, main.class);
					startActivity(getmain);
					SceneryActivity.this.finish();
				}
			});
	        
	        
	        
	        
	    }
	}

