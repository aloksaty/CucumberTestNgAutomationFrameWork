package com.alok.aut.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( plugin = {"pretty"},
        features = "src/test/resources/featureFiles/BusticketBooking.feature",
                glue = "com/alok/aut/StepDef"
               )
                //tags = "not @ignore")

public class CucumberRunner extends AbstractTestNGCucumberTests{

}
