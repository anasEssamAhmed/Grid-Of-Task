package com.example.gridoflist.Datasource

import com.example.gridoflist.R
import com.example.gridoflist.model.task

class ListOfTask {
    fun loadOfTask() : List<task>{
        return listOf(
            task(R.drawable.architecture , R.string.architecture , 58),
            task(R.drawable.business , R.string.business , 78),
            task(R.drawable.design , R.string.design , 423),
            task(R.drawable.film , R.string.film , 165),
            task(R.drawable.drawing , R.string.drawing , 326),
            task(R.drawable.music , R.string.music , 212),
            task(R.drawable.photography , R.string.photography , 321),
            task(R.drawable.crafts , R.string.crafts , 121),
            task(R.drawable.culinary , R.string.culinary , 118),
            task(R.drawable.fashion , R.string.fashion , 92),
            task(R.drawable.gaming , R.string.gaming , 164),
            task(R.drawable.lifestyle , R.string.lifestyle , 305),
            task(R.drawable.painting , R.string.painting , 172),
            task(R.drawable.tech , R.string.tech , 118),
        )
    }
}