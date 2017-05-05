package automated;

import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import unittesting.UnitTestClassBase;

import java.net.URI;

/**
 * Created by khanami on 04.05.2017.
 */
public class FeatureStepDef extends UnitTestClassBase{

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
        config.setServerAddress(new URI("ws://localhost:5095"));
        SDK.init(config);
        Reporter.init();
        Reporter.reportEvent("Step executed", "step executed");
    }

    @When("^user clicks on my dashboard$")
    public void user_clicks_on_my_dashboard() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Reporter.reportEvent("Step executed", "step executed");
    }

    @Then("^dashboard page is displayed$")
    public void dashboard_page_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Reporter.reportEvent("Step executed", "step executed");

        Reporter.generateReport();
        SDK.cleanup();
    }



}
