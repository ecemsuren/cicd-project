package com.ecemsuren.cicdproject.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LoginUiState(
    val emailInput: String = "",
    val passwordInput: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isSuccess: Boolean = false
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChanged(email: String) {
        _uiState.update { 
            it.copy(
                emailInput = email, 
                emailError = if (email.isNotEmpty()) null else it.emailError
            ) 
        }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { 
            it.copy(
                passwordInput = password, 
                passwordError = if (password.isNotEmpty()) null else it.passwordError
            ) 
        }
    }

    fun onLoginClicked() {
        val currentEmail = _uiState.value.emailInput
        val currentPassword = _uiState.value.passwordInput

        val hasEmailError = currentEmail.isBlank() || !currentEmail.contains("@")
        val hasPasswordError = currentPassword.length < 6

        _uiState.update {
            it.copy(
                emailError = if (hasEmailError) "Geçerli bir email adresi giriniz" else null,
                passwordError = if (hasPasswordError) "Şifre en az 6 karakter olmalıdır" else null,
                isSuccess = !hasEmailError && !hasPasswordError
            )
        }
    }
}
