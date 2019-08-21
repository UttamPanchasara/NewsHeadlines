package com.uttampanchasara.baseprojectkotlin.ui.dashboard

import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import com.uttampanchasara.baseprojectkotlin.ui.base.BaseView

class DashboardPresenter {
    interface View : BaseView {
        fun onHeadlinesAvailable(headlines: List<Headlines>)
    }

    interface Controller {
        fun getTopHeadlines(country: String)
    }
}