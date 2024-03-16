package com.srikar.lulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srikar.lulu.databinding.ActivityTransactionsBinding

class TransactionsActivity : AppCompatActivity() {

    private lateinit var binding4: ActivityTransactionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding4 = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding4.root)

        supportActionBar!!.title = "Transactions"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}