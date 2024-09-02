package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.homePage.HomePage;

public class IsUserLoggedIn implements Question<Boolean> {
    public static Question<Boolean> value(){
        return new IsUserLoggedIn();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl().equals(HomePage.urlHome);
    }
}
