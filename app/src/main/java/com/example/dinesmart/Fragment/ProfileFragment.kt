package com.example.dinesmart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dinesmart.R
import com.example.dinesmart.User
import com.example.dinesmart.databinding.ActivitySignUpBinding
import com.example.dinesmart.databinding.FragmentHomeBinding
import com.example.dinesmart.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var user: User
    private lateinit var uid : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        if( uid.isNotEmpty())
        {
            getUserData()
        }

    }

    private fun getUserData() {
         databaseReference.child(uid).addValueEventListener(object:ValueEventListener{
             override fun onDataChange(snapshot: DataSnapshot) {
                     user = snapshot.getValue(User::class.java)!!
                     binding.txname.setText(user.username)
                     binding.txaddress.setText(user.address)
                     binding.txemail.setText(user.email)
                     binding.txphone.setText(user.phone)
             }

             override fun onCancelled(error: DatabaseError) {
                 Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
             }

         })
     }

    companion object {
    }
}