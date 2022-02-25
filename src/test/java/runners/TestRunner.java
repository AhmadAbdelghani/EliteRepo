package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

<<<<<<< HEAD
	@RunWith(Cucumber.class)
	@CucumberOptions(plugin = {"pretty", "html:Reports/htmlReport.html",
		"json:Reports/jsonReport.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
		dryRun = false,
		tags="@verifingTabItemVisibility")
=======
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:Reports/htmlReport.html",
"json:Reports/jsonReport.json"},
features="./src/test/resources/features",
glue="step_definitions",
dryRun = false,
tags="@Logout")
>>>>>>> f611fa0efb55580be3ad819f12d0bf3b515f37ec

public class TestRunner {

}
