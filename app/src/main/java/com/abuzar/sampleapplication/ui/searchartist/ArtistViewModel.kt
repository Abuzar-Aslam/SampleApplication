package com.abuzar.sampleapplication.ui.searchartist

import android.content.Context
import androidx.lifecycle.ViewModel
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.abuzar.sampleapplication.interactors.BaseUseCaseSubscriber
import com.abuzar.sampleapplication.interactors.SearchArtistUseCase

/**
 * Created by ABUZAR on 9/1/2019.
 */

class ArtistViewModel(
    private val context: Context,
    private val deezerApi: DeezerApi,
    private val artistNavigator: ArtistNavigator
) : ViewModel() {

    var requesting = false

    fun getTidalApi(queryString: String) {

        requesting = true
        SearchArtistUseCase(deezerApi).execute(queryString, SearchArtistSubscriber(context))

    }


    internal inner class SearchArtistSubscriber(context: Context) :
        BaseUseCaseSubscriber<ApiResponse<ArtistModel>>(context) {

        override fun onNext(t: ApiResponse<ArtistModel>) {

            artistNavigator.setArtistList(t)
        }

        override fun onError(e: Throwable) {
        }

    }


}