package Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public final TestBase testBase = new TestBase();
    public static WebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();
    private InternetExplorerOptions options = null;

    // DEV
    public static final String connectionDevString = "https://sm-web2-dev:9943/";
    // TestDBO
    public static final String connectionTestDBOString = "https://test-i.lockobank.ru:8446/";
    // Test
    public static final String connectionTestString = "https://test-i.lockobank.ru:8085/";

    private static String address = "lib/";

    private static String Browser = "Chrome";

    @BeforeTest
    public void start_browser() {

        if (OS.contains("win")) {
            if (Browser.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "" + address + "chromedriver.exe");         // Chrome
                WebDriverRunner.setWebDriver(driver);
                WebDriverRunner.supportsJavascript();
                Configuration.reportsFolder = "C:\\lockobank_tests\\screenshots";
            } else if (Browser.equals("Gecko")) {
                System.setProperty("webdriver.gecko.driver", "" + address + "geckodriver.exe");           // FireFox
            } else if (Browser.equals("IE")){
                    System.setProperty("webdriver.ie.driver","" + address + "IEDriverServer.exe");
                    options = new InternetExplorerOptions();
                    options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
            }
        } else if (OS.contains("mac")) {
            String current_directory = System.getProperty("user.dir");
            File file = new File(current_directory);
            File parent_file = new File(file.getParent());
            if (Browser.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", parent_file.getParent() + address + "chromedriver");         // Chrome
            } else if (Browser.equals("Gecko")) {
                System.setProperty("webdriver.gecko.driver", parent_file.getParent() + address + "geckodriver");           // FireFox
            }
        }

        if (Browser.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (Browser.equals("Gecko")) {
            driver = new FirefoxDriver();
        } else if (Browser.equals("IE")) {
            driver = new InternetExplorerDriver(options);
        }
        else {
            if (OS.contains("win")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("enable-automation");
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-extensions");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--disable-gpu");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                String current_address = System.getProperty("user.dir");
                options.setBinary(current_address + "/IB2Tests/webdriver/Opera/50.0.2762.46/opera.exe");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (OS.contains("mac")) {
                OperaOptions options = new OperaOptions();
                driver = new OperaDriver(options);
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
        }

    public void settingBrowserTestDBO() {
        driver.manage().window().maximize();
        driver.get(connectionTestDBOString);
        PageFactory.initElements(driver, this);
    }

    public void settingBrowserTest() {
        driver.manage().window().maximize();
        driver.get(connectionTestString);
        PageFactory.initElements(driver, this);
    }

    public void settingBrowserDev() {
        driver.manage().window().maximize();
        driver.get(connectionDevString);
        PageFactory.initElements(driver, this);
    }

}
