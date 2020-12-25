package com.example.jsonfile

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.jsonfile.ui.main.MainViewModel
import org.junit.After
import org.junit.Assert
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    private val ONE_WORD_MESSAGE = "ONE_WORD_MESSAGE"
    private val TWO_WORD_MESSAGE = "ONE WORD_MESSAGE"
    private val TWO_WORD_MESSAGE_RESULT = "WORD_MESSAGE ONE"
    private val TEN_WORD_MESSAGE = "WORD_MESSAGE ONE1 ONE2 ONE3 ONE4 ONE5 ONE6 ONE7 ONE8 ONE9"
    private val TEN_WORD_MESSAGERESULT = "ONE9 ONE8 ONE7 ONE6 ONE5 ONE4 ONE3 ONE2 ONE1 WORD_MESSAGE"

    @Mock
    private lateinit var context: Context
    private lateinit var vm: MainViewModel

    @Before
    fun before() {
        vm = MainViewModel(context)
    }

    @Test
    fun loadString(){
        `when`(context.getString(R.string.app_name))
            .thenReturn("JsonFile")
        val ViewModel = MainViewModel(context)
        val result = ViewModel.loadWord()
        Assert.assertEquals("JsonFile", result)
    }

    @Test
    fun one_word_message() {
        val text = vm.replaceWords(ONE_WORD_MESSAGE)
        Assert.assertEquals(ONE_WORD_MESSAGE, text)
    }

    @Test
    fun two_word_message() {
        val text = vm.replaceWords(TWO_WORD_MESSAGE)
        Assert.assertEquals(TWO_WORD_MESSAGE_RESULT, text)
    }

    @Test
    fun ten_word_message_return_true() {
        val text = vm.replaceWords(TEN_WORD_MESSAGE)

        Assert.assertEquals(TEN_WORD_MESSAGERESULT, text)
    }


    @After
    fun after() {
    }

}