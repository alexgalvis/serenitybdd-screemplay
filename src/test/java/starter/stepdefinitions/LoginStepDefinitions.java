package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.dashboard.OverviewData;
import starter.login.DoLogin;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {
    Actor name;
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("{actor} has an active account")
    public void has_an_active_account(Actor a) {
        this.name = a;
    }
    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
        theActorCalled(name.getName()).attemptsTo(
                NavigateTo.theSearchHomePage(),
                DoLogin.withCredentials("pepito","1234"));
    }
    @Then("he should have access to manege his account")
    public void he_should_have_access_to_manege_his_account() {
      //  System.out.println("********" + CreditAvailable.value().answeredBy(theActorInTheSpotlight()));
       // System.out.println("********" + OverviewData.creditAvailable().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(
                seeThat("The displayed credit available", OverviewData.creditAvailable(),equalTo("$17,800"))
        );
    }
}
