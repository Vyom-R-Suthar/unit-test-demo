// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static Calculator calculator;
    private static int count = 0;
    @BeforeAll
    static void setup(){
        calculator = new Calculator();
        count++;
        System.out.println("setup-" + count);
    }

    @Test
    void testDoIncrement(){
        calculator.doIncrement();
        assertEquals(0,calculator.getCount());
    }

    @Test
    void testDoDecrement(){
        calculator.doDecrement();
        assertEquals(-1,calculator.getCount());
    }

}
