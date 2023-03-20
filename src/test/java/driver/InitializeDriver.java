package driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InitializeDriver extends DriverProperties{
  @BeforeMethod
    public void main () {
        driver = initializeInstance();
        driver.get("https://login.beta.theemployeeapp.com/?subdomain=rtregcode.beta&callbackUrl=https://rtregcode.beta.theemployeeapp.com");
    }
    @AfterMethod
    public void cleanup () {
      driver.quit();
    }
}

