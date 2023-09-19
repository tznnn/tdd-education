package com.example.tddexamples.acceptancetests

import com.example.tddexamples.Car
import com.example.tddexamples.Engine
import com.example.tddexamples.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    val mainCoroutineScopeRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurnsOnItsEngineAndIncreaseTheTemperature() = runTest {
        car.turnOn()
        delay(6001)
        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}