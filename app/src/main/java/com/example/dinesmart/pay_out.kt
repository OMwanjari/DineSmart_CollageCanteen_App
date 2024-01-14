package com.example.dinesmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dinesmart.databinding.ActivityPayOutBinding
import com.example.dinesmart.databinding.FragmentCongratsBottomSheetBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class pay_out : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var user: User
    private lateinit var uid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  =ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button3.setOnClickListener{
            finish()
        }
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        if( uid.isNotEmpty())
        {
            getUserData()
        }


        databaseReference = FirebaseDatabase.getInstance().getReference("Orders")
        binding.placeOrder.setOnClickListener {
            val userName = binding.ordername.text.toString()
            val address = binding.orderAddress.text.toString()
            val phone = binding.orderPhone.text.toString()
            val price = binding.orderPrice.text.toString()
            val order = "Dosa"

            val user = Order(userName,price ,address, phone,order)
            if (uid != null) {

                databaseReference.child(uid).setValue(user).addOnCompleteListener {


                    if (it.isSuccessful) {
                        val bottomSheetDialog = CongratsBottomSheet()
                        bottomSheetDialog.show(supportFragmentManager,"Test")
                    } else {
                        Toast.makeText(this@pay_out, "Failed", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }


    }
    private fun getUserData() {
        databaseReference.child(uid).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                user = snapshot.getValue(User::class.java)!!
                binding.ordername.setText(user.username)
                binding.orderAddress.setText(user.address)
                binding.orderPhone.setText(user.phone)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@pay_out, "error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}