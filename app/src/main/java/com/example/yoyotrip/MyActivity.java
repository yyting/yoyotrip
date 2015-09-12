package com.example.yoyotrip;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MyActivity extends Activity{

    private Button button2;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_my);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "返回主畫面");
        menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "關於");
        menu.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "離開程式");

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case Menu.FIRST:

                Intent getmain=new Intent();
                getmain.setClass(MyActivity.this, main.class);
                startActivity(getmain);
                MyActivity.this.finish();

                break;

            case Menu.FIRST+1:

                Intent getmain1=new Intent();
                getmain1.setClass(MyActivity.this, MyOneActivity.class);
                startActivity(getmain1);
                MyActivity.this.finish();
                break;

            case Menu.FIRST+2:
                new AlertDialog.Builder(MyActivity.this)
                        .setTitle("離開此程式")
                        .setMessage("你確定要離開？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                finish();
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub

                            }
                        })
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
