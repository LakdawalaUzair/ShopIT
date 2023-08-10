package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shopit.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.nextbtn.setOnClickListener{
            signupUser()
            startActivity(Intent(this,Login::class.java))
        }
        binding.login.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }

    private fun signupUser(){
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (name.isBlank() || email.isBlank() || password.isBlank()) {
            Toast.makeText(this,"Enter an email or password", Toast.LENGTH_SHORT).show()
            return
        }

        if(email != password) {
            Toast.makeText(this,"Incorrect password", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Error creating user",Toast.LENGTH_SHORT).show()
                }
            }
    }
}