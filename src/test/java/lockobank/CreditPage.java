package lockobank;

import Utils.MyThread;
import Utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditPage extends TestBase {

    @FindBy(xpath = "//div[@class='widget-info__trigger widget-info__trigger_pencil ng-star-inserted']/div[@class='icon-pencil']")
    private WebElement buttonChangeNameCredit;

    @FindBy(xpath = "//input[contains(@class, 'widget-info__name-editor ng-untouched ng-pristine ng-valid')]")
    private WebElement fieldsNameCredit;

    public void checkPageCredit(Boolean checkCreditDefault,final String numberContract){
        if(checkCreditDefault == true){
            MyThread.waitVisibleElement("//div[text()='Компания']//following-sibling::div[text()='ООО \"АРДИАЙ ГРУП\"']", 170);
            click("//div[@class='widget__property-value' and text()='" + numberContract + "']");
            MyThread.waitVisibleElement("//div[text()='Компания']//following-sibling::div[text()='ООО \"АРДИАЙ ГРУП\"']", 200);
            checkElementOnDisplay("//div[text()='Договор от']//following-sibling::div[text()='07.08.2015']");
            checkElementOnDisplay("//div[text()='Действует до']//following-sibling::div[text()='31.07.2020']");
            checkElementOnDisplay("//div[text()='Дата ближайшего погашения']//following-sibling::div[text()='31.07.2020']");
            //TODO исправить после решения ошибки
            //checkElementOnDisplay("//span[@class='widget-info__property-value_new' and text()='Кредит']");
            buttonChangeNameCredit.click();
            MyThread.sleep(1000);
            fieldsNameCredit.sendKeys("Autotest1");
            click("//div[@class='widget__property-value' and text()='" + numberContract + "']");
            checkElementOnDisplay("//div[@class='widget widget_credit']//div[text()='Autotest1'] ");
            buttonChangeNameCredit.click();
            MyThread.sleep(1000);
            fieldsNameCredit.sendKeys("Кредит");
            MyThread.sleep(1000);
            click("//div[@class='widget__property-value' and text()='" + numberContract + "']");
        } else {
            click("//div[@class='widget__property-value' and text()=" + numberContract + "]");
        }
    }

    public CreditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
