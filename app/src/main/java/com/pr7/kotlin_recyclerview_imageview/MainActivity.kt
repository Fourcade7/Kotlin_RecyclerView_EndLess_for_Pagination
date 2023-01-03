package com.pr7.kotlin_recyclerview_imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var pastVisibleItem=0
    var visibleItemCount=0
    var totalItemCount=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerview1)

        val names= arrayOf(
            "Cat",
            "Masha",
            "Meow",
            "Cat 2",
            "Cats of Duty",
            "Cat",
            "Masha",
            "Meow",
            "Cat 2",
            "Cats of Duty",
        )
        val images= arrayOf(
            R.drawable.cat1,
            R.drawable.cat2,
            R.drawable.cat3,
            R.drawable.cat4,
            R.drawable.cat5,
            R.drawable.cat1,
            R.drawable.cat2,
            R.drawable.cat3,
            R.drawable.cat4,
            R.drawable.cat5,
        )

        val catAdapter=CatAdapter(this@MainActivity,names,images)

        val layoutManager=LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=catAdapter
        recyclerView.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                visibleItemCount=layoutManager.childCount
                totalItemCount=layoutManager.itemCount
                pastVisibleItem=layoutManager.findLastCompletelyVisibleItemPosition()


                if (dy>0){
                    //Toast.makeText(this@MainActivity,"dy:$dy\n$visibleItemCount",Toast.LENGTH_SHORT).show()
                    title="$visibleItemCount\n$totalItemCount\n$pastVisibleItem"
                    if (pastVisibleItem==totalItemCount-1){
                        title="Eng Game"
                    }

                }

            }
        })

    }
}