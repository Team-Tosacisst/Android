package com.tosacisst.nwar.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
import com.tosacisst.nwar.myapplication.R
import com.tosacisst.nwar.myapplication.binding.BlogListAdapter
import com.tosacisst.nwar.myapplication.event.SetEvent
import com.tosacisst.nwar.myapplication.module.main.UserInfo
import com.tosacisst.nwar.myapplication.module.poster.PosterInfo

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img = findViewById<ImageView>(R.id.img) // 드래그할 뷰
        img.setOnLongClickListener(SetEvent(this).SetOnLongClick())
        val layout = findViewById<ConstraintLayout>(R.id.background) // 드래그한 뷰를 이동시킬 장소.
        layout.setOnDragListener(SetEvent(this).SetOnDrag())

        val recyclerView1 = findViewById<RecyclerView>(R.id.list_first)
        val recyclerView2 = findViewById<RecyclerView>(R.id.list_second)
        val list = ArrayList<PosterInfo>()
        val URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwkE2N1K1_lRv0G31xORCzPCU-MaCQa_QTL4IN06yMypcjRr_i"
        list.add(PosterInfo("","제목1","내용","URL"))
        list.add(PosterInfo(URL,"제목2","내용","URL"))
        list.add(PosterInfo(URL,"제목3","내용","URL"))
        list.add(PosterInfo("","제목4","내용","URL"))
        list.add(PosterInfo(URL,"제목5","내용","URL"))

        setRecyclerView(list, recyclerView1)
        setRecyclerView(list, recyclerView2)
    }
    fun setRecyclerView(list : ArrayList<PosterInfo>, recyclerView : RecyclerView){

        val adapter = BlogListAdapter(this, list)
        val lm = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }
}