package com.abuzar.sampleapplication.interactors

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ApiResponse

/**
 * Created by ABUZAR on 9/2/2019.
 */

class AlbumUseCase(private val deezerApi: DeezerApi) : BaseUseCase<ApiResponse<AlbumModel>>() {


    fun <O> execute(
        artistId: Int,
        disposableObserver: O
    ) where O : Disposable, O : Observer<ApiResponse<AlbumModel>> {
        this.artistId = artistId
        super.execute(disposableObserver)
    }


    override fun buildUseCaseObservable(): Observable<ApiResponse<AlbumModel>> {
        return deezerApi.getAlbumList(artistId)
    }

    var artistId: Int = 0

}