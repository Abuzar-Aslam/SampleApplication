package com.abuzar.sampleapplication.ui.track

import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.TrackModel

/**
 * Created by ABUZAR on 9/2/2019.
 */

interface TrackNavigator {


    fun setTrackList(t: ApiResponse<TrackModel>)

}