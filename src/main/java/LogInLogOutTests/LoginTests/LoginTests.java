package LogInLogOutTests.LoginTests;

import CommonUtils.Constants;
import CommonUtils.Logging;
import CommonUtils.MessageConstants;
import CommonUtils.Utils;
import ConnectionPackage.Browser.BrowserConnection;
import LogInLogOutTests.Common_Login;
import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Alin on 5/3/2015.
 */
public class LoginTests {
    private static final Logger LOGGER = Logger.getLogger(LoginTests.class);
    Logging logging = new Logging();

    @Before
    public void setUp() {
        BrowserConnection.startBrowser(BrowserConnection.Browser.CHROME);
        BrowserConnection.driver.get(Constants.urlLoginAddress);

        //Maximize browser window
        BrowserConnection.driver.manage().window().maximize();
    }

    @Test
    public void testCorrectPasswordAndUserName() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.CorrectUserCorrectPassword);
                loginDetails.loginDetails();
                String successMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.successLoginMessage, successMessage);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }

    }

    @Test
    public void testEmptyPasswordCorrectUser() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.EmptyPasswordCorrectUser);
                loginDetails.loginDetails();
                String errorMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.errorMessagePassword, errorMessage);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }

    }

    @Test
    public void testEmptyUserAndPassword() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.EmptyUserEmptyPassword);
                loginDetails.loginDetails();
                Utils.waitTime(2);
                String errorMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.errorMessageUser, errorMessage);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }
    }

    @Test
    public void testEmptyUserCorrectPassword() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.EmptyUserCorrectPassword);
                loginDetails.loginDetails();
                String errorMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.errorMessageUser, errorMessage);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }

    }

    @Test
    public void testIncorrectPasswordCorrectUser() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.CorrectUserIncorrectPassword);
                loginDetails.loginDetails();
                String errorMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.errorMessagePassword, errorMessage);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }
    }

    @Test
    public void testIncorrectUserCorrectPassword() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.IncorrectUserCorrectPassword);
                loginDetails.loginDetails();
                String errorMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.errorMessageUser, errorMessage);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }
    }

    @Test
    public void testIncorrectUserAndPassword() {
        try {
            if (LoginForm.getLoginForm()) {
                //login action
                LoginDetails loginDetails = new LoginDetails(LoginDetails.LoginOptions.IncorrectUserIncorrectPassword);
                loginDetails.loginDetails();
                String errorMessage = Common_Login.getDivFlashMessage();
                Assert.assertEquals(MessageConstants.errorMessageUser, errorMessage);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }

    }

    @Test
    public void tstLogOut() {
        try {

            String mainTitleElementText = BrowserConnection.driver.findElement(By.xpath("//div[@class='example']/h2")).getText();
            String mainTitle = "Secure Area";
            String messageFlash;

            if (!mainTitle.contains(mainTitleElementText)) {
                testCorrectPasswordAndUserName();
            }

            WebElement logOutButton = BrowserConnection.driver.findElement(By.xpath("//a[@class='button secondary radius']"));
            logOutButton.click();
            Utils.waitTime(5);
            messageFlash = Common_Login.getDivFlashMessage();
            Assert.assertThat(MessageConstants.succesLogOutMessage, CoreMatchers.containsString(messageFlash));

        } catch (Exception ex) {
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }
    }

    @After
    public void teatDown() {
        BrowserConnection.driver.quit();
    }
}
