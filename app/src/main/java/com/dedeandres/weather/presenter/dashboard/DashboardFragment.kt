package com.dedeandres.weather.presenter.dashboard

import androidx.fragment.app.viewModels
import com.dedeandres.weather.common.*
import com.dedeandres.weather.common.base.BaseViewModelFragment
import com.dedeandres.weather.databinding.FragmentDashboardBinding
import com.dedeandres.weather.presenter.dashboard.entity.CurrentWeatherResult
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DashboardFragment : BaseViewModelFragment<FragmentDashboardBinding, DashboardViewModel>() {
    override val viewModel: DashboardViewModel by viewModels()

    override fun getViewBinding(): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(layoutInflater)
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()

        viewModel.fetchCurrentWeather()
        viewModel.fetchCurrentWeatherLiveData.observe(viewLifecycleOwner, EventObserver(::handleFetchCurrentWeather))
    }

    private fun handleFetchCurrentWeather(result: Resource<CurrentWeatherResult>){
        when(result.state){
            ResourceState.SUCCESS -> {
                Timber.d("Fetch Current Weather Success: ${result.data}")
                result.data?.let {
                    binding.tvCity.text = it.locationName
                    binding.tvDay.text = getDayOfTheWeek()
                    binding.tvDate.text = getDate()
                    val weatherIcon = Weather.getIcon(it.coditionCode)
                    binding.ivWeatherIcon.setImageDrawable(resources.getDrawable(weatherIcon))
                }
            }
            ResourceState.LOADING -> {

            }
            ResourceState.ERROR -> {
                Timber.d("Fetch Current Weather Error: ${result.data}")
            }
        }
    }


}