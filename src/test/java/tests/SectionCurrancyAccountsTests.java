package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.CurrantCurrancyAccountPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class SectionCurrancyAccountsTests extends TestBase {

    @Test()
    @Title("РАЗДЕЛ СЧЕТА ВАЛЮТНЫЙ СЧЕТ - Информация по счету")
    public void informationFromCurrancyAccount() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.840.6.00001814010']", 170);
        MainPage mainPage = new MainPage(app.driver);
        CurrantCurrancyAccountPage currantСurrencyAccountPage = new CurrantCurrancyAccountPage(app.driver);
        currantСurrencyAccountPage.testCheckCreatePayment(true,"1.11", "usd", "TICS", "C:\\Users\\ABagaev\\Downloads\\", "AutotestTestPayCurrancy", "Test1", "TCAPCAT1XXX","test");
        mainPage.openTabMainPage("счета");
        checkElementOnDisplay("//div[text()='AutotestTestPayCurrancy']");
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("РАЗДЕЛ СЧЕТА ВАЛЮТНЫЙ СЧЕТ - Реквизиты")
    public void informationFromTransitionCurrancyAccount() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.840.7.00001814020']", 170);
        MainPage mainPage = new MainPage(app.driver);
        CurrantCurrancyAccountPage currantСurrencyAccountPage = new CurrantCurrancyAccountPage(app.driver);
        currantСurrencyAccountPage.testCheckCreatePaymentTransition(true,"40702.840.7.00001814020", "AutotestTestPayCurrancy", "AutotestTestPayCurrancy", "test");
        mainPage.openTabMainPage("Счета");
        mainPage.checkCreateTemplate("AutotestTestTransitionPayCurrancy", "40702810700350001998");
        mainPage.logOut();
        app.tearDown();
    }

}
