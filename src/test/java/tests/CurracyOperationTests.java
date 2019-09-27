package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.CurrancyOperationPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomTestListener.class})
public class CurracyOperationTests extends TestBase {

    @Test

    public void testCheckConversionCurrancyCredit() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MainPage mainPage = new MainPage(app.driver);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.sleep(3000);
        mainPage.openTabMainPage("Валютные операции");
        CurrancyOperationPage currancyOperationPage = new CurrancyOperationPage(app.driver);
        currancyOperationPage.checkCurrancyOperationCredit("test", "Test1");
        mainPage.logOut();
        app.tearDown();
    }

    @Test
    public void testCheckConversionCurrancyContract() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MainPage mainPage = new MainPage(app.driver);
        MyThread.sleep(3000);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        mainPage.openTabMainPage("Валютные операции");
        CurrancyOperationPage currancyOperationPage = new CurrancyOperationPage(app.driver);
        currancyOperationPage.checkCurrancyOperationContract("test", "Test1");
        mainPage.logOut();
        app.tearDown();
    }

    @Test
    public void testCheckListOfContractsRegistered() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MyThread.sleep(3000);
        TestBase.selectCompany("ООО \"ОФЛК\"");
        MyThread.sleep(3000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Валютные операции");
        CurrancyOperationPage currancyOperationPage = new CurrancyOperationPage(app.driver);
        currancyOperationPage.checkListOfContractsRegistered("Test1","test", "01.09.2013", "30.01.2014");
        mainPage.logOut();
        app.tearDown();
    }

    @Test
    public void testCheckForeignCurrencyIncomeRegister() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MyThread.sleep(3000);
        TestBase.selectCompany("ООО \"ФИНПРОМ\"");
        MyThread.sleep(3000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Валютные операции");
        CurrancyOperationPage currancyOperationPage = new CurrancyOperationPage(app.driver);
        currancyOperationPage.checkForeignCurrencyIncomeRegister("59957", "01.09.2013", "30.06.2019", "NTodua", "testdbo");
        mainPage.logOut();
        app.tearDown();
    }

    @Test
    public void testCheckForeignRubIncomeRegister() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MyThread.sleep(3000);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.sleep(3000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Валютные операции");
        CurrancyOperationPage currancyOperationPage = new CurrancyOperationPage(app.driver);
        currancyOperationPage.checkForeignRubIncomeRegister("Test1","test", "01.09.2019", "30.09.2019", "5620");
        mainPage.logOut();
        app.tearDown();
    }

}
