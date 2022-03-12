package binar.academy.mymvvmpractice.service

/**
 * @author Abika Chairul Yusri created on 3/12/2022 at 11:00 PM.
 */
class ApiHelper(private val apiService: ApiService) {
    
    suspend fun getAllCarData() = apiService.getAllCar()
}