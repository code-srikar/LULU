package com.srikar.lulu

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.srikar.lulu.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding1: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        val text =
            "<font color = #000000>Create a new Account?</font> <font color = #4184F3>Click here</font>"

        binding1.newUser.text = Html.fromHtml(text)

        binding1.newUser.setOnClickListener {

            startActivity(Intent(this, RegisterActivity::class.java))
            finish()

        }

        binding1.loginBtn.setOnClickListener {

            if (!TextUtils.isEmpty(binding1.mail.text) and !TextUtils.isEmpty(binding1.password.text)) {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding1.mail.editableText.toString(),
                    binding1.password.editableText.toString()
                )
                    .addOnSuccessListener {
                        Toast.makeText(this, "Logged In Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, DashboardActivity::class.java))
                        finish()
                        binding1.mail.text.clear()
                        binding1.password.text.clear()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                    }

            } else {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            }

        }

    }
}