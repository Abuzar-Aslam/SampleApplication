package com.abuzar.sampleapplication.ui.searchartist

import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel

/**
 * Created by ABUZAR on 9/1/2019.
 */

interface ArtistNavigator {


    fun setArtistList(t: ApiResponse<ArtistModel>)
    fun launchAlbumFragment(artistModel: ArtistModel)
}