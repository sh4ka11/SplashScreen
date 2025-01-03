import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class UserRegistrationViewModel() : ViewModel() {
    var name by mutableStateOf("gustavo")
    var lastname by mutableStateOf("andes")
    var email by mutableStateOf("gasc2004@gmail.com")
    var phone by mutableStateOf("123456789")
    var birthDate by mutableStateOf("2000-12-12")
    var location by mutableStateOf("pasto")
    var number by mutableStateOf("123456789")
    var password by mutableStateOf("123456789")
    var password_confirmation by mutableStateOf("123456789")
    val roleOptions = listOf("investor", "entrepreneur")
    var role by mutableStateOf("investor")


    var image by mutableStateOf<String?>(null)

    var isLoading by mutableStateOf(false)
    var registrationError by mutableStateOf<String?>(null)

//    fun setSelectedImage(uri: Uri?) {
//        image = uri?.toString() ?: ""
//    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun registerUser(onSuccess: () -> Unit) {
        if (validateFields()) {
            isLoading = true
            viewModelScope.launch {
                try {
                    val user = User(
                        name = name,
                        lastname = lastname,
                        email = email,
                        phone = phone,
                        birth_date = birthDate,
                        location = location,
                        number = number,
                        password = password,
                        password_confirmation = password_confirmation,
                        role = role,
                        image = image
                    )
                    val response =  RetrofitInstance.apiService.registerUser(user)
                    if (response.isSuccessful) {
                        clearFields()
                        onSuccess()
                    } else {
                        registrationError = "Error en el registro: ${response.message()}"
                    }
                } catch (e: Exception) {
                    registrationError = "Error en el registro e: ${e.message}"
                } finally {
                    isLoading = false
                }
            }
        }
    }



    @RequiresApi(Build.VERSION_CODES.O)
    private fun validateFields(): Boolean {
        // Validar campos obligatorios
        when {
            name.isBlank() -> {
                registrationError = "El nombre es obligatorio"
                return false
            }
            lastname.isBlank() -> {
                registrationError = "El apellido es obligatorio"
                return false
            }
            email.isBlank() || !isValidEmail(email) -> {
                registrationError = "Ingrese un correo electrónico válido"
                return false
            }
            phone.isBlank() || !isValidPhone(phone) -> {
                registrationError = "Ingrese un número de teléfono válido"
                return false
            }
            birthDate.isBlank() || !isValidBirthDate(birthDate) -> {
                registrationError = "Ingrese una fecha de nacimiento válida"
                return false
            }
            password.isBlank() || password.length < 6 -> {
                registrationError = "La contraseña debe tener al menos 6 caracteres"
                return false
            }
            password != password_confirmation -> {
                registrationError = "Las contraseñas no coinciden"
                return false
            }
            role.isBlank() -> {
                registrationError = "El rol es obligatorio"
                return false
            }


            else -> return true
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")
        return emailRegex.matches(email)
    }

    private fun isValidPhone(phone: String): Boolean {
        // Ejemplo de validación de teléfono (ajustar según tus necesidades)
        return phone.length in 9..15 && phone.all { it.isDigit() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun isValidBirthDate(dateString: String): Boolean {
        return try {
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE
            val parsedDate = LocalDate.parse(dateString, formatter)

            // Validar que la fecha no sea en el futuro y el usuario tenga al menos 13 años
            val minDate = LocalDate.now().minusYears(13)
            parsedDate.isBefore(LocalDate.now()) && parsedDate.isBefore(minDate)
        } catch (e: DateTimeParseException) {
            false
        }
    }

    private fun clearFields() {
        name = ""
        lastname = ""
        email = ""
        phone = ""
        birthDate = ""
        location = ""
        number =""
        password = ""
        password_confirmation = ""
        role = ""
        image = null
    }

}





