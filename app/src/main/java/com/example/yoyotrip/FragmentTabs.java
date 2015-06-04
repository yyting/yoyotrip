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
        mTabHost.setCurrentTab(0);//�]�w�@�}�l�N����Ĥ@�Ӥ���
        
        
        /*mTabManager.addTab(
            mTabHost.newTabSpec("Fragment1").setIndicator("�o��"),
            Fragment1.class, null);
        */
        mTabManager.addTab(
            mTabHost.newTabSpec("Fragment2").setIndicator("�q�q�ڦb��?"),
            Fragment2.class, null);
        mTabManager.addTab(
            mTabHost.newTabSpec("Fragment3").setIndicator("�x�W���Ѥ�"),
            Fragment3.class, null);

        
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //�����o�ù��ѪR��  
        int screenWidth = dm.widthPixels;   //���o�ù����e
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //���otab������
        int count = tabWidget.getChildCount();   //���otab���������X��
        if (count >= 2) {   
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i)
                      .setMinimumWidth((screenWidth)/2);//�]�w�C�@�Ӥ����̤p���e��   
            }   
        }
        
        
        
        
        
    }
}

