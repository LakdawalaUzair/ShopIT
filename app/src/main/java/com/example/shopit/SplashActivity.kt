package com.example.shopit

import android.content.Intent
import android.net.Uri
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.shopit.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    var mediaControls: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.videoViewSplash.start()
        supportActionBar!!.hide()



        if (mediaControls == null) {
            mediaControls = MediaController(this@SplashActivity)
            mediaControls!!.setAnchorView(binding.videoViewSplash)
            mediaControls!!.setAnchorView(binding.backVideoViewSplash)
        }

        // set the media controller for video view
        binding.videoViewSplash!!.setMediaController(mediaControls)
        binding.videoViewSplash!!.setVideoURI(
            Uri.parse("android.resource://"
                + packageName + "/" + R.raw.splash))
        binding.backVideoViewSplash!!.setVideoURI(
            Uri.parse("android.resource://"
                + packageName + "/" + R.raw.aaa))

        binding.videoViewSplash!!.requestFocus()
        binding.backVideoViewSplash!!.requestFocus()

        binding.videoViewSplash!!.start()
        binding.backVideoViewSplash!!.start()



        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
        },2500)
    }
}