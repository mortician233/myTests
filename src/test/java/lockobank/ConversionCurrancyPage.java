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

public class ConversionCurrancyPage extends TestBase {

    @FindBy(xpath = "//app-select[@placeholder='Счет списания']//div[@class='icon-triangle-down']")
    private WebElement buttonWriteOffAccount;

    @FindBy(xpath = "//app-select[@placeholder='Счет комиссии']//div[@class='icon-triangle-down']")
    private WebElement buttonAccountComission;

    @FindBy(xpath = "//app-select[@placeholder='Счет зачисления']//div[@class='icon-triangle-down']")
    private WebElement buttonCreditAccount;

    @FindBy(xpath = "//div[@class='input__placeholder' and text()='Сумма списания']")
    private WebElement fieldSummaWriteOff;

    @FindBy(xpath = "//div[text()='Сумма списания']//following-sibling::input[@data-test='material-input']")
    private WebElement inputSummaWriteOff;

    @FindBy(xpath = "//button[@class='button button_theme_light']")
    private WebElement buttonFurther;

    @FindBy(xpath = "//modal[@id='valuteConversion']//input[@type='checkbox']")
    private WebElement checkboxCreateTemplate;

    @FindBy(xpath = "//input[@placeholder='Имя шаблона']")
    private WebElement fieldNameTemplate;

    @FindBy(xpath = "//modal[@id='valuteConversion']//input[@placeholder='Код из СМС']")
    private WebElement fieldSmsCode;

    @FindBy(xpath = "//modal[@id='valuteConversion']//button[@class='button button_theme_brand']/span[text()='Подтвердить операцию']")
    private WebElement buttonConfirmOperationConversionPayForm;

    @FindBy(xpath = "//modal[@id='valuteConversion']//a[text()='Получить новый смс-код']")
    private WebElement buttonRetrySmsConversionPayForm;


    public void checkConversionCurrancy(String amount, String environment){
        clickElement(buttonWriteOffAccount);
        click("//div[text()='Расчетный счет (ООО \"АКАДЕМСЕРВИС\")']//following::div[text()='40702.810.2.00001814000']");
        checkElementOnDisplay("//label[text()='Счет комиссии']//following::div[text()='40702.810.2.00001814000']");
        clickElement(fieldSummaWriteOff);
        checkElementOnDisplay("//button[@class='button button_theme_light' and @disabled]");
        inputSummaWriteOff.sendKeys(amount);
        MyThread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) app.driver;
        String courseCurrancy = (js.executeScript("return document.querySelectorAll('input[data-test=material-input]')[1].value")).toString();
        LocalDateTime ldt = LocalDateTime.now();
        Assert.assertEquals(courseCurrancy,"По курсу Банка на "+ DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH).format(ldt));
        clickElement(buttonWriteOffAccount);
        click("//div[text()='Расчетный счет (ООО \"АКАДЕМСЕРВИС\")']//following::div[text()='40702.810.2.00001814000']");
        checkElementOnDisplay("//label[text()='Счет комиссии']//following::div[text()='40702.810.2.00001814000']");
        clickElement(buttonCreditAccount);
        checkElementOnDisplay("//li[@class='dropdown__item ng-star-inserted']//following::div[text()='EUR']//following-sibling::div[text()='40702.978.2.00001814010']");
        checkElementOnDisplay("//li[@class='dropdown__item ng-star-inserted']//following::div[text()='USD']//following-sibling::div[text()='40702.840.6.00001814010']");
        click("//app-select[@placeholder='Счет зачисления']//div[text()='40702.978.2.00001814010']");
        clickElement(buttonFurther);
        MyThread.sleep(2000);
        checkElementOnDisplay("//td[text()='11.01']");
        checkElementOnDisplay("//div[text()='Одиннадцать рублей 01 копейка ']");
        clickElement(checkboxCreateTemplate);
        fieldNameTemplate.sendKeys("AutotestConvesionCurrancy");
        fieldSmsCode.sendKeys("12312");
        MyThread.sleep(2000);
        clickElement(buttonConfirmOperationConversionPayForm);
        MyThread.sleep(2000);
        clickElement(buttonRetrySmsConversionPayForm);
        MyThread.sleep(4000);
        EnterSms.enter_sms_sale_currancy_confirmsms_coversion_currancy("Test1", environment);
    }

    public ConversionCurrancyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
