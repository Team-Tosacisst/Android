package com.tosacisst.nwar.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.tosacisst.nwar.myapplication.R
import com.tosacisst.nwar.myapplication.event.SetEvent

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img = findViewById<ImageView>(R.id.img) // 드래그할 뷰
        img.setOnLongClickListener(SetEvent(this).SetOnLongClick())
        val layout = findViewById<LinearLayout>(R.id.background) // 드래그한 뷰를 이동시킬 장소.
        layout.setOnDragListener(SetEvent(this).SetOnDrag())
    }
}
