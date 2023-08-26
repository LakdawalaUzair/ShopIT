package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        }
        binding.login.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }

    private fun signupUser() {
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if(name.isEmpty()) {
            binding.etName.error = "Field can't be blank."
        }else if (email.isEmpty() ){
            binding.etEmail.error = "Field can't be blank."
        }else if(password.isEmpty()) {
            binding.etPassword.error = "Field can't be blank."
        }else{
            signUp(email, password, name)
        }
    }

    private fun signUp(email: String, password: String, name: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                UserModel(name, email, password)
                startActivity(Intent(this@Registration, Login::class.java))
                Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show()
            }

            .addOnFailureListener { it ->
                Log.d("Registration", it.message.toString())
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}