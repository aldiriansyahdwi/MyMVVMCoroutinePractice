package binar.academy.mymvvmpractice.repository

import binar.academy.mymvvmpractice.service.ApiHelper

/**
 * @author Abika Chairul Yusri created on 3/12/2022 at 10:29 PM.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getAllCarData()
}