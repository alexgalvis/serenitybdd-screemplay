package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.interations.GoToShoppingCard;
import starter.ui.CartPage;
import starter.ui.CheckoutPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProceedToCheckout implements Task {
    private final String lastName;
    private final String postalCode;

    public ProceedToCheckout(String lastName, String postalCode) {
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
    public static Performable withData(String lastName,String postalCode){
        return instrumented(ProceedToCheckout.class,lastName,postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GoToShoppingCard.on(),
                Click.on(CartPage.CHECKOUT_BUTTON),
                Enter.theValue(actor.getName()).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE)
        );

    }
}
