package pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DashboardPage extends BasePage {

    private final By pageHeader = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardPageHeaderDisplayed() {
        return isDisplayed(pageHeader);
    }


}
