package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.interations.SelectProduct;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class addProductsToCard implements Task {
    private final String productName;

    public addProductsToCard(String productName) {
        this.productName = productName;
    }
    public static Performable withName(String productName){
        return  instrumented(addProductsToCard.class,productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectProduct.withName(productName)
        );
    }
}
