package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.CreditPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class CreditsTests extends TestBase {

    @Test()
    @Title("Проверка вкладки - Кредит")
    public void testCheckCredit() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.9.00009352000']", 170);
        MyThread.sleep(2000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.openTabMainPage("Кредиты");
        CreditPage creditPage = new CreditPage(app.driver);
        creditPage.checkPageCredit(true,"2015-Ф2Р/114");
        waitloadElement(10);
        mainPage.logOut();
        app.tearDown();
    }
}

