package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.AccountsPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class SectionRubAccountsTests extends TestBase {

    @Test()
    @Title("РАЗДЕЛ СЧЕТА РУБЛЕВЫЙ СЧЕТ - Информация по счету")
    public void informationFromAccount() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.9.00009352000']", 170);
        MyThread.sleep(2000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.checkElementsOnMainPage();
        waitLoadPage(30);
        clickAccount("40702.810.9.00009352000");
        waitloadElement(10);
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.checkInformationFromAccount();
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("РАЗДЕЛ СЧЕТА РУБЛЕВЫЙ СЧЕТ - Реквизиты")
    public void accountRequisites() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.9.00009352000']", 170);
        MyThread.sleep(2000);
        clickAccount("40702.810.9.00009352000");
        waitloadElement(10);
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.checkRequisitsFromAccount();
        accountsPage.sendingOnEmailRequisits("www.abagaev@lockobank.ru");
        MainPage mainPage = new MainPage(app.driver);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("РАЗДЕЛ СЧЕТА РУБЛЕВЫЙ СЧЕТ - Кнопка Создать платеж,Заполнение Платежного поручения")
    public void checkFormPaymentOrder() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.sleep(3000);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.checkErrorRequiredFields();
        MainPage mainPage = new MainPage(app.driver);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("РАЗДЕЛ СЧЕТА РУБЛЕВЫЙ СЧЕТ - Кнопка Создать платеж, Форма подтверждения платежного поручения")
    public void checkPaymentOrder() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.chechPaymentOrder(true, "100");
        accountsPage.chechInn(true, "8");
        accountsPage.checkRecipientName(true, "ООО \"АРДИАЙ ГРУП\"");
        MainPage mainPage = new MainPage(app.driver);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("РАЗДЕЛ СЧЕТА РУБЛЕВЫЙ СЧЕТ - Проверка платежной формы")
    public void checkPayForm() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.checkPayForm(true, "2");
        MainPage mainPage = new MainPage(app.driver);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("РАЗДЕЛ СЧЕТА РУБЛЕВЫЙ СЧЕТ - Проверка Создания ")
    public void checkCreatePayAndTemplate() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.chechFormPayInstruction(true,"5406299616", "1.11", "Autotest125", "Test1", "Autotest Autotest 544","test");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.9.00009352000']", 170);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.checkCreateTemplate("Autotest125", "40101810900000010001");
        MyThread.sleep(2000);
        clickAccount("40702.810.9.00009352000");
        waitloadElement(10);
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        accountsPage.checkPaymentsInAccount("Autotest Autotest 544");
        mainPage.logOut();
        app.tearDown();
    }
}
