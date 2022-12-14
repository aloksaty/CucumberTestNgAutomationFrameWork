package com.alok.aut.Runner;
import com.alok.aut.Listeners.TestNgListener;
import com.alok.aut.SelenumUtilities.BrowserDriver;
import io.cucumber.testng.*;
import org.testng.annotations.*;
@CucumberOptions(

        plugin= {"com.alok.aut.Listeners.customReportListener","json:target/cucumber/cucumber.json"},
        //plugin= {"com.alok.aut.Listeners.customReportListener"},
        features="src/test/resources/featureFiles/BusticketBooking.feature",
        glue= "com/alok/aut/StepDef"
)

public class TestNGCucumber  {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters({ "hubAddress", "platform","browserType", "version" ,"env"})
    public void setUpClass(@Optional("")String hubAddress, @Optional("IamOptional")String platform, @Optional("chrome") String browserType,
                           @Optional("IamOptional") String version,@Optional("IamOptional") String env) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        BrowserDriver browserDriver = new BrowserDriver(browserType);
    }
   @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void
   scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
        TestNgListener.pickleWrapperHashMap.put("pickleEvent",pickleEvent);
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        BrowserDriver.getDriver().close();
    }
}



