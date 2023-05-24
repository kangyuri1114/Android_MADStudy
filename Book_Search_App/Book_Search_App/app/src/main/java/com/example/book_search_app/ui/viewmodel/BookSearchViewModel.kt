package com.example.book_search_app.ui.viewmodel

import androidx.lifecycle.*
import com.example.book_search_app.data.model.SearchResponse
import com.example.book_search_app.data.repository.BookSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookSearchViewModel(
    private val bookSearchRepository: BookSearchRepository,
    private val savedStateHandle: SavedStateHandle, //savedStateHandle 생성자를 썼기에 뷰모델 프로바이더도 변경

) : ViewModel() { //BookSearchViewModel은 초기값으로 bookSearchRepository를 전달 받는데, viewmodel은 그 자체로는 생성 시에 초기 값을 전달받을 수 없으므로 Factory를 만들어야 함

    // Api
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    //Repository의 SearchBooks가 Coroutine 내부에서 수행하는 함수
    //Coroutine은 Background 작업을 훨씬 용이하게 한다.
    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = bookSearchRepository.searchBooks(query, "accuracy", 1, 15)
        //query 이외에는 모두 고정 값을 사용하도록 했다
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResult.postValue(body)
            } //Retrofit의 반환 값은 MutableData인 _searchResult에 저장
              //외부에는 수정 불가한 LiveData로 변환한 searchResult를 노출하도록
        }
    }

    // SavedState
    var query = String()
        set(value) {
            field = value //쿼리 값 변화 시
            savedStateHandle.set(SAVE_STATE_KEY, value) //변환된 값 바로 savedState에 저장
        } //쿼리 보존에 사용할 쿼리 변수 정의

    init { //뷰모델 초기화 시 쿼리 초기 값을 savedState에서 가져오기 없으면 공백 반환
        query = savedStateHandle.get<String>(SAVE_STATE_KEY) ?: ""
    }

    companion object {
        private const val SAVE_STATE_KEY = "query"
    } //저장 및 로드에 savedState 키 정의
}