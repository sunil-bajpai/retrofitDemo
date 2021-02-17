package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dataList: List<RetrofitDemo>
    lateinit var recyclerView: RecyclerView
//    lateinit var adapter:DataAdapter
    lateinit var myBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        myBinding= DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        myBinding.listGiveAways.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
        }
        data
    }


    private val data: Unit
        private get() {
            val giveAwaysList = GameAPI.service?.gameGiveaways
            giveAwaysList?.enqueue(object : Callback<List<RetrofitDemo?>> {
                override fun onResponse(call: Call<List<RetrofitDemo?>>, response: Response<List<RetrofitDemo?>>) {


                    Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                    dataList = response.body() as List<RetrofitDemo>
                    myBinding.listGiveAways.adapter=DataAdapter(dataList)

                }

                override fun onFailure(call: Call<List<RetrofitDemo?>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })
        }
}