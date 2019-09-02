package com.abuzar.sampleapplication.data

import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.abuzar.sampleapplication.data.model.TrackModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ABUZAR on 9/1/2019.
 */

interface DeezerApi {


    @GET("search/artist")
    fun searchArtist(@Query("q") q: String): Observable<ApiResponse<ArtistModel>>


    @GET("artist/{artistId}/albums")
    fun getAlbumList(@Path("artistId") artistId: Int): Observable<ApiResponse<AlbumModel>>


    @GET("album/{albumId}/tracks")
    fun getTrackList(@Path("albumId") albumId: Int): Observable<ApiResponse<TrackModel>>


}