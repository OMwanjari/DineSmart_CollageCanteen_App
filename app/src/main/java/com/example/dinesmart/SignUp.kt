package com.example.dinesmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dinesmart.databinding.ActivityDetailsBinding
import com.example.dinesmart.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var databaseReference:DatabaseReference

    private lateinit var edtName : EditText
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignUp : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        val uid = mAuth.currentUser?.uid
        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_signup)

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.btnSignup.setOnClickListener {
            val userName = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val address = binding.edtAddress.text.toString()
            val phone = binding.edtPhone.text.toString()
            val password = edtPassword.text.toString()

            val user = User(userName, email, address, phone)
            if (uid != null) {

                databaseReference.child(uid).setValue(user).addOnCompleteListener {


                    if (it.isSuccessful) {
                        signUp( email , password)
                        Toast.makeText(this@SignUp, "Data Saved", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this@SignUp, "Failed", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }


        btnLogin.setOnClickListener{
            val intent = Intent(this , LogIn::class.java)
            startActivity(intent)
        }

    }

    private fun signUp( email : String , password : String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent( this@SignUp , MainActivity::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(this@SignUp, "Some error occurred",Toast.LENGTH_SHORT).show()

                }
            }
    }
}