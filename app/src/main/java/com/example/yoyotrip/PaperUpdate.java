package com.example.yoyotrip;

import android.app.Activity;
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
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class PaperUpdate extends Fragment{
	private View v;
	private DisplayMetrics mPhone;
	private Button button1;
	private Button button2;
	private final static int CAMERA = 66 ;
	private final static int PHOTO = 99 ;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);



	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub



		//讀取手機解析度
		mPhone = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(mPhone);


		v = inflater.inflate(R.layout.listview2, container, false);
		ImageButton camera=(ImageButton)v.findViewById(R.id.camera);
		ImageButton photo=(ImageButton)v.findViewById(R.id.photo);


		button2.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				//開啟相機功能，並將拍照後的圖片存入SD卡相片集內，須由startActivityForResult且帶入
				//requestCode進行呼叫，原因為拍照完畢後返回程式後則呼叫onActivityResult
				ContentValues value = new ContentValues();
				value.put(Media.MIME_TYPE, "image/jpeg");
				Uri uri= getActivity().getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
						value);
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());
				startActivityForResult(intent, CAMERA);
			}
		});

		button1.setOnClickListener(new OnClickListener()
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


		return v;

	}
}