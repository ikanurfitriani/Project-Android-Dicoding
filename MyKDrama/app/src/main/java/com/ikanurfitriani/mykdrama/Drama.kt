// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.mykdrama

// Import library yang dibutuhkan
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Anotasi untuk memberikan kemampuan parcelable secara otomatis pada sebuah kelas data
@Parcelize
// Mendeklarasikan sebuah data class dengan nama Drama
data class Drama (
    // Mendeklarasikan properti name dengan tipe data String
    val name :String,
    // Mendeklarasikan properti description dengan tipe data String
    val description : String,
    // Mendeklarasikan properti photo dengan tipe data Integer
    val photo: Int,
    // Mendeklarasikan properti genre dengan tipe data String
    val genre : String,
    // Mendeklarasikan properti pemeran dengan tipe data String
    val pemeran : String,
    // Mendeklarasikan properti tayang dengan tipe data String
    val tayang : String,
    // Mendeklarasikan properti jumlahepisode dengan tipe data String
    val jumlahepisode : String,
// Implementasi Parcelable menandakan bahwa kelas Drama dapat di-serialize dan di-deserialize untuk keperluan transfer data antar komponen di Android
):Parcelable