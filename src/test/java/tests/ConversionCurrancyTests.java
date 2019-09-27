package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.ConversionCurrancyPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class ConversionCurrancyTests extends TestBase {

    @Test
    @Title("Проверка обмена валюты")
    public void testCheckConversionCurrancy() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.sleep(4000);
        MyThread.waitVisibleElement("//*[@routerlink='/conversion' and text()='Обменять валюту']", 190);
        MainPage mainPage = new MainPage(app.driver);
        click("//*[@routerlink='/conversion' and text()='Обменять валюту']");
        ConversionCurrancyPage conversionCurrancyPage = new ConversionCurrancyPage(app.driver);
        conversionCurrancyPage.checkConversionCurrancy("11.01","test");
        mainPage.openTabMainPage("Счета");
        checkElementOnDisplay("//div[text()='ООО \"АКАДЕМСЕРВИС\"']//following::div[text()='–11 ']//sup[text()='01']");
        mainPage.logOut();
        app.tearDown();
    }
}
