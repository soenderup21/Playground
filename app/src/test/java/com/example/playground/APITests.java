package com.example.playground;


import com.example.playground.Models.UnitTestingMathClass;

import org.junit.Test;

import static org.junit.Assert.*;

public class APITests {

    @Test
    public void testMultiplyTwoNumbers(){
        float ans = UnitTestingMathClass.multiply(5,11);
        assertEquals(55,ans, 0);
    }

    @Test
    public void testDivide(){
        float ans = UnitTestingMathClass.Divide(12,2);
        assertEquals(6,ans, 0);
    }

}