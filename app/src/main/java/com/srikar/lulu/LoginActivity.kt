package com.srikar.lulu

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.srikar.lulu.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding1: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding1.root)

        val text = "<font color = #000000>Create a new Account?</font> <font color = #4184F3>Click here</font>"

        binding1.newUser.text = Html.fromHtml(text)

        binding1.newUser.setOnClickListener {

            startActivity(Intent(this,RegisterActivity::class.java))
            finish()

        }

        binding1.loginBtn.setOnClickListener {

            if(!TextUtils.isEmpty(binding1.username.text) and !TextUtils.isEmpty(binding1.password.text)){

                binding1.username.text.clear()
                binding1.password.text.clear()

                Toast.makeText(this,"Logged In Successfully",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,DashboardActivity::class.java))
                finish()

            }
            else{
                Toast.makeText(this,"All fields are mandatory",Toast.LENGTH_SHORT).show()
            }

        }

    }
}