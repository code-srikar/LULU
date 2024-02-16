package com.srikar.lulu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.widget.Toast
import com.srikar.lulu.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding2: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val text =
            "<font color = #000000>Existing customer?</font> <font color = #4184F3> Click here</font>"
        binding2.existingUser.text = Html.fromHtml(text)

        binding2.existingUser.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding2.registerBtn.setOnClickListener {

            if (!TextUtils.isEmpty(binding2.accNumber.text) and !TextUtils.isEmpty(binding2.username.text) and !TextUtils.isEmpty(
                    binding2.password.text) and !TextUtils.isEmpty(binding2.repassword.text) and !TextUtils.isEmpty(binding2.mobileNumber.text)
            ){

                binding2.accNumber.text.clear()
                binding2.username.text.clear()
                binding2.password.text.clear()
                binding2.repassword.text.clear()
                binding2.mobileNumber.text.clear()

                Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()

            }
            else{
                Toast.makeText(this,"All fields are mandatory",Toast.LENGTH_SHORT).show()
            }

        }

    }
}