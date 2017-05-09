package automated;

import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.Verify;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.CucumberException;
import jdk.nashorn.internal.runtime.Undefined;
import org.junit.runner.notification.Failure;
import unittesting.UnitTestClassBase;

import java.net.URI;



public class FeatureStepDef extends UnitTestClassBase{
    Browser browser;

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
        config.setServerAddress(new URI("ws://localhost:5095"));
        SDK.init(config);
        Reporter.init();
        Reporter.reportEvent("Step executed", "step executed");
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.navigate("http://localhost:8083/pages/App/pages/login.sample.html");
        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("text").tagName("INPUT").name("uname").build()).setValue("Amir");
        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("password").tagName("INPUT").name("psw").build()).setValue("HPE");
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
        Button UserName = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit").tagName("BUTTON").name("Login").build());
//
        Verify.areEqual(UserName.getInnerText(), "Login");
        browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit").tagName("BUTTON").name("Login").build()).click();
        browser.close();
        Reporter.generateReport();
        SDK.cleanup();
        //throw new PendingException();


        }


    @Given("^navigate to CPR$")
    public void navigate_to_CPR() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
        config.setServerAddress(new URI("ws://localhost:5095"));
        SDK.init(config);
        Reporter.init();
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.navigate("http://localhost:8083/pages/App/pages/login.sample.html");
    }

    @Given("^page is loaded$")
    public void page_is_loaded() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        browser.sync();
    }

    @Given("^user and password are provided and valid$")
    public void user_and_password_are_provided_and_valid() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("text").tagName("INPUT").name("uname").build()).setValue("amir.khan");

        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("password").tagName("INPUT").name("psw").build()).setValue("microfocus");
    }

    @When("^user clicks on Login button$")
    public void user_clicks_on_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit").tagName("BUTTON").name("Login").build()).click();
    }

    @Then("^user is logged into CPR$")
    public void user_is_logged_into_CPR() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        browser.close();


        Reporter.generateReport();
        SDK.cleanup();

    }


}
