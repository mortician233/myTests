package tests;

import Utils.CustomTestListener;
import Utils.MyThread;
import Utils.TestBase;
import lockobank.LoginPage;
import lockobank.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({CustomTestListener.class})
public class DemoTests extends TestBase {

    @Test()
    @Title("Проверка - Демо режима")
    public void testDemo() {
        app.start_browser();
        waitloadElement(30);
        app.driver.manage().window().maximize();
        app.driver.get(app.connectionTestString);
        waitLoadPage(30);
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.enterDemo();
        waitLoadPage(45);
        MyThread.sleep(4000);
        MainPage mainPage = new MainPage(app.driver);
        mainPage.checkElementsOnMainPage();
        mainPage.logOut();
        app.tearDown();
    }
}
