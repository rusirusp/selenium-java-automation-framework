package pages.orangehrm;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton   = By.xpath("//button[text()[contains(.,'Login')]]");
    private final By errorMessage  = By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String url) {
        open(url);
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}
