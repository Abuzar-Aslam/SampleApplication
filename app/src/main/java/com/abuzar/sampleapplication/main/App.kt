package com.abuzar.sampleapplication.main

import androidx.multidex.MultiDexApplication
import com.abuzar.sampleapplication.injection.datModule
import com.abuzar.sampleapplication.injection.viewModelModule
import org.koin.android.ext.android.startKoin


/**
 * Created by ABUZAR on 9/1/2019.
 */

class App : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(viewModelModule, datModule))
    }

}