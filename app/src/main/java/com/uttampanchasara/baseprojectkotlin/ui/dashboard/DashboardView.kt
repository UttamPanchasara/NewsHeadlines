package com.uttampanchasara.baseprojectkotlin.ui.dashboard

import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import com.uttampanchasara.baseprojectkotlin.ui.base.BaseView

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/20/2018
 */
interface DashboardView : BaseView {
    fun onHeadlinesAvailable(headlines: List<Headlines>)
}