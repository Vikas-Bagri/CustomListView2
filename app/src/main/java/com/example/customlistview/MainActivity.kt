package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val cityData = fillCityData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val cities = findViewById<ListView>(R.id.cities)
        val cityAdapter = CityAdapter(cityData)

        cities.adapter = cityAdapter

        cities.setOnItemClickListener{parent, view, position, id ->

            val city: City? = cityAdapter.getItem(position)
            city?.let{
                city.favorite = !city.favorite
                cityAdapter.notifyDataSetChanged()
            }

        }

    }

    private fun fillCityData(): Array<City>{

        val cityData = arrayOf(City("Argentina", "Bueno Aires"),
                                City("Australia", "Canberra"),
                                City("Austria", "Vienna"),
                                City("Bangladesh", "Dhaka"),
                                City("Belgium", "Brussels"),
                                City("Bhutan", "Thimpu"),
                                City("Bolivia", "La Paz"),
                                City("Brazil", "Brasilia"),
                                City("Myanmar", "Rangoon"),
                                City("Cambodia", "Phnom Penh"),
                                City("Canada", "Ottawa"),
                                City("Denmark", "Copenhagen"),
                                City("Egypt", "Cairo"),
                                City("France", "Paris"),
                                City("Germany", "Berlin"),
                                City("Hungary", "Budapest"),
                                City("India", "New Delhi"),
                                City("Japan", "Tokyo"),
                                City("Kuwait", "Kuwait City"),
                                City("Luxembourg", "Luxembourg"),
                                City("Maldives", "Male"),
                                City("Nepal", "Kathmandu"),
                                City("oman", "Muscat"),
                                City("Pakistan", "Islamabad"),
                                City("Qatar", "Doha"),
                                City("Russia", "Moscow"),
                                City("Saudi Arabia", "Riyadh"),
                                City("Turkey", "Ankara"),
                                City("Uganda", "Kampala"),
                                City("Vietnam", "Hanoi"),
                                City("Wales", "Cardiff"),
                                City("Yemen", "Sana'a"),
                                City("Zimbabwe", "Harare"))

        return cityData

    }

}