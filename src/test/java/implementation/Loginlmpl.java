package implementation;
import driver.InitializeDriver;
import logs.Logs;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testCredencials.LoginInfo;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;



public class Loginlmpl extends Logs implements LoginInfo  {
    private final By usernameHolder = By.xpath( "//input[@type ='text']");
    private final By passwordHolder = By.xpath( "//input[@type = 'password']");
    private final By loginClick = By.xpath("//button[@class= 'sc-gYbzsP iYFfWH']");

    public WebDriver driver;

    public Loginlmpl ( WebDriver driver){
        this.driver = driver;
    }

    public void getUserRole () {
        driver.get("https://rtregcode.beta.theemployeeapp.com/5beb4c2713db91ffce33aa63/my-profile");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void completeLogin (String username,String password) {


        driver.findElement(passwordHolder).sendKeys(password);

        log.info("password is:" + password);
        driver.findElement(usernameHolder).sendKeys(username);
        log.info("Username is:" + username);
        driver.findElement(loginClick).click();
        log.info("User has clicked Login button");
        getUserRole();

  if (username.contains(usernameAdmin)) {
      WebElement header = driver.findElement(By.xpath("//div[@class='column is-12 is-paddingless']/div[@class='css-1dbjc4n r-z6ln5t']/*[contains(text(),'Account Admin')]"));
      String ActualTitle = header.getText();
      String ExpectedTitle = "Account Admin";
      Assert.assertEquals(ExpectedTitle, ActualTitle);
      log.info("ADMIN is logged in");
  }
  else  if (username.contains(usernameContentPublisher)) {
      WebElement header = driver.findElement(By.xpath("//div[@class='column is-12 is-paddingless']/div[@class='css-1dbjc4n r-z6ln5t']/*[contains(text(),'Content Publisher')]"));
      String ActualTitle = header.getText();
      String ExpectedTitle = "Content Publisher";
      Assert.assertEquals(ExpectedTitle, ActualTitle);
      log.info("Content Publisher is logged in");
  }
  else  if (username.contains(usernameSimple)) {
      WebElement header = driver.findElement(By.xpath("//div[@class='sc-kIlzlo fepCUl']/div[@class='css-1dbjc4n r-z6ln5t']/*[contains(text(),'About')]"));
      String ActualTitle = header.getText();
      String ExpectedTitle = "About";
      Assert.assertEquals(ExpectedTitle, ActualTitle);
      log.info("Simple user is logged in");
  }
  else  if (username.contains(usernameCFP)) {
      WebElement header = driver.findElement(By.xpath("//div[@class='column is-12 is-paddingless']/div[@class='css-1dbjc4n r-z6ln5t']/*[contains(text(),'App Profile Admin')]"));
      String ActualTitle = header.getText();
      String ExpectedTitle = "App Profile Admin";
      Assert.assertEquals(ExpectedTitle, ActualTitle);
      log.info("App Profile Admin is logged in");

  }
    }
}
