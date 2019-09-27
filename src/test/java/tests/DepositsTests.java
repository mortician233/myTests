package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.DepositsPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class DepositsTests extends TestBase {

    @Test()
    @Title("Проверка вкладки - Депозиты(Реквизиты)")
    public void testDepositsRequisitesCheck() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Депозиты");
        DepositsPage depositsPage = new DepositsPage(app.driver);
        depositsPage.checkRequisitesDeposit(true,"abagaev@lockobank.ru", "5.5%");
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка вкладки - Депозиты(Виджет открытого депозита)")
    public void testDepositsWidgetCheck() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Депозиты");
        DepositsPage depositsPage = new DepositsPage(app.driver);
        depositsPage.checkWidgetDeposit("5.5%");
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка вкладки - Депозиты(Открытие нового депозита)")
    public void testOpenNewDepositCheck() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Депозиты");
        DepositsPage depositsPage = new DepositsPage(app.driver);
        depositsPage.checkOpenNewDeposit();
        mainPage.logOut();
        app.tearDown();
    }
}
