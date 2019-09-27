package lockobank;

import Utils.EnterSms;
import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LetterPage extends TestBase {

    @FindBy(xpath = "//div[@class='page-header__tabs tabs ng-star-inserted']/div[text()='Входящие']")
    private WebElement tabInboxLetter;

    @FindBy(xpath = "//div[@class='page-header__tabs tabs ng-star-inserted']/div[text()='Исходящие']")
    private WebElement tabOutboxLetter;

    @FindBy(xpath = "//div[@class='page-header__tabs tabs ng-star-inserted']/div[text()='Черновики']")
    private WebElement tabDraftLetter;

    @FindBy(xpath = "//div[@class='page-header__tabs tabs ng-star-inserted']/div[text()='Заказ справок']")
    private WebElement tabOrderingInquiries;

    @FindBy(xpath = "//button[@class='button button_theme_brand' and text()='Ответить']")
    private WebElement buttonRespond;

    @FindBy(xpath = "//a[@class='message-detail__back']")
    private WebElement buttonBackAllLetters;

    @FindBy(xpath = "//button[@class='button respond__cancel ng-tns-c43-2 ng-star-inserted' and text()='Отмена']")
    private WebElement buttonCancel;

    @FindBy(xpath = "//button[@class='button respond__cancel ng-tns-c43-3 ng-star-inserted' and text()='Отмена']")
    private WebElement buttonCancelDraft;

    @FindBy(xpath = "//button[@class='button button_theme_brand respond__submit ng-tns-c43-4 ng-star-inserted']//span[text()='Отправить сообщение']")
    private WebElement buttonSendMessageLetterPage;

    @FindBy(xpath = "//button[@class='button respond__cancel ng-tns-c38-10 ng-star-inserted' and text()='Отмена']")
    private WebElement dropDownSelectRecipient;

    @FindBy(xpath = "//div[@class='respond__item']//textarea[@placeholder='Ваше сообщение']")
    private WebElement fieldYourMessege;

    @FindBy(xpath="//div[@class='tab-content active']//input[@data-period-from='data-period-from']")
    private WebElement fieldPeriodFrom;

    @FindBy(xpath="//div[@class='tab-content active']//input[@data-test='period--input-to']")
    private WebElement fieldPeriodTo;

    @FindBy(xpath="//div[@class='tab-content active']//button[@class='button button_type_search']")
    private WebElement buttonSeachPeriod;

    @FindBy(xpath = "//textarea[@class='control__input respond__control ng-untouched ng-pristine ng-invalid']")
    private WebElement fieldMessage;

    @FindBy(xpath="//a[@class='message-detail__back']")
    private WebElement buttonBackToListMessage;

    @FindBy(xpath="//span[@_ngcontent-c39 and text()='Удалить']")
    private WebElement buttonDeleteDraft;





    public void chechInboxLetter(String login, String environment, String typeLetter){
        openTabLetterPage(typeLetter);
        numberSizeLetter("//div[@class='tab-content active']//div[@class='message']", 5);
        click("//div[@class='tab-content active']//button[@class='button button_theme_brand' and text()='Показать еще']"); // click по кнопке "Показать еще" на табе Входящие письма
        MyThread.sleep(2000);
        numberSizeLetter("//div[@class='tab-content active']//div[@class='message']", 10);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты! ']");
        saveScreenShot(app.driver,"chechInboxLetter");
        fieldPeriodFrom.clear();
        fieldPeriodFrom.sendKeys("01.09.2019");
        fieldPeriodTo.clear();
        fieldPeriodTo.sendKeys("29.09.2019");
        clickElement(buttonSeachPeriod);
        checkElementOnDisplay("//div[@class='message__preview-item message__preview-item_from']//div[text()='Техническая поддержка']");
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        MyThread.sleep(2000);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты!']");
        clickElement(buttonRespond);
        clickElement(buttonCancel);
        openTabLetterPage(typeLetter);
        checkElementOnDisplay("//div[@class='message__preview-item message__preview-item_from']//div[text()='Техническая поддержка']");
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        MyThread.sleep(2000);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты!']");
        clickElement(buttonBackToListMessage);
        checkElementOnDisplay("//div[@class='message__preview-item message__preview-item_from']//div[text()='Техническая поддержка']");
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        MyThread.sleep(2000);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты!']");
        clickElement(buttonRespond);
        app.driver.findElement(By.xpath("//div[@class='respond__item']//input[@class='file-zone__select-file']")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        MyThread.sleep(2000);
        fieldMessage.sendKeys("AutotestchechInboxLetter");
        clickElement(buttonSendMessageLetterPage);
        EnterSms.enter_sms_send_letter(login,environment);
        checkElementOnDisplay("//div[text()='Сообщение успешно отправлено']");
    }


    public void chechOutboxLetter(String typeLetter){
        openTabLetterPage(typeLetter);
        numberSizeLetter("//div[@class='tab-content active']//div[@class='message']", 5);
        click("//div[@class='tab-content active']//button[@class='button button_theme_brand' and text()='Показать еще']"); // click по кнопке "Показать еще" на табе Входящие письма
        MyThread.sleep(2000);
        numberSizeLetter("//div[@class='tab-content active']//div[@class='message']", 10);
        fieldPeriodFrom.clear();
        fieldPeriodFrom.sendKeys("01.09.2019");
        fieldPeriodTo.clear();
        fieldPeriodTo.sendKeys("29.09.2019");
        clickElement(buttonSeachPeriod);
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        MyThread.sleep(2000);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты!']");
        clickElement(buttonRespond);
        clickElement(buttonBackToListMessage);
        saveScreenShot(app.driver,"chechOutboxLetter");
    }

    public void chechDraftLetter(String typeLetter){
        openTabLetterPage(typeLetter);
        numberSizeLetter("//div[@class='tab-content active']//div[@class='message']", 5);
        click("//div[@class='tab-content active']//button[@class='button button_theme_brand' and text()='Показать еще']"); // click по кнопке "Показать еще" на табе Входящие письма
        MyThread.sleep(2000);
        numberSizeLetter("//div[@class='tab-content active']//div[@class='message']", 10);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты! ']");
        saveScreenShot(app.driver,"chechInboxLetter");
        fieldPeriodFrom.clear();
        fieldPeriodFrom.sendKeys("01.09.2019");
        fieldPeriodTo.clear();
        fieldPeriodTo.sendKeys("29.09.2019");
        clickElement(buttonSeachPeriod);
        checkElementOnDisplay("//div[@class='message__preview-item message__preview-item_from']//div[text()='Техническая поддержка']");
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        MyThread.sleep(2000);
        checkElementOnDisplay("//div[text()='Уважаемые клиенты!']");
        clickElement(buttonRespond);
        app.driver.findElement(By.xpath("//div[@class='respond__item']//input[@class='file-zone__select-file']")).sendKeys("C:\\Users\\ABagaev\\Downloads\\payment_20.pdf");
        MyThread.sleep(2000);
        fieldMessage.sendKeys("AutotestchechInboxLetter");
        clickElement(buttonCancel);
        MyThread.sleep(2000);
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        checkElementOnDisplay("//textarea[@ng-reflect-model='AutotestchechInboxLetter']");
        checkElementOnDisplay("//div[text()='payment_20.pdf']");
        clickElement(buttonCancelDraft);
        openTabLetterPage(typeLetter);
        checkElementOnDisplay("//div[@class='message__preview-item message__preview-item_from']//div[text()='Техническая поддержка']");
        click("//div[text()='Изменение счетов по уплате налогов и взносов']"); // клик по письму
        MyThread.sleep(2000);
        checkElementOnDisplay("//textarea[@ng-reflect-model='AutotestchechInboxLetter']");
        checkElementOnDisplay("//div[text()='payment_20.pdf']");
        clickElement(buttonBackToListMessage);
        MyThread.sleep(2000);
        clickElement(buttonDeleteDraft);
        checkElementOnDisplay("//div[text()='Сообщение успешно удалено']");
    }


    public void openTabLetterPage(String tabMainPage) {
        String element = tabMainPage.toLowerCase();
        if (element.equals("входящие")) {
            click("//div[@class='page-header__tabs tabs ng-star-inserted']/div[text()='Входящие']");
            waitloadElement(10);
        }
        if (element.equals("исходящие")) {
            clickElement(tabOutboxLetter);
            waitloadElement(10);
        }
        if (element.equals("черновики")) {
            clickElement(tabDraftLetter);
            waitloadElement(10);
        }
        if (element.equals("заказ справок")) {
            clickElement(tabOrderingInquiries);
            waitloadElement(10);
        }
    }


    public void numberSizeLetter(String xpath, int numberLetter){
        List<WebElement> sizeLetter = app.driver.findElements(By.xpath(xpath));
        if(sizeLetter.size() == numberLetter) {
            System.out.println("Количество писем на странице верное " + numberLetter);
        } else {
            System.out.println("Количество писем на странице неверное " + numberLetter);
        }
    }
    public LetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
