package com.tosacisst.nwar.myapplication.binding

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tosacisst.nwar.myapplication.module.poster.PosterInfo

class SetRecyclerView <T>(val context : Context) {
    public final val HORIZONTAL = 1
    public final val VERTICAL = 2

    fun setRecyclerView(mode : Int,list : ArrayList<T>, recyclerView : RecyclerView){
        val adapter = setAdapter(list)
        val lm = setLinearLayoutManager(mode)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(false)
    }

    private fun setAdapter(list : ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>{
        val adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>
        //if(list[0] is PosterInfo){
            adapter = BlogListAdapter(context,list as ArrayList<PosterInfo>)
        //}
        return adapter
    }

    private fun setLinearLayoutManager(mode : Int) : LinearLayoutManager{
        val lm : LinearLayoutManager
        if(mode == HORIZONTAL){// 모드설정
            lm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        else{
            lm = LinearLayoutManager(context)
        }
        return lm
    }

}