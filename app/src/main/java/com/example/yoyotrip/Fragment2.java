package com.example.yoyotrip;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class Fragment2 extends Fragment {

	private View v;
	private DisplayMetrics mPhone;
	private ImageButton camera;
	private ImageButton photo;
	private final static int CAMERA = 66 ;
	private final static int PHOTO = 99 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	

	      mPhone = new DisplayMetrics();
	      getActivity().getWindowManager().getDefaultDisplay().getMetrics(mPhone);
    	
    	
    	v = inflater.inflate(R.layout.listview2, container, false);
    	ImageButton camera=(ImageButton)v.findViewById(R.id.camera);
    	ImageButton photo=(ImageButton)v.findViewById(R.id.photo);
    	 
 
    	camera.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{

		         ContentValues value = new ContentValues();
		         value.put(Media.MIME_TYPE, "image/jpeg");                                      
		         Uri uri= getActivity().getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
		                                              value); 
		         Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		         intent.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());  
		         startActivityForResult(intent, CAMERA);
			}
		});
    	
    	photo.setOnClickListener(new OnClickListener()
	      {
	         @Override
	         public void onClick(View v) 
	         {

	         Intent intent = new Intent();
	         intent.setType("image/*");
	         intent.setAction(Intent.ACTION_GET_CONTENT);
	         startActivityForResult(intent, PHOTO);
	         }
	      });
    
    	
    	return v;
    	
    }
}
