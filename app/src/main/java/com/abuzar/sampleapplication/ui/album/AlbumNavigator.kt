package com.abuzar.sampleapplication.ui.album

import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ApiResponse

/**
 * Created by ABUZAR on 9/1/2019.
 */

interface AlbumNavigator {


    fun setAlbumList(t: ApiResponse<AlbumModel>)
    fun launchTrackListFragment(albumModel: AlbumModel)
}