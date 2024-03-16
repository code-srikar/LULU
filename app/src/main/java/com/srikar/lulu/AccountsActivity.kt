package com.srikar.lulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srikar.lulu.databinding.ActivityAccountsBinding

class AccountsActivity : AppCompatActivity() {

    private lateinit var binding5: ActivityAccountsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding5 = ActivityAccountsBinding.inflate(layoutInflater)
        setContentView(binding5.root)

        supportActionBar!!.title = "Accounts"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}