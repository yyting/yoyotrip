package com.example.yoyotrip.GCM;

/**
 * Created by 勇元 on 2015/8/3.
 */

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.ListView;

import com.example.yoyotrip.MainActivity;
import com.example.yoyotrip.R;
import com.example.yoyotrip.chat.Message;
import com.example.yoyotrip.chat.MessageAdapter;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.util.Date;



public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {

    public static final int NOTIFICATION_ID = 0;
    public ListView 			listView;
    public MessageAdapter 		adapter;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        String messageType = gcm.getMessageType(intent);
        if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
                    .equals(messageType)) {
                Log.i(getClass() + " GCM ERROR", extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
                    .equals(messageType)) {
                Log.i(getClass() + " GCM DELETE", extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
                    .equals(messageType)) {
                Log.i(getClass() + " GCM MESSAGE", extras.toString());
                if (extras.getString("title") .equals("chat")) {
                    /*顯示通知*/
                    Intent i = new Intent(context, MainActivity.class);
                    i.setAction("android.intent.action.MAIN");
                    i.addCategory("android.intent.category.LAUNCHER");
                    MagicLenGCM.sendLocalNotification(context, NOTIFICATION_ID,
                            R.drawable.icon, "通知", extras
                                    .getString("message"), extras.getString("whofrom"), false,
                            PendingIntent.getActivity(context, 0, i,
                                    PendingIntent.FLAG_CANCEL_CURRENT));
                    //將訊息加入chat
                    final Message message = new Message(0, 1, extras.getString("whofrom"), "avatar", "Jerry", "avatar", extras.getString("message"), false, true, new Date());
                    adapter.getData().add(message);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(listView.getBottom());
                } else if (extras.getString("title").equals("GCM")) {
                    Intent i = new Intent(context, MainActivity.class);
                    i.setAction("android.intent.action.MAIN");
                    i.addCategory("android.intent.category.LAUNCHER");
                    MagicLenGCM.sendLocalNotification(context, NOTIFICATION_ID,
                            R.drawable.icon, "GCM 通知", extras
                                    .getString("message"), "yoyotrip", false,
                            PendingIntent.getActivity(context, 0, i,
                                    PendingIntent.FLAG_CANCEL_CURRENT));
                }

            }
        }
        setResultCode(Activity.RESULT_OK);
    }

}