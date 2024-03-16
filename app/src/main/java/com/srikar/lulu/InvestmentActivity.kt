package com.srikar.lulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srikar.lulu.databinding.ActivityInvestmentBinding

class InvestmentActivity : AppCompatActivity() {

    private lateinit var binding6: ActivityInvestmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding6 = ActivityInvestmentBinding.inflate(layoutInflater)
        setContentView(binding6.root)

        supportActionBar!!.title = "Investment"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}