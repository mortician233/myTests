package lockobank;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AccountsPage extends TestBase {

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and contains(text(), 'Логин')]")
    private WebElement createPayment;

    @FindBy(xpath = "//*[@class='textfield__input textfield__input_recovery autofocus inputLoginRecoveryFirst' and @name='Username']")
    private WebElement oneS;

    @FindBy(xpath = "//*[@data-test='templates-autopayments-true-button']")
    private WebElement buttonShowAllCommonPayments;

    @FindBy(xpath = "//*[@data-test='templates-autopayments-false-button']")
    private WebElement buttonShowAllСommonTemplates;

    @FindBy(xpath = "//*[@class='button-group__item' and text()='Реквизиты']")
    private WebElement buttonRequisites;

    @FindBy(xpath = "//*[@data-test='widget-info--openAccountInfo' and text()='Информация по счету']")
    private WebElement buttonInformationFromAccount;

    @FindBy(xpath = "//*[@data-test='widget-info--closeAccountInfo']/*[@class='icon-cross']")
    private WebElement buttonCloseInformationChekingAccount;

    @FindBy(xpath = "//*[@data-test='widget-info--button_copy']/*[@class='icon-copy']")
    private WebElement buttonCopyRequisists;

    @FindBy(xpath = "//*[@class='widget-modal__control widget-modal__copy']/*[@class='icon-copy']")
    private WebElement buttonCloseRequisistsChekingAccount;

    @FindBy(xpath = "//*[@class='widget-modal__control widget-modal__copy']/*[@class='icon-copy']")
    private WebElement buttonCopyOnPageRequsitis;

    @FindBy(xpath = "//*[@class='widget-modal__control widget-modal__send']/*[@class='icon-send']")
    private WebElement buttonSendRequisitsInLetter;

    @FindBy(xpath = "//*[@id='sendRequisite']//*[@class='col-lg-8']//*[@class='input__placeholder']")
    private WebElement fieldEnteredEmail;

    @FindBy(xpath = "//*[@class='input brand focused']//*[@data-test='material-input']")
    private WebElement entereEmail;

    @FindBy(xpath = "//*[@class='button button_theme_brand email-form__button']")
    private WebElement buttonSendEmail;

    @FindBy(xpath = "//*[@alias='numeric' and @data-test='create-payment--amount']")
    private WebElement amount;

    @FindBy(xpath = "//*[@class='create-payment__item ng-star-inserted']//*[@class='switcher__item active' and text()='Нет']")
    private WebElement buttonEmergenceOrderNo;

    @FindBy(xpath = "//*[@class='select__value-text ng-star-inserted']")
    private WebElement paymentAccountList;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='ИНН']")
    private WebElement fieldInn;

    @FindBy(xpath = "//material-input[@placeholder='ИНН']//input[@data-test='material-input']")
    private WebElement inn;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Наименование получателя']")
    private WebElement fieldRecipientName;

    @FindBy(xpath = " //material-input[@name='recipientCaption']//following-sibling::input[@data-test='material-input']")
    private WebElement recipientName;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='БИК']")
    private WebElement fieldbankBik;

    @FindBy(xpath = "//material-input[@name='recipientBankBik']//following-sibling::input[@data-test='material-input']")
    private WebElement bankBik;

    @FindBy(xpath = "//material-input[@name='recipientKpp']//following-sibling::input[@data-test='material-input']")
    private WebElement kpp;

    @FindBy(xpath = "//textarea[@name='paymentPurpose']")
    private WebElement descriprionPayment;

    @FindBy(xpath = "//material-input[@name='recipientAccount']//following-sibling::input[@data-test='material-input']")
    private WebElement accountNumber;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Номер счета']")
    private WebElement fieldAccountNumber;

    @FindBy(xpath = "//*[@data-test='create-payment--switcher-budgetary']//div[text()='Да']")
    private WebElement buttonBudgetaryPaymentYes;

    @FindBy(xpath = "//*[@data-test='create-payment--switcher-budgetary']//*[@class='switcher__item' and text()='Нет']")
    private WebElement buttonBudgetaryPaymentNo;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Код (УИН)']")
    private WebElement fieldWinCode;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Статус составителя']")
    private WebElement fieldStatusOriginator;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Код бюджетной классификации']")
    private WebElement fieldBudgetClassificationCode;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='ОКТМО']")
    private WebElement fieldOKTMO;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Основание платежа']")
    private WebElement fieldReasonPayment;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Налоговый период / код ТО']")
    private WebElement fieldTaxablePeriod;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='№ налогового документа']")
    private WebElement fieldTaxDocument;

    @FindBy(xpath = "//*[@class='input__placeholder' and text()='Дата налогового документа']")
    private WebElement fieldDateTaxDocument;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoStatus']//following-sibling::input[@data-test='material-input']")
    private WebElement statusOriginator;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoKbk']//following-sibling::input[@data-test='material-input']")
    private WebElement budgetClassificationCode;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoOktmo']//following-sibling::input[@data-test='material-input']")
    private WebElement oktmo;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoReason']//following-sibling::input[@data-test='material-input']")
    private WebElement reasonPayment;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoTaxPeriod']//following-sibling::input[@data-test='material-input']")
    private WebElement taxaPeriod;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoNumTaxDoc']//following-sibling::input[@data-test='material-input']")
    private WebElement taxDocument;

    @FindBy(xpath = "//material-input[@name='budgetaryInfoDateTaxDoc']//following-sibling::input[@data-test='material-input--date-input']")
    private WebElement dateTaxDocument;

    @FindBy(xpath = "//material-input[@name='recipientUin']//following-sibling::input[@data-test='material-input']")
    private WebElement winCode;

    @FindBy(xpath = "//modal[@id='createPayment']//*[text()='Подписать и оплатить' and not(@disabled)]")
    private WebElement buttonSignAndPay;

    @FindBy(xpath = "//modal[@id='createPayment']//*[text()='Подписать' and not(@disabled)]")
    private WebElement buttonSign;

    @FindBy(xpath = "//*[text()='Сохранить и оплатить потом']")
    private WebElement buttonSaveAndPayAfter;

    @FindBy(xpath = "//input[@data-test='create-payment--saveTemplate-input']")
    private WebElement checkboxCreatePayTemplate;

    @FindBy(xpath = "//input[@placeholder='Имя шаблона']")
    private WebElement nameTemplate;

    @FindBy(xpath = "//*[@data-test='sms--edit-small' and text()='Изменить']")
    private WebElement changeTemplete;

    @FindBy(xpath = "//button[@data-test='close-modal--createPayment']//div[@class='icon-cross']")
    private WebElement closePayForm;

    @FindBy(xpath = "//modal[@id='createPayment']//div[@class='modal__body modal__body_confirm ng-star-inserted']//button[@data-test='close-modal--createPayment-confirm-yes']")
    private WebElement buttonClosePayFormYes;

    @FindBy(xpath = "//modal[@id='createPayment']//div[@class='sms__control']")
    private WebElement fieldSmsCreateTemlate;

    @FindBy(xpath = "//modal[@id='createPayment']//input[@data-test='sms--input-small']")
    private WebElement smsCreateTemlate;

    @FindBy(xpath = "//*[@data-test='sms--action-submit-small' and not(@disabled)]")
    private WebElement confirmOperationCreateTemplate;

    @FindBy(xpath = "//a[@data-test='sms--new-sms-small' and text()='Получить новый смс-код']")
    private WebElement buttonTakeNewSmsCode;

    @FindBy(xpath = "//button[@data-test='create-payment--closeModal' and text()='Закрыть']")
    private WebElement buttonClosePayFormAfterCreate;

    @FindBy(xpath = "//input[@data-test='create-payment--docNumber']")
    private WebElement fieldsNumberPayment;

    @FindBy(xpath = "//div[@class='payment-tab__caption' and text()='На второй подписи']")
    private WebElement buttonSecondSignature;

    @FindBy(xpath = "//div[@class='payment-tab__caption' and text()='На подписи']")
    private WebElement buttonFirstSignature;




    public void checkInformationFromAccount() {
        clickElement(buttonInformationFromAccount);
        checkElementOnDisplay("//*[text()='Остаток на начало дня']");
        checkElementOnDisplay("//*[text()='Текущий остаток']");
        checkElementOnDisplay("//*[text()='Овердрафт']");
        checkElementOnDisplay("//*[text()='Заблокированные средства']");
        clickElement(buttonCloseInformationChekingAccount);
    }

    public void checkErrorRequiredFields() {
        MyThread.sleep(3000);
        clickElement(fieldInn);
        clickElement(fieldRecipientName);
        clickElement(fieldbankBik);
        clickElement(descriprionPayment);
        clickElement(fieldAccountNumber);
        clickElement(buttonEmergenceOrderNo);
        checkElementOnDisplay("//*[@class='control-error' and not(@hidden) and text()='Не указано наименование получателя']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан ИНН получателя']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан номер счета получателя']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()=' Не указан БИК банка получателя']");
        checkElementOnDisplay("//*[@class='control-error control-error-comment ng-star-inserted' and not(@hidden) and text()=' Не указано назначение платежа']");
        clickElement(buttonBudgetaryPaymentYes);
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан код (УИН) получателя']");
        clickElement(fieldStatusOriginator);
        clickElement(fieldWinCode);
        clickElement(fieldBudgetClassificationCode);
        clickElement(fieldOKTMO);
        clickElement(fieldReasonPayment);
        clickElement(fieldTaxablePeriod);
        clickElement(fieldTaxDocument);
        clickElement(fieldDateTaxDocument);
        clickElement(fieldStatusOriginator);
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан статус составителя']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан код бюджетной классификации']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан ОКТМО']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указано основание платежа']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан налоговый период / код ТО']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указан № налогового документа']");
        checkElementOnDisplay("//*[@class='control-error ng-star-inserted' and not(@hidden) and text()='Не указана дата налогового документа']");
        checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
        checkElementOnDisplay("//*[@data-test='create-payment--saveDraft' and @disabled]");
        clickElement(closePayForm);
        clickElement(buttonClosePayFormYes);
    }

    public void checkRequisitsFromAccount() {
        clickElement(buttonCopyRequisists);
        assertElementPresent("//*[@class='informer__tc' and text()='Реквизиты скопированы в буфер обмена.']");
        clickElement(buttonRequisites);
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"АРДИАЙ ГРУП\"']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='Московская обл, г. Красноармейск, ул. Чкалова, д. 14 пом. 52']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='5012032486']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='1055012249643  ']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='502301001']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='40702810900009352000']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='КБ \"ЛОКО-БАНК\" (АО)']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='Россия, 125167, г. Москва, пр-кт Ленинградский, д. 39, строение 80']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='30101810945250000161']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='7750003943']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='044525161']");
        clickElement(buttonCopyOnPageRequsitis);
        assertElementPresent("//*[@class='informer__tc' and text()='Реквизиты скопированы в буфер обмена.']");
        clickElement(buttonCloseRequisistsChekingAccount);
    }

    public void sendingOnEmailRequisits(String email) {
        clickElement(buttonSendRequisitsInLetter);
        MyThread.sleep(2000);
        checkElementOnDisplay("//*[@class='email-form__title title title_h1' and text()='Отправить реквизиты']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"АРДИАЙ ГРУП\"']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='Московская обл, г. Красноармейск, ул. Чкалова, д. 14 пом. 52']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='5012032486']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='1055012249643  ']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='502301001']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='40702810900009352000']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='КБ \"ЛОКО-БАНК\" (АО)']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='Россия, 125167, г. Москва, пр-кт Ленинградский, д. 39, строение 80']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='30101810945250000161']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='7750003943']");
        checkElementOnDisplay("//*[@class='widget-modal__prop']/*[text()='044525161']");
        clickElement(fieldEnteredEmail);
        entereEmail.sendKeys(email);
        clickElement(buttonSendEmail);
        checkElementOnDisplay("//*[@class='informer__tc' and text()='Реквизиты счета 40702810900009352000 успешно отправлены на адрес www.abagaev@lockobank.ru']");
    }

    public void chechPaymentOrder(Boolean check_summm, String summ) { //false
        if (check_summm == true) {
            this.amount.sendKeys("0.12");
            clickElement(buttonEmergenceOrderNo);
            this.amount.clear();
            this.amount.sendKeys("100000.01");
            clickElement(buttonEmergenceOrderNo);
        } else {
            this.amount.sendKeys(summ);
            clickElement(buttonEmergenceOrderNo);
            clickElement(paymentAccountList);
            checkElementOnDisplay("//*[@class='select__dropdown dropdown']//*[text()='40702.810.4.00103435002']");
            checkElementOnDisplay("//*[@class='select__dropdown dropdown']//*[text()='40701.810.6.00001619000']");
            checkElementOnDisplay("//*[@class='select__dropdown dropdown']//*[text()='40702.810.9.00120561000']");
            saveScreenShot(app.driver, "checkAvailableAccount");
            click("//*[@class='select__dropdown dropdown']//*[text()='40702.810.4.00103435002']");
            checkElementOnDisplay("//*[@class='control control_info']/*[text()='ООО \"ТЕХПРОМ\"']");
            clickElement(paymentAccountList);
            click("//*[@class='select__dropdown dropdown']//*[text()='40701.810.6.00001619000']");
            checkElementOnDisplay("//*[@class='control control_info']/*[text()='ООО \"ОФЛК\"']");
            clickElement(paymentAccountList);
            click("//*[@class='select__dropdown dropdown']//*[text()='40702.810.9.00120561000']");
            checkElementOnDisplay("//*[@class='control control_info']/*[text()='ООО \"Премьер-Пресса\"']");
        }
    }

    public void chechInn(Boolean check_inn, String enterInn) {
        if (check_inn == true) {
            this.inn.sendKeys("6");
            click("//*[@class='item selected ng-star-inserted']");
            this.inn.clear();
            this.inn.sendKeys("2");
            click("//*[@class='item selected ng-star-inserted']");
        } else {
            this.inn.sendKeys(enterInn);
            click("//*[@class='item selected ng-star-inserted']");
        }
    }

    public void checkRecipientName(Boolean chech_Name, String enterRecipientName) {
        if (chech_Name == true) {
            recipientName.clear();
            recipientName.sendKeys("ИП ");
            click("//*[@class='item selected ng-star-inserted']");
            recipientName.clear();
            recipientName.sendKeys("ООО");
            click("//*[@class='item selected ng-star-inserted']");
            clickElement(closePayForm);
            clickElement(buttonClosePayFormYes);
        } else {
            recipientName.clear();
            recipientName.sendKeys(enterRecipientName);
            click("//*[@class='item selected ng-star-inserted']");
            clickElement(closePayForm);
            clickElement(buttonClosePayFormYes);
        }
    }

    public void checkPayForm(Boolean takeError, String inn) {
        if (takeError == false) {
            this.amount.sendKeys("0.12");
            this.inn.clear();
            this.inn.sendKeys(inn);
            click("//*[@class='item selected ng-star-inserted']");
            clickElement(fieldAccountNumber);
            accountNumber.clear();
            accountNumber.sendKeys("40101235546857896890");
            descriprionPayment.sendKeys("Autotest Autotest");
            clickElement(buttonBudgetaryPaymentYes);
            statusOriginator.sendKeys("10");
            budgetClassificationCode.sendKeys("0");
            oktmo.sendKeys("11111111111");
            reasonPayment.sendKeys("0");
            taxaPeriod.sendKeys("11.12.2009");
            taxDocument.sendKeys("0");
            dateTaxDocument.sendKeys("0");
            winCode.sendKeys("2222222222222222222222222");
            clickElement(buttonBudgetaryPaymentNo);
            clickElement(buttonSignAndPay);
            JavascriptExecutor js = (JavascriptExecutor) app.driver;
            String element1 = (js.executeScript("return document.querySelectorAll('.create-payment__doc-date')[0].value").toString());
            System.out.println(element1);
            MyThread.waitVisibleElement("//*[@class='informer__tc']", 5);
            String element2 = (js.executeScript("return document.querySelectorAll('.informer__tc')[0].innerText")).toString();
            System.out.println(element2);
            LocalDateTime ldt = LocalDateTime.now();
            Assert.assertEquals(element1, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
            Assert.assertEquals(element2, " Запрещено указывать в поле <счёт получателя> валютные счета. \"40101235546857896890\". В счете получателя указан счет бюджетной организации, при этом не указано, что это бюджетный платеж.");
            clickElement(closePayForm);
            clickElement(buttonClosePayFormYes);
        } else {
            this.amount.sendKeys("0.12");
            this.inn.clear();
            this.inn.sendKeys(inn);
            click("//*[@class='item selected ng-star-inserted']");
            checkElementOnDisplay("//*[@id='createPayment']//*[@class='modal-title__number']");
            clickElement(buttonBudgetaryPaymentYes);
            descriprionPayment.sendKeys("Autotest Autotest");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            statusOriginator.sendKeys("10");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            budgetClassificationCode.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            oktmo.sendKeys("11111111111");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            reasonPayment.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            taxaPeriod.sendKeys("11.12.2009");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            taxDocument.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            dateTaxDocument.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            winCode.sendKeys("2222222222222222222222222");
            fieldsNumberPayment.clear();
            fieldsNumberPayment.sendKeys(get_template_name());
            clickElement(buttonSignAndPay);
            clickElement(closePayForm);
            clickElement(buttonClosePayFormYes);
        }
    }

    public void chechFormPayInstruction(Boolean BudgetaryPay, String inn, String summ, String nameTemplate, String currantLogin, String Despription,String environment) {
        if (BudgetaryPay == true) {
            this.amount.sendKeys(summ);
            this.inn.clear();
            this.inn.sendKeys(inn);
            MyThread.sleep(3000);
            click("//*[@class='item selected ng-star-inserted']");
            checkElementOnDisplay("//*[@id='createPayment']//*[@class='modal-title__number']");
            accountNumber.clear();
            accountNumber.sendKeys("40101810900000010001");
            kpp.clear();
            kpp.sendKeys("540601001");
            bankBik.clear();
            bankBik.sendKeys("045004001");
            clickElement(buttonBudgetaryPaymentYes);
            descriprionPayment.sendKeys("Autotest Autotest");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            statusOriginator.sendKeys("08");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            budgetClassificationCode.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            oktmo.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            reasonPayment.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            taxaPeriod.sendKeys("11.12.2009");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            taxDocument.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            dateTaxDocument.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            winCode.sendKeys("2222222222222222222222222");
            fieldsNumberPayment.clear();
            fieldsNumberPayment.sendKeys(get_template_name());
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            checkElementOnDisplay("//td[@class='payment-order__cell' and text()='Autotest Autotest']");
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(changeTemplete);
            MyThread.sleep(3000);
            descriprionPayment.clear();
            descriprionPayment.sendKeys(Despription);
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            checkElementOnDisplay("//td[@class='payment-order__cell' and text()='" + Despription + "']");
            clickElement(fieldSmsCreateTemlate);
            smsCreateTemlate.sendKeys("0000");
            checkElementOnDisplay("//*[@data-test='sms--action-submit-small' and @disabled]");
            smsCreateTemlate.clear();
            smsCreateTemlate.sendKeys("00000");
            MyThread.sleep(2000);
            clickElement(confirmOperationCreateTemplate);
            checkElementOnDisplay("//div[@class='informer__tc' and text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(buttonTakeNewSmsCode);
            EnterSms.enter_sms_pp(currantLogin, environment);
            checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ принят в обработку']");
            clickElement(buttonClosePayFormAfterCreate);
            MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.9.00009352000']", 110);
            click("//*[@class='widget__property-value' and text()='40702.810.9.00009352000']");
            waitloadElement(10);
            assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        } else{
            this.amount.sendKeys(summ);
            this.inn.clear();
            this.inn.sendKeys(inn);
            MyThread.sleep(3000);
            click("//*[@class='item selected ng-star-inserted']");
            checkElementOnDisplay("//*[@id='createPayment']//*[@class='modal-title__number']");
            fieldsNumberPayment.clear();
            fieldsNumberPayment.sendKeys(get_template_name());
            descriprionPayment.clear();
            descriprionPayment.sendKeys(Despription);
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            MyThread.sleep(3000);
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(changeTemplete);
            MyThread.sleep(3000);
            descriprionPayment.clear();
            descriprionPayment.sendKeys(Despription);
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            checkElementOnDisplay("//td[@class='payment-order__cell' and text()='" + Despription + " НДС не облагается']");
            clickElement(fieldSmsCreateTemlate);
            smsCreateTemlate.sendKeys("0000");
            checkElementOnDisplay("//*[@data-test='sms--action-submit-small' and @disabled]");
            smsCreateTemlate.clear();
            smsCreateTemlate.sendKeys("00000");
            MyThread.sleep(2000);
            clickElement(confirmOperationCreateTemplate);
            checkElementOnDisplay("//div[@class='informer__tc' and text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(buttonTakeNewSmsCode);
            EnterSms.enter_sms_pp(currantLogin, environment);
            checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ принят в обработку']");
            clickElement(buttonClosePayFormAfterCreate);
            MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00002185000']", 110);
            click("//*[@class='widget__property-value' and text()='40702.810.2.00002185000']");
            waitloadElement(10);
            assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        }
    }


    public void checkSendSignatureSecond(Boolean BudgetaryPay, String inn, String summ, String nameTemplate, String currantLogin, String Despription, String environment, final String account) {
        if (BudgetaryPay == true) {
            this.amount.sendKeys(summ);
            this.inn.clear();
            this.inn.sendKeys(inn);
            MyThread.sleep(3000);
            click("//*[@class='item selected ng-star-inserted']");
            checkElementOnDisplay("//*[@id='createPayment']//*[@class='modal-title__number']");
            accountNumber.clear();
            accountNumber.sendKeys("40101810900000010001");
            kpp.clear();
            kpp.sendKeys("540601001");
            bankBik.clear();
            bankBik.sendKeys("045004001");
            clickElement(buttonBudgetaryPaymentYes);
            descriprionPayment.sendKeys("Autotest Autotest");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            statusOriginator.sendKeys("08");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            budgetClassificationCode.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            oktmo.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            reasonPayment.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            taxaPeriod.sendKeys("11.12.2009");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            taxDocument.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            dateTaxDocument.sendKeys("0");
            checkElementOnDisplay("//*[@data-test='create-payment--onSubmit' and @disabled]");
            winCode.sendKeys("2222222222222222222222222");
            fieldsNumberPayment.clear();
            fieldsNumberPayment.sendKeys(get_template_name());
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            checkElementOnDisplay("//td[@class='payment-order__cell' and text()='Autotest Autotest']");
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(changeTemplete);
            MyThread.sleep(3000);
            descriprionPayment.clear();
            descriprionPayment.sendKeys(Despription);
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            checkElementOnDisplay("//td[@class='payment-order__cell' and text()='" + Despription + "']");
            clickElement(fieldSmsCreateTemlate);
            smsCreateTemlate.sendKeys("0000");
            checkElementOnDisplay("//*[@data-test='sms--action-submit-small' and @disabled]");
            smsCreateTemlate.clear();
            smsCreateTemlate.sendKeys("00000");
            MyThread.sleep(2000);
            clickElement(confirmOperationCreateTemplate);
            checkElementOnDisplay("//div[@class='informer__tc' and text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(buttonTakeNewSmsCode);
            EnterSms.enter_sms_pp(currantLogin, environment);
            checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ принят в обработку']");
            checkElementOnDisplay("//div[@class='informer__tc' and text()= 'Шаблон платежа успешно создан.']");
            clickElement(buttonClosePayFormAfterCreate);
            MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()=" + account + "]", 110);
            click("//*[@class='widget__property-value' and text()=" + account + "]");
            waitloadElement(10);
            assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        } else{
            this.amount.sendKeys(summ);
            this.inn.clear();
            this.inn.sendKeys(inn);
            MyThread.sleep(3000);
            click("//*[@class='item selected ng-star-inserted']");
            checkElementOnDisplay("//*[@id='createPayment']//*[@class='modal-title__number']");
            fieldsNumberPayment.clear();
            fieldsNumberPayment.sendKeys(get_template_name());
            descriprionPayment.clear();
            descriprionPayment.sendKeys(Despription);
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            MyThread.sleep(5000);
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(changeTemplete);
            MyThread.sleep(3000);
            descriprionPayment.clear();
            descriprionPayment.sendKeys(Despription);
            try{
                buttonSignAndPay.click();
            } catch(NoSuchElementException e) {
                buttonSign.click();
            }
            checkElementOnDisplay("//td[@class='payment-order__cell' and text()='" + Despription + " НДС не облагается']");
            clickElement(fieldSmsCreateTemlate);
            smsCreateTemlate.sendKeys("0000");
            checkElementOnDisplay("//*[@data-test='sms--action-submit-small' and @disabled]");
            smsCreateTemlate.clear();
            smsCreateTemlate.sendKeys("00000");
            MyThread.sleep(2000);
            clickElement(confirmOperationCreateTemplate);
            checkElementOnDisplay("//div[@class='informer__tc' and text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
            checkBoxClick(checkboxCreatePayTemplate);
            this.nameTemplate.sendKeys(nameTemplate);
            MyThread.sleep(3000);
            clickElement(buttonTakeNewSmsCode);
            EnterSms.enter_sms_pp(currantLogin, environment);
            checkElementOnDisplay("//div[@class='informer__tc' and text()= 'Шаблон успешно сохранен.']");
            checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ отправлен на вторую подпись']");
            clickElement(buttonClosePayFormAfterCreate);
            MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()=" + account + "]", 110);
            click("//*[@class='widget__property-value' and text()=" + account + "]");
            waitloadElement(10);
            assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
            clickElement(buttonSecondSignature);
            checkElementOnDisplay("//div[@class='link-action__caption' and text()='Вернуть']");
        }
    }

    public void checkSignatureSecondPay(String currantLogin, String password, String environment) {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.logInTest(currantLogin, password);
        EnterSms.enter_sms(currantLogin,environment);
        waitLoadPage(40);
        MyThread.waitVisibleElement("//div[@class='widgets ng-star-inserted']//*[@class='widget__info']", 200);
        MyThread.sleep(2000);
        TestBase.selectCompany("ООО \"АКАДЕМСЕРВИС\"");
        MyThread.sleep(2000);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00001814000']", 200);
        clickAccount("40702.810.2.00001814000");
        MyThread.sleep(2000);
        clickElement(buttonSecondSignature);
        checkElementOnDisplay("//div[@class='link-action__caption' and text()='Подписать и оплатить']");
        checkElementOnDisplay("//div[@class='link-action__caption' and text()='Отказать в подписи']");
        click("//a[@class='link-action link-action_sign ng-star-inserted']//div[@class='link-action__caption' and text()='Подписать и оплатить']");
        clickElement(buttonSignAndPay);
        EnterSms.enter_sms_pp(currantLogin, environment);
        checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ принят в обработку']");
        clickElement(buttonClosePayFormAfterCreate);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()='40702.810.2.00001814000']", 110);
        click("//div[@class='link-action__caption' and text()='Отказать в подписи']");
        checkElementOnDisplay("//div[@class='informer__tc' and text()='Документ сохранен в черновики']");
    }

    public void checkReturneFirstSignature(Boolean BudgetaryPay, String inn, String summ, String nameTemplate, String currantLogin, String Despription, String environment, final String account) {
        this.amount.sendKeys(summ);
        this.inn.clear();
        this.inn.sendKeys(inn);
        MyThread.sleep(3000);
        click("//*[@class='item selected ng-star-inserted']");
        checkElementOnDisplay("//*[@id='createPayment']//*[@class='modal-title__number']");
        fieldsNumberPayment.clear();
        fieldsNumberPayment.sendKeys(get_template_name());
        descriprionPayment.clear();
        descriprionPayment.sendKeys(Despription);
        try{
            buttonSignAndPay.click();
        } catch(NoSuchElementException e) {
            buttonSign.click();
        }
        MyThread.sleep(5000);
        checkBoxClick(checkboxCreatePayTemplate);
        this.nameTemplate.sendKeys(nameTemplate);
        MyThread.sleep(3000);
        clickElement(changeTemplete);
        MyThread.sleep(3000);
        descriprionPayment.clear();
        descriprionPayment.sendKeys(Despription);
        try{
            buttonSignAndPay.click();
        } catch(NoSuchElementException e) {
            buttonSign.click();
        }
        checkElementOnDisplay("//td[@class='payment-order__cell' and text()='" + Despription + " НДС не облагается']");
        clickElement(fieldSmsCreateTemlate);
        smsCreateTemlate.sendKeys("0000");
        checkElementOnDisplay("//*[@data-test='sms--action-submit-small' and @disabled]");
        smsCreateTemlate.clear();
        smsCreateTemlate.sendKeys("00000");
        MyThread.sleep(2000);
        clickElement(confirmOperationCreateTemplate);
        checkElementOnDisplay("//div[@class='informer__tc' and text()='Указан неверный код. Необходимо повторно запросить SMS с кодом.']");
        checkBoxClick(checkboxCreatePayTemplate);
        this.nameTemplate.sendKeys(nameTemplate);
        MyThread.sleep(3000);
        clickElement(buttonTakeNewSmsCode);
        EnterSms.enter_sms_pp(currantLogin, environment);
        checkElementOnDisplay("//div[@class='informer__tc' and text()= 'Шаблон успешно сохранен.']");
        checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ отправлен на вторую подпись']");
        clickElement(buttonClosePayFormAfterCreate);
        MyThread.waitVisibleElement("//*[@class='widget__property-value' and text()=" + account + "]", 110);
        click("//*[@class='widget__property-value' and text()=" + account + "]");
        waitloadElement(10);
        assertElementPresent("//*[text()='При загрузке списка операций произошла ошибка (undefined)']"); //проверка на наличие ошибок
        clickElement(buttonSecondSignature);
        checkElementOnDisplay("//div[@class='link-action__caption' and text()='Вернуть']");
        click("//div[@class='link-action__caption' and text()='Вернуть']");
        checkElementOnDisplay("//div[@class='informer__tc' and text()='Документ возвращен на первую подпись']");
        clickElement(buttonFirstSignature);
        click("//span//div[@class='link-action__caption' and text()='Подписать']");
        clickElement(buttonSign);
        EnterSms.enter_sms_pp(currantLogin, environment);
        checkElementOnDisplay("//div[@class='form-success__text ng-star-inserted' and text()='Документ отправлен на вторую подпись']");
        clickElement(buttonClosePayFormAfterCreate);
    }


    public void closeCreatePayForm() {
        clickElement(closePayForm);
        clickElement(buttonClosePayFormYes);
    }

    public void checkPaymentsInAccount(String Description) {
        JavascriptExecutor js = (JavascriptExecutor) app.driver;
        String element2 = (js.executeScript("return document.querySelectorAll('.operation__description')[1].innerText")).toString();
//        Assert.assertEquals(element2, Description + " НДС не облагается...");
    }

    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

