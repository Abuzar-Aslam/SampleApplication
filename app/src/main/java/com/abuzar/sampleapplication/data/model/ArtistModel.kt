package com.abuzar.sampleapplication.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ABUZAR on 9/1/2019.
 */

@Parcelize
data class ArtistModel(
    @SerializedName("id") val id: Int
    , @SerializedName("name") val name: String
    , @SerializedName("link") val link: String
    , @SerializedName("picture") val picture: String
    , @SerializedName("picture_small") val pictureSmall: String
    , @SerializedName("picture_medium") val pictureMedium: String
    , @SerializedName("picture_big") val pictureBig: String
    , @SerializedName("nb_album") val nbAlbum: String
    , @SerializedName("nb_fan") val nbFan: String
    , @SerializedName("radio") val radio: String
):Parcelable