package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.questions.IsUserLoggedIn;
import starter.questions.ShoppingCartItemCount;
import starter.tasks.DoLogin;
import starter.tasks.NavigateTo;
import starter.tasks.ProceedToCheckout;
import starter.tasks.addProductsToCard;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ShoppingCartDefinitions {
    String actor;

    @Before
    public void setTheStage(){OnStage.setTheStage(new OnlineCast());}
    @Given("^that (.*) is on the product page$")
    public void thatAlexIsOnTheProductPage(String a) {
        this.actor = a;
    }

    @And("the user enters valid credentials")
    public void theUserAddsAProductToTheCart() {
        theActorCalled(actor).attemptsTo(
                NavigateTo.theSearchHomePage(),
                DoLogin.withCredentials("standard_user","secret_sauce")

        );

    }

    @And("the user should be redirected to the home page")
    public void theProductShouldBeVisibleInTheCart() {
        theActorInTheSpotlight().should(
                seeThat("the user should be redirected to the home page",IsUserLoggedIn.value(),is(true))
        );
    }
    @When("^(.*) adds the product (.*)$")
    public void the_user_adds_the_product_productName(String actor, String productName) {
        theActorCalled(actor).attemptsTo(
                addProductsToCard.withName(productName)
        );
    }
    @Then("^the quantity of added products should be (.*)$")
    public void the_quantity_of_added_products_should_be(String cantProduct) {

        theActorInTheSpotlight().should(
                seeThat("The number of items in the shopping cart is correct",
                        ShoppingCartItemCount.ofTheCart(),equalTo(cantProduct))
        );

    }
    @When("^(.*) navigates to the shopping cart and proceeds to checkout entering his first last name (.*) and zip code (.*)$")
    public void checkout(String actor,String lastName,String postalCode) {
        theActorCalled(actor).attemptsTo(
                ProceedToCheckout.withData(lastName,postalCode)
        );

    }
}
