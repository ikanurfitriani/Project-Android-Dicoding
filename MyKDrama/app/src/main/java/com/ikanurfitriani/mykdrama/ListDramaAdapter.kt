// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.mykdrama

// Import library, kelas atau file yang dibutuhkan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikanurfitriani.mykdrama.databinding.ItemRowDramaBinding

// Mendeklarasikan kelas ListDramaAdapter yang merupakan adaptor untuk RecyclerView
class ListDramaAdapter(private val listDrama : ArrayList<Drama>) : RecyclerView.Adapter<ListDramaAdapter.ListViewHolder>() {
    // Properti untuk menangani callback ketika suatu item pada RecyclerView di-klik
    private lateinit var onItemClickCallback : OnItemClickCallback

    // Mendeklarasikan sebuah antarmuka untuk menangani callback ketika suatu item pada RecyclerView di-klik
    interface OnItemClickCallback {
        fun onItemClicked(data : Drama)
    }

    // Mendeklarasikan fungsi setOnItemClickCallback yang digunakan untuk mengatur nilai properti onItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    // Mendeklarasikan kelas ListViewHolder sebagai holder untuk setiap item dalam RecyclerView
    class ListViewHolder(var binding: ItemRowDramaBinding) : RecyclerView.ViewHolder(binding.root)

    // Override dari fungsi onCreateViewHolder yang digunakan untuk membuat instance dari ListViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDramaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    // Override dari fungsi getItemCount yang mengembalikan jumlah item dalam listDrama
    override fun getItemCount(): Int = listDrama.size

    // Override dari fungsi onBindViewHolder yang digunakan untuk mengikat data pada posisi tertentu ke dalam ListViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        // Mendeklarasikan tiga variabel dan menginisialisasinya dengan nilai dari objek Drama pada posisi tertentu
        val (name, description, photo) = listDrama[position]
        // Menetapkan gambar dari objek Drama ke dalam ImageView pada layout item
        holder.binding.imgItemPhoto.setImageResource(photo)
        // Menetapkan teks nama dari objek Drama ke dalam TextView pada layout item
        holder.binding.itemName.text = name
        // Menetapkan teks deskripsi dari objek Drama ke dalam TextView pada layout item
        holder.binding.itemDescription.text = description
        // Menetapkan onClickListener pada itemView yang akan memanggil metode onItemClicked pada objek onItemClickCallback ketika item diklik
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listDrama[holder.adapterPosition])
        }
    }
}