package com.dedeandres.weather.presenter.dashboard.bottomsheet

import com.dedeandres.weather.common.base.BaseBottomSheetDialogFragment
import com.dedeandres.weather.databinding.BottomsheetSearchLocationBinding

class SearchLocationBottomSheet: BaseBottomSheetDialogFragment<BottomsheetSearchLocationBinding>() {

    override fun getViewBinding(): BottomsheetSearchLocationBinding {
        return BottomsheetSearchLocationBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        super.initViews()
    }

}