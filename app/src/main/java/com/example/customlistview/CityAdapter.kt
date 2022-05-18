package com.example.customlistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

class CityAdapter(val cityData: Array<City>): BaseAdapter() {
    override fun getCount(): Int {
        // count of the # of items present in the list
        return cityData.size
    }

    override fun getItem(position: Int): City {
        // item for the passed argument will be returned
        return cityData[position]
    }

    override fun getItemId(position: Int): Long {
        // returns a unique id corresponding to each item
        return cityData[position].name.hashCode().toLong()
    }

//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val convertView = LayoutInflater.from(parent.context).inflate(R.layout.city_item,
//            parent, false)
//
//        val cityCountry: TextView = convertView.findViewById(R.id.city_country)
//        val cityName: TextView = convertView.findViewById(R.id.city_name)
//
//        cityCountry.text = getItem(position).country
//        cityName.text = getItem(position).name
//
//        return convertView
//    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val cityView: View
        val viewHolder: ViewHolder

        if(convertView == null){
            cityView = LayoutInflater.from(parent?.context).inflate(R.layout.city_item,
                parent, false)

            viewHolder = ViewHolder()
            with(viewHolder){
                cityCountry = cityView.findViewById(R.id.city_country)
                cityName = cityView.findViewById(R.id.city_name)
                cityView.tag = this
            }
        } else{
            cityView = convertView
            viewHolder = cityView.tag as ViewHolder
        }

        with(viewHolder){
            val city = getItem(position)
            cityCountry.text = getItem(position).country
            cityName.text = getItem(position).name

            if(city.favorite){
                cityView.setBackgroundColor(ContextCompat
                    .getColor(cityView.context, R.color.colorFavorite))
            } else{
                cityView.setBackgroundColor(ContextCompat
                    .getColor(cityView.context, R.color.white))
            }
        }

        return cityView

    }

    private class ViewHolder{
        lateinit var cityCountry: TextView
        lateinit var cityName: TextView
    }

}