package lockobank;

import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends TestBase {

    @FindBy(xpath = "//*[@class='icon-logout']")
    private WebElement logOut;

    @FindBy(xpath = "//*[@data-test='operations-list']")
    private WebElement temlateOperationsFromAccounts;

    @FindBy(xpath = "//*[@data-test='templates-autopayments-true']")
    private WebElement temlateСommonPayments;

    @FindBy(xpath = "//*[@data-test='templates-autopayments-false']")
    private WebElement temlateСommonTemplates;

    @FindBy(xpath = "//*[@data-test='templates-autopayments-true-button']")
    private WebElement buttonShowAllCommonPayments;

    @FindBy(xpath = "//*[@data-test='templates-autopayments-false-button']")
    private WebElement buttonShowAllСommonTemplates;

    @FindBy(xpath = "//*[@routerlink='/accounts' and text()='Счета']")
    private WebElement tabAccounts;

    @FindBy(xpath = "//*[@routerlink='/deposits' and text()='Депозиты']")
    private WebElement tabDeposits;

    @FindBy(xpath = "//*[@routerlink='/credits' and text()='Кредиты']")
    private WebElement tabCredits;

    @FindBy(xpath = "//*[@routerlink='/conversion' and text()='Обменять валюту']")
    private WebElement tabCurrencyConversion;

    @FindBy(xpath = "//*[@routerlink='/currency' and text()='Валютные операции']")
    private WebElement tabCurrencyOperations;

    @FindBy(xpath = "//*[@routerlink='/service' and text()='Бухгалтерия и сервисы']")
    private WebElement tabAccountingAndServices;

    @FindBy(xpath = "//div[@class='management__icon management__icon_notify']/div[@class='icon-mail']")
    private WebElement buttonLetter;

    public void logOut() {
        WebDriverWait wait = new WebDriverWait(app.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logOut));
        app.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        clickElement(logOut);
        app.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public void checkElementsOnMainPage() {
        temlateOperationsFromAccounts.isDisplayed();
//        temlateСommonPayments.isDisplayed();
//        temlateСommonTemplates.isDisplayed();
        tabAccountingAndServices.isDisplayed();
        tabAccounts.isDisplayed();
        tabCredits.isDisplayed();
//        tabCurrencyConversion.isDisplayed();
        tabCurrencyOperations.isDisplayed();
        tabDeposits.isDisplayed();
    }

    public void checkCreateTemplate(String nameTemplate, final String numberAccount) {
        clickElement(tabAccounts);
        MyThread.sleep(4000);
        clickElement(buttonShowAllСommonTemplates);
        waitLoadPage(5);
        MyThread.sleep(3000);
        checkElementOnDisplay("//div[@class='templates-list__row ng-star-inserted']//div[text()='" + nameTemplate + "']");
        clickElement(tabAccounts);
        MyThread.waitVisibleElement("//*[@class='template__subinfo' and text()='" + numberAccount + "']", 110);
    }

    public void clickShowAllCommonPayments() {
        clickElement(buttonShowAllCommonPayments);
    }

    public void clickShowAllСommonTemplates() {
        clickElement(buttonShowAllСommonTemplates);
    }

    public void openTabMainPage(String tabMainPage) {
        String element = tabMainPage.toLowerCase();
        if (element.equals("счета")) {
            clickElement(tabAccounts);
            waitloadElement(10);
        }
        if (element.equals("кредиты")) {
            clickElement(tabCredits);
            waitloadElement(10);
        }
        if (element.equals("депозиты")) {
            clickElement(tabDeposits);
            waitloadElement(10);
        }
        if (element.equals("обменять валюту")) {
            clickElement(tabCurrencyConversion);
            waitloadElement(10);
        }
        if (element.equals("валютные операции")) {
            clickElement(tabCurrencyOperations);
            waitloadElement(10);
        }
        if (element.equals("бухгалтерия и сервисы")) {
            clickElement(tabAccountingAndServices);
            waitloadElement(10);
        }
    }

    public void interedLetter(){
      clickElement(buttonLetter);
      saveScreenShot(app.driver,"interedLetter");
    }

    public void checkTemplate(final String nameTemplate){
        checkElementOnDisplay("//div[@class='template__payer' and text()= '" + nameTemplate + "']");
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
