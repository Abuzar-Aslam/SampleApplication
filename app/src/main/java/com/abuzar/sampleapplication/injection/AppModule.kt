package com.abuzar.sampleapplication.injection

import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.ui.searchartist.ArtistViewModel
import com.abuzar.sampleapplication.data.DeezerApi
import com.abuzar.sampleapplication.ui.album.AlbumViewModel
import com.abuzar.sampleapplication.ui.track.TrackViewModel
import com.abuzar.sampleapplication.utils.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by ABUZAR on 9/1/2019.
 */

val viewModelModule = module {


    viewModel {
        ArtistViewModel(
            androidContext(),
            get(),
            getProperty(SEARCH_ARTIST_NAVIGATOR)
        )
    }

    viewModel {
        AlbumViewModel(
            androidContext(),
            get(),
            getProperty(ALBUM_NAVIGATOR),
            getProperty(ARTIST_MODEL)
        )

    }


    viewModel {
        TrackViewModel(
            androidContext(),
            get(),
            getProperty(TRACK_NAVIGATOR),
            getProperty(ALBUM_MODEL),
            getProperty(ARTIST_MODEL)
        )

    }


}


val datModule = module {

    single {


        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(androidContext().getString(R.string.baseurl))
            .build()

        retrofit.create(DeezerApi::class.java)
    }


}