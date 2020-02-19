package com.capco.steps;

import org.openqa.selenium.WebDriver;
import com.capco.library.CommonActions;
import com.mongodb.diagnostics.logging.Logger;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GenericSteps {

	public static WebDriver driver = null;
	CommonActions commonActions;

	public GenericSteps(CommonActions commonActions) {

		this.commonActions = commonActions;
	}

	@Before
	public void before(Scenario s) throws Exception {
		commonActions.initReports(s.getName());
		commonActions.setfeaturefilenameansscenario(s.getId(), s.getName());

	}

	
	@After
	public void after() throws Exception {
		commonActions.quit();
	}

	
	@Given("user Launches PiggyBank application")
	public void user_Launches_PiggyBank_application() {
		try {
			commonActions.launchBrowser();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@When("user login {string} as username and {string} as password")
	public void user_login_as_username_and_as_password(String string, String string2) {
		try {
			commonActions.enterText("uName", string);
			commonActions.enterText("pwd", string2);
			commonActions.takesScreenshot("user enter username and password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("user click on {string} as signIn")
	public void user_click_on_as_signIn(String string) throws Exception {
		try {
			commonActions.click(string);
			commonActions.takesScreenshot("Click on SignIn");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@When("user navigates to {string}")
	public void user_navigates_to(String string) throws Exception {
		commonActions.click(string);
	}

	@When("user enter login {string} as username and {string} as password")
	public void user_enter_login_as_username_and_as_password(String string, String string2) {
		try {
			commonActions.enterText("uName", string);
			commonActions.enterText("", string2);
			commonActions.takesScreenshot("user enter username and password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
