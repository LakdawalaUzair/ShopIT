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

        //Initialize the UI
        initUI()
    }
    private fun initUI() {
        binding.logbtn.setOnClickListener{
            login()
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.signup.setOnClickListener{
            startActivity(Intent(this,Registration::class.java))
        }
    }
    private fun login(){
        val email = binding.logemail.text.toString()
        val password = binding.logpassword.text.toString()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this,"Enter an email or password",Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful){
                    //code
                }
                else{
                    Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT).show()
                }
            }
    }
}