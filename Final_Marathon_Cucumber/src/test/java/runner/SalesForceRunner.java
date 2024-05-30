package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.ProjectSpecifiedMethod;

@CucumberOptions (features = "src/test/java/features/createLeadfeature.feature"
					,glue ="stepDefinition"
					,publish =true
					,monochrome = true)
public class SalesForceRunner extends ProjectSpecifiedMethod {

}
