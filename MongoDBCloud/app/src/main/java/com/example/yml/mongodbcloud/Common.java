package com.example.yml.mongodbcloud;

import com.example.yml.mongodbcloud.Class.User;

/**
 * Created by yml on 2018/9/20
 **/

public class Common {

    private static String DB_NAME = "mydb"; // 数据库名
    private static String COLLECTION_NAME = "user"; //集合名
    public static String API_KEY = "1dR-Hrn82Xl46sid920h-crpPfImSscP"; //访问此数据库需要的 API_KEY

    public static String getAddressSingle(User user){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("/"+user.get_id().getOid()+"?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    public static String getAddressAPI(){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }


}
