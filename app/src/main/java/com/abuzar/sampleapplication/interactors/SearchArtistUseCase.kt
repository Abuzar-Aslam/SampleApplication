package com.abuzar.sampleapplication.interactors

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel

/**
 * Created by ABUZAR on 9/2/2019.
 */


class SearchArtistUseCase(private val deezerApi: DeezerApi) : BaseUseCase<ApiResponse<ArtistModel>>() {


    fun <O> execute(
        queryString: String,
        disposableObserver: O
    ) where O : Disposable, O : Observer<ApiResponse<ArtistModel>> {
        this.queryString = queryString
        super.execute(disposableObserver)
    }


    override fun buildUseCaseObservable(): Observable<ApiResponse<ArtistModel>> {
        return deezerApi.searchArtist(queryString)
    }

    var queryString: String = ""

}