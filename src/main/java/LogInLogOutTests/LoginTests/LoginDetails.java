package LogInLogOutTests.LoginTests;

import CommonUtils.Logging;
import ConnectionPackage.Browser.BrowserConnection;
import LogInLogOutTests.LoginParser.JSONLoginReader;
import LogInLogOutTests.LoginParser.JSONUserMapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Alin on 5/2/2015.
 */
public class LoginDetails {
    private static final Logger LOGGER = Logger.getLogger(LoginDetails.class);

    public enum LoginOptions{
        CorrectUserCorrectPassword, IncorrectUserCorrectPassword, CorrectUserIncorrectPassword,
        IncorrectUserIncorrectPassword, EmptyUserCorrectPassword, EmptyPasswordCorrectUser, EmptyUserEmptyPassword
    }

    LoginOptions loginOptions;

    public LoginDetails(LoginOptions loginOptions) {
        this.loginOptions = loginOptions;

    }


    public void loginDetails() {
        WebElement userNameInput = BrowserConnection.driver.findElement(By.id("username"));
        WebElement passwordInput = BrowserConnection.driver.findElement(By.id("password"));
        WebElement submitButton = BrowserConnection.driver.findElement(By.xpath("//button[@type='submit']"));
        JSONLoginReader.jsonParserLogin("login.json");
        JSONUserMapper jsonLoginMapper = new JSONUserMapper();
        Logging logging = new Logging();

        userNameInput.clear();
        passwordInput.clear();
        try{
            switch (loginOptions){
                case CorrectUserCorrectPassword:
                    userNameInput.sendKeys(jsonLoginMapper.getUser());
                    passwordInput.sendKeys(jsonLoginMapper.getPassword());
                    break;
                case IncorrectUserCorrectPassword:
                    userNameInput.sendKeys("incorrect");
                    passwordInput.sendKeys(jsonLoginMapper.getPassword());
                    break;
                case CorrectUserIncorrectPassword:
                    userNameInput.sendKeys(jsonLoginMapper.getUser());
                    passwordInput.sendKeys("incorrect");
                    break;
                case IncorrectUserIncorrectPassword:
                    userNameInput.sendKeys("incorrect");
                    passwordInput.sendKeys("incorrect");
                    break;
                case EmptyUserCorrectPassword:
                    userNameInput.sendKeys("");
                    passwordInput.sendKeys(jsonLoginMapper.getPassword());
                    break;
                case EmptyPasswordCorrectUser:
                    userNameInput.sendKeys(jsonLoginMapper.getUser());
                    passwordInput.sendKeys("");
                    break;
                case EmptyUserEmptyPassword:
                    userNameInput.sendKeys("");
                    passwordInput.sendKeys("");
                    break;
                default:
                    System.out.println("This test name doesn't exists !");
            }
            submitButton.click();

        }catch(Exception ex){
            ex.printStackTrace();
            logging.debug(LOGGER,ex.getMessage());
        }

    }
}

