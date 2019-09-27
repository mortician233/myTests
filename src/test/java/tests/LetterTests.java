package tests;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.LetterPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class LetterTests extends TestBase {

    @Test
    @Description("Входящие письма")
    public void testCheckInboxLetter() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MainPage mainPage = new MainPage(app.driver);
        waitLoadPage(15);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.sleep(2000);
        mainPage.interedLetter();
        LetterPage letterPage = new LetterPage(app.driver);
        letterPage.chechInboxLetter("Test1","test", "входящие");
        mainPage.logOut();
        app.tearDown();
    }

    @Test
    @Description("Исходящие письма")
    public void testCheckOutboxLetter() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MainPage mainPage = new MainPage(app.driver);
        waitLoadPage(15);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.sleep(2000);
        mainPage.interedLetter();
        LetterPage letterPage = new LetterPage(app.driver);
        letterPage.chechOutboxLetter("исходящие");
        mainPage.logOut();
        app.tearDown();
    }

    @Test
    @Description("Исходящие письма")
    public void testCheckАDraftLetter() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MainPage mainPage = new MainPage(app.driver);
        waitLoadPage(15);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.sleep(2000);
        mainPage.interedLetter();
        LetterPage letterPage = new LetterPage(app.driver);
        letterPage.chechDraftLetter("входящие");
        mainPage.logOut();
        app.tearDown();
    }
}
