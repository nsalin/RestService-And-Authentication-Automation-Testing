package LogInLogOutTests;

import CommonUtils.Logging;
import CommonUtils.Utils;
import ConnectionPackage.Browser.BrowserConnection;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Created by Alin on 5/2/2015.
 */
public class Common_Login {
    private static final Logger LOGGER = Logger.getLogger(Common_Login.class);

    public static String getDivFlashMessage(){
        Logging logging = new Logging();
        String messageFlash = null;
        try{
            Utils.waitTime(1);
            messageFlash = BrowserConnection.driver.findElement(By.id("flash")).getText().split("!")[0]+"!";
        }catch (Exception ex){
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }
        return messageFlash;
    }
}
