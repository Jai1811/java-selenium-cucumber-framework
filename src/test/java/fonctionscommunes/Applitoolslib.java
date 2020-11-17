package fonctionscommunes;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import coeur.Properties;

public class Applitoolslib extends CommonFunction {

	EyesRunner runner;
	Eyes eyes;
	
	public Eyes setApplitoolsApikey() {
	runner = new ClassicRunner();
	eyes = new Eyes(runner);
	eyes.setApiKey(Properties.getProperties("appligtoolsAPIKey"));
	return eyes;
}
	public TestResultsSummary collectTestResults() {
		
		eyes.closeAsync();
		eyes.abortIfNotClosed();
		TestResultsSummary allTestResults = runner.getAllTestResults();
		
		return allTestResults;
	}

	}
