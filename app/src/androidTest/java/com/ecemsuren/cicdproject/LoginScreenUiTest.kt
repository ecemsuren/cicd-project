package com.ecemsuren.cicdproject

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LoginScreenUiTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun loginScreen_displaysAllElements() {
        composeTestRule.onNodeWithText("Hoş Geldiniz").assertIsDisplayed()
        composeTestRule.onNodeWithTag("email_input").assertIsDisplayed()
        composeTestRule.onNodeWithTag("password_input").assertIsDisplayed()
        composeTestRule.onNodeWithTag("login_button").assertIsDisplayed()
    }

    @Test
    fun loginScreen_emptyFields_showsErrors() {
        composeTestRule.onNodeWithTag("login_button").performClick()
        composeTestRule.onNodeWithText("Geçerli bir email adresi giriniz").assertIsDisplayed()
        composeTestRule.onNodeWithText("Şifre en az 6 karakter olmalıdır").assertIsDisplayed()
    }
}
