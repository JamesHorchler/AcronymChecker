package com.example.acronymapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acronymapp.database.AcronymItemModel
import com.example.acronymapp.repository.RepositoryImpl
import com.example.acronymapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RepositoryImpl
) : ViewModel() {

    private val _acronym: MutableStateFlow<Resource<List<AcronymItemModel>>> =
        MutableStateFlow(Resource.Loading())
    val acronym: StateFlow<Resource<List<AcronymItemModel>>> = _acronym

    private fun handleResponse(response: Response<List<AcronymItemModel>>): Resource<List<AcronymItemModel>> {
        return if (response.isSuccessful) Resource.Success(response.body()!!)
        else Resource.Error(response.message())
    }

    fun getAcronym(sf: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _acronym.emit(Resource.Loading())
                val response = repository.getAcronym(sf)
                _acronym.emit(handleResponse(response))

            } catch (e: HttpException) {
                _acronym.emit(Resource.Error("Error occurred"))
            } catch (e: IOException) {
                _acronym.emit(Resource.Error("Dunno"))
            }
        }
    }
}