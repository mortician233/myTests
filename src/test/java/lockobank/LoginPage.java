package lockobank;

import Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//*[@class='textfield']/*[contains(text(), 'Логин')]")
    private WebElement fieldLogin;

    @FindBy(xpath = "//*[@class='textfield__input autofocus inputUserName' and @name='Username']")
    private WebElement login;

    @FindBy(xpath = "//*[@class='textfield']/*[contains(text(), 'Пароль')]")
    private WebElement fieldPassword;

    @FindBy(xpath = "//*[@class='textfield__input inputPassword' and @name='Password']")
    private WebElement password;

    @FindBy(xpath = "//*[@value='login']//*[text()='Войти']")
    private WebElement entry;

    @FindBy(xpath = "//*[@class='login_recovery_button' and contains(text(), 'Забыли логин или пароль?')]")
    private WebElement forgetLogin;

    @FindBy(xpath = "//*[@class='login_demo_button']")
    private WebElement enteredDemo;

    public void logInTest(String currentUser, String currentPassword) {
        clickElement(fieldLogin);
        waitloadElement(20);
        login.sendKeys(currentUser);
        clickElement(fieldPassword);
        password.sendKeys(currentPassword);
        waitloadElement(20);
        clickElement(entry);
        waitLoadPage(10);
    }

    public void enterDemo() {
        clickElement(enteredDemo);
    }

    public void forgetLogin() {
        clickElement(forgetLogin);
    }

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
