// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.mykdrama

// Import library, kelas atau file yang dibutuhkan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Mendeklarasikan kelas MainActivity yang merupakan aktivitas utama dalam aplikasi dan mewarisi sifat dari kelas AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Mendeklarasikan properti rvDramas yang merupakan instance dari RecyclerView untuk menampilkan daftar drama
    private lateinit var rvDramas : RecyclerView
    // Mendeklarasikan properti list yang merupakan ArrayList yang akan digunakan untuk menyimpan objek-objek Drama
    private val list = ArrayList<Drama>()

    // Mendeklarasikan fungsi getListDrama yang mengembalikan ArrayList berisi objek-objek Drama
    private fun getListDrama():ArrayList<Drama>{
        // Menggunakan sumber daya string array dan array of typed resources untuk menginisialisasi objek Drama dari data yang ada
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_decsription)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataPemeran = resources.getStringArray(R.array.data_pemeran)
        val dataTayang = resources.getStringArray(R.array.data_tayang)
        val dataJumlahEpisode = resources.getStringArray(R.array.data_jumlahepisode)
        // Mendeklarasikan variabel listDrama sebagai ArrayList yang akan menyimpan objek-objek Drama
        val listDrama = ArrayList<Drama>()
        // Melakukan iterasi sebanyak indeks yang dimiliki oleh array dataName
        for (i in dataName.indices){
            // Membuat objek Drama dengan menggunakan nilai dari array yang sesuai dengan indeks saat ini dalam iterasi
            val drama = Drama(dataName[i], dataDescription[i], dataPhoto.getResourceId(i,-1),
                dataGenre[i], dataPemeran[i], dataTayang[i], dataJumlahEpisode[i])
            // Menambahkan objek Drama yang telah dibuat ke dalam ArrayList listDrama
            listDrama.add(drama)
        }
        // Memanggil metode recycle() pada array dataPhoto untuk membebaskan sumber daya yang digunakan oleh array tersebut setelah selesai digunakan
        dataPhoto.recycle()
        // Mengembalikan ArrayList listDrama yang berisi objek-objek Drama yang telah dibuat
        return listDrama
    }

    // Mendeklarasikan fungsi showRecycleList yang menyiapkan dan menampilkan RecyclerView dengan menggunakan ListDramaAdapter sebagai adaptor
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


    // Override dari fungsi onCreate yang dipanggil ketika aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Menginisialisasi properti rvDramas dengan merujuk ke RecyclerView dari layout dengan id rv_drama
        rvDramas = findViewById(R.id.rv_drama)
        // Mengatur bahwa ukuran RecyclerView tidak akan berubah saat diisi dengan data, sehingga meningkatkan kinerja
        rvDramas.setHasFixedSize(true)

        // Menambahkan semua objek Drama dari fungsi getListDrama ke dalam properti list
        list.addAll(getListDrama())
        // Memanggil fungsi showRecycleList untuk menampilkan daftar drama dalam RecyclerView
        showRecycleList()
    }

    // Override dari fungsi onCreateOptionsMenu yang digunakan untuk membuat menu pada ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Meng-inflate (membuat) menu dari resource XML dengan id menu_main
        menuInflater.inflate(R.menu.menu_main, menu)
        // Mengembalikan nilai yang diperoleh dari pemanggilan superclass
        return super.onCreateOptionsMenu(menu)
    }

    // Override dari fungsi onOptionsItemSelected yang dipanggil saat suatu item menu dipilih
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Struktur percabangan when yang menangani aksi berdasarkan ID item menu yang dipilih
        when (item.itemId){
            // Jika yang dipilih adalah item dengan ID R.id.action_about, maka akan dibuka aktivitas MoveAbout
            R.id.action_about ->{
                val aboutIntent = Intent(this@MainActivity, MoveAbout::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Mendeklarasikan fungsi showSelectedDrama yang menginisialisasi intent untuk membuka aktivitas MoveSelected dengan mengirimkan objek Drama sebagai data tambahan
    private fun showSelectedDrama(drama: Drama){
        val intentDetail = Intent(this, MoveSelected::class.java)
        intentDetail.putExtra(MoveSelected.EXTRA_DRAMA, drama)
        // Memulai aktivitas MoveSelected dengan intent yang telah disiapkan
        startActivity(intentDetail)
    }

}