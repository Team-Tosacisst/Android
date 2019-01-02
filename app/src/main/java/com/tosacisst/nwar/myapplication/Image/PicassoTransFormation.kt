package com.tosacisst.nwar.myapplication.Image

import android.graphics.Bitmap
import com.squareup.picasso.Transformation

class PicassoTransFormation(val isHeight : Boolean, val size : Int) {
    val resize = object : Transformation{
        override fun transform(source: Bitmap): Bitmap {
            val height : Int
            val width : Int
            val aspectRatio : Double
            if(isHeight){
                height = size
                aspectRatio = source.width.toDouble() / source.height.toDouble()
                width = (height*aspectRatio).toInt()
            } else {
                width = size
                aspectRatio = source.height.toDouble()/source.width.toDouble()
                height = (width*aspectRatio).toInt()
            }
            val result = Bitmap.createScaledBitmap(source,width,height,false)
            if(result!=source) source.recycle()
            return result
        }

        override fun key(): String {
            return "resizeTransformation#" + System.currentTimeMillis()
        }
    }
}