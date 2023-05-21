package com.example.androidarchitecturecomponents


import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

/**
 * ViewModel을 만들 때 Factory를 통해 만듦
 * ViewModel을 Factory가 받고 해당 형식이 MyViewModel이면 그곳에 counter를 담아 다시 ViewModel 반환
 * */
@Suppress("UNCHECKED_CAST")
//class MyViewModelFactory(private val counter: Int ): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass. isAssignableFrom(MyViewModel::class.java)) {
//            return MyViewModel(counter) as T
//        }
//        throw java.lang.IllegalArgumentException("Viewmodel class not found")
//    }
//}

/**
 * MyViewModelFactory가 생성자로 savedstate를 받도록 변경
 * MyViewModelFactory() 상속받음
 * MyViewModel 반환 시 handle 함께 반환
 * */

class MyViewModelFactory(
    private val counter: Int,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(counter, handle) as T
        }

        throw java.lang.IllegalArgumentException("Viewmodel class not found")
    }
}
