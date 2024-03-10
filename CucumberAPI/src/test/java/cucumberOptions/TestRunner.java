package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/dwija/eclipse-workspace/CucumberAPI/src/test/java/features",
plugin="json:target/jsonReports/cucumber-report.json"
,glue={"stepDefs"},tags="@DeletePlace")

public class TestRunner {
//tags="@DeletePlace"

}
