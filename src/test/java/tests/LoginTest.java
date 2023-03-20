package tests;
import driver.InitializeDriver;
import implementation.Loginlmpl;
import org.testng.annotations.Test;
import testCredencials.LoginInfo;

public class LoginTest extends InitializeDriver implements LoginInfo {
    @Test
    public void loginAdmin () {

        Loginlmpl loginlmpl = new Loginlmpl(driver);
        loginlmpl.completeLogin(usernameAdmin, password);
    }

    @Test
    public void loginContentPublisher () {
        Loginlmpl loginlmpl = new Loginlmpl(driver);
        loginlmpl.completeLogin(usernameContentPublisher, password);
    }
    @Test
    public void loginSimple () {
        Loginlmpl loginlmpl = new Loginlmpl(driver);
        loginlmpl.completeLogin(usernameSimple, password);
    }
    @Test
    public void loginCFP () {
        Loginlmpl loginlmpl = new Loginlmpl(driver);
        loginlmpl.completeLogin(usernameCFP, password);
    }
}