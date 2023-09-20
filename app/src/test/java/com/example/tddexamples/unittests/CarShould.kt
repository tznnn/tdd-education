package com.example.tddexamples.unittests

import com.example.tddexamples.Car
import com.example.tddexamples.Engine
import com.example.tddexamples.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class CarShould {

    private val engine: Engine = mock()
    private val car: Car

    init {
        runTest {
            `when`(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)

            })
        }
        car = Car(engine, 5.0)
    }

    @get:Rule
    val mainCoroutineScopeRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runTest {

        car.turnOn()

        assertEquals(4.5, car.fuel)

    }


    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}