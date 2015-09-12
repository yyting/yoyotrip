package com.example.yoyotrip;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class PayStartActivity extends Activity{
	
	private List<String> list1 = new ArrayList<String>();
	private List<String> list2 = new ArrayList<String>();
	private Spinner spinner1;
	private Spinner spinner2;
	private ArrayAdapter<String> adapter1;
	private ArrayAdapter<String> adapter2;
	private Button button3;
	private Button button2;
	private EditText editText2;
	private EditText editText1;
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	
	 private ImageView imageView1;
	 private DisplayMetrics mPhone;
	 private final static int CAMERA = 66 ;
	 private final static int PHOTO = 99 ;
	
	
	public void onCreate(Bundle savedInstanceState) {    
	       super.onCreate(savedInstanceState);
	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		   setContentView(R.layout.activity_paystart);
		   
		 //讀取手機解析度
		      mPhone = new DisplayMetrics();
		      getWindowManager().getDefaultDisplay().getMetrics(mPhone);
		            
		      imageView1 = (ImageView) findViewById(R.id.imageView1);
		      imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
		      imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
		                
		      imageButton1.setOnClickListener(new OnClickListener()
		      {
		         @Override
		         public void onClick(View v) 
		         {
		         //開啟相機功能，並將拍照後的圖片存入SD卡相片集內，須由startActivityForResult且
		         //帶入requestCode進行呼叫，原因為拍照完畢後返回程式後則呼叫onActivityResult
		         ContentValues value = new ContentValues();
		         value.put(Media.MIME_TYPE, "image/jpeg");                                      
		         Uri uri= getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
		                                              value); 
		         Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		         intent.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());  
		         startActivityForResult(intent, CAMERA);      
		         }
		      });
		                
		      imageButton2.setOnClickListener(new OnClickListener()
		      {
		         @Override
		         public void onClick(View v) 
		         {
		         //開啟相簿相片集，須由startActivityForResult且帶入requestCode進行呼叫，原因
		         //為點選相片後返回程式呼叫onActivityResult
		         Intent intent = new Intent();
		         intent.setType("image/*");
		         intent.setAction(Intent.ACTION_GET_CONTENT);
		         startActivityForResult(intent, PHOTO);
		         }
		      });
		   
		   
		   
		   
		   
		   
		   
		   list1.add("大眾運輸");    
		   list1.add("汽車");    
		   list1.add("機車");    
		   list1.add("自行車");
		   spinner1 = (Spinner)findViewById(R.id.spinner1);
		   adapter1 = new ArrayAdapter<String>(this,R.layout.myspinner, list1);
		   adapter1.setDropDownViewResource(R.layout.myspinner);  //下拉選單的樣式
		   spinner1.setAdapter(adapter1);
		   

		   
		   
			           /*下拉菜单弹出的内容选项触屏事件处理*/    
		//  spinner1.setOnTouchListener(new Spinner.OnTouchListener(){    
			              // public boolean onTouch(View v, MotionEvent event) {    
			                   // TODO Auto-generated method stub    
			                   /** 
			                    *  
			                    */  
			                 //  return false;    
			              // }  
			         //  });   
			           /*下拉菜单弹出的内容选项焦点改变事件处理*/    
		  // spinner1.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){    
			           //public void onFocusChange(View v, boolean hasFocus) {    
			               // TODO Auto-generated method stub    
			     
			         //  }    
			       //    });    

		   
		   list2.add("半小時");    
		   list2.add("一小時以內");    
		   list2.add("三小時以上");    
		   list2.add("一天");
		   spinner2 = (Spinner)findViewById(R.id.spinner2);
		   adapter2 = new ArrayAdapter<String>(this,R.layout.myspinner, list2);
		   adapter2.setDropDownViewResource(R.layout.myspinner);
		   spinner2.setAdapter(adapter2);
		  
		   
		   Button button3=(Button)findViewById(R.id.button3);
		   button3.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Spinner spinner1=(Spinner)findViewById(R.id.spinner1);
             	   String traiff=spinner1.getSelectedItem().toString();
             	   
             	   Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
             	   String time=spinner2.getSelectedItem().toString();
             	   
             	   EditText editText2=(EditText)findViewById(R.id.editText2);
           		Editable edit1;
           		edit1=editText2.getText();
           		String view=edit1.toString();
             	   //String view=editText2.getText().toString();
           		   
           		   EditText editText1=(EditText)findViewById(R.id.editText1);
           		   String me=editText1.getText().toString();
           		   
//           		ImageView imageView1=(ImageView)findViewById(R.id.imageView1);
//           		Drawable cord=imageView1.getDrawable();
             		
             		
           		//new一個intent物件，並指定Activity切換的class
                     Intent intent=new Intent();
                     intent.setClass(getApplicationContext(), small.class);
                     
                     //new一個Bundle物件，並將要傳遞的資料傳入
                     Bundle bundle = new Bundle();
             	    bundle.putString("traiff", traiff);
             	    bundle.putString("time", time); 
             	    bundle.putString("view", view); 
             	    bundle.putString("me", me);
             	  // bundle.putParcelable("cord", cord);
             	    
             	  //將Bundle物件assign給intent
             	    intent.putExtras(bundle);  
             	  //切換Activity
                     startActivity(intent);
            		
            		
            		//Intent intent=new Intent();
                   // intent.setClass(getApplicationContext(), MainActivity.class);
                   // startActivity(intent);
				}
			});
		   
		   
		   
		   Button button2=(Button)findViewById(R.id.button2);
		   button2.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
            	   Intent intent=new Intent();
                   intent.setClass(getApplicationContext(), MapActivity.class);
                   startActivity(intent);
				}
			});
	
	
	
	}
	
	
	//拍照完畢或選取圖片後呼叫此函式
	   @Override 
	   protected void onActivityResult(int requestCode, int resultCode,Intent data)
	   {
	      //藉由requestCode判斷是否為開啟相機或開啟相簿而呼叫的，且data不為null
	      if ((requestCode == CAMERA || requestCode == PHOTO ) && data != null)
	      {
	         //取得照片路徑uri
	         Uri uri = data.getData();
	         ContentResolver cr = this.getContentResolver();
	                      
	         try
	         {
	         BitmapFactory.Options mOptions = new BitmapFactory.Options();
	         //Size=2為將原始圖片縮小1/2，Size=4為1/4，以此類推
	         mOptions.inSampleSize = 2; 
	         Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri),null,mOptions);
	         //讀取照片，型態為Bitmap
	         //Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));

	         //判斷照片為橫向或者為直向，並進入ScalePic判斷圖片是否要進行縮放
	         if(bitmap.getWidth()>bitmap.getHeight())ScalePic(bitmap,mPhone.heightPixels);
	         else ScalePic(bitmap,mPhone.widthPixels);
	         } 
	         catch (FileNotFoundException e)
	         {
	         }
	      }
	                
	      super.onActivityResult(requestCode, resultCode, data);
	   }
	        
	   private void ScalePic(Bitmap bitmap,int phone)
	   {
	      //縮放比例預設為1
	      float mScale = 1 ;
	                
	      //如果圖片寬度大於手機寬度則進行縮放，否則直接將圖片放入ImageView內
	      if(bitmap.getWidth() > phone )
	      {
	         //判斷縮放比例
	         mScale = (float)phone/(float)bitmap.getWidth();
	                      
	         Matrix mMat = new Matrix() ;
	         
	         //mMat.setScale(mScale, mScale);
	         mMat.setRotate(90);                 
	         Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap,
	                                                   0,
	                                                   0,
	                                                   bitmap.getWidth(),
	                                                   bitmap.getHeight(),
	                                                   mMat,
	                                                   false);
	         imageView1.setImageBitmap(mScaleBitmap);
	      }
	   else imageView1.setImageBitmap(bitmap);
	   }
	
	
	   
	}
