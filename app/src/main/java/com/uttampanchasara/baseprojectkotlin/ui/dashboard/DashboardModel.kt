package com.uttampanchasara.baseprojectkotlin.ui.dashboard

import android.util.Log
import com.androidnetworking.error.ANError
import com.uttampanchasara.baseprojectkotlin.BasePresenter
import com.uttampanchasara.baseprojectkotlin.data.DataManager
import com.uttampanchasara.baseprojectkotlin.ui.base.BaseView
import com.uttampanchasara.baseprojectkotlin.utils.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DashboardModel
@Inject constructor(mDataManager: DataManager,
                    mSchedulerProvider: SchedulerProvider,
                    mCompositeDisposable: CompositeDisposable) : BasePresenter(mDataManager, mSchedulerProvider, mCompositeDisposable),
        DashboardPresenter.Controller {

    private var mView: DashboardPresenter.View? = null

    override fun onAttachView(view: BaseView) {
        mView = view as DashboardPresenter.View
    }

    override fun getTopHeadlines(country: String) {

        val headlinesFromApi = mDataManager.getHeadlines(country)
                .onErrorResumeNext { throwable: Throwable ->
                    return@onErrorResumeNext Observable.empty()
                }
                .map {
                    mDataManager.deleteHeadlines().subscribe()
                    mDataManager.insertHeadlines(it.articles).subscribe()
                    return@map it.articles
                }
                .subscribeOn(mSchedulerProvider.io())

        val headlinesFromDB = mDataManager.getHeadlines()
                .subscribeOn(mSchedulerProvider.io())

        mCompositeDisposable.add(Observable.concat(headlinesFromApi, headlinesFromDB)
                .observeOn(mSchedulerProvider.ui())
                .subscribe({
                    mView?.onHeadlinesAvailable(it)
                    Log.i("DashboardModel", it.toString())
                }, {
                    mView?.onHeadlinesAvailable(emptyList())
                    it.printStackTrace()
                    Log.e("DashboardModel", it.toString())
                }))
    }
}