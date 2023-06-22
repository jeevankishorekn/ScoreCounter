package com.jeevan.scorecounter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _teamOneScore = MutableLiveData(0)
    val teamOneScore = _teamOneScore as LiveData<Int>

    private var _teamTwoScore = MutableLiveData(0)
    val teamTwoScore = _teamTwoScore as LiveData<Int>

    fun addThreePointsA(){
        _teamOneScore.value = _teamOneScore.value?.plus(3)
    }
    fun addTwoPointsA(){
        _teamOneScore.value = _teamOneScore.value?.plus(2)
    }

    fun addOnePointA(){
        _teamOneScore.value = _teamOneScore.value?.plus(1)
    }

    fun addThreePointsB(){
        _teamTwoScore.value = _teamTwoScore.value?.plus(3)
    }
    fun addTwoPointsB(){
        _teamTwoScore.value = _teamTwoScore.value?.plus(2)
    }

    fun addOnePointB(){
        _teamTwoScore.value = _teamTwoScore.value?.plus(1)
    }

    fun reset(){
        _teamOneScore.value = 0
        _teamTwoScore.value = 0
    }



}