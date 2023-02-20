package com.github.pats1337.movieapp_tad

import androidx.annotation.StringRes
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    @StringRes val title: Int,
    val cover: Int,
    val releaseDate: Int,
    val rating: Int,
    @StringRes val description: Int
) : Parcelable {

}
