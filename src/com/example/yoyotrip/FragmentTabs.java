package com.example.yoyotrip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.TabHost;
import android.widget.TabWidget;

public class FragmentTabs extends FragmentActivity{
    private TabHost mTabHost;
    private TabManager mTabManager;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
        
        setContentView(R.layout.fragment_tabs);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
        mTabHost.setCurrentTab(0);//設定一開始就跳到第一個分頁
        
        
        /*mTabManager.addTab(
            mTabHost.newTabSpec("Fragment1").setIndicator("發文"),
            Fragment1.class, null);
        */
        mTabManager.addTab(
            mTabHost.newTabSpec("Fragment2").setIndicator("猜猜我在哪?"),
            Fragment2.class, null);
        mTabManager.addTab(
            mTabHost.newTabSpec("Fragment3").setIndicator("台灣知識王"),
            Fragment3.class, null);

        
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //先取得螢幕解析度  
        int screenWidth = dm.widthPixels;   //取得螢幕的寬
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //取得tab的物件
        int count = tabWidget.getChildCount();   //取得tab的分頁有幾個
        if (count >= 2) {   
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i)
                      .setMinimumWidth((screenWidth)/2);//設定每一個分頁最小的寬度   
            }   
        }
        
        
        
        
        
    }
}

