import Pages.LoginPage;
import Pages.Waitt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class loginTest {
    WebDriver driver;
    Waitt waitt = new Waitt();
    SoftAssert softAssert = new SoftAssert();


    @BeforeTest

    public void before_Test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(priority = 2)

    public void TC_Login_001() {
        driver.get("https://go-bus.com/?lang=en");

        //login with invaild Email and Password
        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("sss@gmail.com", "1111111");


        waitt.waitForElementClickable(driver, By.className("btnSubmit"));
        String expectedResult = "- Sorry, something went wrong";
        WebElement errorMsg = waitt.waitForElementVisible(driver, loginn.erroMess());

        String ActualResult = errorMsg.getText();
        softAssert.assertEquals(ActualResult, expectedResult, "Error");
        softAssert.assertAll();

    }


    @Test(priority = 3)
    public void TC_Login_002() {
        //login with vaild Email and invalid Password
        driver.get("https://go-bus.com/?lang=en");

        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("yyhlwysmila@gmail.com", "22222222222");


        WebElement errorMsg = waitt.waitForElementVisible(driver, By.xpath("//h4/div[@class='error-validition']"));
        String expectedResult3 = "- Sorry, something went wrong";
        WebElement mess_Fail3 = driver.findElement(loginn.erroMess());
        String ActualResult3 = mess_Fail3.getText();

        softAssert.assertEquals(ActualResult3, expectedResult3, "Error");
        softAssert.assertAll();

    }


    @Test(priority = 1)
    public void TC_Login_003() {
        //scenario for TC_Login_003:When user login with valid data


        driver.get("https://go-bus.com/?lang=en");
        System.out.println(driver.getTitle());
        softAssert.assertEquals(driver.getTitle(), "Go Bus Official Website For Booking Buses In Egypt", "Error1");

        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
    }


    @Test(priority = 4)
    public void TC_Login_004() {
        //login with invaild Email and valid Password
        driver.get("https://go-bus.com/?lang=en");
        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("111111111@gmail.com", "Samar_1972#");


        WebElement errorMsg = waitt.waitForElementVisible(driver, By.xpath("//h4/div[@class='error-validition']"));
        String expectedResult3 = "- Sorry, something went wrong";
        WebElement mess_Fail3 = driver.findElement(loginn.erroMess());

        String ActualResult3 = mess_Fail3.getText();
        softAssert.assertEquals(ActualResult3, expectedResult3, "Error");
        softAssert.assertAll();

    }


    @AfterTest
    public void afterClass() {
        driver.quit();

    }
}











