package com.example.androidarchitecturecomponents

import androidx.lifecycle.*
import androidx.lifecycle.map
/**
 * LiveData 사용
 * viewModel의 counter를 LiveData 변경
 * LiveData는 값을 변경 불가능 한 타입이기 때문에 MutableLiveData 사용
 * */
class MyViewModel(_counter: Int,
                  private val savedStateHandle: SavedStateHandle
): ViewModel() {

    //var counter: Int = _counter
    var liveCounter: MutableLiveData<Int> = MutableLiveData(_counter)
    val modifiedCounter : LiveData<String> = liveCounter.map { counter ->
        "$counter 입니다"
    }
    private var counter = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter

    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}