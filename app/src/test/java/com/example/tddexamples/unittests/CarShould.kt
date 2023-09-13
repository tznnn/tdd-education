package com.example.tddexamples.unittests

import com.example.tddexamples.Car
import com.example.tddexamples.Engine

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CarShould {

    private val engine:Engine = mock()
    private val car = Car(engine,5.0)
    @Test
    fun looseFuelWhenItTurnsOn(){
        car.turnOn()

        assertEquals(4.5,car.fuel)
    }

    @Test
    fun turnOnItsEngine(){
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}