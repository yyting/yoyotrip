package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
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

	
	 ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	 private SimpleAdapter adapter;

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
		       
		      
		       
		       for(int i=0;i<mName.length;i++)  
		       {  
		        HashMap<String, Object> map = new HashMap<String, Object>();  
		        map.put("pic",mPics[i]);//添加图像资源的ID  
		        //map.put("ItemTitle", "標題");  
		        //map.put("ItemText", "內容");
		        //map.put("button1", "");
		        map.put("name", "景點名稱："+mName[i]);
		        map.put("add", "地址："+mAdd[i]);
		        lstImageItem.add(map);
		        
		       }  
		       
		     
		       
		       //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
		       SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
		                                                lstImageItem,//数据来源   
		                                                R.layout.activity_scenery_one,//ListItem的XML实现  
		                                                  
		                                                //动态数组与ImageItem对应的子项          
		                                                new String[] {"pic","name","add"},   
		                                                  
		                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
		                                                new int[] {R.id.imageView1,R.id.textView1,R.id.textView2});  
		    
		    
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
			
			
			 ImageButton imageButton2=(ImageButton)findViewById(R.id.imageButton2);
			 imageButton2.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						//登入後切換到註冊畫面
						Intent getmain=new Intent();
						getmain.setClass(SceneryActivity.this, LoveActivity.class);
						startActivity(getmain);
						SceneryActivity.this.finish();
					}
				});
	        
	       
	    }
	    private static final int[] mPics=new int[]{
   		 R.drawable.a,R.drawable.b,R.drawable.c, R.drawable.d,R.drawable.e,
   		 R.drawable.f,R.drawable.g,R.drawable.h, R.drawable.i,R.drawable.j,
   		 R.drawable.k,R.drawable.l,R.drawable.m, R.drawable.n,R.drawable.o,
   		 R.drawable.p,R.drawable.q,R.drawable.r, R.drawable.s,R.drawable.t,
   		 R.drawable.u,R.drawable.v,R.drawable.x, R.drawable.y,R.drawable.y,
   		 R.drawable.z,R.drawable.aa,R.drawable.bb, R.drawable.cc,R.drawable.dd
   		 };
      private static final String[] mName = new String[] {
    "水璉、牛山海岸", "石梯坪", "長虹橋", "北回歸線標碑", "金樽",
    "加路蘭", "都蘭", "成功", "阿美族民俗中心", "綠島露營區",
    "帆船鼻大草原", "哈巴狗與睡美人岩", "綠島人權文化園區", "牛頭山、樓門岩", "樟原",
    "杉原-富山復魚區", "柴口", "美山驛站", "目斗嶼", "吉貝嶼",
    "姑婆嶼", "險礁嶼", "員貝嶼", "林投公園、隘門沙灘", "眷村文化園區",
    "觀音亭親水遊憩區", "中央街", "菜園休閒漁業區", "風櫃洞", "嵵裡沙灘"
   	   };
   	   
   	   private static final String[] mAdd = new String[] {
   		"壽豐鄉水璉村牛山39-5號", "瑞穗鄉港口村石梯坪52號", "豐濱鄉臺11線68公里處", "豐濱鄉臺11線70.5公里路旁", "東河鄉臺11線136.5公里路旁",
   		"臺東市臺11線157公里處", "東河鄉都蘭村","成功鎮", "成功鎮信義里新村路25號", "綠島鄉環島公路13公里處",
   		"綠島鄉環島公路12.8公里處","綠島鄉環島公路9公里處","綠島鄉公館村將軍岩20號","綠島鄉環島公路6公里處","長濱鄉樟原村",
   		"卑南鄉臺11線153.5公里處","綠島鄉環島公路2公里處","美山路139號","澎湖縣白沙鄉目斗嶼","澎湖縣白沙鄉吉貝嶼",
   		"澎湖縣白沙鄉姑婆嶼","澎湖縣白沙鄉險礁嶼","澎湖縣白沙鄉員貝嶼","澎湖縣湖西鄉澎湖縣湖西鄉林投村","澎湖縣馬公市新復里",
   		"澎湖縣馬公市媽宮城牆西側海岸邊","澎湖縣馬公市中央街","澎湖縣馬公市菜園里","澎湖縣馬公市風櫃里風櫃洞","澎湖縣馬公市嵵裡里"
   	   };
   	  
   	   
   	
	}

