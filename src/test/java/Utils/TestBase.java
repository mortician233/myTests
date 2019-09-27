package Utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();


    public static void click(String xpath) {
        try {
            MyThread.sleep(1000);
            app.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            app.driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
            app.driver.findElement(By.xpath(xpath)).click();
        }
        catch (Exception w){
            MyThread.sleep(1000);
            WebElement element = app.driver.findElement(By.xpath(xpath));
            JavascriptExecutor executor = (JavascriptExecutor)app.driver;
            app.driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
            app.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            ((JavascriptExecutor) app.driver).executeScript("arguments[0].scrollIntoView(true);", element);
            executor.executeScript("arguments[0].click();", element);
        }
    }
/*
    public static void click(String xpath) {
           WebElement element = app.driver.findElement(By.xpath(xpath));
           if(Selenide.element(element).is(hidden)){
               MyThread.sleep(3000);
               ((JavascriptExecutor) app.driver).executeScript("arguments[0].scrollIntoView(true);", element);
               Selenide.element(element).click();
           } else {
               MyThread.sleep(1000);
               ((JavascriptExecutor) app.driver).executeScript("arguments[0].scrollIntoView(true);", element);
               Selenide.element(element).click();
           }
        }

    public static void clickElement(WebElement element) {
        if(Selenide.element(element).is(hidden)){
            MyThread.sleep(3000);
            ((JavascriptExecutor) app.driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Selenide.element(element).click();
        } else {
            MyThread.sleep(1000);
            ((JavascriptExecutor) app.driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Selenide.element(element).click();
        }
    }
*/

    public static void waitLoadPage(int seconds) {
        app.driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
    }

    public static void waitloadElement(int seconds) {
        app.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void selectCompany(final String company){
        click("//div[@class='management__name_company']");
        MyThread.sleep(2000);
        app.driver.findElement(By.xpath("//div[@class='company-tooltip-title' and text()='" + company + "']")).click();
    }


    public static void checkElementOnDisplay(String xpathElement) {
        app.driver. findElement(By.xpath(xpathElement)).isDisplayed();
    }

    public void logOut() {
        click("//*[@class='icon-logout']");
    }

    public void tearDown() {
        app.tearDown();
    }

    public boolean assertElementPresent(String xpathElement) throws IllegalArgumentException {
        List<WebElement> sizeElement = app.driver.findElements(By.xpath(xpathElement));
        if (sizeElement.size() == 0) {
            System.out.println("Element not displayed = " + xpathElement);
            return true;
        } else {
            System.out.println("Element is displayed = " + xpathElement);
            return false;
        }
    }
    public static void clickElement(WebElement element) {
        try{
            MyThread.sleep(1000);
            app.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            app.driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
            element.click();
        } catch (Exception w){
            MyThread.sleep(1000);
            JavascriptExecutor executor = (JavascriptExecutor)app.driver;
            app.driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
            app.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            ((JavascriptExecutor) app.driver).executeScript("arguments[0].scrollIntoView(true);", element);
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public static void saveScreenShot(WebDriver webDriver, final String nameTest) {
        File f1 = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            String file = "C:\\lockobank_tests\\screenshots\\" + nameTest + "_" +
                    System.currentTimeMillis() + ".png";
            Files.copy(new FileInputStream(f1), Paths.get(file), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        boolean found = false;
        File[] dirContents = dir.listFiles();
        File f = null;
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().matches(fileName)) {
                f = new File(fileName);
                found =true;
            }
        }
        MyThread.sleep(2000);
        Assert.assertTrue(found,"Downloaded document is not found");
        if(f.delete()) //{   }
            System.out.println("File deleted successfully");
        }

        public static void switchWindows() {
            String originalWindow = app.driver.getWindowHandle();
            final Set<String> oldWindowsSet = app.driver.getWindowHandles();

            app.driver.findElement(By.tagName("a")).click();

            String newWindow = (new WebDriverWait(app.driver, 10))
                    .until(new ExpectedCondition<String>() {
                               public String apply(WebDriver driver) {
                                   Set<String> newWindowsSet = driver.getWindowHandles();
                                   newWindowsSet.removeAll(oldWindowsSet);
                                   return newWindowsSet.size() > 0 ?
                                           newWindowsSet.iterator().next() : null;
                               }
                           }
                    );

            app.driver.switchTo().window(newWindow);

            System.out.println("New window title: " + app.driver.getTitle());
            app.driver.close();

            app.driver.switchTo().window(originalWindow);
            System.out.println("Old window title: " + app.driver.getTitle());
        }

        public static void clickAccount(final String Account){
            app.driver.findElement(By.xpath("//*[@class='widget__property-value' and text()='" + Account + "']")).click();
        }

        public static void checkBoxClick(WebElement element){
            if ( !element.isSelected() )
            {
                element.click();
            }
        }

    public static String get_template_name(){
        Integer template_name = null;
        int a = 1;
        int b = 999999;

        final Integer random_number = a + (int) (Math.random() * b); // Максимальное число для диапазона от 0 до max
        template_name = random_number;
        System.out.println("Template name is:");
        System.out.println(template_name);

        return String.valueOf(template_name);
    }

    public static void logInCheckEmail(){
        waitLoadPage(30);
        List<WebElement> sizeElement = app.driver.findElements(By.xpath("//div[@class='question-title' and text()='Улучшите защиту своего личного кабинета!']"));
        if (sizeElement.size() == 0) {
            waitLoadPage(30);
        } try {
           click("//div[@class='question-button' and text()='Продолжить']");
           //click("//div[@class='question-close icon-cross']");
           app.driver.findElement(By.xpath("//material-input[@name='emailValueTag']//input[@class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")).sendKeys("ABagaev@lockobank.ru");
           click("//div[@class='question-button ng-star-inserted']//span[text()='Продолжить']");
           checkElementOnDisplay("//div[@class='question-text' and text()='Для подтверждения перейдите по ссылке, направленной']//following-sibling::div[text()='на Вашу электронную почту.']");
           click("//div[@class='question-close icon-cross']");
           waitLoadPage(30);
        } catch(WebDriverException e){
            click("//div[@class='question-number' and text()='1']//following::div[@class='icon-triangle-down']");
            MyThread.sleep(1000);
            click("//li[text()='Ваш любимый цвет?']");
            app.driver.findElement(By.xpath("//div[@class='question-number' and text()='1']//following::input[@data-test='material-input']")).sendKeys("AT");
            click("//div[@class='question-number' and text()='2']//following::div[@class='icon-triangle-down']");
            MyThread.sleep(1000);
            click("//li[text()='Номер школы, в которой вы учились?']");
            app.driver.findElement(By.xpath("//div[@class='question-number' and text()='2']//following::input[@data-test='material-input']")).sendKeys("AT");
            click("//div[@class='question-number' and text()='3']//following::div[@class='icon-triangle-down']");
            MyThread.sleep(1000);
            click("//li[text()='Кличка вашего домашнего животного?']");
            app.driver.findElement(By.xpath("//div[@class='question-number' and text()='3']//following::input[@data-test='material-input']")).sendKeys("AT");
            click("//div[@class='question-number' and text()='4']//following::div[@class='icon-triangle-down']");
            click("//li[text()='Любимая музыкальная группа?']");
            app.driver.findElement(By.xpath("//div[@class='question-number' and text()='4']//following::input[@data-test='material-input']")).sendKeys("AT");
            MyThread.sleep(1000);
            click("//div[@class='question-button' and text()='Продолжить']");
            waitLoadPage(30);
        }
    }

    public static void logInCheckCodeWord(){
        waitLoadPage(30);
        List<WebElement> sizeElement = app.driver.findElements(By.xpath("//div[@class='question-title-word' and text()='Придумайте и запомните']"));
        if (sizeElement.size() == 0) {
            waitLoadPage(30);
        } else {
            click("//div[@class='question-back-word' and text()='Отказаться']");
            waitLoadPage(30);
        }
    }

}

