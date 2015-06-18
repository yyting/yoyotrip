package com.example.yoyotrip;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login2Activity extends Activity {
	public ProgressDialog PDialog = null;
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	private EditText last_name;
	private EditText first_name;
	private RadioButton male;
	private RadioButton female;
	public JSONObject signup_info;
	public JSONParser jsonparser=new JSONParser();
	public String path;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login2);
		last_name=(EditText)findViewById(R.id.last_name);
		first_name=(EditText)findViewById(R.id.first_name);
		male=(RadioButton)findViewById(R.id.male);
		female=(RadioButton)findViewById(R.id.female);
		imageButton2=((ImageButton)findViewById(R.id.imageButton2));
		path=getResources().getString(R.string.sign_up_path);
		final Bundle get_info=this.getIntent().getExtras();
		
		imageButton2.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {
						String gender="";
						if(male.isChecked())
						{gender="male";}
						else if (female.isChecked())
						{gender="female";}
						signup_info=new JSONObject();
						try{
							signup_info.put("account",get_info.getString("account"));
							signup_info.put("password",get_info.getString("password"));
							signup_info.put("name",last_name.getText().toString()+first_name.getText().toString());
							signup_info.put("gender",gender);
							Log.v("set_info", signup_info.toString());
							new getsign_up().execute();
						}
						catch (JSONException e)
						{

						}

				    }});
		imageButton1=((ImageButton)findViewById(R.id.imageButton1));
		imageButton1.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {

				    	//�n�J�������D�e��
						Intent getmain=new Intent();
						getmain.setClass(Login2Activity.this, Login1Activity.class);
						startActivity(getmain);
						Login2Activity.this.finish();
				  
				    }});
	}

	class getsign_up extends AsyncTask<String,String,Integer> {

		protected void onPreExecute() {
			final CharSequence strDialogTitle = getString(R.string.login_dialog_title);
			final CharSequence strDialogBody = getString(R.string.login_dialog_body);
			super.onPreExecute();
			PDialog = ProgressDialog.show(Login2Activity.this, "請稍後", "正在與伺服器交換資訊...", true);
		}

		protected Integer doInBackground(String... args) {
			//building parameters
			int resp=0;
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("set_info", signup_info.toString()));
			JSONObject json = jsonparser.makeHttpRequest(path, "POST", params);
			Log.d("Response", json.toString());

			try {
				JSONObject status = new JSONObject(json.toString());
				Log.d("status", (String) status.get("status"));
				resp =status.getInt("status") ;

			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// some code
			}


			return resp;
		}
		protected void onPostExecute(Integer result) {
			super.onPostExecute(result);
			if(result==1)
			{
				try {

					PDialog.setTitle("註冊成功!");
					PDialog.setMessage("畫面將在2秒後跳轉...");
					PDialog.show();
					Thread.sleep(2000);
					PDialog.dismiss();
					Intent getmain=new Intent();
					getmain.setClass(Login2Activity.this, Login3Activity.class);
					startActivity(getmain);
					Login2Activity.this.finish();
				}catch(InterruptedException e){}
			}else{
				PDialog.dismiss();

				try {
					PDialog = ProgressDialog.show(Login2Activity.this, "Waring", "註冊失敗請連略管理員", true);
					Thread.sleep(5000);
					PDialog.dismiss();

				}catch(InterruptedException e){}
				//toast.setText();

			}
		}
		protected  void onCancelled(){
			PDialog.dismiss();

			super.onCancelled();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
