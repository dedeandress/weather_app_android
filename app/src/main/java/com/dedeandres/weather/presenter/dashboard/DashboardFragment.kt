package com.dedeandres.weather.presenter.dashboard

import androidx.fragment.app.viewModels
import com.dedeandres.weather.common.base.BaseViewModelFragment
import com.dedeandres.weather.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseViewModelFragment<FragmentDashboardBinding, DashboardViewModel>() {
    override val viewModel: DashboardViewModel by viewModels()

    override fun getViewBinding(): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(layoutInflater)
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()

        viewModel.fetchCurrentWeather()
    }


}