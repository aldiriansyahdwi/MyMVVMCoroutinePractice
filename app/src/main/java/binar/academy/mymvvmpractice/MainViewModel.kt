package binar.academy.mymvvmpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import binar.academy.mymvvmpractice.repository.MainRepository
import binar.academy.mymvvmpractice.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 * @author Abika Chairul Yusri created on 3/12/2022 at 2:57 PM.
 */
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getAllCarData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}