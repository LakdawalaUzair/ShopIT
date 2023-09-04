package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shopit.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        checkUserLoginOrNot()

        binding.logbtn.setOnClickListener{
            login()
        }

        binding.signup.setOnClickListener{
            startActivity(Intent(this,Registration::class.java))
        }


        if(firebaseAuth.currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))

        }
    }

    private fun checkUserLoginOrNot() {
        if(firebaseAuth.currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
    private fun login(){
        val email = binding.logemail.text.toString()
        val password = binding.logpassword.text.toString()

        if (email.isEmpty() ){
            binding.logemail.error = "Field can't be blank."
        }else if(password.isEmpty()){
            binding.logpassword.error = "Field can't be blank."
        }else {
            signIn(email, password)
        }
    }


    private fun signIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                //Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
            }
    }
}