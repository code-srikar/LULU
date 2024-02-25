package com.srikar.lulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.srikar.lulu.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding3: ActivityDashboardBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding3.root)

        user = User()

        binding3.name.text = Firebase.firestore.collection("User")
            .document(FirebaseAuth.getInstance().currentUser!!.uid).get()
            .addOnSuccessListener {
                binding3.name.text = it.get("uname").toString()
            }.toString()
    }
}