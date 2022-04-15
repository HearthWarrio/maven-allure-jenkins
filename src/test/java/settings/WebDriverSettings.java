package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import static pages.SignInPage.*;

public class WebDriverSettings {
    public static WebDriver driver;
    public static String homeURL = "https://mail.ru";
    public static Integer PAGELOADTIMEOUT = 15;
    public static BaseSelenium baseSelenium;

    public static void setup(String browser) throws Exception {
        if (browser == "chrome") {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGELOADTIMEOUT, TimeUnit.SECONDS);
            baseSelenium = new BaseSelenium(driver);
        }
        if (browser == "opera") {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        if (browser == "firefox") {
            WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "src/test/java/settings/geckodriver.exe");
            FirefoxOptions a_FirefoxOptions = new FirefoxOptions();
            a_FirefoxOptions.setProfile(new ProfilesIni().getProfile("default-release"));
            driver=new FirefoxDriver(a_FirefoxOptions);
            baseSelenium = new BaseSelenium(driver);
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void close() throws Exception {
        Allure.step("Выключаем драйвер");
        driver.quit();
        Thread.sleep(2000);
    }
}
