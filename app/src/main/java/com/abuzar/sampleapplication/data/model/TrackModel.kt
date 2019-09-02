package com.abuzar.sampleapplication.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ABUZAR on 9/2/2019.
 */
@Parcelize
data class TrackModel(
    @SerializedName("id") val id: Int
    , @SerializedName("title") val title: String
    , @SerializedName("link") val link: String
    , @SerializedName("track_position") val trackPosition: String
):Parcelable