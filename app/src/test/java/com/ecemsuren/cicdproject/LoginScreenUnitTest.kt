package com.ecemsuren.cicdproject

import org.junit.Test
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

/**
 * Unit Tests focus on testing business logic, input validations,
 * and calculations in isolation without Android UI dependencies.
 */
class LoginScreenUnitTest {

    @Test
    fun emailValidation_validEmail_returnsTrue() {
        val email = "user@example.com"
        val isValid = email.contains("@") && email.endsWith(".com")
        assertTrue(isValid)
    }

    @Test
    fun emailValidation_invalidEmail_returnsFalse() {
        val email = "userexample.com"
        val isValid = email.contains("@") && email.endsWith(".com")
        assertFalse(isValid)
    }

    @Test
    fun passwordValidation_tooShort_returnsFalse() {
        val password = "123"
        val isValid = password.length >= 6
        assertFalse(isValid)
    }

    @Test
    fun passwordValidation_sufficientLength_returnsTrue() {
        val password = "securePassword123"
        val isValid = password.length >= 6
        assertTrue(isValid)
    }

}
