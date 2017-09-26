package automated;

import com.hp.lft.report.Reporter;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.Verify;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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


    @Given("^user name is valid$")
    public void user_name_is_valid() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
        config.setServerAddress(new URI("ws://localhost:5095"));
        SDK.init(config);
        Reporter.init();
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.navigate("http://localhost:8083/pages/App/pages/login.sample.html");
        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("text").tagName("INPUT").name("uname").build()).setValue("amir.khan");
    }

    @Given("^password is valid$")
    public void password_is_valid() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("password").tagName("INPUT").name("psw").build()).setSecure("592be67846f75c58e9b60d90bb0951481af327d1f1fa509df2c7");
    }

    @When("^user clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit").tagName("BUTTON").name("Login").build()).click();
    }

    @Then("^user is logged into the reporting tool$")
    public void user_is_logged_into_the_reporting_tool() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        browser.close();
        Reporter.generateReport();
        SDK.cleanup();

    }


    @Given("^some webpage is loaded and user pw provided$")
    public void some_webpage_is_loaded_and_user_pw_provided() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
        config.setServerAddress(new URI("ws://localhost:5095"));
        SDK.init(config);
        Reporter.init();
        Reporter.reportEvent("Step", "description");
    }

    @When("^button on webpage is clicked$")
    public void button_on_webpage_is_clicked() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Reporter.reportEvent("Step", "description");
    }


    //something
    //Change your code as Dev Engineer
    @Then("^user is logged in and something happens\\.$")
    public void user_is_logged_in_and_something_happens() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Reporter.reportEvent("Step", "description");
        Reporter.generateReport();
        SDK.cleanup();

        //Code something
        //Implement the user story.
    }
}
