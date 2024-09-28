package starter.interations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import starter.ui.homePage.HomePage;



public class SelectProduct implements Interaction {
    private final String productName;

    public SelectProduct(String productName) {
        this.productName = productName;
    }

    public static SelectProduct withName(String productName) {
        return new SelectProduct(productName);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.product(productName).addToCartButton())
        );
    }
}
