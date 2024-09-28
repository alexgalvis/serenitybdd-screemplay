package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderConfirmationPage {
    public static Target SUMMARY_TOTAL = Target.the("summary total label")
            .located(By.xpath("//div[@class='summary_total_label']"));
    public static Target FINISH = Target.the("finish")
            .located(By.id("finish"));
    public static Target CONFIRMATION_LABEL = Target.the("summary total label")
            .located(By.xpath("/html/body/div/div/div/div[2]/h2"));
}
