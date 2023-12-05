package com.ikanurfitriani.mykdrama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDramas : RecyclerView
    private val list = ArrayList<Drama>()

    private fun getListDrama():ArrayList<Drama>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_decsription)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataPemeran = resources.getStringArray(R.array.data_pemeran)
        val dataTayang = resources.getStringArray(R.array.data_tayang)
        val dataJumlahEpisode = resources.getStringArray(R.array.data_jumlahepisode)
        val listDrama = ArrayList<Drama>()
        for (i in dataName.indices){
            val drama = Drama(dataName[i], dataDescription[i], dataPhoto.getResourceId(i,-1),
                dataGenre[i], dataPemeran[i], dataTayang[i], dataJumlahEpisode[i])
            listDrama.add(drama)
        }
        dataPhoto.recycle()
        return listDrama
    }

    private fun showRecycleList(){
        rvDramas.layoutManager = LinearLayoutManager(this)
        val listDramaAdapter = ListDramaAdapter(list)
        rvDramas.adapter = listDramaAdapter

        listDramaAdapter.setOnItemClickCallback(object : ListDramaAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Drama) {
                showSelectedDrama(data)
            }
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDramas = findViewById(R.id.rv_drama)
        rvDramas.setHasFixedSize(true)

        list.addAll(getListDrama())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about ->{
                val aboutIntent = Intent(this@MainActivity, MoveAbout::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedDrama(drama: Drama){
        val intentDetail = Intent(this, MoveSelected::class.java)
        intentDetail.putExtra(MoveSelected.EXTRA_DRAMA, drama)
        startActivity(intentDetail)
    }

}