package com.abuzar.sampleapplication.interactors

import android.content.Context
import io.reactivex.observers.DisposableObserver

/**
 * Created by ABUZAR on 9/2/2019.
 */

abstract class BaseUseCaseSubscriber<T> (private val context: Context) : DisposableObserver<T>() {

    override fun onComplete() {}

    override fun onError(e: Throwable) {

    }

    override fun onNext(t: T) {}

}
