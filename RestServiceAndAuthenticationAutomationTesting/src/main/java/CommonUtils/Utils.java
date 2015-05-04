package CommonUtils;


import ConnectionPackage.Browser.BrowserConnection;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alin on 4/25/2015.
 */
public class Utils {

    public static String getFullClassName(Class className) {

        return className.getName();
    }

    public static String getOnlyClassName(Class className) {

        return className.getSimpleName();
    }

    public static void switchTab(int tabIndex) {

        ArrayList<String> tabs = new ArrayList<String>(BrowserConnection.driver.getWindowHandles());

        BrowserConnection.driver.switchTo().window((tabs.get(tabIndex)));
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

    public static String readFile(String filePath) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String fileReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fileReader = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileReader;
    }

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public static void waitTime(Integer seconds){
        Integer miliseconds = seconds * 1000;
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getMethodResult(String failOrPass){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return methodName + " " + failOrPass;
    }

}


