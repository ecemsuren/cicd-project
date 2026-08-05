package com.ecemsuren.cicdproject

import com.ecemsuren.cicdproject.ui.login.LoginViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        viewModel = LoginViewModel()
    }

    @Test
    fun initialState_isEmpty() {
        val state = viewModel.uiState.value
        assertEquals("", state.emailInput)
        assertEquals("", state.passwordInput)
        assertNull(state.emailError)
        assertNull(state.passwordError)
        assertFalse(state.isSuccess)
    }

    @Test
    fun onLoginClicked_emptyFields_setsErrorMessages() {
        viewModel.onLoginClicked()

        val state = viewModel.uiState.value
        assertEquals("Geçerli bir email adresi giriniz", state.emailError)
        assertEquals("Şifre en az 6 karakter olmalıdır", state.passwordError)
        assertFalse(state.isSuccess)
    }

    @Test
    fun onLoginClicked_validFields_setsSuccessTrue() {
        viewModel.onEmailChanged("ecem@example.com")
        viewModel.onPasswordChanged("123456")
        viewModel.onLoginClicked()

        val state = viewModel.uiState.value
        assertNull(state.emailError)
        assertNull(state.passwordError)
        assertTrue(state.isSuccess)
    }
}
