// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.mykdrama

// Import library, kelas atau file yang dibutuhkan
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Mendeklarasikan kelas MoveAbout dan mewarisi sifat dari kelas AppCompatActivity
class MoveAbout : AppCompatActivity() {
    // Meng-override metode onCreate yang dipanggil ketika aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        // Memanggil metode onCreate pada kelas induk (AppCompatActivity) untuk melakukan inisialisasi yang diperlukan oleh kelas tersebut
        super.onCreate(savedInstanceState)
        // Menetapkan layout yang akan digunakan oleh aktivitas ini
        setContentView(R.layout.activity_move_about)

        // Menampilkan tombol "Up" (panah kembali) di action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Mengatur judul action bar dengan menggunakan string dari sumber daya string yang diidentifikasi oleh ID moveAbout
        supportActionBar?.apply {
            title = getString(R.string.moveAbout)
        }
    }
}