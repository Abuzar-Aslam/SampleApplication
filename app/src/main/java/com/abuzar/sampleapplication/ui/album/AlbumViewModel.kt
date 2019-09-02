package com.abuzar.sampleapplication.ui.album

import android.content.Context
import androidx.lifecycle.ViewModel
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.abuzar.sampleapplication.interactors.AlbumUseCase
import com.abuzar.sampleapplication.interactors.BaseUseCaseSubscriber

/**
 * Created by ABUZAR on 9/1/2019.
 */
class AlbumViewModel(
    private val context: Context,
    private val deezerApi: DeezerApi,
    private val albumNavigator: AlbumNavigator,
    private val artistModel: ArtistModel
) : ViewModel() {

    fun fetchAlbumList() {

        AlbumUseCase(deezerApi).execute(artistModel.id, AlbumSubscriber(context))

    }

    fun getArtistModel(): ArtistModel {
        return artistModel
    }


    internal inner class AlbumSubscriber(context: Context) :
        BaseUseCaseSubscriber<ApiResponse<AlbumModel>>(context) {

        override fun onNext(t: ApiResponse<AlbumModel>) {

            albumNavigator.setAlbumList(t)
        }

        override fun onError(e: Throwable) {

        }

    }


}