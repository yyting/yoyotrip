package com.example.yoyotrip;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yoyotrip.chat.Message;
import com.example.yoyotrip.chat.MessageAdapter;
import com.example.yoyotrip.chat.MessageInputToolBox;
import com.example.yoyotrip.chat.OnOperationListener;
import com.example.yoyotrip.chat.Option;

public class chatroom extends ActionBarActivity {

    private MessageInputToolBox box;
    public ListView 			listView;
    public MessageAdapter 		adapter;
    public List<Message> messages ;
    public Serializable msg=null;
    @SuppressLint("UseSparseArrays")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chatroom);

        initMessageInputToolBox();

        initListView();
        if (getIntent()!=null&& getIntent().getExtras()!=null)
        {
            Bundle msg_info=getIntent().getExtras();
            msg_info.getString("message");
            Message message = new Message(0, 1, msg_info.getString("whofrom"), "avatar", "Jerry", "avatar", msg_info.getString("message"), false, true, new Date());
            createReplayMsg(message);
        }

    }

    /**
     * init MessageInputToolBox
     */
    @SuppressLint("ShowToast")
    public void initMessageInputToolBox(){
            box = (MessageInputToolBox) findViewById(R.id.messageInputToolBox);
        box.setOnOperationListener(new OnOperationListener() {

            @Override
            public void send(String content) {

                System.out.println("===============" + content);
                int rd = (int) (Math.random() * 99) + 1;
                Message message = new Message(0, 1, rd % 2 == 1 ? "Tom" : "helen", "avatar", "Jerry", "avatar", content, true, true, new Date());
                adapter.getData().add(message);
                listView.setSelection(listView.getBottom());

                //Just demo
                createReplayMsg(message);
            }


            @Override
            public void selectedFace(String content) {

                System.out.println("===============" + content);
                Message message = new Message(Message.MSG_TYPE_FACE, Message.MSG_STATE_SUCCESS, "Tomcat", "avatar", "Jerry", "avatar", content, true, true, new Date());
                adapter.getData().add(message);
                listView.setSelection(listView.getBottom());

                //Just demo
                createReplayMsg(message);
            }


            @Override
            public void selectedFuncation(int index) {

                System.out.println("===============" + index);

                switch (index) {
                    case 0:
                        //do some thing
                        break;
                    case 1:
                        //do some thing
                        break;

                    default:
                        break;
                }
                Toast.makeText(chatroom.this, "Do some thing here, index :" + index, Toast.LENGTH_LONG).show();

            }

        });

        ArrayList<String> faceNameList = new ArrayList<String>();
        for(int x = 1; x <= 10; x++){
            faceNameList.add("big"+x);
        }
        for(int x = 1; x <= 10; x++){
            faceNameList.add("big"+x);
        }

        ArrayList<String> faceNameList1 = new ArrayList<String>();
        for(int x = 1; x <= 7; x++){
            faceNameList1.add("cig"+x);
        }


        ArrayList<String> faceNameList2 = new ArrayList<String>();
        for(int x = 1; x <= 24; x++){
            faceNameList2.add("dig"+x);
        }

        Map<Integer, ArrayList<String>> faceData = new HashMap<>();
        faceData.put(R.drawable.em_cate_magic, faceNameList2);
        faceData.put(R.drawable.em_cate_rib, faceNameList1);
        faceData.put(R.drawable.em_cate_duck, faceNameList);
        box.setFaceData(faceData);


        List<Option> functionData = new ArrayList<Option>();
        for(int x = 0; x < 5; x++){
            Option takePhotoOption = new Option(this, "Take", R.drawable.take_photo);
            Option galleryOption = new Option(this, "Gallery", R.drawable.gallery);
            functionData.add(galleryOption);
            functionData.add(takePhotoOption);
        }
        box.setFunctionData(functionData);
    }



    private void initListView(){
        listView = (ListView) findViewById(R.id.messageListview);

        //create Data
        Message message = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar", "Hi，大家好我是你們的導遊", true, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 8));
        Message message1 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar", "Hello", false ,true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24)* 8));
        Message message2 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS, "helen", "avatar", "Jerry", "avatar", "我們要在哪集合??", false, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 7));
        Message message3 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar", "台北車站嗎!?", false, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 7));
        Message message4 = new Message(Message.MSG_TYPE_FACE, Message.MSG_STATE_SUCCESS, "Joe", "avatar", "Jerry", "avatar", "big3", false, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));
        Message message5 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS, "Joe", "avatar", "Jerry", "avatar", "可以在229公園那邊嗎?", false, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));
//        Message message6 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_FAIL, "Tom", "avatar", "Jerry", "avatar", "test send fail", true, false, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));
//        Message message7 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SENDING, "Tom", "avatar", "Jerry", "avatar", "test sending", true, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));

        messages = new ArrayList<Message>();
        messages.add(message);
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        messages.add(message4);
        messages.add(message5);
//        messages.add(message6);
//        messages.add(message7);

        adapter = new MessageAdapter(this, messages);
        System.out.println("Data+++"+adapter.getData());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                box.hide();
                return false;
            }
        });

    }

    //Re:採串接GCM，聊天室完成
    public void createReplayMsg(final Message message){

        final Message reMessage = new Message(message.getType(), 1, message.getFromUserName(), "avatar", "Jerry", "avatar",message.getType() == 0 ? message.getContent() : message.getContent(),false, true, new Date());
          new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Thread.sleep(1000 * (new Random().nextInt(3) +1));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.getData().add(reMessage);
                            adapter.notifyDataSetChanged();
                            listView.setSelection(listView.getBottom());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}

