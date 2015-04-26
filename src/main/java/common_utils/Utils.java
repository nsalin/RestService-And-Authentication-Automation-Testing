package common_utils;


import connection_package.Browser.BrowserConnectionLogin;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alin on 4/25/2014.
 */
public class Utils {

    public static String getFullClassName(Class className) {

        return className.getName();
    }

    public static String getOnlyClassName(Class className) {

        return className.getSimpleName();
    }

    public static void switchTab(int tabIndex) {

        ArrayList<String> tabs = new ArrayList<String>(BrowserConnectionLogin.driver.getWindowHandles());

        BrowserConnectionLogin.driver.switchTo().window((tabs.get(tabIndex)));
    }

    public static void copyToClipboard(String text) {

        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    public static void pasteFromClipboard() {

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Integer getRandomNumberFromArrayList(ArrayList arrayListName) {

        Random random = new Random();
        Integer randomNumberFromArrayList = (Integer) arrayListName.get(random.nextInt(arrayListName.size()));

        return randomNumberFromArrayList;
    }

}


