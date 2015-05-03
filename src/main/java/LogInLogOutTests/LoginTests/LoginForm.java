package LogInLogOutTests.LoginTests;

import CommonUtils.Logging;
import ConnectionPackage.Browser.BrowserConnection;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Created by Alin on 5/2/2015.
 */
public class LoginForm {
    private static final Logger LOGGER = Logger.getLogger(LoginForm.class);
    public static boolean getLoginForm(){
        Logging logging = new Logging();
        boolean isLogin = false;
        try {
            if (BrowserConnection.driver.findElement(By.id("login")).isDisplayed()) {
                isLogin = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }

        return isLogin;
    }
}

