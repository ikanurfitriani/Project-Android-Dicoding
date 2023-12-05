package com.ikanurfitriani.mykdrama

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drama (
    val name :String,
    val description : String,
    val photo: Int,
    val genre : String,
    val pemeran : String,
    val tayang : String,
    val jumlahepisode : String,
):Parcelable