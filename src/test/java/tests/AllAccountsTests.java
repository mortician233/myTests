package tests;

import Utils.CustomTestListener;
import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.AccountsPage;
import lockobank.CurrentRurAccountPage;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.FileNotFoundException;

@Listeners({CustomTestListener.class})
public class AllAccountsTests extends TestBase {

    @Test()
    @Title("Проверка формы платежа")
    public void commonPayments() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        //MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        TestBase.selectCompany("ООО \"АРДИАЙ ГРУП\"");
        MyThread.sleep(3000);
        mainPage.checkElementsOnMainPage();
        mainPage.clickShowAllCommonPayments();
        waitloadElement(5);
        checkElementOnDisplay("//*[@class='page-header__title']//*[text()='Частые платежи']");
        click("//*[@class='templates-list__cell' and text()='ООО \"АрДиАй\"']");
        waitloadElement(5);
        checkElementOnDisplay("//*[@class='control__text' and text()='ООО \"АРДИАЙ ГРУП\"']");
        accountsPage.closeCreatePayForm();
        waitloadElement(5);
        checkElementOnDisplay("//*[@class='page-header__title']/*[text()='Частые платежи']");
        checkElementOnDisplay("//*[@class='icon-logout']");
        waitLoadPage(25);
        mainPage.logOut();
        waitLoadPage(25);
        app.tearDown();
    }


    @Test()
    @Title("Проверка формы шаблона")
    public void commonTemplate() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        MainPage mainPage = new MainPage(app.driver);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(3000);
        mainPage.clickShowAllСommonTemplates();
        MyThread.sleep(3000);
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        waitLoadPage(5);
        checkElementOnDisplay("//*[@class='tabs__item active' and text()='Шаблоны']");
       // app.driver.findElement(By.xpath("//*[@class='tab-content active']//button[@class='button button_theme_brand ng-star-inserted']//span[@class='ng-star-inserted' and text()='Показать еще']")).click();
        //TODO исправить на название шаблона
        app.driver.findElement(By.xpath("//*[@class='templates-list__cell' and text()='ООО \"Сапсан-Недвижимость\"']")).click();
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        waitLoadPage(5);
        click("//*[@class='create-payment__save button button_theme_brand ng-star-inserted']//*[text()='Сохранить изменения']");
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        waitloadElement(5);
        checkElementOnDisplay("//*[@class='tabs__item active' and text()='Шаблоны']");
        checkElementOnDisplay("//*[@class='icon-logout']");
        waitLoadPage(25);
        mainPage.logOut();
        app.tearDown();
    }


    @Test()
    @Title("Проверка создания платежа")
    public void createPayment() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        MainPage mainPage = new MainPage(app.driver);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(3000);
        click("//*[@data-test='create-new-payment-button' and text()='Создать платёж']");
        waitloadElement(10);
        checkElementOnDisplay("//*[@class='create-payment__title-layout ng-star-inserted']/*[text()='Платежное поручение №']");
        MyThread.sleep(2000);
        click("//*[@class='button button_type_close modal__close ng-star-inserted' and @data-test='close-modal--createPayment']");
        waitloadElement(10);
        click("//*[@id=\"createPayment\"]//*[@class='button button_theme_brand' and text()='Да']");
        MyThread.sleep(4000);
        checkElementOnDisplay("//*[@class='button__1c button__1c_theme_yellow-light']");
        click("//*[@class='button__1c button__1c_theme_yellow-light']");
        waitLoadPage(10);
        checkElementOnDisplay("//*[@class='file-upload']");
        MyThread.sleep(2000);
        click("//*[@class='button button_theme_brand' and text()='Закрыть']");
        waitloadElement(10);
        MyThread.sleep(5000);
        checkElementOnDisplay("//*[@class='icon-logout']");
        waitLoadPage(25);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка валютного счета и отображение курса валют")
    public void checkUserEurAccount() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        MainPage mainPage = new MainPage(app.driver);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(3000);
        assertElementPresent("//*[@class='currency-small__item currency-small__item-center' and text()='Покупка']");//проверка наличия курсов обмена валют = is displayed
        waitloadElement(10);
        MyThread.sleep(5000);
        checkElementOnDisplay("//*[@class='icon-logout']");
        waitLoadPage(25);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка рублевого счета")
    public void checkUserRubAccount() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(30);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(3000);
        MainPage mainPage = new MainPage(app.driver);
        assertElementPresent("//*[@class='currency-small__item currency-small__item-center' and text()='Покупка']");//проверка наличия курсов обмена валют =  not displayed
        waitloadElement(10);
        MyThread.sleep(5000);
        checkElementOnDisplay("//*[@class='icon-logout']");
        waitLoadPage(25);
        mainPage.logOut();
        app.tearDown();
    }


    @Test()
    @Title("Проверка фильтра на вкладке операции")
    public void testCheckFilterOperation() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkFilterOperation();
        currentRurAccountPage.checkFilterStatus();
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Создание шаблона")
    public void testCheckTabOpetaionCreateTemplate() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOperationCreateTemplate("Test456");
        mainPage.openTabMainPage("Счета");
        MyThread.sleep(5000);
        mainPage.checkCreateTemplate("Test456", "40702810440000021798");
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Повтор платежа")
    public void testCheckTabOpetaionRetryPayment() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOpetaionRetryPayment("Test1","23.25","AutotestCreateRetryPay", "test");
        mainPage.openTabMainPage("Счета");
        MyThread.sleep(5000);
        mainPage.checkCreateTemplate("AutotestCreateRetryPay", "40702810440000021798");
        mainPage.logOut();
        app.tearDown();
    }


    @Test()
    @Title("Проверка на вкладке операции - Отправка имэйла")
    public void testCheckTabOpetaionSendEmail() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        MainPage mainPage = new MainPage(app.driver);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOpetaionSendEmail();
        MyThread.sleep(5000);
        mainPage.logOut();
        app.tearDown();
    }


    @Test()
    @Title("Проверка на вкладке выписка")
    public void testCheckTabStatment() throws FileNotFoundException {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 170);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        MyThread.sleep(2000);
        currentRurAccountPage.openTabCurrentAccountPage("Выписка");
        currentRurAccountPage.checkTabStatement("abagaev@lockobank.ru", "10.08.2019", "19.09.2019", "C:\\Users\\ABagaev\\Downloads\\");
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке лимиты")
    public void testCheckTabLimits() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.openTabCurrentAccountPage("Лимиты");
        currentRurAccountPage.checkTabLimits();
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Отозвать платеж")
    public void testCheckTabOpetaionRecallPay() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        accountsPage.chechFormPayInstruction(true,"501", "1.11", "Autotest125", "Test1", "Autotest Autotest 544","test");
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00002185000']", 170);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOpetaionRecallPay();
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Возврат платежа")
    public void testCheckTabOpetaionReturnPay() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOpetaionReturnPay("19.11", "Autotest213","Test1","AutotestReturnPay", "test");
        mainPage.openTabMainPage("Счета");
        waitLoadPage(10);
        saveScreenShot(app.driver,"testCheckTabOpetaionReturnPay");
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test(dependsOnMethods = "checkSavePayFromDraft")
    @Title("Проверка на вкладке операции - Отправить на подпись")
    public void testCheckTabOpetaionSendOnTheSignature() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(4000);
        clickAccount("40702.810.2.00002185000");
        MyThread.sleep(3000);
        waitLoadPage(20);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOpetaionSendOnTheSignature();
        saveScreenShot(app.driver,"testCheckTabOpetaionSendOnTheSignature1");
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test(dependsOnMethods = "testCheckTabOpetaionSendOnTheSignature")
    @Title("Проверка на вкладке операции - Удалить платеж")
    public void testCheckTabOpetaionDeletePay() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.checkTabOpetaionDeletePay();
        saveScreenShot(app.driver,"testCheckTabOpetaionDeletePay");
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Отправить на подпись и оплатить")
    public void testCheckTabOpetaionSignatureAndPay() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.testCheckTabOpetaionSignatureAndPay("100.12", "Test1", "test");
        saveScreenShot(app.driver,"testCheckTabOpetaionSignatureAndPay");
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Сохранить платеж -черновик")
    public void checkSavePayFromDraft() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"РА Тотал Вью\"");
        MyThread.sleep(2000);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00002185000']", 200);
        clickAccount("40702.810.2.00002185000");
        waitloadElement(10);
        CurrentRurAccountPage currentRurAccountPage = new CurrentRurAccountPage(app.driver);
        currentRurAccountPage.testCheckSavePayFromDraft();
        saveScreenShot(app.driver,"testCheckSavePayFromDraft");
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

    @Test()
    @Title("Проверка на вкладке операции - Сохранить платеж -черновик")
    public void testCheckSignatureFirstAndSecond() {
        app.start_browser();
        waitLoadPage(15);
        app.settingBrowserTest();
        waitloadElement(10);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Test1", "Password1");
        EnterSms.enter_sms("Test1","test");
        waitLoadPage(40);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        AccountsPage accountsPage = new AccountsPage(app.driver);
        MainPage mainPage = new MainPage(app.driver);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.sleep(2000);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00001814000']", 200);
        clickAccount("40702.810.2.00001814000");
        MyThread.sleep(4000);
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        waitloadElement(10);
        accountsPage.checkSendSignatureSecond(false,"501", "1.11", "Autotest125", "Test1", "Autotest Autotest 544","test", "'40702.810.2.00001814000'");
        MyThread.sleep(3000);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00001814000']", 200);
        clickAccount("40702.810.2.00001814000");
        MyThread.sleep(4000);
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        waitloadElement(10);
        accountsPage.checkReturneFirstSignature(false,"501", "1.11", "Autotest125", "Test1", "Autotest Autotest 544","test", "'40702.810.2.00001814000'");
        MyThread.sleep(3000);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00001814000']", 200);
        clickAccount("40702.810.2.00001814000");
        MyThread.sleep(3000);
        click("//*[@class='button__create' and text()='Создать платёж']");
        MyThread.waitVisibleElement("//*[@class='control__input create-payment__doc-number text-center ng-untouched ng-pristine ng-valid']", 5);
        waitloadElement(10);
        accountsPage.checkSendSignatureSecond(false,"501", "1.11", "Autotest125", "Test1", "Autotest Autotest 544","test", "'40702.810.2.00001814000'");
        MyThread.sleep(3000);
        mainPage.logOut();
        MyThread.sleep(3000);
        waitLoadPage(15);
        accountsPage.checkSignatureSecondPay("Test2","Password1","test");
        MyThread.sleep(3000);
        mainPage.logOut();
        app.tearDown();
    }

}
