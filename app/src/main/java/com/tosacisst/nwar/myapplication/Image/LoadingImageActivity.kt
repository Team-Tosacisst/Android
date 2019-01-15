package com.tosacisst.nwar.myapplication.Image

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.tosacisst.nwar.myapplication.R

class LoadingImageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startLoading()
    }

    private fun startLoading() {
        val handler = Handler()
        handler.postDelayed({
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 2000)
    }
}