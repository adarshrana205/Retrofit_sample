package com.rana.adarsh.retrofit_sample;

import com.google.gson.annotations.SerializedName;

public class Post {

    private  int id,age;
    private String name,employee_id;
    @SerializedName("ranking")
    private float rank;

    public int getId() {
        return id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public float getRank() {
        return rank;
    }
//    public int getUserId() {
//        return userId;
//    }
//
//    public String getText() {
//        return text;
//    }

//    public String getTitle() {
//        return title;
//    }


}

