package com.example.junheelee.dagger2example.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.junheelee.dagger2example.R
import com.example.junheelee.dagger2example.home.data.User
import javax.inject.Inject

class Main4Activity : BaseActivity() {

    @Inject
    lateinit var user: User
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        (applicationContext as MyApplication).component.inject(this)

        tv = findViewById<TextView>(R.id.textView2) as TextView
        tv.text = "user : ${user.name}, age : ${user.age}"
        Toast.makeText(this, "user : ${user.name}, age : ${user.age}", Toast.LENGTH_SHORT).show()
    }
}
