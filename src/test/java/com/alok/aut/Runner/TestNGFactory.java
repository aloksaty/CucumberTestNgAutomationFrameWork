package com.alok.aut.Runner;

import org.testng.annotations.*;

public class TestNGFactory {
    @Parameters({ "testType"})
    @Factory()
    public Object[] getTestClasses(String testType) {
        Object[] tests = new Object[1];
        if(testType.equalsIgnoreCase("Rest")) {
            tests[0] = new TestNGCucumberRest();
        }else{
            tests[0] = new TestNGCucumber();
        }
        return tests;
    }
}
