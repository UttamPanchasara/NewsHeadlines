package com.uttampanchasara.baseprojectkotlin.ui.splash

import com.uttampanchasara.baseprojectkotlin.ui.base.BaseView

class SplashPresenter {
    interface View : BaseView {
        fun navigateToDashboard()
    }

    interface Controller {
        fun navigateToDashboard()
    }
}