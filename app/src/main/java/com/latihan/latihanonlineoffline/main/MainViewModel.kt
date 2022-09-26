package com.latihan.latihanonlineoffline.main

import androidx.lifecycle.*
import com.latihan.latihanonlineoffline.core.data.Resource
import com.latihan.latihanonlineoffline.core.domain.model.Fact
import com.latihan.latihanonlineoffline.core.domain.usecase.FactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val factUseCase: FactUseCase): ViewModel() {
    private val _factList = MutableLiveData<Resource<List<Fact>>>()
    val factList: LiveData<Resource<List<Fact>>> = _factList

    init {
        getFact()
    }

    private fun getFact() {
        viewModelScope.launch {
            factUseCase.getFact()
                .catch {
                    _factList.postValue(Resource.Error(it.message.toString()))
                }
                .collect {
                    _factList.postValue(it)
                }
        }
    }
}