package com.abuzar.sampleapplication.ui.track

import android.content.Context
import androidx.lifecycle.ViewModel
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.abuzar.sampleapplication.data.model.TrackModel
import com.abuzar.sampleapplication.interactors.BaseUseCaseSubscriber
import com.abuzar.sampleapplication.interactors.TrackUseCase

/**
 * Created by ABUZAR on 9/2/2019.
 */

class TrackViewModel(
    private val context: Context,
    private val deezerApi: DeezerApi,
    private val trackNavigator: TrackNavigator,
    private val albumModel: AlbumModel,
    private val artistModel: ArtistModel
) : ViewModel() {

    fun getAlbumModel(): AlbumModel {
        return albumModel

    }

    fun getArtistModel(): ArtistModel {

        return artistModel
    }

    fun fetchTrackList() {

        TrackUseCase(deezerApi).execute(albumModel.id, TrackSubscriber(context))

    }


    internal inner class TrackSubscriber(context: Context) :
        BaseUseCaseSubscriber<ApiResponse<TrackModel>>(context) {

        override fun onNext(t: ApiResponse<TrackModel>) {

            trackNavigator.setTrackList(t)
        }

        override fun onError(e: Throwable) {
        }
    }


}