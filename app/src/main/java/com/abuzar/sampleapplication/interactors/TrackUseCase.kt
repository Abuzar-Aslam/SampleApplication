package com.abuzar.sampleapplication.interactors

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.TrackModel

/**
 * Created by ABUZAR on 9/2/2019.
 */


class TrackUseCase(private val deezerApi: DeezerApi) : BaseUseCase<ApiResponse<TrackModel>>() {


    fun <O> execute(
        albumId: Int,
        disposableObserver: O
    ) where O : Disposable, O : Observer<ApiResponse<TrackModel>> {
        this.albumId = albumId
        super.execute(disposableObserver)
    }


    override fun buildUseCaseObservable(): Observable<ApiResponse<TrackModel>> {
        return deezerApi.getTrackList(albumId)
    }

    var albumId: Int = 0

}