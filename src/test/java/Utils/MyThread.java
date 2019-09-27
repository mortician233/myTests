package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyThread extends ApplicationManager {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scroll(String search_element) {
        try {
            WebElement element = driver.findElement(By.xpath(search_element));
            new Actions(driver).moveToElement(element).moveToElement((WebElement) By.xpath(search_element));
        } catch(ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void waitVisibleElement(String xpath, int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

}


