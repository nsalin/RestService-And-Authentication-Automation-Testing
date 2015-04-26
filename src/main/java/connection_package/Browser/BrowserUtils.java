package connection_package.Browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by Alin on 4/25/2015.
 */
public class BrowserUtils {

    public static void getAddress(WebDriver driver,String URL) {

        driver.get(URL);
    }


    public static void closeChromeDriverConnection(WebDriver driver) {

       driver.close();
    }

    public static void quitChromeDriverConnection(WebDriver driver) {

        driver.quit();
    }
}
