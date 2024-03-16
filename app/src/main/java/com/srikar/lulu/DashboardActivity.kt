package com.srikar.lulu

import android.content.Intent
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
            .document(FirebaseAuth.getInstance().currentUser!!.email.toString()).get()
            .addOnSuccessListener {
                binding3.name.text = it.get("uname").toString()
            }.toString()

        binding3.transactionsCard.setOnClickListener {

            startActivity(Intent(this,TransactionsActivity::class.java))

        }

        binding3.investCard.setOnClickListener {

            startActivity(Intent(this,InvestmentActivity::class.java))

        }

        binding3.accountCard.setOnClickListener {

            startActivity(Intent(this,AccountsActivity::class.java))

        }

        binding3.serviceCard.setOnClickListener {

            startActivity(Intent(this,ServiceActivity::class.java))

        }
    }
}