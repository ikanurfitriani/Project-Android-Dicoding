// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.mykdrama

// Import library, kelas atau file yang dibutuhkan
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ikanurfitriani.mykdrama.databinding.ActivityMoveSelectedBinding

// Mendeklarasikan kelas MoveSelected dan mewarisi sifat dari kelas AppCompatActivity
class MoveSelected : AppCompatActivity() {
    // Mendeklarasikan properti binding yang bertipe ActivityMoveSelectedBinding
    private lateinit var binding: ActivityMoveSelectedBinding
    // Mendeklarasikan properti button yang bertipe Button untuk tombol "Share"
    private lateinit var button : Button

    // Mendeklarasikan blok objek pendamping (companion object) yang berisi konstanta EXTRA_DRAMA
    companion object {
        const val EXTRA_DRAMA = "extra_drama"
    }

    // Meng-override metode onCreate yang dipanggil ketika aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menginisialisasi binding dengan menggunakan metode inflate dari ActivityMoveSelectedBinding
        binding = ActivityMoveSelectedBinding.inflate(layoutInflater)
        // Menetapkan tampilan utama aktivitas ke tampilan yang diperoleh dari binding.root
        setContentView(binding.root)
        // Mendeklarasikan variabel drama yang diinisialisasi dengan objek Drama yang dikirimkan dari aktivitas sebelumnya melalui ekstra
        val drama = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_DRAMA, Drama::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_DRAMA)
        }
        // Memeriksa apakah objek drama tidak null sebelum mengakses propertinya
        if (drama != null) {
            // Mengatur gambar drama pada tampilan gambar
            binding.imgItemPhotoSelected.setImageResource(drama.photo)
            // Mengatur nama drama pada tampilan teks
            binding.itemName.text = drama.name
            // Mengatur deskripsi drama pada tampilan teks
            binding.itemDescription.text = drama.description
            // Mengatur genre drama pada tampilan teks
            binding.itemGenre.text = drama.genre
            // Mengatur pemeran drama pada tampilan teks
            binding.itemPemeran.text = drama.pemeran
            // Mengatur tanggal tayang drama pada tampilan teks
            binding.itemTayang.text = drama.tayang
            // Mengatur jumlah episode drama pada tampilan teks
            binding.itemJumlah.text = drama.jumlahepisode
            // Menginisialisasi tombol "Share" dari layout menggunakan ID button_sharee
            button = findViewById(R.id.button_sharee)
            // Menetapkan pendengar klik untuk tombol "Share"
            button.setOnClickListener{
                // Membuat variabel share yang berisi deskripsi dari objek drama
                val share = drama.description
                // Membuat objek Intent untuk mengirimkan data
                val intentbutton = Intent(Intent.ACTION_SEND)
                // Menetapkan tipe konten yang akan dibagikan, dalam hal ini adalah teks (text/plain)
                intentbutton.type = "text/plan"
                // Menambahkan teks yang akan dibagikan ke dalam objek Intent
                intentbutton.putExtra("Share this", share)
                // Membuat objek Intent yang disertakan dengan dialog pemilih
                val choose = Intent.createChooser(intentbutton, "Share using....")
                // Memulai aktivitas dengan intent yang telah dibuat
                startActivity(choose)
            }
            // Mengatur judul action bar menjadi "Selected"
            supportActionBar?.apply {
                title = getString(R.string.selected)
            }
        }
        // Menampilkan tombol "Up" (panah kembali) di action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}