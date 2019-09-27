package lockobank;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage extends TestBase {

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and contains(text(), 'Логин')]")
    private WebElement fieldLogin;

    @FindBy(xpath = "//*[@class='textfield__input textfield__input_recovery autofocus inputLoginRecoveryFirst' and @name='Username']")
    private WebElement login;

    @FindBy(xpath = "//*[@class='login__form__button_recovery login__form__button_recoveryFirst' and @name='sms_button']")
    private WebElement buttonСontinue;

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and contains(text(), 'Введите новый пароль')]")
    private WebElement fieldPassword;

    @FindBy(xpath = "//*[@class='textfield__input inputNewPassword autofocus' and @name='Username']")
    private WebElement password;

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and contains(text(), 'Повторите новый пароль')]")
    private WebElement fieldRetryPassword;

    @FindBy(xpath = "//*[@class='textfield__input inputNewPasswordRepeat autofocus' and @name='Username']")
    private WebElement retryPassword;

    @FindBy(xpath = "//*[@class='login__form__button_recovery login__form__button_recoverySaveNewPassword']")
    private WebElement buttonSavePassword;

    @FindBy(xpath = "//*[@class='login__form__button_recoveryEnd']//*[text()='Войти']")
    private WebElement buttonEntry;

    @FindBy(xpath = "//div[@data-test='recovery-form--forgot']")
    private WebElement buttonForgetLogin;

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and text()='Номер телефона']")
    private WebElement fieldPhone;

    @FindBy(xpath = "//*[@class='textfield__input textfield__input_recovery inputUserPhone autofocus']")
    private WebElement phone;

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and text()='Серия']")
    private WebElement fieldPassportSeries;

    @FindBy(xpath = "//*[@class='textfield__input textfield__input_recovery inputPassportSeries autofocus']")
    private WebElement passportSeriesFocus;

    @FindBy(xpath = "//*[@class='textfield__placeholder textfield__placeholder_recovery' and text()='Номер']")
    private WebElement fieldPassportNumber;

    @FindBy(xpath = "//*[@class='textfield__input textfield__input_recovery inputPassportNumber autofocus']")
    private WebElement passportNumberFocus;

    @FindBy(xpath = "//*[@class='login__form__button_recovery login__form__button_recoveryPassport']/*[text()='Продолжить']")
    private WebElement buttonContinuePassportPage;

    public void forgetPasswordFromLogin(String currentUser, String currentPassword, String environment) {
        waitLoadPage(20);
        clickElement(fieldLogin);
        waitLoadPage(10);
        login.sendKeys(currentUser);
        waitLoadPage(10);
        clickElement(buttonСontinue);
        EnterSms.enter_sms_lp(currentUser, environment);
        clickElement(fieldPassword);
        password.sendKeys(currentPassword);
        clickElement(fieldRetryPassword);
        retryPassword.sendKeys(currentPassword);
        clickElement(buttonSavePassword);
        MyThread.waitVisibleElement("//*[@class='login__form__button_recoveryEnd']//*[text()='Войти']", 30);
        MyThread.sleep(2000);
        clickElement(buttonEntry);
    }

    public void forgetPasswordFromPhoneNumber(String numberPhone, String passportSeries, String passportNumber, String currentUser, String currentPassword, String environment) {
        waitLoadPage(10);
        clickElement(fieldPhone);
        phone.sendKeys(numberPhone);
        clickElement(fieldPassportSeries);
        passportSeriesFocus.sendKeys(passportSeries);
        clickElement(fieldPassportNumber);
        passportNumberFocus.sendKeys(passportNumber);
        clickElement(buttonContinuePassportPage);
        EnterSms.enter_sms_lp(currentUser, environment);
        clickElement(fieldPassword);
        password.sendKeys(currentPassword);
        clickElement(fieldRetryPassword);
        retryPassword.sendKeys(currentPassword);
        clickElement(buttonSavePassword);
        MyThread.waitVisibleElement("//*[@class='login__form__button_recoveryEnd']//*[text()='Войти']", 30);
        clickElement(buttonEntry);
    }

    public ForgetPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
