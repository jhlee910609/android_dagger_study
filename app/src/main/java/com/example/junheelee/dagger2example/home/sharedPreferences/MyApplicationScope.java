package com.example.junheelee.dagger2example.home.sharedPreferences;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.Policy;

import javax.inject.Scope;

/**
 * Created by junhee.lee on 2018. 2. 21..
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MyApplicationScope {

}