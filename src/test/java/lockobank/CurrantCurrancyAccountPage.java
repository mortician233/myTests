package lockobank;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CurrantCurrancyAccountPage extends TestBase {

    @FindBy(xpath = "//button[@class='widget-info__button widget-info__button_bigger button button_theme_orange ng-star-inserted' and text()='Создать перевод']")
    private WebElement buttonCreatePayment;

    @FindBy(xpath = "//material-input[@name='payerName']//input[@data-test='material-input']")
    private WebElement payerName;

    @FindBy(xpath = "//material-input[@name='payerCountryCity']//input[@data-test='material-input']")
    private WebElement cityAndCountry;

    @FindBy(xpath = "//material-input[@name='payerAddress']//input[@data-test='material-input']")
    private WebElement address;

    @FindBy(xpath = "//input[@name='transferAmount']")
    private WebElement transferAmount;

    @FindBy(xpath = "//material-input[@name='corrSwiftCode']//input[@data-test='material-input']")
    private WebElement codeSWIFTCorrspondentBank;

    @FindBy(xpath = "//material-input[@name='benSwiftCode']//input[@data-test='material-input']")
    private WebElement codeSWIFTBank;

    @FindBy(xpath = "//a[@class='transfer-valute__recommendation' and text()='Прочтите рекомендации по заполнению']")
    private WebElement buttonReadReccomendationFromFill;

    @FindBy(xpath = "//div[text()='Приложить документы']//following::input[@name='withDocs']")
    private WebElement checkBoxAttachDocuments;

    @FindBy(xpath = "//div[text()='Без документов']//following::input[@name='withDocs']")
    private WebElement checkBoxNotDocuments;

    @FindBy(xpath = "//div[@class='transfer-valute']//input[@type='checkbox']")
    private WebElement checkBoxCreateTemplateCurrancyPayForm;

    @FindBy(xpath = "//div[@class='sold-valute__submit']//input[@type='checkbox']")
    private WebElement checkBoxCreateTemplateTransitionPayForm;

    @FindBy(xpath = "//input[@placeholder='Имя шаблона']")
    private WebElement fieldNameTemplate;

    @FindBy(xpath = "//button[@class='button button_theme_orange button_theme_orange_big ng-star-inserted']")
    private WebElement buttonSignatureAndPay;

    @FindBy(xpath = "//button[@class='button button_theme_brand ng-star-inserted']/span[text()='Сохранить черновик']")
    private WebElement buttonSaveDraft;

    @FindBy(xpath = "//button[@class='button button_theme_brand ng-star-inserted']/span[text()='Сохранить и оплатить потом']")
    private WebElement buttonSaveAndPayAfter;

    @FindBy(xpath = "//material-input[@name='payerName']//input[@data-test='material-input']")
    private WebElement fieldPayer;

    @FindBy(xpath = "//material-input[@name='payerAddress']//input[@data-test='material-input']")
    private WebElement fieldPayerAdress;

    @FindBy(xpath = "//material-input[@name='benAccount']//input[@data-test='material-input']")
    private WebElement fieldAccontBeneficiaryIBAN;

    @FindBy(xpath = "//material-input[@name='benName']//input[@data-test='material-input']")
    private WebElement fieldBeneficiaryName;

    @FindBy(xpath = "//material-input[@name='benCity']//input[@data-test='material-input']")
    private WebElement fieldBeneficiaryCity;

    @FindBy(xpath = "//textarea[@placeholder='Назначение перевода, номер и дата документа-обоснования']")
    private WebElement fieldTransferDestination;

    @FindBy(xpath = "//a[text()='Изменить']")
    private WebElement buttonChangeCurrancyPay;

    @FindBy(xpath = "//input[@data-test='sms--input-small']")
    private WebElement fieldSmsCodeCurrancyPayForm;

    @FindBy(xpath = "//div[@class='transfer-valute']//a[text()='Получить новый смс-код']")
    private WebElement buttonRetrySmsCodeCurrancyPayForm;

    @FindBy(xpath = "//div[@class='sold-valute']//a[text()='Получить новый смс-код']")
    private WebElement buttonRetrySmsCodeTransactionCurrancyPayForm;

    @FindBy(xpath = "//div[@class='transfer-valute']//button[@class='button button_theme_brand']/span[text()='Подтвердить операцию']")
    private WebElement buttonConfirmOperationCurrancyPayForm;

    @FindBy(xpath = "//div[@class='sold-valute']//button[@class='button button_theme_brand']/span[text()='Подтвердить операцию']")
    private WebElement buttonConfirmOperationTransitionPayForm;

    @FindBy(xpath = "//modal[@id='tranfserValute']//button[@class='button button_type_close modal__close']")
    private WebElement buttonCloseStatementOnTransferCurrancy;

    @FindBy(xpath = "//modal[@id='soldValute']//button[@class='button button_theme_brand new-message__submit ng-star-inserted']")
    private WebElement buttonSendMessageSaleCurrancy;

    @FindBy(xpath = "//input[@name='incomeAmount']")
    private WebElement fieldAmountOfReceivedCurrency;

    @FindBy(xpath = "//input[@name='transferAmount']")
    private WebElement fieldTransferForCurrentAccount;

    @FindBy(xpath = "//input[@name='exchangeAmount']")
    private WebElement fieldExchangeCurrancy;

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

    @FindBy(xpath = "//input[@name='attachDocuments']")
    private WebElement checkboxAttachDocuments;

    @FindBy(xpath = "//div[@class='sold-valute__message']//textarea[@placeholder='Ваше сообщение']")
    private WebElement fieldYourMessage;

    @FindBy(xpath = "//app-select[@name='documentCode']//div[@class='select__trigger ng-star-inserted']")
    private WebElement dropDownDocumentCode;

    @FindBy(xpath = "//app-select[@name='transferCode']//div[@class='select__trigger ng-star-inserted']")
    private WebElement dropDownCodeVO;

    @FindBy(xpath = "//app-select[@name='operationCode']//div[@class='select__trigger ng-star-inserted']")
    private WebElement dropDownCodeVOTransferForm;

    @FindBy(xpath = "//app-select[@name='transferTaxType']//div[@class='select__trigger ng-star-inserted']")
    private WebElement dropDownTypeCommission;


    public void testCheckCreatePayment(Boolean defaultCurrancyCheck, String amount, String currancy, String correspondentBankCodeSWIFT, String downloadPath, String nameCreateTemplate, String logIn, String CodeSWIFTBank, String environment) {
        if (defaultCurrancyCheck == true) {
            MyThread.sleep(3000);
            clickAccount("40702.978.2.00001814010");
            MyThread.sleep(2000);
            clickElement(buttonCreatePayment);
            MyThread.sleep(4000);
            JavascriptExecutor js = (JavascriptExecutor) app.driver;
            String element1 = (js.executeScript("return document.querySelector('input[name=\"docDate\"]').value")).toString();
            System.out.println(element1);
            LocalDateTime ldt = LocalDateTime.now();
            Assert.assertEquals(element1, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            selectDropDownCurrancyTransfer("usd");
            transferAmount.sendKeys("1.11");
            clickElement(payerName);
            transferAmount.clear();
            transferAmount.sendKeys("11");
            clickElement(payerName);
            transferAmount.clear();
            transferAmount.sendKeys("0.99");
            clickElement(payerName);
            codeSWIFTCorrspondentBank.sendKeys("TI");
            saveScreenShot(app.driver, "testCheckCreatePaymentSWIFTCorresp");
            codeSWIFTCorrspondentBank.clear();
            codeSWIFTCorrspondentBank.sendKeys("TICS");
            MyThread.sleep(2000);
            checkElementOnDisplay("//span[text()='TINKOFF BANK']");
            MyThread.sleep(2000);
            click("//div[@class='ngui-auto-complete']"); // клик по первому коду SWIFT
            codeSWIFTBank.sendKeys("TC");
            saveScreenShot(app.driver, "testCheckCreatePaymentSWIFTBank");
            codeSWIFTBank.clear();
            MyThread.sleep(2000);
            codeSWIFTBank.sendKeys("TCAPCAT1XXX");
            MyThread.sleep(2000);
            click("//ngui-auto-complete[@style='display: inline-block; width: 389px; position: absolute; z-index: 1; left: 0px; top: 22px;']");
            clickElement(buttonReadReccomendationFromFill);
            MyThread.sleep(2000);
            isFileDownloaded("C:\\Users\\ABagaev\\Downloads\\", "Пример заполнения заявления на перевод в иностранной валюте.pdf");
            clickElement(dropDownCodeVO);
            click("//li[text()='21100 - Оказание работ, услуг, предоставление информации и результатов интеллектуальной деятельности (аванс)']"); // клик по полю Код ВО
            clickElement(checkBoxAttachDocuments);
            fieldPayer.clear();
            fieldPayer.sendKeys("OOO TestPay");
            fieldPayerAdress.clear();
            fieldPayerAdress.sendKeys("RU, Moskow");
            fieldTransferDestination.sendKeys("AutotestTest");
            clickElement(checkBoxNotDocuments);
            fieldAccontBeneficiaryIBAN.sendKeys("4789895796890689067907909790707979");
            fieldBeneficiaryName.sendKeys("OOO TestCurrancyPay");
            fieldBeneficiaryCity.sendKeys("Toronto");
            clickElement(dropDownTypeCommission);
            click("//li[text()='OUR']"); // выбор комиссии
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(2000);
            checkElementOnDisplay("//td[text()='USD 0,99']");
            checkElementOnDisplay("//td[text()='Ноль долларов США 99 центов ']");
            checkElementOnDisplay("//td[text()='OOO TestPay']");
            checkElementOnDisplay("//td[text()='RU, Moskow']");
            checkElementOnDisplay("//td[text()='TICSRUMMXXX']");
            checkElementOnDisplay("//td[text()='TINKOFF BANK']");
            checkElementOnDisplay("//td[text()='TCAPCAT1XXX']");
            checkElementOnDisplay("//td[text()='TAURUS CAPITAL MARKETS, LTD.']");
            checkElementOnDisplay("//td[text()='CANADA TORONTO']");
            checkElementOnDisplay("//td[text()='4789895796890689067907909790707979']");
            checkElementOnDisplay("//td[text()='OOO TestCurrancyPay']");
            checkElementOnDisplay("//td[text()='Toronto']");
            checkElementOnDisplay("//td[text()='AutotestTest']");
            checkElementOnDisplay("//td[text()='OUR']");
            clickElement(buttonChangeCurrancyPay);
            transferAmount.clear();
            transferAmount.sendKeys("13.21");
            fieldBeneficiaryName.clear();
            fieldBeneficiaryName.sendKeys("OOO AutotestCurrancyPay");
            selectDropDownCurrancyTransfer("eur");
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(2000);
            checkElementOnDisplay("//td[text()='OOO AutotestCurrancyPay']");
            checkElementOnDisplay("//td[text()='EUR 13,21']");
            checkElementOnDisplay("//td[text()='Тринадцать ЕВРО 21 цент ']");
            checkBoxClick(checkBoxCreateTemplateCurrancyPayForm);
            fieldNameTemplate.sendKeys("AutotestTestPayCurrancy");
            fieldSmsCodeCurrancyPayForm.sendKeys("023411");
            clickElement(buttonConfirmOperationCurrancyPayForm);
            clickElement(buttonRetrySmsCodeCurrancyPayForm);
            EnterSms.enter_sms_pp("Test1",environment);
            checkElementOnDisplay("//div[text()='Документ отправлен на вторую подпись']");
            clickElement(buttonCloseStatementOnTransferCurrancy);
            checkElementOnDisplay("//div[@class='tab-content active ng-star-inserted']//div[text()='OOO AutotestCurrancyPay']");
        } else {
            MyThread.sleep(2000);
            clickAccount("40702.978.1.00130209010");
            MyThread.sleep(2000);
            clickElement(buttonCreatePayment);
            MyThread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) app.driver;
            String element1 = (js.executeScript("return document.querySelector('input[name=\"docDate\"]').value")).toString();
            LocalDateTime ldt = LocalDateTime.now();
            Assert.assertEquals(element1, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            selectDropDownCurrancyTransfer(currancy);
            transferAmount.sendKeys(amount);
            clickElement(payerName);
            codeSWIFTCorrspondentBank.sendKeys("TI");
            saveScreenShot(app.driver, "testCheckCreatePaymentSWIFTCorresp");
            codeSWIFTCorrspondentBank.clear();
            codeSWIFTCorrspondentBank.sendKeys(correspondentBankCodeSWIFT);
            checkElementOnDisplay("//span[text()='TINKOFF BANK']");
            click("//ngui-auto-complete[@style='display: inline-block; width: 848px; position: absolute; z-index: 1; left: 0px; top: 22px;']"); // клик по первому коду SWIFT
            codeSWIFTBank.sendKeys("TC");
            saveScreenShot(app.driver, "testCheckCreatePaymentSWIFTBank");
            codeSWIFTBank.clear();
            codeSWIFTBank.sendKeys(CodeSWIFTBank);
            MyThread.sleep(1000);
            click("//ngui-auto-complete[@style='display: inline-block; width: 389px; position: absolute; z-index: 1; left: 0px; top: 22px;']");
            clickElement(buttonReadReccomendationFromFill);
            isFileDownloaded(downloadPath, "Пример заполнения заявления на перевод в иностранной валюте.pdf");
            click("//li[text()='21100 - Оказание работ, услуг, предоставление информации и результатов интеллектуальной деятельности (аванс)']"); // клик по полю Код ВО
            clickElement(checkBoxAttachDocuments);
            fieldPayer.clear();
            fieldPayer.sendKeys("OOO TestPay");
            fieldPayerAdress.clear();
            fieldPayerAdress.sendKeys("RU, Moskow");
            fieldTransferDestination.sendKeys("AutotestTest");
            clickElement(checkBoxNotDocuments);
            fieldAccontBeneficiaryIBAN.sendKeys("4789895796890689067907909790707979");
            fieldBeneficiaryName.sendKeys("OOO TestCurrancyPay");
            fieldBeneficiaryCity.sendKeys("Toronto");
            click("\"//li[text()='OUR']\""); // выбор комиссии
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(2000);
            checkBoxClick(checkBoxCreateTemplateCurrancyPayForm);
            fieldNameTemplate.sendKeys(nameCreateTemplate);
            EnterSms.enter_sms_pp(logIn,environment);
            checkElementOnDisplay("//div[text()='Документ отправлен на вторую подпись']");
            clickElement(buttonCloseStatementOnTransferCurrancy);

        }
    }

    public void testCheckCreatePaymentTransition(Boolean defaultSaleCurrancyCheck, String accountOpen, String Descriprion, String nameTemplate, String environment) {
        if (defaultSaleCurrancyCheck == true) {
            MyThread.sleep(2000);
            clickAccount("40702.840.7.00001814020");
            MyThread.sleep(2000);
            clickElement(buttonCreatePayment);
            MyThread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) app.driver;
            String element1 = (js.executeScript("return document.querySelector('input[name=\"docDate\"]').value")).toString();
            LocalDateTime ldt = LocalDateTime.now();
            Assert.assertEquals(element1, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            fieldAmountOfReceivedCurrency.sendKeys("0.99");
            clickElement(fieldNotificationNumber);
            fieldAmountOfReceivedCurrency.clear();
            fieldAmountOfReceivedCurrency.sendKeys("0.01");
            clickElement(fieldNotificationNumber);
            fieldAmountOfReceivedCurrency.clear();
            fieldAmountOfReceivedCurrency.sendKeys("29.01");
            clickElement(fieldNotificationNumber);
            fieldTransferForCurrentAccount.sendKeys("0.99");
            clickElement(fieldNotificationNumber);
            fieldTransferForCurrentAccount.clear();
            fieldTransferForCurrentAccount.sendKeys("0.01");
            clickElement(fieldNotificationNumber);
            fieldTransferForCurrentAccount.clear();
            fieldTransferForCurrentAccount.sendKeys("28.01");
            clickElement(fieldNotificationNumber);
            String courseCurrancy = (js.executeScript("return document.querySelector('input[name=\"rate\"]').value")).toString();
            Assert.assertEquals(courseCurrancy,"По курсу банка на "+ DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt) + " г.");
            fieldNotificationNumber.sendKeys(get_template_name());
            fieldNotificationDate.sendKeys(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            fieldContractNumber.sendKeys(get_template_name());
            fieldContractDate.sendKeys(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            saveScreenShot(app.driver,"testCheckCreatePaymentTransition");
            fieldUNKNumber.sendKeys("468578957808908568");
            clickElement(fieldNotificationNumber);
            checkElementOnDisplay("//input[@name='contractNumber' and @readonly]");
            checkElementOnDisplay("//input[@name='contractDate' and @readonly]");
            clickElement(checkboxAttachDocuments);
            clickElement(dropDownDocumentCode);
            click("//li[text()='1 - Документы НЕ представляются - по договору на сумму до 200000 руб (вкл.), п.2.7, 2.15']");
            clickElement(dropDownCodeVOTransferForm);
            click("//li[text()='10100 - Экспорт товаров (аванс) ']");
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(3000);
            checkElementOnDisplay("//td[text()='29,01 USD']");
            checkElementOnDisplay("//td[text()='Двадцать девять долларов США 01 цент ']");
            checkElementOnDisplay("//td[text()='1,00 USD']");
            checkElementOnDisplay("//td[text()='Один доллар США 00 центов ']");
            checkElementOnDisplay("//td[text()='28,01 USD']");
            checkElementOnDisplay("//td[text()='Двадцать восемь долларов США 01 цент ']");
            checkElementOnDisplay("//td[text()='40702840700001814020']");
            checkElementOnDisplay("//td[text()='40702810200001814000']");
            clickElement(buttonChangeCurrancyPay);
            fieldAmountOfReceivedCurrency.clear();
            fieldAmountOfReceivedCurrency.sendKeys("32.01");
            clickElement(fieldNotificationNumber);
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(3000);
            checkElementOnDisplay("//td[text()='32,01 USD']");
            checkBoxClick(checkBoxCreateTemplateTransitionPayForm);
            fieldNameTemplate.sendKeys("AutotestTestTransitionPayCurrancy");
            fieldSmsCodeCurrancyPayForm.sendKeys("023411");
            clickElement(buttonConfirmOperationTransitionPayForm);
            checkElementOnDisplay("//div[text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
            clickElement(buttonRetrySmsCodeTransactionCurrancyPayForm);
            MyThread.sleep(3000);
            EnterSms.enter_sms_sale_currancy("Test1",environment);
            MyThread.sleep(2000);
            fieldYourMessage.sendKeys("AutotestSaleCurrancy");
            clickElement(buttonSendMessageSaleCurrancy);
            EnterSms.enter_sms_sale_currancy_confirmsms_sale_currancy("Test1",environment);
        } else {
            MyThread.sleep(2000);
            clickAccount(accountOpen);
            MyThread.sleep(2000);
            clickElement(buttonCreatePayment);
            MyThread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) app.driver;
            String element1 = (js.executeScript("return document.querySelector('input[name=\"docDate\"]').value")).toString();
            System.out.println(element1);
            LocalDateTime ldt = LocalDateTime.now();
            Assert.assertEquals(element1, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            fieldAmountOfReceivedCurrency.sendKeys("29.01");
            clickElement(fieldNotificationNumber);
            checkElementOnDisplay("//input[@name='transferAmount' and @ng-reflect-model='29.01']");
            fieldTransferForCurrentAccount.sendKeys("28.01");
            clickElement(fieldNotificationNumber);
            checkElementOnDisplay("//input[@name='exchangeAmount' and @ng-reflect-model='1']");
            String courseCurrancy = (js.executeScript("return document.querySelector('input[name=\"rate\"]').value")).toString();
            Assert.assertEquals(courseCurrancy,"По курсу банка на "+ DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt) + " г.");
            fieldNotificationNumber.sendKeys(get_template_name());
            fieldNotificationDate.sendKeys(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            fieldContractNumber.sendKeys(get_template_name());
            fieldContractDate.sendKeys(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            saveScreenShot(app.driver,"testCheckCreatePaymentTransition");
            fieldUNKNumber.sendKeys("468578957808908568");
            clickElement(fieldNotificationNumber);
            checkElementOnDisplay("//input[@name='contractNumber' and @readonly]");
            checkElementOnDisplay("//input[@name='contractDate' and @readonly]");
            clickElement(checkboxAttachDocuments);
            click("//li[text()='1 - Документы НЕ представляются - по договору на сумму до 200000 руб (вкл.), п.2.7, 2.15']");
            click("//li[text()='10100 - Экспорт товаров (аванс) ']");
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(3000);
            clickElement(buttonChangeCurrancyPay);
            fieldAmountOfReceivedCurrency.clear();
            fieldAmountOfReceivedCurrency.sendKeys("32.01");
            clickElement(fieldNotificationNumber);
            clickElement(buttonSignatureAndPay);
            MyThread.sleep(3000);
            checkElementOnDisplay("//td[text()='32,01 USD']");
            checkBoxClick(checkBoxCreateTemplateTransitionPayForm);
            fieldNameTemplate.sendKeys(nameTemplate);
            EnterSms.enter_sms_sale_currancy("NTodua", environment);
            MyThread.sleep(2000);
            fieldYourMessage.sendKeys(Descriprion);
            clickElement(buttonSendMessageSaleCurrancy);
            EnterSms.enter_sms_sale_currancy_confirmsms_sale_currancy("NTodua",environment);
        }
    }

        public void selectDropDownCurrancyTransfer (String currancy){
            click("//div[@class='transfer-valute__item ng-star-inserted']//div[@class='icon-triangle-down']");
            String element = currancy.toUpperCase();
            if (element.equals("USD")) {
                click("//li[text()='USD - ДОЛЛАР США']");
            }
            if (element.equals("EUR")) {
                click("//li[text()='EUR - ЕВРОПЕЙСКАЯ ВАЛЮТА ЕВРО']");
            }

        }

    public CurrantCurrancyAccountPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
}
