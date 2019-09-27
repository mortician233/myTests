package lockobank;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CurrancyOperationPage extends TestBase {

    @FindBy(xpath = "//button[text()='+ Кредит']")
    private WebElement buttonCredit;

    @FindBy(xpath = "//button[text()='+ Контракт']")
    private WebElement buttonContact;

    @FindBy(xpath = "//button[text()='Выгрузка в Excel']")
    private WebElement buttonDownloadExcel;

    @FindBy(xpath = "//modal[@id='createBankMessage']//div[@class='icon-triangle-down']")
    private WebElement checkboxSender;

    @FindBy(xpath = "//modal[@id='createBankMessage']//app-select[@placeholder='Получатель']//div[@class='icon-triangle-down']")
    private WebElement checkboxRecipient;

    @FindBy(xpath = "//app-popup-message[@class='ng-star-inserted']//button[@class='button button_theme_brand new-message__submit ng-star-inserted']")
    private WebElement buttonSendMessage;

    @FindBy(xpath = "//modal[@id='createBankMessage']//span[contains(text(), \"Подтвердить операцию\")]")
    private WebElement buttonConfirOperation;

    @FindBy(xpath = "//app-popup-message[@class='ng-star-inserted']//input[@data-test='sms--input-big']")
    private WebElement fieldSmsCode;

    @FindBy(xpath = "//a[@data-test='sms--new-sms-big']")
    private WebElement buttonRetrySmsCode;

    @FindBy(xpath = "//modal[@id='createBankMessage']//a[@class='button __cancel ng-star-inserted' and text()='Отмена']")
    private WebElement buttonCancel;

    @FindBy(xpath = "//div[@class='filter__item statement-period wide']//div[@class='select__trigger ng-star-inserted']")
    private WebElement dropBoxFromPeriod;

    @FindBy(xpath = "//button[@class='button button_type_search']")
    private WebElement buttonSearchFormListOfContractsRegistered;

    @FindBy(xpath = "//input[@data-pikaday='.periodFromTrigger']")
    private WebElement fieldDatePeriodFrom;

    @FindBy(xpath = "//input[@data-pikaday='.periodToTrigger']")
    private WebElement fieldDatePeriodTo;

    @FindBy(xpath = "//div[@class='filter__item thin']//following-sibling::div[@class='select__trigger ng-star-inserted']")
    private WebElement dropBoxFromStatus;

    @FindBy(xpath = "//input[@name='search_query']")
    private WebElement fieldSearchFormListOfContractsRegistered;

    @FindBy(xpath = "//button[@class='widget-info__button widget-info__button_bigger button button_theme_orange']")
    private WebElement buttonUnloadingInExcel;

    @FindBy(xpath = "//div[@tooltiptitle='Переписка с банком']")
    private WebElement buttonCorrespondenceWithBank;

    @FindBy(xpath = "//div[@tooltiptitle='Внести изменения']")
    private WebElement buttonMakeChanges;

    @FindBy(xpath = "//textarea[@class='corrMessage__textarea ng-untouched ng-pristine ng-valid']")
    private WebElement fieldMessage;

    @FindBy(xpath = "//div[@class='corrMessage__send']")
    private WebElement buttonSendMessageFormMakeChanges;

    @FindBy(xpath = "//modal[@id='createBankMessage']//button[@class='button button_theme_brand new-message__submit ng-star-inserted']")
    private WebElement buttonSendMessageFormCorrespondenceWithBank;

    @FindBy(xpath = "//div[@tooltiptitle='Создать перевод']")
    private WebElement buttonCreateTransfer;

    @FindBy(xpath = "//*[text()='Подписать и оплатить' and not(@disabled)]")
    private WebElement buttonSignAndPay;

    @FindBy(xpath = "//modal[@id='soldValute']//div[text()='Создать шаблон']//following::input[@type='checkbox']")
    private WebElement checkboxCreateTemplate;

    @FindBy(xpath = "//input[@placeholder='Имя шаблона']")
    private WebElement fieldNameTemplate;

    @FindBy(xpath = "//textarea[@placeholder='Сообщение']")
    private WebElement fieldMessageFormCurrancy;

    @FindBy(xpath = "//modal[@id='valuteConversion']//button[@class='button button_theme_brand']/span[text()='Подтвердить операцию']")
    private WebElement buttonConfirmOperationConversionPayForm;

    @FindBy(xpath = "//modal[@id='soldValute']//a[text()='Получить новый смс-код']")
    private WebElement buttonRetrySmsConversionPayForm;

    @FindBy(xpath = "//div[@class='corrMessage__send']")
    private WebElement buttonSendMessageBankFormCurrancy;

    @FindBy(xpath = "//input[@name='alertNum']")
    private WebElement fieldNotificationNumber;

    @FindBy(xpath = "//input[@name='notificationDate']")
    private WebElement fieldNotificationDate;

    @FindBy(xpath = "//input[@name='contractNumber']")
    private WebElement fieldContractNumber;

    @FindBy(xpath = "//input[@name='contractDate']")
    private WebElement fieldContractDate;

    @FindBy(xpath = "//input[@name='recordContractNumber']")
    private WebElement fieldUNKNumber;

    @FindBy(xpath = "//input[@name='transferAmount']")
    private WebElement fieldTransferForCurrentAccount;

    @FindBy(xpath = "//div[text()='Приложить документы']//following::input[@name='attachDocuments']")
    private WebElement checkboxAttachDocuments;

    @FindBy(xpath = "//modal[@id='soldValute']//textarea[@placeholder='Ваше сообщение']")
    private WebElement fieldYourMessage;

    @FindBy(xpath = "//modal[@id='createBankMessage']//button[@class='button button_theme_brand new-message__submit ng-star-inserted']")
    private WebElement buttonSendMessageFromSaleCurrancy;

    @FindBy(xpath = "//div[@tooltiptitle='Переписка с Банком']")
    private WebElement buttonCorrespondenceWithBankRubIncomeRegisterForm;

    @FindBy(xpath = "//div[@tooltiptitle='Отправка в Банки информации по операции']")
    private WebElement buttonSendingTransactionInformationToBanks;

    @FindBy(xpath = "//modal[@style='display: inline;']//input[@data-test='material-input']")
    private WebElement fieldMessageSubject;

    @FindBy(xpath = "//modal[@style='display: inline;']//textarea[@placeholder='Ваше сообщение']")
    private WebElement fieldYourMessageRubForm;

    @FindBy(xpath = "//modal[@style='display: inline;']//button[@class='button button_theme_brand new-message__submit ng-star-inserted']")
    private WebElement buttonSendingMessadgeRubForm;


    public void checkCurrancyOperationCredit(String environment, String login){
        MyThread.waitVisibleElement("//div[text()='Список контрактов, поставленных на учет']",100);
        MyThread.sleep(2000);
        click("//div[text()='Список контрактов, поставленных на учет']");
        clickElement(buttonCredit);
        MyThread.waitVisibleElement("//modal[@id='createBankMessage']//app-select[@placeholder='Получатель']//div[@class='icon-triangle-down']",100);
        MyThread.sleep(5000);
        click("//modal[@id='createBankMessage']//span[text()='ООО \"АКАДЕМСЕРВИС\"']");
        JavascriptExecutor js = (JavascriptExecutor) app.driver;
        String courseCurrancy = (js.executeScript("return document.querySelectorAll('strong[_ngcontent-c20]')[1].innerText")).toString();
        LocalDateTime ldt = LocalDateTime.now();
        Assert.assertEquals(courseCurrancy,DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        saveScreenShot(app.driver,"checkCurrancyOperationCredit");
        clickElement(buttonSendMessage);
        fieldSmsCode.sendKeys("12762");
        clickElement(buttonConfirOperation);
        MyThread.sleep(3000);
        clickElement(buttonRetrySmsCode);
        EnterSms.enter_sms_currancy_Operation(login, environment);
    }

    public void checkCurrancyOperationContract(String environment, String login){
        MyThread.sleep(2000);
        click("//div[text()='Список контрактов, поставленных на учет']");
        clickElement(buttonContact);
        MyThread.waitVisibleElement("//modal[@id='createBankMessage']//app-select[@placeholder='Получатель']//span[text()='Валютный контроль']",100);
        JavascriptExecutor js = (JavascriptExecutor) app.driver;
        String courseCurrancy = (js.executeScript("return document.querySelectorAll('strong[_ngcontent-c20]')[1].innerText")).toString();
        LocalDateTime ldt = LocalDateTime.now();
        Assert.assertEquals(courseCurrancy,DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        saveScreenShot(app.driver,"checkCurrancyOperationCredit");
        MyThread.sleep(3000);
        clickElement(buttonCancel);
        clickElement(buttonContact);
        MyThread.sleep(3000);
        clickElement(buttonSendMessage);
        fieldSmsCode.sendKeys("12762");
        clickElement(buttonConfirOperation);
        MyThread.sleep(3000);
        clickElement(buttonRetrySmsCode);
        EnterSms.enter_sms_currancy_Operation(login, environment);
    }

    public void checkListOfContractsRegistered(String login, String environment, String periodDateFrom, String periodDateTo) {
        MyThread.waitVisibleElement("//div[text()='ООО \"ОФЛК\"']",100);
        MyThread.sleep(2000);
        click("//div[text()='Список контрактов, поставленных на учет']");
        clickElement(dropBoxFromPeriod);
        click("//li[@data-test='app-select--item' and text()='За сегодня']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        clickElement(dropBoxFromPeriod);
        click("//li[@data-test='app-select--item' and text()='За период']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        fieldDatePeriodFrom.clear();
        fieldDatePeriodFrom.sendKeys(periodDateFrom);
        fieldDatePeriodTo.clear();
        fieldDatePeriodTo.sendKeys(periodDateTo);
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//div[text()='13100001/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100002/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100003/2707/0000/5/1']");
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Закрыт']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//div[text()='13100001/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100002/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100003/2707/0000/5/1']");
        clickElement(dropBoxFromStatus);
        clickElement(buttonSearchFormListOfContractsRegistered);
        click("//li[@data-test='app-select--item' and text()='Показать все']");
        checkElementOnDisplay("//div[text()='13100001/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100002/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100003/2707/0000/5/1']");
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Действует']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        saveScreenShot(app.driver,"checkListOfContractsRegistered");
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Закрыт']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//div[text()='13100001/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100002/2707/0000/5/1']");
        checkElementOnDisplay("//div[text()='13100003/2707/0000/5/1']");
        fieldSearchFormListOfContractsRegistered.sendKeys("13100001/2707/0000/5/1");
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//div[text()='13100001/2707/0000/5/1']");
        clickElement(buttonUnloadingInExcel);
        LocalDateTime ldt = LocalDateTime.now();
        String dateFile = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt);
        MyThread.sleep(7000);
        isFileDownloaded("C:\\Users\\ABagaev\\Downloads\\", "Список_контрактов_поставленных_на_учет_" + dateFile + ".xlsx");
        checkElementOnDisplay("//div[@tooltiptitle='Внести изменения']");
        checkElementOnDisplay("//div[@tooltiptitle='Переписка с банком']");
        clickElement(buttonCorrespondenceWithBank);
        app.driver.findElement(By.xpath("//div[@class='corrMessage__action-buttons']//input[@class='file-zone__select-file']")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        MyThread.sleep(2000);
        fieldMessage.sendKeys("AutotestListOfContractsRegistered");
        clickElement(buttonSendMessageFormMakeChanges);
        clickElement(buttonMakeChanges);
        JavascriptExecutor js = (JavascriptExecutor) app.driver;
        String courseCurrancy = (js.executeScript("return document.querySelectorAll('strong[_ngcontent-c20]')[1].innerText")).toString();
        Assert.assertEquals(courseCurrancy,DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        checkElementOnDisplay("//form[@class='ng-untouched ng-pristine ng-invalid']//span[@class='new-message__select-item' and text()='ООО \"ОФЛК\"']");
        app.driver.findElement(By.xpath("//modal[@id='createBankMessage']//input[@class='file-zone__select-file']")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        clickElement(buttonSendMessageFormCorrespondenceWithBank);
        MyThread.sleep(2000);
        EnterSms.enter_sms_currancy_Operation(login,environment);
        saveScreenShot(app.driver,"checkListOfContractsRegistered");
        MainPage mainPage = new MainPage(app.driver);
        mainPage.logOut();
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest("Eev", "1");
        EnterSms.enter_sms("Eev","test");
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.sleep(3000);
        mainPage.openTabMainPage("Валютные операции");
        click("//div[text()='Список контрактов, поставленных на учет']");
        checkElementOnDisplay("//div[text()='19070002/2707/0000/3/1']");
        checkElementOnDisplay("//div[text()='Действует']");
        click("//div[@tooltiptitle='Закрыть контракт']");
        saveScreenShot(app.driver,"checkListOfContractsRegistered_formClose");
        MyThread.sleep(2000);
        buttonSendMessageFromSaleCurrancy.click();

    }

    public void checkForeignCurrencyIncomeRegister(final String numberContract, String periodDateFrom, String periodDateTo, String login, String environment) {
        MyThread.waitVisibleElement("//div[text()='Реестр поступлений иностранной валюты']",100);
        click("//div[text()='Реестр поступлений иностранной валюты']");
        MyThread.waitVisibleElement("//div[text()='Завершён']",200);
        clickElement(buttonUnloadingInExcel);
        LocalDateTime ldt = LocalDateTime.now();
        String dateFile = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt);
        MyThread.sleep(15000);
        isFileDownloaded("C:\\Users\\ABagaev\\Downloads\\", "Реестр_поступлений_иностранной_валюты_" + dateFile + ".xlsx");
        click("//div[text()='Реестр поступлений иностранной валюты']");
        clickElement(dropBoxFromPeriod);
        click("//li[@data-test='app-select--item' and text()='За сегодня']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        MyThread.sleep(2000);
        clickElement(dropBoxFromPeriod);
        click("//li[@data-test='app-select--item' and text()='За период']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        MyThread.sleep(2000);
        fieldDatePeriodFrom.clear();
        fieldDatePeriodFrom.sendKeys(periodDateFrom);
        fieldDatePeriodTo.clear();
        fieldDatePeriodTo.sendKeys(periodDateTo);
        clickElement(buttonSearchFormListOfContractsRegistered);
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='В ожидании']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//span[text()='" + numberContract + "']");
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Исполнено']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Показать все']");
        //TODO сделать множественный клик на поиск, сейчас бага
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//span[text()='" + numberContract + "']");
        clickElement(buttonCreateTransfer);
        MyThread.sleep(4000);
        MyThread.waitVisibleElement("//div[text()='Реестр поступлений иностранной валюты']",100);
        JavascriptExecutor js = (JavascriptExecutor) app.driver;
        String courseCurrancy = (js.executeScript("return document.querySelectorAll('input[name=\"docDate\"]')[0].value")).toString();
        Assert.assertEquals(courseCurrancy,DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        fieldNotificationNumber.sendKeys(get_template_name());
        fieldNotificationDate.sendKeys(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        fieldContractNumber.sendKeys(get_template_name());
        fieldContractDate.sendKeys(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        fieldTransferForCurrentAccount.clear();
        fieldTransferForCurrentAccount.sendKeys("2100");
        clickElement(fieldNotificationNumber);
        checkElementOnDisplay("//input[@name='exchangeAmount' and @ng-reflect-model='200']");
        click("//app-icon-tooltip[@tooltiptext='Заполняется, если договор поставлен на учет в соответствии с Инструкцией ЦБ 181-И.']/div");
        checkElementOnDisplay("//app-icon-tooltip[@tooltiptext='Заполняется, если договор поставлен на учет в соответствии с Инструкцией ЦБ 181-И.']//div[@class='tooltip bottom in fade']");
        app.driver.findElements(By.xpath("//app-icon-tooltip[@tooltiptext='Заполняется, если договор НЕ ставится на учёт в соответствии с Инструкцией ЦБ 181-И.']")).get(0).click();
        checkElementOnDisplay("//app-icon-tooltip[@tooltiptext='Заполняется, если договор НЕ ставится на учёт в соответствии с Инструкцией ЦБ 181-И.']//div[@class='tooltip bottom in fade']");
        app.driver.findElements(By.xpath("//app-icon-tooltip[@tooltiptext='Заполняется, если договор НЕ ставится на учёт в соответствии с Инструкцией ЦБ 181-И.']")).get(1).click();
        checkElementOnDisplay("//app-icon-tooltip[@tooltiptext='Заполняется, если договор НЕ ставится на учёт в соответствии с Инструкцией ЦБ 181-И.']//div[@class='tooltip bottom in fade']");
        saveScreenShot(app.driver,"testCheckCreatePaymentTransition");
        fieldUNKNumber.sendKeys("468578957808908568");
        clickElement(fieldNotificationNumber);
        checkElementOnDisplay("//input[@name='contractNumber' and @readonly]");
        checkElementOnDisplay("//input[@name='contractDate' and @readonly]");
        click("//li[text()='1 - Документы НЕ представляются - по договору на сумму до 200000 руб (вкл.), п.2.7, 2.15']");
        click("//li[text()='10100 - Экспорт товаров (аванс) ']");
        clickElement(buttonSignAndPay);
        MyThread.sleep(2000);
        clickElement(checkboxCreateTemplate);
        fieldNameTemplate.sendKeys("AutotestConvesionCurrancy");
        EnterSms.enter_sms_sale_currancy(login, environment);
        click("//div[@class='form-success__button']//button");
        click("//span[text()='18913']");
        fieldMessageFormCurrancy.sendKeys("AutotestCheckForeignCurrency");
        app.driver.findElement(By.xpath("//div[@class='corrMessage__attach']//input")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        clickElement(buttonSendMessageBankFormCurrancy);
        MyThread.sleep(3000);
        saveScreenShot(app.driver,"checkForeignCurrencyIncomeRegister");
        clickElement(buttonCreateTransfer);
        MyThread.sleep(2000);
        clickElement(checkboxAttachDocuments);
        clickElement(buttonSignAndPay);
        MyThread.sleep(2000);
        EnterSms.enter_sms_sale_currancy("Test1","test");
        MyThread.sleep(2000);
        checkElementOnDisplay("//modal[@id='soldValute']//div[@class='select__value-text ng-star-inserted']//span[text()='ООО \"ОПТИМА\"']");
        String dateMessage = (js.executeScript("return document.querySelectorAll('strong[_ngcontent-c15]')[1].textContent")).toString();
        Assert.assertEquals(dateMessage,DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        fieldYourMessage.sendKeys("AutotestcheckForeignCurrencyIncomeRegister");
        clickElement(buttonSendMessageFromSaleCurrancy);
        EnterSms.enter_sms_sale_currancy_confirmsms_sale_currancy("Test1","test");
        saveScreenShot(app.driver,"checkForeignCurrencyIncomeRegister2");
    }

    public void checkForeignRubIncomeRegister(String login, String environment, String periodFrom, String periodTo, String numberContract) {
        MyThread.waitVisibleElement("//div[@data-test='widget-currency-3']",100);
        click("//div[@data-test='widget-currency-3']");
        MyThread.waitVisibleElement("//div[text()='В ожидании']",100);
        clickElement(buttonUnloadingInExcel);
        LocalDateTime ldt = LocalDateTime.now();
        String dateFile = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt);
        MyThread.sleep(9000);
        isFileDownloaded("C:\\Users\\ABagaev\\Downloads\\", "Реестр_поступлений_рубли_РФ_" + dateFile + ".xlsx");
        clickElement(dropBoxFromPeriod);
        click("//li[@data-test='app-select--item' and text()='За сегодня']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        MyThread.sleep(2000);
        clickElement(dropBoxFromPeriod);
        click("//li[@data-test='app-select--item' and text()='За период']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        MyThread.sleep(2000);
        //TODO сделать проверку поиска при дате < реестра например здесь 01.01.2018(сейчас ошибка)
        fieldDatePeriodFrom.clear();
        fieldDatePeriodFrom.sendKeys(periodFrom);
        fieldDatePeriodTo.clear();
        fieldDatePeriodTo.sendKeys(periodTo);
        clickElement(buttonSearchFormListOfContractsRegistered);
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='В ожидании']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        MyThread.sleep(2000);
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Исполнено']");
        clickElement(buttonSearchFormListOfContractsRegistered);
        MyThread.sleep(2000);
        clickElement(dropBoxFromStatus);
        click("//li[@data-test='app-select--item' and text()='Показать все']");
        //TODO сделать множественный клик на поиск, сейчас бага
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//span[text()='" + numberContract + "']");
        fieldSearchFormListOfContractsRegistered.sendKeys(numberContract);
        clickElement(buttonSearchFormListOfContractsRegistered);
        checkElementOnDisplay("//span[text()='" + numberContract + "']");
        clickElement(buttonCorrespondenceWithBankRubIncomeRegisterForm);
        app.driver.findElement(By.xpath("//div[@class='corrMessage__action-buttons']//input[@class='file-zone__select-file']")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        MyThread.sleep(2000);
        fieldMessage.sendKeys("AutotestkForeignRubIncomeRegister");
        clickElement(buttonSendMessageFormMakeChanges);
        saveScreenShot(app.driver, "checkForeignRubIncomeRegister");
        clickElement(buttonSendingTransactionInformationToBanks);
        MyThread.sleep(2000);
        checkElementOnDisplay("//form[@class='ng-untouched ng-pristine ng-invalid']//span[text()='ООО \"АКАДЕМСЕРВИС\"']");
        click("//div[text()='Получатель']//following::div[@class='icon-triangle-down']"); //dropBox Получатель
        click("//modal[@style='display: inline;']//span[text()='Техническая поддержка']");
        fieldMessageSubject.sendKeys("checkForeignRubIncomeRegister");
        fieldYourMessageRubForm.sendKeys("checkForeignRubIncomeRegister");
        app.driver.findElement(By.xpath("//modal[@style='display: inline;']//input[@multiple='multiple']")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        clickElement(buttonSendingMessadgeRubForm);
        MyThread.sleep(2000);
        EnterSms.enter_sms_currancy_Operation_Rub(login,environment);
        checkElementOnDisplay("//div[text()='Сообщение успешно отправлено']");
    }



    public CurrancyOperationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
