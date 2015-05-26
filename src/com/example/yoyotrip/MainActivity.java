package com.example.yoyotrip;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public ProgressDialog PDialog = null;
	
	public EditText account;
	public EditText passwd;
	public String path="";
	JSONParser jsonParser=new JSONParser();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		path=getResources().getString(R.string.login_path);
		account=(EditText)findViewById(R.id.email_phone);
		passwd=(EditText)findViewById(R.id.pwd);
		
		
		Button login=(Button)findViewById(R.id.sign_in);
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
				//登入後切換到主畫面
				new getlogin().execute();
			}
		});
		
		Button sign_up=(Button)findViewById(R.id.sign_up);
		sign_up.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//登入後切換到註冊畫面
				Intent getmain=new Intent();
				getmain.setClass(MainActivity.this, FirstUsedActivity.class);
				startActivity(getmain);
				MainActivity.this.finish();
			}
		});
		
		
	}
	
class getlogin extends AsyncTask<String,String,String> {
		
		protected void onPreExecute() {
			final CharSequence strDialogTitle = getString(R.string.login_dialog_title);
		    final CharSequence strDialogBody = getString(R.string.login_dialog_body);
            super.onPreExecute();
            PDialog = ProgressDialog.show(MainActivity.this, strDialogTitle, strDialogBody, true);
        }
		
		protected String doInBackground(String... args){
			String acc=account.getText().toString();
			String pwd=passwd.getText().toString();
			Log.v("acc",acc);
			//building parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("acc",acc));
			params.add(new BasicNameValuePair("pwd",pwd));
			JSONObject json=jsonParser.makeHttpRequest(path,"POST",params);
			Log.d("Create Response",json.toString());
			
			 try {
				 JSONObject status=new JSONObject(json.toString());
				 Log.d("status",(String) status.get("status"));
				
				 if(status.getInt("status")==1)
				 {
					 Intent getmain=new Intent();
					  getmain.setClass(MainActivity.this,FragmentTabs.class);
						//Log.i("123","11111");
					  startActivity(getmain);
					  MainActivity.this.finish();
				 }else{
					 Toast toast = Toast.makeText(MainActivity.this, "Hello world!", Toast.LENGTH_LONG);
					 toast.show();

				 }
	              
	            } 
			 catch (JSONException e) {
	                e.printStackTrace();
	            }
			 catch (Exception e) {
	                // some code
	            }
	 
			
			return null;
		}
		protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            PDialog.dismiss();
        }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
