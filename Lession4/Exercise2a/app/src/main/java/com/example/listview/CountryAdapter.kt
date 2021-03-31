package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.udn.vku.nhhai.exercise2_uedn5.CountryInfo

class CountryAdapter (val context:Context,
                      val countrySource: List<CountryInfo>): BaseAdapter(){
    val layoutInflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Version 1 - Basic
        /*
        val rowView = layoutInflater.inflate(R.layout.row_item_country,
                                parent,false)
        rowView.findViewById<TextView>(R.id.nameTV).text = countrySource[position].name
        rowView.findViewById<TextView>(R.id.populationTV).text =
            countrySource[position].population.toString() + " millions"
        rowView.findViewById<ImageView>(R.id.flagIV).setImageResource(
            countrySource[position].flag)
        return rowView
        */
        //Version 2 - Optimized Way
        val rowView: View
        val viewHolder: ViewHolder
        if(convertView==null){
            rowView = layoutInflater.inflate(R.layout.row_item_country,
                parent,false)
            viewHolder = ViewHolder(rowView)
            rowView.tag = viewHolder
        }
        else{
            rowView = convertView
            viewHolder = rowView.tag as ViewHolder
        }
        viewHolder.nameTV.text = countrySource[position].name
        viewHolder.populationTV.text = countrySource[position].population.toString() + " millions"
        viewHolder.flagIV.setImageResource(countrySource[position].flag)
        return rowView
    }

    override fun getItem(position: Int): Any {
        return countrySource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return countrySource.count()
    }
    inner class ViewHolder(view:View){
        val flagIV = view.findViewById<ImageView>(R.id.flagIV)
        val nameTV = view.findViewById<TextView>(R.id.nameTV)
        val populationTV = view.findViewById<TextView>(R.id.populationTV)
    }
}