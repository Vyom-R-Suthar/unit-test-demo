// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo.service;

import com.person.persondemo.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest2 {

    private Calculator calculator;
    private static int count = 0;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
        count++;
        System.out.println("setup-"+count);
    }

    @Test
    void testDoIncrement(){
        calculator.doIncrement();
        assertEquals(1,calculator.getCount());
    }

    @Test
    void testDoDecrement(){
        calculator.doDecrement();
        assertEquals(-1,calculator.getCount());
    }
}
