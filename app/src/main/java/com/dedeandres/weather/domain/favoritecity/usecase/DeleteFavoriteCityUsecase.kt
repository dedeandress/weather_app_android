package com.dedeandres.weather.domain.favoritecity.usecase

import com.dedeandres.weather.common.Either
import com.dedeandres.weather.common.base.BaseUseCase
import com.dedeandres.weather.domain.favoritecity.repository.FavoriteCityRepository
import javax.inject.Inject

class DeleteFavoriteCityUsecase @Inject constructor(private val favoriteCityRepository: FavoriteCityRepository): BaseUseCase<Unit>(){
    override suspend fun buildUseCase(data: Map<String, Any?>): Either<Exception, Unit> {
        favoriteCityRepository.deleteFavoriteCity(data[ID] as Int)
        return Either.Right(Unit)
    }

    companion object{
        const val ID = "ID"
    }
}