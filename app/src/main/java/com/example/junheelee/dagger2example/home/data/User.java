package com.example.junheelee.dagger2example.home.data;

import javax.inject.Inject;

/**
 * Created by junhee.lee on 2018. 2. 23..
 */

public class User {

    private String name;
    private int age = 0;

    @Inject
    public User(){

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
