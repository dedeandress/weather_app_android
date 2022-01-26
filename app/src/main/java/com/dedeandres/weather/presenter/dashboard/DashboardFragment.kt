package com.dedeandres.weather.presenter.dashboard

import androidx.fragment.app.viewModels
import com.dedeandres.weather.common.*
import com.dedeandres.weather.common.base.BaseViewModelFragment
import com.dedeandres.weather.databinding.FragmentDashboardBinding
import com.dedeandres.weather.presenter.dashboard.adapter.FavoriteCityListAdapter
import com.dedeandres.weather.presenter.dashboard.entity.CityWeatherResult
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DashboardFragment : BaseViewModelFragment<FragmentDashboardBinding, DashboardViewModel>(), FavoriteCityListAdapter.OnAddMoreCityClickListener {

    private lateinit var favoriteCityListAdapter: FavoriteCityListAdapter

    override val viewModel: DashboardViewModel by viewModels()

    override fun getViewBinding(): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        super.initViews()

        setupFavoriteCityListAdapter()
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()

        viewModel.deleteFavoriteCity(2)
        viewModel.fetchCurrentWeather()
        viewModel.fetchFavoriteCityWeatherList()
        viewModel.fetchCurrentWeatherLiveData.observe(viewLifecycleOwner, EventObserver(::handleFetchCurrentWeather))
        viewModel.fetchFavoriteCityWeatherListLiveData.observe(viewLifecycleOwner, EventObserver(::handleFetchFavoriteCityWeatherList))
    }

    private fun setupFavoriteCityListAdapter(){
        favoriteCityListAdapter = FavoriteCityListAdapter()
        binding.rvFavoriteCityWeather.adapter = favoriteCityListAdapter

        favoriteCityListAdapter.setOnAddMoreCityClickListener(this)
    }

    private fun handleFetchCurrentWeather(result: Resource<CityWeatherResult>){
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

    private fun handleFetchFavoriteCityWeatherList(result: Resource<List<CityWeatherResult>>){
        when(result.state){
            ResourceState.SUCCESS -> {
                Timber.d("Fetch Current Weather Success: ${result.data}")
                result.data?.let {
                    favoriteCityListAdapter.bind(it)
                }
            }
            ResourceState.LOADING -> {

            }
            ResourceState.ERROR -> {
                Timber.d("Fetch Current Weather Error: ${result.data}")
            }
        }
    }

    override fun onAddMoreCityClick() {
        Timber.d("onAddMoreCityClick clicked")
    }


}