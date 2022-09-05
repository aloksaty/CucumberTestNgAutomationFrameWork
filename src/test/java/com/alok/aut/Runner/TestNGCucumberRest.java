package com.alok.aut.Runner;

import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(

        plugin= {"pretty","html:target/report/report.html","json:target/cucumber/cucumber.json"},
        features="src/test/java/com/alok/demo/featureFiles/RestExecutionFromFiles.feature",
        glue= "com/alok/aut/StepDefRest"
)
public class TestNGCucumberRest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters({ "hubAddress", "platform","browserType", "version" ,"env"})
    public void setUpClass(String hubAddress, String platform, String browserType,String version,String env) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();

    }

}



