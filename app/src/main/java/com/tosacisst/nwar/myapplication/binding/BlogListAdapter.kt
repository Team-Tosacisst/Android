package com.tosacisst.nwar.myapplication.binding

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tosacisst.nwar.myapplication.Image.PicassoTransFormation
import com.tosacisst.nwar.myapplication.R
import com.tosacisst.nwar.myapplication.module.poster.PosterInfo

class BlogListAdapter(val context : Context, val item : ArrayList<PosterInfo> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_horizon_item,p0,false))
        return view
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if(p0 is ViewHolder){
            if(item[p1].picture!=null&&item[p1].picture!=""){
                Log.e("imageURL",item[p1].picture)
                val picasso = PicassoTransFormation(true,50)
                Picasso.with(context).load(item[p1].picture).transform(picasso.resize).into(p0.picture)
            }
            p0.bind(item[p1])
        }
    }

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val title = v?.findViewById<TextView>(R.id.blog_title)
        val picture = v?.findViewById<ImageView>(R.id.blog_picture)
        val content = v?.findViewById<TextView>(R.id.blog_content)
        fun bind(info : PosterInfo){
            title.text = info.title
            content.text = info.content
        }
    }
}