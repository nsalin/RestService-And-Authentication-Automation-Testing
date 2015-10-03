package ConnectionPackage.Browser;

import CommonUtils.Constants;
import CommonUtils.Logging;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


/**
 * Created by Alin on 4/25/2015.
 */
public class BrowserConnection {

    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(BrowserConnection.class);
    public enum Browser {
        CHROME, FIREFOX, OPERA, SAFARI, INTERNET_EXPLORER
    }
    public static void startBrowser (Browser browser) {

        Logging logging = new Logging();
        try {
            switch (browser) {
                case CHROME:
                    String chromeDriverPath = Constants.browserDriverResource + "chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case OPERA:
                    String IEDriverPath = Constants.browserDriverResource + "IEDriverServer.exe";
                    System.setProperty("webdriver.ie.driver", IEDriverPath);
                    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                    caps.setCapability(
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                            true);
                    driver = new InternetExplorerDriver(caps);
                    break;
                case SAFARI:
                    String operaDriverPath = Constants.browserDriverResource + "operadriver.exe";
                    System.setProperty("webdriver.opera.driver", operaDriverPath);
                    driver = new OperaDriver();
                    break;
                case INTERNET_EXPLORER:
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
