package com.vharya.latihan2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(
    val context: Context,
    val itemImages: ArrayList<Int>,
    val itemNames: ArrayList<String>,
) : BaseAdapter() {
    override fun getCount(): Int {
        return itemNames.size
    }

    override fun getItem(position: Int): Any {
        return itemNames[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_grid, parent, false)

            val imageView = view.findViewById<ImageView>(R.id.item_image)
            val textView = view.findViewById<TextView>(R.id.item_name)

            imageView.setImageResource(itemImages[position])
            textView.text = itemNames[position]
        }

        return view!!
    }
}