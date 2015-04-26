package connection_package.Browser;

import abstract_classes.Abstract_BrowserConnection;
import common_utils.Logging;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by Win81 on 4/25/2015.
 */
public class BrowserConnectionREST extends Abstract_BrowserConnection{
    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(BrowserConnectionLogin.class);
    public static void startBrowser () {

        Logging logging = new Logging();
        try{
            /*ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File("src\\main\\resources\\crx_extension\\rest_client.crx"));
            String chromeDriverPath = new File("src\\main\\resources\\browsers\\chromedriver.exe").getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeDriver driver = new ChromeDriver(options);
*/

            File file = new File("src\\main\\resources\\crx_extension\\rest_client.xpi");
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.addExtension(file);
            firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.8.1"); // Avoid startup screen
            WebDriver driver = new FirefoxDriver(firefoxProfile);
        }catch (Exception ex){
            logging.debug(LOGGER,ex.getMessage());
        }
    }
}
