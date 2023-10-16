package com.example.demoapp.favoritecity

import com.example.demoapp.R

class CityDataSource {
    companion object {
        fun loadCities(): List<City> {
            return listOf<City>(
                City(1, R.string.spain, R.drawable.ic_launcher_background),
                City(2, R.string.new_york, R.drawable.ic_launcher_foreground),
                City(3, R.string.tokyo, R.drawable.ic_launcher_background),
                City(4, R.string.switzerland, R.drawable.ic_launcher_foreground),
                City(5, R.string.singapore, R.drawable.ic_launcher_background),
                City(6, R.string.paris, R.drawable.ic_launcher_foreground),
            )
        }

    }
}