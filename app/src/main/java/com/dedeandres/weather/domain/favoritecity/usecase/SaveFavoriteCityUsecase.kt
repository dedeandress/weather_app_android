package com.dedeandres.weather.domain.favoritecity.usecase

import com.dedeandres.weather.common.Either
import com.dedeandres.weather.common.base.BaseUseCase
import com.dedeandres.weather.domain.favoritecity.repository.FavoriteCityRepository
import javax.inject.Inject

class SaveFavoriteCityUsecase @Inject constructor(private val favoriteCityRepository: FavoriteCityRepository) : BaseUseCase<Unit>(){
    override suspend fun buildUseCase(data: Map<String, Any?>): Either<Exception, Unit> {
        favoriteCityRepository.insertFavoriteCity(data[NAME] as String)
        return Either.Right(Unit)
    }

    companion object{
        const val NAME = "NAME"
    }
}