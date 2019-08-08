package com.uttampanchasara.baseprojectkotlin.ui.dashboard

import android.support.v7.widget.LinearLayoutManager
import com.uttampanchasara.baseprojectkotlin.R
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import com.uttampanchasara.baseprojectkotlin.di.component.ActivityComponent
import com.uttampanchasara.baseprojectkotlin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardView, HeadlinesAdapter.HeadlinesClickListener {
    override fun getLayout(): Int {
        return R.layout.activity_dashboard
    }

    @Inject
    lateinit var mPresenter: DashboardPresenter

    private lateinit var mAdapter: HeadlinesAdapter

    override fun injectComponents(mActivityComponent: ActivityComponent) {
        transparentStatusBar()
        mActivityComponent.inject(this)
        mPresenter.onAttachView(this)
    }

    override fun setUp() {
        init()
        fetchHeadlines()
    }

    private fun init() {
        rvHeadlines.layoutManager = LinearLayoutManager(this)
        mAdapter = HeadlinesAdapter(this, this)
        rvHeadlines.adapter = mAdapter
    }

    private fun fetchHeadlines() {
        viewFlipper.displayedChild = 0
        mPresenter.getTopHeadlines("in")
    }

    override fun onHeadlinesAvailable(headlines: List<Headlines>) {
        if (headlines.isEmpty()) {
            viewFlipper.displayedChild = 1
        } else {
            viewFlipper.displayedChild = 2
            mAdapter.setHeadlines(headlines)
        }
    }

    override fun onHeadlinesClicked(headline: Headlines) {
        headline.title?.let {
            onError(it)
        }
    }
}