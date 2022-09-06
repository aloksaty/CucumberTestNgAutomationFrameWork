package com.alok.aut.Listeners;
import com.alok.aut.SelenumUtilities.GetScreenShot;
import com.alok.aut.project.Util.Log;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import io.cucumber.testng.PickleWrapper;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
@Listeners
public class TestNgListener implements ITestListener, ISuiteListener, IInvokedMethodListener, IAnnotationTransformer {

    static Boolean isRetry = true;
    public static HashMap<String, PickleWrapper> pickleWrapperHashMap = new HashMap<>();
    String suiteName;
    @Override
    public void onFinish (ITestContext Result) {
        Set<ITestResult> failedTests = Result.getFailedTests ().getAllResults ();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod ();
            if (Result.getFailedTests ().getResults (method).size () > 1) {
                failedTests.remove (temp);
            } else {
                if (Result.getPassedTests ().getResults (method).size () > 0) {
                    failedTests.remove (temp);
                }
            }
        }
        ExtentTestManager.endTest ();
        ExtentManager.getInstance ().flush ();
    }
    @Override
    public void onStart (ITestContext Result) {
        DateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd_HH-mm-ss");
        Date date = new Date ();
        Log.info (Result.getName () + "Test Class Started at:" + date);
        ParseTestNgXml.getSuiteName (Result);
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage (ITestResult Result) {
    }
    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure (ITestResult Result) {
        /**  Zephyer Client need to call to update the test -cases
         * ZephyrClient.execTest(Test,"2");
         * Result.getTestContext().getFailedTests().removeResult((ITestNGMethod) Result);
         */

        String Test = pickleWrapperHashMap.get("pickleEvent").getPickle().getName();;
        GetScreenShot getScreenShot = new GetScreenShot (Test);
        getScreenShot.capture (Test);
        String ScreenShotPath = ".\\" + Test + ".png";
        Log.error ("Test Case FAIL :" + Result.FAILURE);
        ExtentTestManager.getTest ().log (Status.FAIL, "Test Failed");
        try {
            ExtentTestManager.getTest ().fail ((Markup) ExtentTestManager.getTest ().addScreenCaptureFromPath (ScreenShotPath));
        } catch (IOException e) {
            Log.error (" Get ScreenShot Fail ");
            throw new RuntimeException (e);
        }
    }
    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped (ITestResult Result) {
        String Test = pickleWrapperHashMap.get("pickleEvent").getPickle().getName();;
        Log.info ("Test Case FAIL :" +Test+": " +Result.SKIP);
        ExtentTestManager.getTest ().log (Status.SKIP, "Test Skipped");
    }
    @Override
    public void onTestStart (ITestResult result) {
        DateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd_HH-mm-ss");
        Date date = new Date ();
        Log.info (result. getTestName () + "Test-Case Started at:" + date);
        ExtentTestManager.startTest (result.getMethod ().getId ());
    }
    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess (ITestResult Result) {
        /** Zephyr Client need to implement
         * ZephyrClient.execTest(Test,"1");
         extentTest.log(LogStatus.UNKNOWN, stepName, details);
         extentTest.log(LogStatus.PASS, TestName);*/
        String Test = pickleWrapperHashMap.get("pickleEvent").getPickle().getName();;
        Log.info ("Test Case PASS " +Test+ " : "+ Result.SUCCESS);
        ExtentTestManager.getTest ().log (Status.PASS, "Test passed");
    }
    @Override
    public void afterInvocation (IInvokedMethod method, ITestResult result) {
        IRetryAnalyzer retry = result.getMethod ().getRetryAnalyzer ();
        if (retry == null) {
            return;
        }
        if (isRetry == true) {
            switch (result.getStatus ()) {
                case ITestResult.FAILURE:
                    result.setStatus (ITestResult.SKIP);
                    break;
                case ITestResult.SUCCESS:
                    break;
            }
        } else {
            isRetry = true;
        }
        Log.info ("On  afterInvocation :" + result.getStatus ());
    }
    @Override
    public void beforeInvocation (IInvokedMethod arg0, ITestResult arg1) {
        Log.info ("On  beforeInvocation :" + arg0.getTestResult ());
    }
    @Override
    public void onFinish (ISuite suite) {
        Log.info ("On finish suite:" + suite.getResults ().toString ());
/*		try {
		MailSender.SendMailToGroup(ExtentManager.getReport (), "",suiteName);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    }
    @Override
    public void onStart (ISuite arg0) {
        Log.info ("On Start: suite " + arg0.getResults ().toString ());
    }
    @Override
    public void transform (ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
                           Method testMethod) {
        IRetryAnalyzer retry = testannotation.getRetryAnalyzer ();
        if (retry == null) {
            testannotation.setRetryAnalyzer (Retry.class);
        }

    }

}
