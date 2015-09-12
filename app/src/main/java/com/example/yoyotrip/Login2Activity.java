package com.example.yoyotrip;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.yoyotrip.GCM.MagicLenGCM;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Login2Activity extends Activity {
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	private Button date;
    private Calendar calendar;
    private int mYear, mMonth, mDay;
    private TextView dateText;
    private DatePickerDialog datePickerDialog;
    public ProgressDialog PDialog = null;
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
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login2);
        final Bundle get_info=this.getIntent().getExtras();
        last_name=(EditText)findViewById(R.id.last_name);
        first_name=(EditText)findViewById(R.id.first_name);
        male=(RadioButton)findViewById(R.id.radio0);
        female=(RadioButton)findViewById(R.id.radio1);
        imageButton2=((ImageButton)findViewById(R.id.imageButton2));
        path=getResources().getString(R.string.sign_up_path);
		calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        
        dateText = (TextView)findViewById(R.id.dateText);
        date = (Button)findViewById(R.id.date);
        date.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                showDialog(0);
                datePickerDialog.updateDate(mYear, mMonth, mDay);
            }
            
        });
		
		
		

		imageButton2=((ImageButton)findViewById(R.id.imageButton2));
		
		
		imageButton2.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {
                        String gender = "";
                        if (male.isChecked()) {
                            gender = "male";
                        } else if (female.isChecked()) {
                            gender = "female";
                        }
                        MagicLenGCM register = new MagicLenGCM(Login2Activity.this);
                        /**@檢查GCM狀態*/
                        register.openGCM();
                        try {
                            signup_info = new JSONObject();
                            signup_info.put("regid",register.getRegistrationId());
                            signup_info.put("account", get_info.getString("account"));
                            signup_info.put("password", get_info.getString("password"));
                            signup_info.put("name", last_name.getText().toString() + first_name.getText().toString());
                            signup_info.put("gender", gender);
                            Log.v("set_info", signup_info.toString());
                            new getsign_up().execute();
                        } catch (JSONException e) {}
				    }});

		imageButton1=((ImageButton)findViewById(R.id.imageButton1));
		
		
		imageButton1.setOnClickListener(
				new OnClickListener() {
				    public void onClick(View arg0) {


						Intent getmain=new Intent();
						getmain.setClass(Login2Activity.this, Login1Activity.class);
						startActivity(getmain);
						Login2Activity.this.finish();
				  
				    }});
		
		
	}
    class getsign_up extends AsyncTask<String,Integer,Integer> {


        protected void onPreExecute() {
            super.onPreExecute();
            PDialog = ProgressDialog.show(Login2Activity.this, "請稍後", "正在與伺服器交換資訊...", true);
        }

        protected Integer doInBackground(String... args) {
            //building parameters
            int resp=0;
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("set_info", signup_info.toString()));
            JSONObject json = jsonparser.makeHttpRequest(path, "POST", params);
            Log.d("Response", json.toString());

            try {
                JSONObject status = new JSONObject(json.toString());
                Log.d("sign_up_status", (String) status.get("sign_up_status"));
                resp =status.getInt("sign_up_status") ;

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                // some code
            }


            return resp;
        }

//        protected void onProgressUpdate(Integer progress) {
//            super.onProgressUpdate();
//            // TODO Auto-generated method stub
//            if (progress==1){
//                PDialog.setTitle("註冊成功!");
//                PDialog.setMessage("畫面將在2秒後跳轉...");
//                PDialog.show();
//                try {
//                    Thread.sleep(2000);
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                PDialog.dismiss();
//            }
//        }
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if(result==1) {
                    PDialog.dismiss();
                    Intent getmain=new Intent();
                    getmain.setClass(Login2Activity.this, Login4Activity.class);
                    startActivity(getmain);
                    Login2Activity.this.finish();

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
    protected Dialog onCreateDialog(int id) {
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePicker view, int year, int month,
                       int day) {
                   mYear = year;
                   mMonth = month;
                   mDay = day;
                   dateText.setText(setDateFormat(year,month,day)); 
               }
               
           }, mYear,mMonth, mDay);
           
           return datePickerDialog;        
    }
    private String setDateFormat(int year,int monthOfYear,int dayOfMonth){
        return String.valueOf(year) + "-"
        + String.valueOf(monthOfYear + 1) + "-"
        + String.valueOf(dayOfMonth);
    }

}
