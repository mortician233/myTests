package Utils;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;


public class EnterSms extends ApplicationManager {

    public static String get_sms(String login,String environment) throws Exception {
        URL obj = null;
        String rest = environment.toLowerCase();
        if (rest.equals("dev")) {
            obj = new URL("http://sm-svc-dev-dbo:8081/api/sms/dev?loginName=" + login);
        }
        if (rest.equals("testdbo")) {
            obj = new URL("http://sm-svc-dev-dbo:8081/api/sms/test?loginName=" + login);
        }
        if (rest.equals("test")) {
            obj = new URL("http://sm-svc-dev-dbo:8081/api/sms/test1?loginName=" + login);
        }
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String self = response.toString();
        String result = self.replaceAll("\\[|\\]", "");
        System.out.println("Value of result: " + result);
        Gson parser = new Gson();
        ArrayList list = parser.fromJson(response.toString(), ArrayList.class);
        System.out.print("Value of list is: " + list);
        Object map = list.get(0);
        Map map1 = ((Map) map);
        String code = (String) map1.get("code");
        return code;
    }

    public static void enter_sms(String currantLogin,String environment) {
        WebDriverWait waiter = new WebDriverWait(driver, 50);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("sms_body"))));
        MyThread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='textfield textfield_sms']")).click();
        MyThread.sleep(1000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        WebElement sms_code = driver.findElement(By.className("sms_body"));
        sms_code.findElement(By.id("Username")).sendKeys(code_enter);
        MyThread.sleep(6000);
        driver.findElement(By.cssSelector("[class='login__form__button_sms_enter']")).click();
    }

    public static void enter_sms_pp(String currantLogin,String environment) {
        MyThread.sleep(3000);
        WebDriverWait waiter = new WebDriverWait(driver, 50);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("control-group"))));
        driver.findElement(By.className("control-group")).click();
        MyThread.sleep(1000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.cssSelector("[data-test='sms--input-small']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(), \"Подтвердить\")]")).click();
    }

    public static void enter_sms_cancel_operation(String currantLogin,String environment) {
        MyThread.sleep(6000);
        WebDriverWait waiter = new WebDriverWait(driver, 50);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='sms__control']"))));
        driver.findElement(By.xpath("//div[@class='sms__control']")).click();
        MyThread.sleep(1000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.cssSelector("[data-test='sms--input-small']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(), \"Отозвать операцию\")]")).click();
    }


    public static void enter_sms_currancy_Operation(String currantLogin,String environment) {
        MyThread.sleep(6000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.xpath("//app-popup-message[@class='ng-star-inserted']//input[@data-test='sms--input-big']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//app-popup-message[@class='ng-star-inserted']//button[@data-test='sms--action-submit-big']//span[contains(text(), \"Подтвердить операцию\")]")).click();
    }

    public static void enter_sms_currancy_Operation_Rub(String currantLogin,String environment) {
        MyThread.sleep(6000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.xpath("//input[@data-test='sms--input-big']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//button[@data-test='sms--action-submit-big']//span[contains(text(), \"Подтвердить операцию\")]")).click();
    }

    public static void enter_sms_send_letter(String currantLogin,String environment) {
        MyThread.sleep(6000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.xpath("//modal[@id='submitSendMessage']//input")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//modal[@id='submitSendMessage']//span[contains(text(), \"Подтвердить операцию\")]")).click();
    }

    public static void enter_sms_sale_currancy(String currantLogin,String environment) {
        MyThread.sleep(6000);
        WebDriverWait waiter = new WebDriverWait(driver, 50);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='sms__control']"))));
        driver.findElement(By.xpath("//div[@class='sms__control']")).click();
        MyThread.sleep(1000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.cssSelector("[data-test='sms--input-small']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='sold-valute']//span[contains(text(), \"Подтвердить операцию\")]")).click();
    }

    public static void enter_sms_sale_currancy_confirmsms_sale_currancy(String currantLogin,String environment) {
        MyThread.sleep(6000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        driver.findElement(By.xpath("//*[@class='sold-valute__message']//*[@class='control__input ng-untouched ng-pristine ng-invalid']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='sold-valute']//span[contains(text(), \"Подтвердить операцию\")]")).click();
    }

    public static void enter_sms_sale_currancy_confirmsms_coversion_currancy(String currantLogin,String environment) {
        MyThread.sleep(10000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        MyThread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-test='sms--input-small']")).clear();
        driver.findElement(By.xpath("//input[@data-test='sms--input-small']")).click();
        driver.findElement(By.xpath("//input[@data-test='sms--input-small']")).sendKeys(code_enter);
        MyThread.sleep(3000);
        driver.findElement(By.xpath("//modal[@id='valuteConversion']//span[text()='Подтвердить операцию']")).click();
    }

    public static void enter_sms_lp(String currantLogin,String environment) {
        WebDriverWait waiter = new WebDriverWait(driver, 50);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='sms_recovery_first closeSelector']"))));
        MyThread.sleep(4000);
        driver.findElement(By.xpath("//*[@class='first-sms-password']//*[@class='textfield__placeholder textfield__placeholder_sms']")).click();
        MyThread.sleep(1000);
        String code_enter = null;
        try {
            code_enter = get_sms(currantLogin,environment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Value of code_enter: " + code_enter);
        WebElement sms_code = driver.findElement(By.xpath("//*[@class='sms_recovery_first closeSelector']"));
        sms_code.findElement(By.xpath("//*[@class='textfield__input textfield__input_sms textfield__input_sms_recoveryFirst autofocus']")).sendKeys(code_enter);
        MyThread.sleep(5000);
        driver.findElement(By.xpath("//*[@data-test='recovery-sms-form--submit']")).click();
    }
}