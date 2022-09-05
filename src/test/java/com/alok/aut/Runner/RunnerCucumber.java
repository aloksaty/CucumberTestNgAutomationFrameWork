package com.alok.aut.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        plugin= {"com.alok.aut.Listeners.customReportListener"},
        features="src/test/resources/featureFiles/BusticketBooking.feature",
        glue= "com/alok/demo/StepDefRest"
)
public class RunnerCucumber extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}