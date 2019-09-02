package com.abuzar.sampleapplication.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ABUZAR on 9/2/2019.
 */

@Parcelize
data class AlbumModel(
    @SerializedName("id") val id: Int
    , @SerializedName("title") val title: String
    , @SerializedName("link") val link: String
    , @SerializedName("cover") val cover: String
    , @SerializedName("cover_small") val coverSmall: String
    , @SerializedName("cover_medium") val coverMedium: String
    , @SerializedName("cover_big") val coverBig: String
    , @SerializedName("cover_xl") val coverXl: String
) : Parcelable