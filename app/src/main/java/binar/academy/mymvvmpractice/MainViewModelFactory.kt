package binar.academy.mymvvmpractice

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import binar.academy.mymvvmpractice.repository.MainRepository
import binar.academy.mymvvmpractice.service.ApiHelper

class MainViewModelFactory(private val apiHelper: ApiHelper, private val context: Application) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper), context) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}