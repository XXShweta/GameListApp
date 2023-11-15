package com.android.consumeapi.ui.gamescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.consumeapi.di.IoDispatcher
import com.android.consumeapi.domain.model.GameItem
import com.android.consumeapi.domain.usecase.GetGamesUseCase
import com.android.consumeapi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gamesUseCase: GetGamesUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {

    init {
        getGames()
    }

    private val _gameItems: MutableStateFlow<Resource<List<GameItem>>> = MutableStateFlow(Resource.Loading())
    val gameItems = _gameItems.asStateFlow()

    private fun getGames(){
        viewModelScope.launch(dispatcher) {
            gamesUseCase.getGames().collect{
                _gameItems.emit(it)
            }
        }
    }
}
