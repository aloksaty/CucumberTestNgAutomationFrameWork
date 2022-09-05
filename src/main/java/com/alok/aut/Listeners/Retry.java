package com.alok.aut.Listeners;


import com.alok.aut.project.Util.Log;
import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;
// implement IRetryAnalyzer interface
public class Retry extends TestNgListener implements IRetryAnalyzer {
    int minretryCount = 0;
    // set maxcounter value this will execute our test 3 times
    int maxretryCount = 2;
    // override retry Method
    public boolean retry (ITestResult result) {
        // this will run until max count completes if test pass within this frame it will come out of for loop
        if (minretryCount < maxretryCount) {
            Log.info ("Failing : " + result.getName ());
            minretryCount++;
            if (minretryCount == maxretryCount) {
                isRetry = false;
            }
            return true;
        }
        return false;
    }
}
 
