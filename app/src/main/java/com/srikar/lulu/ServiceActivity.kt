package com.srikar.lulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srikar.lulu.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    private lateinit var binding7: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding7 = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding7.root)

        supportActionBar!!.title = "Service"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}