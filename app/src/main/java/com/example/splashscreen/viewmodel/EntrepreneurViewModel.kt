//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.splashscreen.data.model.Entrepreneur
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//
//class EntrepreneurViewModel : ViewModel() {
//    private val _entrepreneur = MutableStateFlow<Entrepreneur?>(null)
//    val entrepreneur: StateFlow<Entrepreneur?> get() = _entrepreneur
//
//    fun fetchEntrepreneur(id: Int) {
//        viewModelScope.launch {
//            try {
//                val response = RetrofitInstance.apiService.getEntrepreneur(id)
//                _entrepreneur.value = response
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//}
