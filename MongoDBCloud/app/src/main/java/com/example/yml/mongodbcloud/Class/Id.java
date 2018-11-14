package com.example.yml.mongodbcloud.Class;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yml on 2018/9/20
 **/
public class Id {
    @SerializedName("$oid")

    private String oid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
