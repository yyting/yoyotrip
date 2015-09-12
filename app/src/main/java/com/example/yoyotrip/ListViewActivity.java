package com.example.yoyotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity{
    private ListView listView;
    private ImageButton imageButton1;
    private String[] list = {"潘小姐：我想去台南!接任務","楊先生：我想要去墾丁!接任務","丁先生：我想要去新竹!接任務","吳小姐：我想要去台東!接任務","周先生：我想要去澎湖!接任務","石小姐：我想要去台北!解任務"};
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        imageButton1=((ImageButton)findViewById(R.id.imageButton1));

        imageButton1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                //切換到地圖
                Intent getmain=new Intent();
                getmain.setClass(ListViewActivity.this, map.class);
                startActivity(getmain);
                ListViewActivity.this.finish();

            }});



        listView = (ListView)findViewById(R.id.listView);
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), "你選擇的是"+list[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
    
