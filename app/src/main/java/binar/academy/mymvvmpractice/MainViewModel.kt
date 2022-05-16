package binar.academy.mymvvmpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import binar.academy.mymvvmpractice.repository.MainRepository
import binar.academy.mymvvmpractice.service.ApiClient
import binar.academy.mymvvmpractice.service.ApiHelper
import binar.academy.mymvvmpractice.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Abika Chairul Yusri created on 3/12/2022 at 2:57 PM.
 */
class MainViewModel(private val mainRepository: MainRepository, application: Application) : AndroidViewModel(application) {
//    val repository = MainRepository(ApiHelper(ApiClient.getInstance(getApplication())))


    fun getAllCarData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}