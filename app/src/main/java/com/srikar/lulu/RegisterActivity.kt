package com.srikar.lulu

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.srikar.lulu.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding2: ActivityRegisterBinding
    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        user = User()

        val text =
            "<font color = #000000>Existing customer?</font> <font color = #4184F3> Click here</font>"
        binding2.existingUser.text = Html.fromHtml(text)

        binding2.existingUser.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding2.registerBtn.setOnClickListener {

            if (!TextUtils.isEmpty(binding2.accNumber.text) and !TextUtils.isEmpty(binding2.mail.text) and !TextUtils.isEmpty(
                    binding2.password.text
                ) and !TextUtils.isEmpty(binding2.repassword.text) and !TextUtils.isEmpty(binding2.mobileNumber.text)
            ) {

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding2.mail.editableText.toString(),
                    binding2.password.editableText.toString()
                )
                    .addOnSuccessListener {

                        user.uname = binding2.username.text?.toString()
                        user.accno = binding2.accNumber.text?.toString()
                        user.email = binding2.mail.text?.toString()
                        user.pass = binding2.password.text?.toString()
                        user.repass = binding2.repassword.text?.toString()
                        user.mobile = binding2.mobileNumber.text?.toString()

                        Firebase.firestore.collection("User").document(FirebaseAuth.getInstance().currentUser!!.uid).set(user)

                        FirebaseAuth.getInstance().currentUser!!.sendEmailVerification()
                            .addOnSuccessListener {

                                binding2.accNumber.text.clear()
                                binding2.mail.text.clear()
                                binding2.password.text.clear()
                                binding2.repassword.text.clear()
                                binding2.mobileNumber.text.clear()

                                Toast.makeText(this, "Verification mail has been sent", Toast.LENGTH_LONG).show()
                                startActivity(Intent(this, LoginActivity::class.java))
                                finish()

                            }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                    }

            } else {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            }

        }

    }
}