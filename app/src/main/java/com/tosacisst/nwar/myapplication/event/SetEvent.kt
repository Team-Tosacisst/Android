package com.tosacisst.nwar.myapplication.event

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast

class SetEvent(val context : Context){
    inner class SetOnLongClick : View.OnLongClickListener{
        override fun onLongClick(v: View?): Boolean {
            val item = ClipData.Item(v?.tag as CharSequence?)
            var types : Array<String> = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(v?.tag.toString(),types,item)
            val shadowBuilder = View.DragShadowBuilder(v)
            v?.startDragAndDrop(data,shadowBuilder,v,0)
            v?.visibility = View.VISIBLE
            return true
        }
    }

    inner class SetOnDrag : View.OnDragListener{
        override fun onDrag(v: View?, event: DragEvent?): Boolean {
            var x : Float?
            var y : Float?
            x = event?.x
            y = event?.y
            when (event?.action){
                DragEvent.ACTION_DRAG_STARTED -> Toast.makeText(context,"드래그", Toast.LENGTH_SHORT).show()
                DragEvent.ACTION_DROP -> {
                    val view : View = event.localState as View
                    val viewGroup : ViewGroup = view.parent as ViewGroup
                    viewGroup.removeView(view)
                    val containView = v as ConstraintLayout
                    view.animate().translationX(event?.x-view.width/2)
                    view.animate().translationY(event?.y-view.height/2)
                    containView.addView(view)
                    view.visibility = View.VISIBLE
                }
            }
            Log.e("Drag","Point X: ${x.toString()} PointY: ${y.toString()}")
            return true
        }
    }
}