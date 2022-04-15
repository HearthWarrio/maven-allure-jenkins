package pages;

import io.qameta.allure.Allure;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.BaseSelenium;
import settings.ConfigVars;
import settings.WebDriverSettings;

public class SignInPage extends WebDriverSettings {
    public static BaseSelenium baseSelenium;
    public static SignInPage signInPage;

    @FindBy(xpath = "/html/body/main/div[5]/div[1]/div[1]/div[2]/div[2]/a")
    public static WebElement addMailBtn;
    @FindBy(xpath = "//*[@name=\"username\"]")
    public static WebElement loginField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/div/div/div/div/div/input")
    public static WebElement passField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[2]/div/div/form/div[2]/div/div[3]/div/div/div[1]/div/button")
    public static WebElement applyBtn;
    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div[1]/div[2]/div[1]/button")
    public static WebElement enterBtn;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/div")
    public static WebElement preExtiBtn;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[3]/div/div/a[3]")
    public static WebElement exitBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[3]/div/div/div[1]/button")
    public static WebElement enterPassBtn;
    @FindBy(xpath = "/html/body/main/div[4]/div[3]/div[5]/div[3]/div[2]/div[1]/div/div[2]/div/div/div[1]/a[8]")
    public static WebElement check1;


    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static void authorizaton(String mode) throws Exception {
        if(mode.equals("start_driver")){
            setup("chrome");
        }
        final ConfigVars var = ConfigFactory.create(ConfigVars.class);
        baseSelenium = new BaseSelenium(driver);
        signInPage = new SignInPage(driver);
        baseSelenium.openPage(homeURL);
        Allure.step("Проверяем отображение кнопки войти");
        Allure.step("Еще шаг");
        Allure.step("Еще шаг");
        Allure.step("Еще шаг");
        Allure.step("Еще шаг");
        Allure.step("Еще шаг");
        Allure.step("Еще шаг");
        Allure.step("Еще шаг");
        Assert.assertNotNull(enterBtn.isDisplayed());

    }

    public static void checks() throws Exception {

        baseSelenium = new BaseSelenium(driver);
        signInPage = new SignInPage(driver);
        Allure.step("Смотрим видимость");
        Assert.assertNotNull(check1.isDisplayed());
    }
}
