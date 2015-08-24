package com.example.yoyotrip.GCM;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by �� on 2015/7/27.
 */
public class MagicLenGCM {

    // ----------憿撣豢(�銵耨��----------
    /**
     * Google Developers Console ��Project Number
     */
    public final static String SENDER_ID = "910570490011";

    // ----------憿��----------
    public static enum PlayServicesState {
        SUPPROT, NEED_PLAY_SERVICE, UNSUPPORT;
    }

    public static enum GCMState {
        PLAY_SERVICES_NEED_PLAY_SERVICE, PLAY_SERVICES_UNSUPPORT, NEED_REGISTER, AVAILABLE;
    }

    // ----------憿隞----------
    public static interface MagicLenGCMListener {
        /**
         * GCM閮餃�蝯�
         *
         * @param successfull
         *            �臬閮餃���
         * @param regID
         *            �喳�閮餃��啁�regID
         */
        public void gcmRegistered(boolean successfull, String regID);

        /**
         * GCM閮餃���嚗�蝯�撖怠App Server
         *
         * @param regID
         *            �喳�閮餃��啁�regID
         * @return �臬�喲�App Server��
         */
        public boolean gcmSendRegistrationIdToAppServer(String regID);

    }

    // ----------憿撣豢----------
    /**
     * �其��嗡�SharedPreferences�ey.
     */
    private static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    /**
     * 雿輻MagicLenGCM�ctivity�臭誑撖虫���ActivityResult�Ⅳ
     */
    public final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    // ----------憿�寞�----------
    /**
     * �澆Local蝡舐��(憿舐內�券��交�銝�
     *
     * @param context
     *            Context
     * @param notifyID
     *            �ID(���◤閬�)
     * @param drawableSmallIcon
     *            撠�蝷��求rawable ID靘身摰�
     * @param title
     *            璅�
     * @param msg
     *            閮
     * @param info
     *            ����
     * @param autoCancel
     *            �臬��敺停瘨仃
     * @param pendingIntent
     *            ��敺�雿輻隞�獐Intent
     */
    public static int notifymax=3;
    public static int notifynum=0;

    public static void sendLocalNotification(Context context, int notifyID,
                                             int drawableSmallIcon, String title, String msg, String info,
                                             boolean autoCancel, PendingIntent pendingIntent) {
        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(drawableSmallIcon).setContentTitle(title)
                .setContentText(msg).setAutoCancel(autoCancel)
                .setContentInfo(info).setDefaults(Notification.DEFAULT_ALL);

        if (msg.length() > 10) {
            mBuilder.setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(msg));
        }
        mBuilder.setContentIntent(pendingIntent);
        mNotificationManager.notify(notifynum++, mBuilder.build());
        Log.i("notifyID", (""+notifynum));
        /**�梯�頞�notifymax隞亙�����*/
        if(notifynum>notifymax){mNotificationManager.cancel(notifynum-(notifymax+1));}
    }

    // ----------�拐辣霈----------
    private Activity activity;
    private MagicLenGCMListener listener;

    // ----------撱箸�摮�---------
    public MagicLenGCM(Activity activity) {
        this(activity, null);
    }

    public MagicLenGCM(Activity activity, MagicLenGCMListener listener) {
        this.activity = activity;
        setMagicLenGCMListener(listener);
    }

    // ----------�拐辣�寞�----------
    /**
     * ��Activity
     *
     * @return �喳�Activity
     */
    public Activity getActivity() {
        return activity;
    }

    public void setMagicLenGCMListener(MagicLenGCMListener listener) {
        this.listener = listener;
    }

    /**
     * ���乩�GCM
     *
     * @return �喳�GCM���
     */
    public GCMState startGCM() {
        return openGCM();
    }

    /**
     * ���乩�GCM
     *
     * @return �喳�GCM���
     */
    public GCMState openGCM() {
        switch (checkPlayServices()) {
            case SUPPROT:
                String regid = getRegistrationId();
                if (regid.isEmpty()) {
                    registerInBackground();
                    return GCMState.NEED_REGISTER;
                } else {
                    return GCMState.AVAILABLE;
                }
            case NEED_PLAY_SERVICE:
                return GCMState.PLAY_SERVICES_NEED_PLAY_SERVICE;
            default:
                return GCMState.PLAY_SERVICES_UNSUPPORT;
        }
    }

    public String getRegistrationId() {
        final SharedPreferences prefs = getGCMPreferences();
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            return "";
        }
        // 瑼Ｘ蝔��臬��圈�
        int registeredVersion = prefs.getInt(MagicLenGCM.PROPERTY_APP_VERSION,
                Integer.MIN_VALUE);
        int currentVersion = getAppVersion();
        if (registeredVersion != currentVersion) {
            return "";
        }
        return registrationId;
    }

    public int getAppVersion() {
        try {
            PackageInfo packageInfo = activity.getPackageManager()
                    .getPackageInfo(activity.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // 銝�賣��潛�
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    private SharedPreferences getGCMPreferences() {
        return activity.getSharedPreferences(activity.getClass()
                .getSimpleName(), Context.MODE_PRIVATE);
    }

    /**
     * 瑼ＸGoogle Play Service�舐���
     *
     * @return �喳�Google Play Service�舐���
     */
    public PlayServicesState checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(activity);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, activity,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
                return PlayServicesState.NEED_PLAY_SERVICE;
            } else {
                return PlayServicesState.UNSUPPORT;
            }
        }
        return PlayServicesState.SUPPROT;
    }

    /**
     * �刻��航酉�CM
     */
    private void registerInBackground() {
        new AsyncTaskRegister().execute();
    }

    private final class AsyncTaskRegister extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String regid = "";
            try {
                GoogleCloudMessaging gcm = GoogleCloudMessaging
                        .getInstance(activity);
                regid = gcm.register(SENDER_ID);

                if (regid == null || regid.isEmpty()) {
                    return "";
                }

                // �脣�regID
                storeRegistrationId(regid);

                if (listener != null) {
                    if (!listener.gcmSendRegistrationIdToAppServer(regid)) {
                        storeRegistrationId("");
                        return "";
                    }
                }
            } catch (IOException ex) {

            }
            return regid;
        }

        @Override
        protected void onPostExecute(String msg) {
            if (listener != null) {
                listener.gcmRegistered(!msg.isEmpty(), msg.toString());
            }
        }
    }

    private void storeRegistrationId(String regId) {
        final SharedPreferences prefs = getGCMPreferences();
        int appVersion = getAppVersion();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }
}