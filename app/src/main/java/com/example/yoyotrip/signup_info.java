package com.example.yoyotrip;

/**
 * Created by Administrator on 2015/6/4.
 */
public class signup_info {
    String account,passwd,name,gender;

    public void signup_info(String acc,String pwd,String first_name,String last_name,String gen){
        account=acc;
        passwd=pwd;
        name=last_name+first_name;
        gender=gen;
    }
    public String show_info(){
        String info= "account:"+account +"passwd:"+passwd+"name:"+name+"gender:"+gender.toString();
        return info;
    }
}
