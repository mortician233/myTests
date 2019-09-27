package lockobank;

import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class DepositsPage extends TestBase {

    @FindBy(xpath = "//button[text()='Реквизиты']")
    private WebElement buttonRequisites;

    @FindBy(xpath = "//*[text()='Копировать']")
    private WebElement buttonCopies;

    @FindBy(xpath = "//app-widgets//*[text()='Отправить']")
    private WebElement buttonSendEmail;

    @FindBy(xpath = "//modal[@id='sendRequisite']//input[@class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//modal[@style='display: inline;']//button[@type='submit']//span[text()='Отправить']")
    private WebElement buttonSend;

    @FindBy(xpath = "//div[@class='widget-info__trigger widget-info__trigger_pencil ng-star-inserted']/div[@class='icon-pencil']")
    private WebElement buttonChangeNameDeposit;

    @FindBy(xpath = "//input[contains(@class, 'widget-info__name-editor ng-untouched ng-pristine ng-valid')]")
    private WebElement fieldsNameDeposit;

    @FindBy(xpath = "//a[@class='button button_type_add']//span[text()='Открыть новый']")
    private WebElement buttonOpenNewDeposit;

    @FindBy(xpath = "//div[@class='deposit-open__item deposit-open__item_submit']//span[text()='Открыть депозит']")
    private WebElement buttonOpenDeposit;

    @FindBy(xpath = "//div[@style='background-image: url(\"../../../assets/images/deposit-end-date.jpg\");']//span[text()='Открыть депозит']")
    private WebElement buttonOpenNewDepositProcentEndTime;

    @FindBy(xpath = "//div[@style='background-image: url(\"../../../assets/images/deposit-every-month.jpg\");']//span[text()='Открыть депозит']")
    private WebElement buttonOpenNewDepositProcentEndMouth;

    @FindBy(xpath = "//a[@download='https://www.lockobank.ru/upload/content/business/deposits/msb-vysokaya-stavka/hight-end.pdf']//span[text()='Скачать ставки (pdf)']")
    private WebElement buttonDownloadRatePDF;

    @FindBy(xpath = "//div[@class='deposit-section deposit-calc']//material-input[@name='newDepositAmount']//input[@class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement fieldAmountDepositCalculateDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-open']//material-input[@name='newDepositAmount']//input[@class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement fieldAmountDepositOpenDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-calc']//material-input[@name='newDepositPeriod']//input[@class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement fieldPeriodDepositCalculateDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-open']//material-input[@name='newDepositPeriod']//input[@class='input__control ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement fieldPeriodDepositOpenDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-calc']//material-input[@name='newDepositAmount']//input[@class='input__control ng-pristine ng-valid ng-star-inserted ng-touched']")
    private WebElement fieldInputAmountDepositCalculateDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-open']//material-input[@name='newDepositAmount']//input[@class='input__control ng-pristine ng-valid ng-star-inserted ng-touched']")
    private WebElement fieldInputAmountDepositOpenDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-calc']//material-input[@name='newDepositPeriod']//input[@class='input__control ng-pristine ng-valid ng-star-inserted ng-touched']")
    private WebElement fieldInputPeriodDepositCalculateDeposit;

    @FindBy(xpath = "//div[@class='deposit-section deposit-open']//material-input[@name='newDepositPeriod']//input[@class='input__control ng-pristine ng-valid ng-star-inserted ng-touched']")
    private WebElement fieldInputPeriodDepositOpenDeposit;

    @FindBy(xpath = "//button[@class='button button_theme_brand']//span[text()='Подтвердить']")
    private WebElement buttonConfirm;



    public void checkRequisitesDeposit(Boolean defaultCheck, String email, String procentSelect){
        if(defaultCheck == true) {
            click("//div[@class='widget widget_extended widget_end-date']//div[text()='" + procentSelect + "']");
            clickElement(buttonRequisites);
            checkElementOnDisplay("//*[@class='email-form__title title title_h1' and text()='Отправить реквизиты']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='Общество с ограниченной ответственностью \"РА Тотал Вью\"']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='125212, г. Москва, Головинское ш, д. 5, кор. 1, Оф. эт. 10  пом. 10024']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='7743079684']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='1037743024065  ']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='774301001']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='КБ \"ЛОКО-БАНК\" (АО)']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='Россия, 125167, г. Москва, пр-кт Ленинградский, д. 39, строение 80']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='30101810945250000161']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='7750003943']");
            checkElementOnDisplay("//*[@class='widget-modal__prop-value' and text()='044525161']");
            clickElement(buttonCopies);
            checkElementOnDisplay("//div[text()='Реквизиты скопированы в буфер обмена.'] ");
            clickElement(buttonSendEmail);
            saveScreenShot(app.driver, "checkRequisiteDepositSendEmail");
            clickElement(buttonSend);
            fieldEmail.sendKeys(email);
            clickElement(buttonSend);
            checkElementOnDisplay("//div[text()='Реквизиты счета успешно отправлены на адрес abagaev@lockobank.ru']");
            saveScreenShot(app.driver, "checkRequisiteSendEmail");
        } else {
            click("//div[@class='swiper-slide widgets-list__item ng-star-inserted']//div[text()=" + procentSelect + "]");
            clickElement(buttonRequisites);
            clickElement(buttonCopies);
            checkElementOnDisplay("//div[text()='Реквизиты скопированы в буфер обмена.'] ");
            clickElement(buttonSendEmail);
            saveScreenShot(app.driver, "checkRequisiteDepositSendEmail");
            clickElement(buttonSend);
            fieldEmail.sendKeys(email);
            clickElement(buttonSend);
            checkElementOnDisplay("//div[text()='Реквизиты счета успешно отправлены на адрес abagaev@lockobank.ru']");
            saveScreenShot(app.driver, "checkRequisiteSendEmail");
        }
    }

    public void checkWidgetDeposit(String procentSelect){
            click("//div[@class='widget widget_extended widget_end-date']//div[text()='" + procentSelect + "']");
            checkElementOnDisplay("//h1[text()='Информация по депозиту']");
            //TODO добавить проверку после исправления ошибки
            //checkElementOnDisplay("//span[@class='widget-info__property-value_new' and text()='Высокая ставка Онлайн']");
            clickElement(buttonChangeNameDeposit);
            MyThread.sleep(1000);
            fieldsNameDeposit.sendKeys("Autotest1");
            checkElementOnDisplay("//span[@class='widget-info__property-value_new' and text()='Autotest1']");
            click("//li[text()='Информация']");
            clickElement(buttonChangeNameDeposit);
            MyThread.sleep(1000);
            fieldsNameDeposit.sendKeys("Высокая ставка Онлайн");
            click("//li[text()='Информация']");
            checkElementOnDisplay("//span[@class='widget-info__property-value_new' and text()='Высокая ставка Онлайн']");
            click("//div[@class='deposit-info__cell deposit-info__cell-prop' and text()='Счёт возврата']");
            saveScreenShot(app.driver,"checkWidgetDepositInformationPage");
    }

    public void checkOpenNewDeposit(){
            clickElement(buttonOpenNewDeposit);
            clickElement(buttonOpenNewDepositProcentEndTime);
            saveScreenShot(app.driver,"checkOpenNewDepositConditions");
            String originalWindow = app.driver.getWindowHandle();
            final Set<String> oldWindowsSet = app.driver.getWindowHandles();
            clickElement(buttonDownloadRatePDF);
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
            MyThread.sleep(2000);
            buttonOpenDeposit.click();
            checkElementOnDisplay("//div[@class='deposit-open__error ng-star-inserted']");
            fieldAmountDepositCalculateDeposit.clear();
            MyThread.sleep(2000);
            fieldInputAmountDepositCalculateDeposit.sendKeys("1");
            MyThread.sleep(2000);
            fieldPeriodDepositCalculateDeposit.clear();
            MyThread.sleep(2000);
            fieldInputPeriodDepositCalculateDeposit.sendKeys("7");
            click("//app-select[@placeholder='Выберите счет списания']//div[@class='select__trigger ng-star-inserted']"); //dropBox счет списания
            click("//div[@class='select__dropdown dropdown']//div[text()='40702.810.2.00002185000']"); // выбор первого счета
            checkElementOnDisplay("//div[text()='Счёт выплаты процентов']//following::div[text()='40702.810.2.00002185000']");
            checkElementOnDisplay("//div[text()='Счёт возврата депозита']//following::div[text()='40702.810.2.00002185000']");
            clickElement(buttonOpenDeposit);
            MyThread.sleep(3000);
            saveScreenShot(app.driver,"checkOpenNewDepositFinalForm");
            clickElement(buttonConfirm);
            MyThread.waitVisibleElement("//div[@class='form-success__text' and text()='Депозит открыт']", 170);
            click("//button[@class='button button_theme_brand' and text()='Закрыть']");
            checkElementOnDisplay("//div[text()='Высокая ставка Онлайн']//following-sibling::div[text()='Выплата процентов в конце срока']");
            click("//div[text()='Высокая ставка Онлайн']//following-sibling::div[text()='Выплата процентов в конце срока']");
            clickElement(buttonChangeNameDeposit);
            MyThread.sleep(1000);
            fieldsNameDeposit.sendKeys("Autotest1");
            checkElementOnDisplay("//span[@class='widget-info__property-value_new' and text()='Autotest1']");
            click("//li[text()='Информация']");
    }



    public DepositsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

