package com.ikanurfitriani.mykdrama

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ikanurfitriani.mykdrama.databinding.ActivityMoveSelectedBinding

class MoveSelected : AppCompatActivity() {
    private lateinit var binding: ActivityMoveSelectedBinding
    private lateinit var button : Button

    companion object {
        const val EXTRA_DRAMA = "extra_drama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveSelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drama = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_DRAMA, Drama::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_DRAMA)
        }
        if (drama != null) {
            binding.imgItemPhotoSelected.setImageResource(drama.photo)
            binding.itemName.text = drama.name
            binding.itemDescription.text = drama.description
            binding.itemGenre.text = drama.genre
            binding.itemPemeran.text = drama.pemeran
            binding.itemTayang.text = drama.tayang
            binding.itemJumlah.text = drama.jumlahepisode
            button = findViewById(R.id.button_sharee)
            button.setOnClickListener{
                val share = drama.description
                val intentbutton = Intent(Intent.ACTION_SEND)
                intentbutton.type = "text/plan"
                intentbutton.putExtra("Share this", share)
                val choose = Intent.createChooser(intentbutton, "Share using....")
                startActivity(choose)
            }
            supportActionBar?.apply {
                title = getString(R.string.selected)
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}