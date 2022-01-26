package com.dedeandres.weather.presenter.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dedeandres.weather.common.Weather
import com.dedeandres.weather.databinding.ItemAddMoreCityBinding
import com.dedeandres.weather.databinding.ItemCurrentWeatherBinding
import com.dedeandres.weather.presenter.dashboard.entity.CityWeatherResult
import timber.log.Timber

class FavoriteCityListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val items: ArrayList<CityWeatherResult> = ArrayList()
    private var onAddMoreCityClickListener: OnAddMoreCityClickListener ?= null

    init{
        Timber.d("init FavoriteCityListAdapter")
    }

    fun setOnAddMoreCityClickListener(onAddMoreCityClickListener: OnAddMoreCityClickListener) {
        this.onAddMoreCityClickListener = onAddMoreCityClickListener
    }

    interface OnAddMoreCityClickListener {
        fun onAddMoreCityClick()
    }

    fun bind(items: List<CityWeatherResult>){
        this.items.clear()
        if(this.items.isEmpty()){
            this.items.addAll(items)
            this.items.add(CityWeatherResult(null,"", "","","","","","","","","","",0))
            Timber.d("items FavoriteCityListAdapter: ${this.items}")
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != items.size-1) 1 else 2
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1){
            val itemBinding = ItemCurrentWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return FavoriteCityViewHolder(itemBinding)
        } else {
            val itemBinding = ItemAddMoreCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return AddMoreCityViewHolder(itemBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == 1){
            val item = items[position]
            val viewHolder = holder as FavoriteCityViewHolder
            viewHolder.bindCurrentWeather(item)
        }

        if(holder.itemViewType == 2){
            val viewHolder = holder as AddMoreCityViewHolder
            viewHolder.bind()
        }
    }

    override fun getItemCount(): Int = items.size

    inner class FavoriteCityViewHolder(private val itemCurrentWeatherBinding: ItemCurrentWeatherBinding) :
        RecyclerView.ViewHolder(itemCurrentWeatherBinding.root){

        fun bindCurrentWeather(cityWeatherResult: CityWeatherResult){
            val weatherIcon = Weather.getIcon(cityWeatherResult.coditionCode)
            itemCurrentWeatherBinding.ivWeatherIcon.setImageDrawable(itemView.resources.getDrawable(weatherIcon))
            itemCurrentWeatherBinding.tvFeelsLike.text = Weather.feelsLikeFormatC(cityWeatherResult.feelsLikeC)
            itemCurrentWeatherBinding.tvCity.text = cityWeatherResult.locationName
            itemCurrentWeatherBinding.tvWind.text = Weather.windFomatKmh(cityWeatherResult.windKph)
            itemCurrentWeatherBinding.tvTemp.text = cityWeatherResult.tempC
        }
    }

    inner class AddMoreCityViewHolder(private val itemAddMoreCityBinding: ItemAddMoreCityBinding):
        RecyclerView.ViewHolder(itemAddMoreCityBinding.root){
            fun bind(){
                itemView.setOnClickListener {
                    onAddMoreCityClickListener?.onAddMoreCityClick()
                }
            }
        }
}