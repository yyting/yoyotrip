package com.example.yoyotrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.support.v4.app.FragmentActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author angle
 *
 */
/**
 * @author angle
 *
 */
/**
 * @author angle
 *
 */
public class MapActivity extends FragmentActivity {

	static GoogleMap mMap;
	final int MARKER_UPDATE_INTERVAL = 1000;
	Handler handler = new Handler();
	LatLng myLatLng;

	//按鈕
	private ImageButton imageButton3;
	private ImageButton imageButton2;
	private ImageButton imageButton1;
	private UiSettings uiSettings;
	private Spinner spinner;
	private ArrayAdapter<String> adapter1;
	private List<String> list1 = new ArrayList<String>();
	private CheckBox checkBox3;
	private CheckBox checkBox2;
	private CheckBox checkBox1;


	Marker marker;





	Runnable updateMarker = new Runnable(){
		@Override
		public void run(){
			new AsyncTaskParseJson().execute();
			handler.postDelayed(this, MARKER_UPDATE_INTERVAL);
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());


		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_map);



		mMap = ((SupportMapFragment)
				getSupportFragmentManager().findFragmentById(R.id.map)).getMap();



		setUpMapIfNeeded();


		mMap.setTrafficEnabled(false);//顯示交通資訊
		mMap.setMyLocationEnabled(true);//顯示自己位置
		uiSettings=mMap.getUiSettings();


		mMap.clear();
		myLatLng = new LatLng(25.086774, 121.565490);
		mMap.setOnMyLocationChangeListener(new OnMyLocationChangeListener() {
			@Override
			public void onMyLocationChange(Location arg) {
				// TODO Auto-generated method stub
				myLatLng = new LatLng(arg.getLatitude(),arg.getLongitude());

			}
		});


		//mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);//地圖種類
		//move.setMyLocationEnabled(new LatLng(25.0419,121.534));
		Bundle bundle = this.getIntent().getExtras();
		if (!(bundle == null)){
			if(bundle.getBoolean("marker_show") == true){
				MarkerOptions markerOpt = new MarkerOptions();
				String markerOptionString = bundle.getString("markerOptionString");
				String array[] = markerOptionString.split("&&");
				markerOpt.position(new LatLng(Double.valueOf(array[0]), Double.valueOf(array[1])));
				moveMap(new LatLng(Double.valueOf(array[0]),Double.valueOf(array[1])));
				Log.d("lat", array[0]);
				Log.d("lng", array[1]);
				markerOpt.title(array[2]);
				markerOpt.snippet("人數：" + array[3]);
				markerOpt.visible(true);
				markerOpt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
				mMap.addMarker(markerOpt);
			}
		}


		handler.postDelayed(updateMarker, MARKER_UPDATE_INTERVAL);
	}



	@Override
	protected void onResumeFragments() {
		// TODO Auto-generated method stub
		super.onResumeFragments();
		moveMap(myLatLng);
	}



	//初始化地圖
	private void setUpMapIfNeeded(){
		if (mMap == null){
			mMap = ((SupportMapFragment)
					getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

		}
	}

//	class CMuseumAdapter implements InfoWindowAdapter
//	{
//
//		@Override
//		public View getInfoContents(Marker m)
//		{
//			return null;
//		}
//
//		@Override
//		public View getInfoWindow(Marker m)
//		{
//			View infoWindow = getLayoutInflater().inflate(R.layout.marker, null);
//			TextView textView3 = (TextView) infoWindow.findViewById(R.id.textView3);
//			TextView textView1 = (TextView) infoWindow.findViewById(R.id.textView1);
//			TextView textView2 = (TextView) infoWindow.findViewById(R.id.textView2);
//			TextView textView4 = (TextView) infoWindow.findViewById(R.id.textView4);
//			TextView textView5 = (TextView) infoWindow.findViewById(R.id.textView5);
//
//			textView3.setText("");
//			textView1.setText("交通");
//			textView2.setText("時間");
//			textView4.setText("景點");
//			textView5.setText("自我");
//			return infoWindow;
//		}
//	}


	//地址轉經緯度
	public void onLocationNameClick(View view){
//    	if(!isMapReady()){
//    		return;
//    	}
		EditText editText1=(EditText) findViewById(R.id.editText1);
		String locationName = editText1.getText().toString().trim();
		if (locationName.length()>0){
			locationNameToMarker(locationName);
		} else{
			Toast.makeText(getBaseContext(),"",Toast.LENGTH_SHORT).show();
		}
	}

	private void locationNameToMarker(String locationName){

		//map.clear();
		Geocoder geocoder = new Geocoder(getBaseContext());
		List<Address> addressList=null;
		int maxResults =1;
		try {
			//將maxResults設為1,回傳一筆
			addressList = geocoder.getFromLocationName(locationName, maxResults);
		}
		catch(IOException e){
			Log.e("MapActivity",e.toString());
		}

		if(addressList == null || addressList.isEmpty()){
			Toast.makeText(getBaseContext(),"", Toast.LENGTH_SHORT).show();
		}else{

			Address address = addressList.get(0);

			LatLng position = new LatLng(address.getLatitude(),address.getLongitude());

			String snippet = address.getAddressLine(0);

			mMap.addMarker(new MarkerOptions().position(position).title(locationName).snippet(snippet));

			CameraPosition cameraPosition = new CameraPosition.Builder().target(position).zoom(15).build();
			mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		}
	}

	//路線
    
	/*private void drawPolyline(){
        PolylineOptions polylineOpt = new PolylineOptions();
        polylineOpt.add(new LatLng(25.033611, 121.565000));
        polylineOpt.add(new LatLng(25.032728, 121.565137));
        polylineOpt.add(new LatLng(25.033739, 121.527886));
        polylineOpt.add(new LatLng(25.038716, 121.517758));
        polylineOpt.add(new LatLng(25.045656, 121.519636));
        polylineOpt.add(new LatLng(25.046200, 121.517533));

        polylineOpt.color(Color.BLUE);

        Polyline polyline = mMap.addPolyline(polylineOpt);
        polyline.setWidth(50);
    }*/


//    private boolean isMapReady(){
//    	if(mMap==null){
//    		Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//    		return false;
//    	}
//    	return false;
//    }


//    public void onTrafficClick(View view){
//    	if (!isMapReady()){
//    		return;
//    	}
//    	mMap.setTrafficEnabled(((CheckBox) view).isChecked());
//    }






	private void moveMap(LatLng place) {
		CameraPosition cameraPosition =
				new CameraPosition.Builder().target(place).zoom(13).build();
		mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}

	@Override
	protected void onDestroy(){
		handler.removeCallbacks(updateMarker);
		super.onDestroy();
	}

	@Override
	protected void onResume(){
		super.onResume();
		setUpMapIfNeeded();
	}



	public class AsyncTaskParseJson extends AsyncTask<String, String, String>{
		String yourJsonStringUrl="http://192.192.140.198/~D10116203/geturl.php";
		String yourJsonStringUrl2="http://192.192.140.198/~D10116203/geturl2.php";
		String yourJsonStringUrl3="http://192.192.140.198/~D10116203/geturl4.php";

		JSONArray dataJsonArr =null;
		JSONArray dataJsonArr2 =null;
		JSONArray dataJsonArr3 =null;

		@Override
		protected String doInBackground(String... argO) {



			return null;
		}

		@Override
		protected void onPostExecute(String strFromDoInBg){


			//JSONObject json= jParser.getJSONFromUrl(yourJsonStringUrl);


			checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
			checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
			checkBox1 = (CheckBox) findViewById(R.id.checkBox1);

			checkBox3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
				{

					//判斷CheckBox是否有勾選，同mCheckBox.isChecked()
					if(isChecked)
					{

						try {
							Parser jParser = new Parser();
							dataJsonArr= jParser.getJSONAryFromUrl(yourJsonStringUrl);
							for(int i=0;i<dataJsonArr.length();i++){
								JSONObject c= dataJsonArr.getJSONObject(i);

								double lng1 = Double.parseDouble(c.getString("lon"));
								double lat1 = Double.parseDouble(c.getString("lat"));
								//int sbi1 = Integer.parseInt(c.getString("sbi"));
								//int tot1 = Integer.parseInt(c.getString("tot"));
								Log.i("mylog", lat1+","+lng1);
								MarkerOptions markerOpt = new MarkerOptions();
								markerOpt.position(new LatLng(lat1, lng1));
								markerOpt.title(c.getString("name"));
								markerOpt.snippet("地址：" +c.getString("adress"));
								markerOpt.visible(true);
								markerOpt.icon(BitmapDescriptorFactory.fromResource(R.drawable.police));
								mMap.addMarker(markerOpt);
								//mMap.addMarker(new MarkerOptions().title(c.getString("name")).snippet("地址：" +c.getString("adress") ).position(new LatLng(lat1, lng1)).icon(BitmapDescriptorFactory.fromResource(R.drawable.police)));

							}
						} catch (JSONException e){
							e.printStackTrace();
						}

					}
					else
					{
						mMap.clear();
						//CheckBox狀態 : 未勾選，隱藏TextView
						//checkBox1.setVisibility(View.GONE);

					}
				}
			});


			checkBox2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
				{
					Marker markerOpt;
					//判斷CheckBox是否有勾選，同mCheckBox.isChecked()
					if(isChecked)
					{


						try {
							Parser jParser = new Parser();
							dataJsonArr2= jParser.getJSONAryFromUrl(yourJsonStringUrl2);

							for(int i=0;i<dataJsonArr2.length();i++){
								JSONObject c= dataJsonArr2.getJSONObject(i);

								double lng1 = Double.parseDouble(c.getString("lon"));
								double lat1 = Double.parseDouble(c.getString("lat"));
								//int sbi1 = Integer.parseInt(c.getString("sbi"));
								//int tot1 = Integer.parseInt(c.getString("tot"));
								Log.i("mylog", lat1+","+lng1);
								mMap.addMarker(new MarkerOptions().title(c.getString("name")).snippet("地址：" +c.getString("adress") ).position(new LatLng(lat1, lng1)).icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));




							}
						} catch (JSONException e){
							e.printStackTrace();
						}

					}
					else
					{
						mMap.clear();
						//CheckBox狀態 : 未勾選，隱藏TextView
						//checkBox1.setVisibility(View.GONE);

					}
				}
			});


			checkBox1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
				{

					//判斷CheckBox是否有勾選，同mCheckBox.isChecked()
					if(isChecked)
					{

						try {
							Parser jParser = new Parser();
							dataJsonArr3= jParser.getJSONAryFromUrl(yourJsonStringUrl3);
							for(int i=0;i<dataJsonArr3.length();i++){
								JSONObject c= dataJsonArr3.getJSONObject(i);

								double lng1 = Double.parseDouble(c.getString("lon"));
								double lat1 = Double.parseDouble(c.getString("lat"));
								//int sbi1 = Integer.parseInt(c.getString("sbi"));
								//int tot1 = Integer.parseInt(c.getString("tot"));
								Log.i("mylog", lat1+","+lng1);
								MarkerOptions markerOpt = new MarkerOptions();
								markerOpt.position(new LatLng(lat1, lng1));
								//mMap.setInfoWindowAdapter(new CMuseumAdapter());
								markerOpt.title(c.getString("name"));
								markerOpt.snippet("自我推薦：" +c.getString("license")+"交通：" +c.getString("traffic"));
								markerOpt.visible(true);
								markerOpt.icon(BitmapDescriptorFactory.fromResource(R.drawable.pay));
								mMap.addMarker(markerOpt);
								//mMap.addMarker(new MarkerOptions().title(c.getString("name")).snippet("地址：" +c.getString("adress") ).position(new LatLng(lat1, lng1)).icon(BitmapDescriptorFactory.fromResource(R.drawable.police)));

							}
						} catch (JSONException e){
							e.printStackTrace();
						}

					}
					else
					{
						mMap.clear();
						//CheckBox狀態 : 未勾選，隱藏TextView
						//checkBox1.setVisibility(View.GONE);

					}
				}
			});


		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "列表呈現");
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
				getmain.setClass(MapActivity.this, TaskActivity.class);
				startActivity(getmain);
				break;
			case Menu.FIRST+1:
				Intent getmain1=new Intent();
				getmain1.setClass(MapActivity.this, PayStartActivity.class);
				startActivity(getmain1);
				break;
			case Menu.FIRST+2:
				Intent getmain2=new Intent();
				getmain2.setClass(MapActivity.this, main.class);
				startActivity(getmain2);
				break;
		}
		return super.onOptionsItemSelected(item);
	}



}