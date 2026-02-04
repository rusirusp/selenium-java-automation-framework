package pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ProfileDropdown extends BasePage {

    public ProfileDropdown(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropDownItem(String drpItem){
        By element = By.xpath(String.format("//a[text()='%s']", drpItem));
        click(element);
    }

}
