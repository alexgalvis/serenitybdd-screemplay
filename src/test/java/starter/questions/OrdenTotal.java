package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static starter.ui.OrderConfirmationPage.SUMMARY_TOTAL;

public class OrdenTotal implements Question<Double> {

    public static Question<Double> dispayed(){
        return new OrdenTotal();
    }
    @Override
    public Double answeredBy(Actor actor) {
        String total = Text.of(SUMMARY_TOTAL)
                .answeredBy(actor);
        String num = total.replace("Total: $", "").trim();

        return Double.parseDouble(num);
    }
}
