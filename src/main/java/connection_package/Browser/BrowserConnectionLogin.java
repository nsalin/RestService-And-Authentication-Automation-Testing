package connection_package.Browser;

import abstract_classes.Abstract_BrowserConnection;
import common_utils.Logging;
import com.opera.core.systems.OperaDesktopDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;


/**
 * Created by Alin on 4/25/2014.
 */
public class BrowserConnectionLogin extends Abstract_BrowserConnection {

    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(BrowserConnectionLogin.class);
    public static void startBrowser (String browser) {

        Logging logging = new Logging();
        try {
            switch (browser) {
                case "chrome":
                    String chromeDriverPath = new File("src\\main\\resources\\browsers\\chromedriver.exe").getAbsolutePath();
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "IE":
                    driver = new InternetExplorerDriver();
                    break;
                case "opera":
                    driver = new OperaDesktopDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    String message = "This browser type is not supporter. Please use one of the following: " +
                            "Google Chrome -> chrome\nMozzila Firefox -> firefox\nInternet Explorer -> IE\nOpera -> opera" +
                            "Safari -> safari";
                    System.err.println(message);
                    logging.info(LOGGER,message);
            }
        }
        catch (Exception ex){
            logging.debug(LOGGER,ex.getMessage());
        }
    }



}
