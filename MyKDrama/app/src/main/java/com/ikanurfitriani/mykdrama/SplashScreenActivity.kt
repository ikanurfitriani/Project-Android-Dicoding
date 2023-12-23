// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.mykdrama

// Import library, kelas atau file yang dibutuhkan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

// Mendeklarasikan kelas SplashScreenActivity dan mewarisi sifat dari kelas AppCompatActivity
class SplashScreenActivity : AppCompatActivity() {
    // Membuat konstanta SPLASH_TIME_OUT dengan nilai 3000 milidetik (3 detik)
    // Konstanta ini menentukan berapa lama splash screen akan ditampilkan sebelum berpindah ke aktivitas berikutnya
    private val SPLASH_TIME_OUT:Long = 3000
    // Meng-override metode onCreate untuk melakukan inisialisasi saat aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        // Memanggil metode onCreate dari kelas induk (AppCompatActivity) untuk melakukan inisialisasi standar
        super.onCreate(savedInstanceState)
        // Mengatur tata letak tampilan yang akan digunakan oleh aktivitas ini
        setContentView(R.layout.activity_splash_screen)

        // Membuat objek Handler dan menggunakan metode postDelayed untuk menunda eksekusi kode di dalam blok hingga waktu yang ditentukan (SPLASH_TIME_OUT)
        Handler().postDelayed({
            // Membuat dan memulai intent untuk membuka MainActivity setelah splash screen selesai
            startActivity(Intent(this,MainActivity::class.java))
            // Menyelesaikan aktivitas splash screen sehingga pengguna tidak dapat kembali ke halaman splash screen setelah pindah ke MainActivity
            finish()
        }, SPLASH_TIME_OUT)

    }
}