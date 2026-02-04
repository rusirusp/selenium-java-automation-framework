package pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HeaderBar extends BasePage {

    private final By imgProfile = By.xpath("//span/img[@alt='profile picture']");

    public HeaderBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnProfileDropDown(){
        click(imgProfile);
    }

}
