package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.ForgetPasswordPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class AutorizationTests extends TestBase {

    @Test()
    @Title("Вход в приложение")
    public void testLogIn() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        MainPage mainPage = new MainPage(app.driver);
        checkElementOnDisplay("//*[@class='icon-logout']");
     //   MyThread.sleep(7000);
        mainPage.logOut();
        waitLoadPage(25);
        app.tearDown();
    }

    @Test()
    @Title("Попытка входа в приложение - неправильный юзер, правильный пароль")
    public void testLogOffNotUserAndPassword() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test", "Password1");
        MyThread.waitVisibleElement("//*[@class='login__error__message hide-alert' and text()='Неверные имя пользователя или пароль']", 100);
        app.tearDown();
    }

    @Test()
    @Title("Попытка входа в приложение - юзер отсутствует, неправильный пароль")
    public void testLogOffUserNotPassword() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "123");
        MyThread.waitVisibleElement("//*[@class='login__error__message hide-alert' and text()='Неверные имя пользователя или пароль']", 100);
        app.tearDown();
    }

    @Test()
    @Title("Попытка входа в приложение - юзер отсутствует")
    public void testLogOffUserNotUser() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "22");
        MyThread.waitVisibleElement("//*[@class='login__error__message hide-alert' and text()='Неверные имя пользователя или пароль']", 100);
        app.tearDown();
    }

    @Test()
    @Title("Попытка входа в приложение - юзер отсутствует, правильный пароль")
    public void testLogOffUserNotUserYesPassword() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("ABVGDY", "Password1");
        MyThread.waitVisibleElement("//*[@class='login__error__message hide-alert' and text()='Неверные имя пользователя или пароль']", 100);
        app.tearDown();
    }

    @Test()
    @Title("Восстановление пароля - проверка аллерта о звонке в банк")
    public void testRecoveryPasswordAllert() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.forgetLogin();
        MyThread.sleep(2000);
        click("//div[@data-test='recovery-passport-form--no-phone']");
        MyThread.sleep(2000);
        checkElementOnDisplay("//*[@class='recovery_body']/*[@class='recovery_info textCenter']"); // Проверка алерта - Забыли логин или пароль?
        click("//*[@class='login__form__button_recovery login__form__button_recoveryConnect']//*[text()='Закрыть']");
        checkElementOnDisplay("//*[@class='textfield__placeholder' and text()='Логин']");
        app.tearDown();
    }

    @Test()
    @Title("Восстановление пароля")
    public void testRecoveryPasswordFromNumberPhone() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.forgetLogin();
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(app.driver);
        forgetPasswordPage.forgetPasswordFromPhoneNumber("9999999999", "5208", "757414", "Test1", "Password1", "test");
        waitLoadPage(30);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        MainPage mainPage = new MainPage(app.driver);
        checkElementOnDisplay("//*[@class='icon-logout']");
        //MyThread.sleep(7000);
        mainPage.logOut();
        waitLoadPage(25);
        app.tearDown();
    }

    @Test()
    @Title("Восстановление пароля ошибочный паспорт")
    public void testRecoveryPasswordErrorPassport() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.forgetLogin();
        MyThread.sleep(2000);
        click("//*[@class='textfield__placeholder textfield__placeholder_recovery' and text()='Номер телефона']");
        app.driver.findElement(By.xpath("//*[@class='textfield__input textfield__input_recovery inputUserPhone autofocus']")).sendKeys("0000000000");
        click("//*[@class='textfield__placeholder textfield__placeholder_recovery' and text()='Серия']");
        app.driver.findElement(By.xpath("//*[@class='textfield__input textfield__input_recovery inputPassportSeries autofocus']")).sendKeys("4508");
        click("//*[@class='textfield__placeholder textfield__placeholder_recovery' and text()='Номер']");
        app.driver.findElement(By.xpath("//*[@class='textfield__input textfield__input_recovery inputPassportNumber autofocus']")).sendKeys("257358");
        click("//*[@class='login__form__button_recovery login__form__button_recoveryPassport']/*[text()='Продолжить']");
        waitloadElement(10);
        checkElementOnDisplay("//*[@class='error_block' and @style='display: block;']");
        app.tearDown();
    }
}
