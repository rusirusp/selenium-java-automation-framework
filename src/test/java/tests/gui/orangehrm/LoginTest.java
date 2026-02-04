package tests.gui.orangehrm;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.orangehrm.DashboardPage;
import pages.orangehrm.LoginPage;
import tests.BaseTest;
import utils.Config;
import utils.JsonData;


public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private String orangeHRMURL;

    SoftAssert softAssert;

    String username = JsonData.getString("testdata/users.json", "/OrangeHRM/username");
    String password = JsonData.getString("testdata/users.json", "/OrangeHRM/password");

    @BeforeClass
    public void runBeforeClass(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        orangeHRMURL = Config.get("baseUrlOrangeHRM");

        softAssert = new SoftAssert();
    }

    @Test (priority = 2)
    public void verifyThatTheUserCanLoginToTheApplicationWithValidCredentials(){
        loginPage.openLoginPage(orangeHRMURL);
        loginPage.login(username,password);
        softAssert.assertTrue(dashboardPage.isDashboardPageHeaderDisplayed(),"Login unsuccessful with username:"+username);
    }

    @Test (priority = 1)
    public void verifyThatTheUserWillReceiveAnErrorWhenTryingToLoginWithInvalidCredentials(){
        loginPage.openLoginPage(orangeHRMURL);
        loginPage.login(username+"123",password);
        softAssert.assertTrue(loginPage.isErrorDisplayed(),"Error Message has not appeared");
    }
}
