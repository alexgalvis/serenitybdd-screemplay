package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static starter.ui.homePage.HomePage.SHOPPING_CART_BADGE;

public class ShoppingCartItemCount implements Question<String> {
    public static Question<String> ofTheCart(){
        return new ShoppingCartItemCount();
    }
    @Override
    public String answeredBy(Actor actor) {
        return SHOPPING_CART_BADGE.resolveFor(actor).getText();
    }
}
