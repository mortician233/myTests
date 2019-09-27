package lockobank;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.Set;

public class CurrentRurAccountPage extends TestBase {

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='ИНН']")
    private WebElement fieldInn;

    @FindBy(xpath = "//material-input[@placeholder='ИНН']//input[@data-test='material-input' and @class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement inn;

    @FindBy(xpath = "//textarea[@name='paymentPurpose']")
    private WebElement descriprionPayment;

    @FindBy(xpath = "//a[@class='widget-info__button widget-info__button_bigger button button__1c-wrap ng-star-inserted']//span[@class='button__create' and text()='Создать платёж']")
    private WebElement buttonCreatePay;

    @FindBy(xpath = "//div[@class='filter__item filter__item_type ng-star-inserted']//div[@class='filter__control']//div[@class='select__trigger ng-star-inserted']//div[@class='icon-triangle-down']")
    private WebElement typeOperationDropBox;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='Все']")
    private WebElement typeOperationDropBoxAll;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='Приход']")
    private WebElement typeOperationDropBoxCost;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='Расход']")
    private WebElement typeOperationDropBoxReceipt;

    @FindBy(xpath = "//div[@class='filter__item filter__item_status ng-star-inserted']//div[@class='filter__control']//div[@class='select__trigger ng-star-inserted']//div[@class='icon-triangle-down']")
    private WebElement statusOperationDropBox;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='Показать все']")
    private WebElement statusOperationDropBoxShowAll;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='На подтверждении']")
    private WebElement statusOperationDropBoxForConfirmation;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='В обработке']")
    private WebElement statusOperationDropBoxInProcess;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='Черновик']")
    private WebElement statusOperationDropBoxDraft;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='Исполнен']")
    private WebElement statusOperationDropBoxExecuted;

    @FindBy(xpath = "//div[@class='filter__item filter__item_search-btn']/button")
    private WebElement buttonFilterSearchOperationTab;

    @FindBy(xpath = "//div[@class='table-actions__item statement-action']/button")
    private WebElement buttonFilterSearchStatementTab;

    @FindBy(xpath = "//div[@class='filter__item filter__item_period statement-period']//div[@class='select__value-text select__value-text_simple ng-star-inserted']")
    private WebElement forperiodOperationDropBox;

    @FindBy(xpath = "//div[@class='table-actions__item statement-period wide']//div[@data-test='app-select--openDropdown']//div[@class='select__trigger ng-star-inserted']")
    private WebElement forperiodStatmentDropBox;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='За период']")
    private WebElement forperiodOperationDropBoxOverPeriod;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='За сегодня']")
    private WebElement forperiodOperationDropBoxForToday;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='За вчера']")
    private WebElement forperiodOperationDropBoxForYesterday;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='За месяц']")
    private WebElement forperiodOperationDropBoxForMonth;

    @FindBy(xpath = "//div[@class='select__dropdown dropdown']//li[@class='dropdown__item dropdown__item_simple ng-star-inserted' and text()='За год']")
    private WebElement forperiodOperationDropBoxForYear;

    @FindBy(xpath = "//a[@data-test='templates--gotoAutopayments' and text()='Частые платежи']")
    private WebElement buttonFrequentPayments;

    @FindBy(xpath = "//span[@data-test='quick-button--createTemplateRequest' and @title='Создать шаблон']")
    private WebElement buttonCreateTemplate;

    @FindBy(xpath = "//span[@data-test='quick-button--repeatPayment' and @title='Повторить платеж']")
    private WebElement buttonRetryPayment;

    @FindBy(xpath = "//button[@class='button button_theme_brand']//span[text()='ОК']")
    private WebElement buttonCreateTemplateOK;

    @FindBy(xpath = "//button[@class='button button_theme_brand']//span[text()='Отмена']")
    private WebElement buttonCreateTemplateCancel;

    @FindBy(xpath = "//material-input[@placeholder='Наименование шаблона']")
    private WebElement fieldNameTemplate;

    @FindBy(xpath = "//div[text()='Наименование шаблона']//following-sibling::input[@data-test='material-input']")
    private WebElement nameTemplate;

    @FindBy(xpath = "//span[text()='Подписать и оплатить' and not(@disabled)]")
    private WebElement buttonSignAndPay;

    @FindBy(xpath = "//span[text()='Подписать' and not(@disabled)]")
    private WebElement buttonSign;

    @FindBy(xpath = "//span[text()='Сохранить черновик' and not(@disabled)]")
    private WebElement buttonSaveDraft;

    @FindBy(xpath = "//button[@data-test='create-payment--closeModal' and text()='Закрыть']")
    private WebElement buttonClosePayFormAfterCreate;

    @FindBy(xpath = "//input[@data-test='create-payment--saveTemplate-input']")
    private WebElement checkboxCreatePayTemplate;

    @FindBy(xpath = "//*[@class='create-payment__item ng-star-inserted']//*[@class='switcher__item active' and text()='Нет']")
    private WebElement buttonEmergenceOrderNo;

    @FindBy(xpath = "//*[@alias='numeric' and @data-test='create-payment--amount']")
    private WebElement amount;

    @FindBy(xpath = "//input[@placeholder='Имя шаблона']")
    private WebElement nameTemplatePayInstruction;

    @FindBy(xpath = "//li[@class='tabs__item ng-star-inserted' and text()='Операции']")
    private WebElement tabOperation;

    @FindBy(xpath = "//li[@class='tabs__item ng-star-inserted' and text()='Выписка']")
    private WebElement tabStatement;

    @FindBy(xpath = "//li[@class='tabs__item ng-star-inserted' and text()='Лимиты']")
    private WebElement tabLimits;

    @FindBy(xpath = "//li[@class='tabs__item ng-star-inserted' and text()='Тарифы']")
    private WebElement tabTariffs;

    @FindBy(xpath = "//div[@class='table-actions__item statement-period wide']//input[@data-test='period--input-from']")
    private WebElement fieldPeriodFromStatement;

    @FindBy(xpath = "//div[@class='table-actions__item statement-period wide']//input[@data-test='period--input-to']")
    private WebElement fieldPeriodToStatement;

    @FindBy(xpath = "//div[@class='filter__item filter__item_period statement-period']//input[@data-test='period--input-from']")
    private WebElement fieldPeriodFromOperation;

    @FindBy(xpath = "//div[@class='filter__item filter__item_period statement-period']//input[@data-test='period--input-to']")
    private WebElement fieldPeriodToOperation;

    @FindBy(xpath = "//div[@class='operation__body prevent-click']//span[@class='button__text' and text()='Отправить на почту']")
    private WebElement buttonOpenFormSendEmailOnOperation;

    @FindBy(xpath = "//div[@class='col-lg-6 prevent-click']//button[text()='Отправить']")
    private WebElement buttonSendEmailSend;

    @FindBy(xpath = "//div[@class='col-lg-6 prevent-click']//button[text()='Отмена']")
    private WebElement buttonSendEmailCancel;

    @FindBy(xpath = "//input[@name='paymentEmailField']")
    private WebElement fieldEnterEmail;

    @FindBy(xpath = "//span[@class='button__text' and text()='Экспорт в 1С']")
    private WebElement buttonExportInOneS;

    @FindBy(xpath = "//span[@class='button__text' and text()='Распечатать']")
    private WebElement buttonPrint;

    @FindBy(xpath = "//span[@class='button__text' and text()='Отправить на почту']")
    private WebElement buttonSendEmailOnTabStatement;

    @FindBy(xpath = "//button[@data-test='send-statement--send-button']//span[text()='Отправить']")
    private WebElement buttonSendEmailSendOnTabStatement;

    @FindBy(xpath = "//modal[@id='sendStatement']//div[text()='Введите E-mail']//following-sibling::input[@data-test='material-input']")
    private WebElement fieldEnterEmailOnTabStatement;

    @FindBy(xpath = "//button[@class='button button_theme_brand' and text()='Сменить тариф']")
    private WebElement buttonChangeTariff;

    @FindBy(xpath = "//span[@class='operation__cancel ng-star-inserted']//span[text()='Отозвать платеж']")
    private WebElement buttonRecallPay;

    @FindBy(xpath = "//button[@class='button button_theme_brand']//span[text()='Отозвать операцию']")
    private WebElement buttonRecallOperation;

    @FindBy(xpath = "//span[@class='operation__quick-button ng-star-inserted' and @title='Ответный платеж']")
    private WebElement buttonReturnPayment;

    @FindBy(xpath = "//modal[@id='refusePayment']//input[@name='userConfirmCode']")
    private WebElement fieldCodeSmsRecallOperation;

    @FindBy(xpath = "//a[@data-test='sms--new-sms-small' and text()='Получить новый смс-код']")
    private WebElement buttonRetrySmsCode;

    @FindBy(xpath = "//div[@class='payment-tab__caption' and text()='На подписи']")
    private WebElement buttonOnTheSignatureOperationTab;

    @FindBy(xpath = "//div[@class='link-action__icon']/span[@class='icon-sendtosign']")
    private WebElement buttonSendOnTheSignature;

    @FindBy(xpath = "//button[@class='button button_theme_brand create-payment__draft ng-star-inserted']//span[text()='Отправить на подпись']")
    private WebElement buttonSendOnTheSignatureInPayForm;

    @FindBy(xpath = "//button[@class='create-payment__save button button_theme_brand ng-star-inserted']//span[text()='Сохранить изменения']")
    private WebElement buttonChangeSaveInPayForm;

    @FindBy(xpath = "//div[@class='payment-tab__caption' and text()='Черновики']")
    private WebElement buttonDrafts;

    @FindBy(xpath = "//span[@class='operation__quick-button operation__delete-button ng-star-inserted' and @title='Удалить']")
    private WebElement buttonDeletePay;

    @FindBy(xpath = "//div[@class='operation']//div[text()='Подписать']")
    private WebElement buttonSignatureAndPay;

    @FindBy(xpath = "//*[@data-test='create-payment--switcher-budgetary']//*[text()='Нет']")
    private WebElement buttonBudgetaryPaymentNo;

    @FindBy(xpath = "//*[@data-test='create-payment--switcher-budgetary']//div[text()='Да']")
    private WebElement buttonBudgetaryPaymentYes;

    @FindBy(xpath = "//input[@data-test='create-payment--docNumber']")
    private WebElement fieldsNumberPayment;

    public void checkFilterOperation() {
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxAll);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxCost);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxReceipt);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxAll);
    }

    public void checkFilterStatus() {
        clickElement(forperiodOperationDropBox);
        clickElement(forperiodOperationDropBoxForYear);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxShowAll);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxForConfirmation);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxInProcess);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxExecuted);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxDraft);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(forperiodOperationDropBox);
        clickElement(forperiodOperationDropBoxForYear);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        MyThread.waitVisibleElement("//div[@class='operation__item operation__item_date']", 220);
        clickElement(forperiodOperationDropBox);
        clickElement(forperiodOperationDropBoxOverPeriod);
        clickElement(buttonFilterSearchOperationTab);
        MyThread.sleep(2000);
        waitloadElement(10);
        MyThread.waitVisibleElement("//div[@class='operation__item operation__item_date']", 220);
        clickElement(forperiodOperationDropBox);
        clickElement(forperiodOperationDropBoxForMonth);
        clickElement(buttonFilterSearchOperationTab);
        MyThread.sleep(2000);
        MyThread.waitVisibleElement("//div[@class='operation__item operation__item_date']", 220);
        waitloadElement(10);
        clickElement(buttonFrequentPayments);
        MyThread.sleep(2000);
        checkElementOnDisplay("//span[text()='Частые платежи']");
    }

    public void checkTabOperationCreateTemplate(String nameTemlates) {
        clickElement(forperiodOperationDropBox);
        clickElement(forperiodOperationDropBoxForYear);
        clickElement(buttonFilterSearchOperationTab);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxShowAll);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxCost);
        clickElement(buttonFilterSearchOperationTab);
        saveScreenShot(app.driver, "checkCreateTemplateDisable");
        assertElementPresent("//span[@data-test='quick-button--createTemplateRequest' and @title='Создать шаблон']");
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxAll);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxExecuted);
        MyThread.sleep(4000);
        clickElement(buttonFilterSearchOperationTab);
        MyThread.waitVisibleElement("//span[@class='ng-star-inserted' and text()='Исполнен']",200);
        waitloadElement(10);
        checkElementOnDisplay("//span[@class='ng-star-inserted' and text()='Исполнен']");
        saveScreenShot(app.driver, "checkTabOperationCreateTemplate");
        clickElement(statusOperationDropBox);
        MyThread.sleep(1000);
        clickElement(statusOperationDropBoxInProcess);
        clickElement(buttonFilterSearchOperationTab);
        clickElement(buttonCreateTemplate);
        checkElementOnDisplay("//div[@class='modal-title__caption' and text()='Введите название шаблона']");
        clickElement(buttonCreateTemplateCancel);
        checkElementOnDisplay("//div[@class='widget-info__property-value']//span[@class='widget-info__property-value_new' and text()='Расчетный счет']");
        clickElement(buttonCreateTemplate);
        waitLoadPage(10);
        MyThread.sleep(2000);
        clickElement(buttonCreateTemplateOK);
        checkElementOnDisplay("//div[@class='informer__tc' and text()='Пожалуйста введите название шаблона.']");
        MyThread.sleep(2000);
        clickElement(fieldNameTemplate);
        nameTemplate.sendKeys(nameTemlates);
        clickElement(buttonCreateTemplateOK);
        checkElementOnDisplay("//div[@class='informer__tc' and text()= 'Шаблон платежа успешно создан.']");
    }

    public void checkTabOpetaionRetryPayment(String currantLogin, String amount, String nameTemplate, String environment){
        MyThread.sleep(2000);
        clickElement(forperiodOperationDropBox);
        clickElement(forperiodOperationDropBoxForYear);
        clickElement(buttonFilterSearchOperationTab);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxShowAll);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxCost);
        clickElement(buttonFilterSearchOperationTab);
        assertElementPresent("//span[@data-test='quick-button--createTemplateRequest' and @title='Повторить платеж']");
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxAll);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxInProcess);
        MyThread.sleep(2000);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        clickElement(buttonRetryPayment);
        checkElementOnDisplay("//span[text()='Платежное поручение №']");
        MyThread.sleep(2000);
        fieldsNumberPayment.clear();
        fieldsNumberPayment.sendKeys(get_template_name());
        this.amount.clear();
        clickElement(buttonBudgetaryPaymentYes);
        checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
        this.amount.sendKeys(amount);
        clickElement(buttonBudgetaryPaymentNo);
        clickElement(buttonSignAndPay);
        MyThread.sleep(5000);
        clickElement(checkboxCreatePayTemplate);
        this.nameTemplatePayInstruction.sendKeys(nameTemplate);
        MyThread.sleep(3000);
        EnterSms.enter_sms_pp(currantLogin, environment);
        checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ принят в обработку']");
        clickElement(buttonClosePayFormAfterCreate);
    }

    public void checkTabOpetaionSendEmail(){
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxInProcess);
        waitloadElement(10);
        clickElement(buttonFilterSearchOperationTab);
        waitloadElement(10);
        click("//div[@class='operation__item operation__item_caption']");
        MyThread.sleep(3000);
        clickElement(buttonOpenFormSendEmailOnOperation);
        clickElement(buttonSendEmailSend);
        checkElementOnDisplay("//span[@class='control-error ng-star-inserted' and text()='Не указан адрес электронной почты' and not(@hidden)]");
        MyThread.sleep(4000);
        fieldEnterEmail.sendKeys("@gmail.com");
        clickElement(buttonSendEmailSend);
        checkElementOnDisplay("//span[@class='control-error ng-star-inserted' and text()='Указан некорректный адрес электронной почты' and not(@hidden)]");
        fieldEnterEmail.clear();
        fieldEnterEmail.sendKeys("abagaev@lockobank.ru");
        clickElement(buttonSendEmailSend);
        MyThread.sleep(5000);
        clickElement(buttonOpenFormSendEmailOnOperation);
  //      clickElement(buttonSendEmailCancel);
        checkElementOnDisplay("//div[not(@class='row template-request email-request')]");
    }

    public void checkTabStatement(String email, String dateFrom, String dateTo, String downloadPath) throws FileNotFoundException {
        MyThread.sleep(3000);
        clickElement(forperiodStatmentDropBox);
        clickElement(forperiodOperationDropBoxOverPeriod);
        MyThread.sleep(2000);
        fieldPeriodFromStatement.clear();
        fieldPeriodFromStatement.sendKeys(dateFrom);
        fieldPeriodToStatement.clear();
        fieldPeriodToStatement.sendKeys(dateTo);
        clickElement(buttonFilterSearchStatementTab);
        clickElement(buttonExportInOneS);
        MyThread.sleep(9000);
        //TODO: удалять файл после каждой проверки, пока не решено удаление файла
        isFileDownloaded(downloadPath,"kl_to_1c.txt");
        clickElement(buttonPrint);
        clickElement(buttonSendEmailOnTabStatement);
        MyThread.sleep(4000);
        clickElement(buttonSendEmailSendOnTabStatement);
        checkElementOnDisplay("//div[@class='control-error ng-star-inserted' and text()='Не указан адрес электронной почты' and not(@hidden)]");
        fieldEnterEmailOnTabStatement.sendKeys(email);
        clickElement(buttonSendEmailSendOnTabStatement);
        MyThread.waitVisibleElement("//div[text()='Выписка успешно отправлена на " + email + "']", 170);
        MyThread.sleep(4000);
    }

    public void checkTabLimits() {
        MyThread.sleep(3000);
        clickElement(buttonChangeTariff);
        checkElementOnDisplay("//div[@class='tariff__cell' and text()='Лимит исходящих коммерческих платежей']");
        checkElementOnDisplay("//div[@class='tariff__cell' and text()='Снятие наличных на зарплату']");
        String originalWindow = app.driver.getWindowHandle();
        final Set<String> oldWindowsSet = app.driver.getWindowHandles();
        click("//a[@class='tariff__detail' and text()='Подробнее']");
        String newWindow = (new WebDriverWait(app.driver, 5))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        app.driver.switchTo().window(newWindow);
        System.out.println("New window title: " + app.driver.getTitle());
        checkElementOnDisplay("//embed[@id='plugin']");
        app.driver.close();
        app.driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + app.driver.getTitle());
        click("//button[@class='button button_theme_brand ng-star-inserted' and text()='Перейти на тариф']");
        click("//button[@data-test='close-modal--changeTariff-confirm-yes']"); // Подтвердить смену тарифа
        checkElementOnDisplay("//*[text()='Уважаемый клиент! Мы приняли вашу заявку. Тарифный план будет изменен в ближайшее время.']");
    }

    public void checkTabOpetaionRecallPay() {
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxDraft);
        clickElement(buttonFilterSearchOperationTab);
        assertElementPresent("//span[@class='operation__cancel ng-star-inserted']//span[not(text()='Отозвать платеж')]");
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxExecuted);
        clickElement(buttonFilterSearchOperationTab);
        assertElementPresent("//span[@class='operation__cancel ng-star-inserted']//span[not(text()='Отозвать платеж')]");
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxInProcess);
        clickElement(buttonFilterSearchOperationTab);
        assertElementPresent("//span[@class='operation__cancel ng-star-inserted']//span[text()='Отозвать платеж']");
        clickElement(buttonRecallPay);
        fieldCodeSmsRecallOperation.sendKeys("00000");
        clickElement(buttonRecallOperation);
        checkElementOnDisplay("//p[@class='text-center ng-star-inserted' and text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
        clickElement(buttonRetrySmsCode);
        EnterSms.enter_sms_cancel_operation("Test1","test");
        checkElementOnDisplay("//div[@class='informer__tc' and text()='Заявка на отзыв платежа успешно отправлена']");
        checkElementOnDisplay("//span[@class='ng-star-inserted' and text()='Отозван']");
    }

    public void checkTabOpetaionReturnPay(String Amount, String DescriptionPay, String currantLogin, String nameTemplate, String environment) {
        clickElement(typeOperationDropBox);
        clickElement(typeOperationDropBoxCost);
        clickElement(statusOperationDropBox);
        clickElement(statusOperationDropBoxShowAll);
        fieldPeriodFromOperation.clear();
        fieldPeriodFromOperation.sendKeys("10.06.2019");
        fieldPeriodToOperation.clear();
        fieldPeriodToOperation.sendKeys("27.07.2019");
        clickElement(buttonFilterSearchOperationTab);
        clickElement(buttonReturnPayment);
        amount.sendKeys(Amount);
        clickElement(buttonBudgetaryPaymentNo);
        checkElementOnDisplay("//*[@data-test='create-payment--saveDraft' and @disabled]");
        checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
        descriprionPayment.clear();
        descriprionPayment.sendKeys(DescriptionPay);
        fieldsNumberPayment.clear();
        fieldsNumberPayment.sendKeys(get_template_name());
        clickElement(buttonBudgetaryPaymentNo);
        MyThread.sleep(3000);
        clickElement(buttonSignAndPay);
        MyThread.sleep(4000);
        clickElement(checkboxCreatePayTemplate);
        this.nameTemplatePayInstruction.sendKeys(nameTemplate);
        EnterSms.enter_sms_pp(currantLogin, environment);
        saveScreenShot(app.driver,"checkTabOpetaionReturnPay");
        clickElement(buttonClosePayFormAfterCreate);
    }

    public void checkTabOpetaionSendOnTheSignature() {
        clickElement(buttonDrafts);
        MyThread.sleep(2000);
        clickElement(buttonSendOnTheSignature);
        MyThread.sleep(2000);
        fieldsNumberPayment.clear();
        fieldsNumberPayment.sendKeys(get_template_name());
        MyThread.sleep(2000);
        clickElement(buttonChangeSaveInPayForm);
        MyThread.sleep(2000);
        clickElement(buttonSendOnTheSignature);
        MyThread.sleep(2000);
        clickElement(buttonSendOnTheSignatureInPayForm);
        clickElement(buttonSendOnTheSignatureInPayForm);
    }

    public void checkTabOpetaionDeletePay() {
        clickElement(buttonOnTheSignatureOperationTab);
        clickElement(buttonDeletePay);
    }

    public void testCheckTabOpetaionSignatureAndPay(String Amount, String currantLogin, String environment) {
        MyThread.sleep(2000);
        clickElement(buttonDrafts);
        clickElement(buttonSignatureAndPay);
        fieldsNumberPayment.clear();
        fieldsNumberPayment.sendKeys(get_template_name());
        amount.clear();
        amount.sendKeys(Amount);
        clickElement(buttonEmergenceOrderNo);
        clickElement(buttonSignAndPay);
        MyThread.sleep(2000);
        EnterSms.enter_sms_pp(currantLogin, environment);
        checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ принят в обработку']");
        clickElement(buttonClosePayFormAfterCreate);
    }

    public void testCheckSavePayFromDraft() {
        clickElement(buttonCreatePay);
        MyThread.sleep(4000);
        amount.clear();
        amount.sendKeys("101");
        MyThread.sleep(2000);
        inn.sendKeys("2");
        MyThread.sleep(2000);
        click("//li[@class='item selected ng-star-inserted']");
        descriprionPayment.sendKeys("Autotest Autotest");
        clickElement(buttonEmergenceOrderNo);
        clickElement(buttonSaveDraft);
        checkElementOnDisplay("//div[text()='Черновик успешно создан']");
    }

    public void openTabCurrentAccountPage(String tabMainPage) {
        String element = tabMainPage.toLowerCase();
        if (element.equals("операции")) {
            clickElement(tabOperation);
            waitloadElement(10);
        }
        if (element.equals("выписка")) {
            clickElement(tabStatement);
            waitloadElement(10);
        }
        if (element.equals("лимиты")) {
            clickElement(tabLimits);
            waitloadElement(10);
        }
        if (element.equals("тарифы")) {
            clickElement(tabTariffs);
            waitloadElement(10);
        }
    }

    public CurrentRurAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
