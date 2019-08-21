package com.uttampanchasara.baseprojectkotlin.ui.splash

import com.uttampanchasara.baseprojectkotlin.BasePresenter
import com.uttampanchasara.baseprojectkotlin.data.DataManager
import com.uttampanchasara.baseprojectkotlin.ui.base.BaseView
import com.uttampanchasara.baseprojectkotlin.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/20/2018
 */
class SplashModel
@Inject constructor(mDataManager: DataManager,
                    mSchedulerProvider: SchedulerProvider,
                    mCompositeDisposable: CompositeDisposable) : BasePresenter(mDataManager, mSchedulerProvider, mCompositeDisposable)
        , SplashPresenter.Controller {

    var mView: SplashPresenter.View? = null

    override fun onAttachView(view: BaseView) {
        super.onAttachView(view)
        mView = view as SplashPresenter.View
    }

    override fun navigateToDashboard() {
        mView?.navigateToDashboard()
    }
}