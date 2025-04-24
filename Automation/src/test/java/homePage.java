
import Pages.LoginPage;
import Pages.Waitt;
import Pages.bookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class homePage {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    Waitt waitt = new Waitt();
    bookingPage bookingPage = new bookingPage();


    //@BeforeTest


    @BeforeMethod
    public void set_up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }




    @Test
    public void manageAccount() {
        //scenario for TC_Login_003:When user login with valid data
        //user changes her personal data


        driver.get("https://go-bus.com/?lang=en");

        //Login with valid E_mail and Password
        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        System.out.println(driver.getTitle());


        waitt.waitForElementVisible(driver, By.className("pm-btn"));
        WebElement _Acc = driver.findElement(By.className("pm-btn"));
        _Acc.click();
        WebElement dropdown = waitt.waitForElementVisible(driver, By.xpath("//ul/li/a[contains(text(),'My Account')]"));

        //using Actions to  hoover by mouse in the dropDown_List and navigate to another page.
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement myAccount = waitt.waitForElementClickable(driver, By.xpath("//ul//li/a[contains(text(),'My Account')]"));
        WebElement dropdownn = driver.findElement(By.xpath("//ul/li/a[contains(text(),'My Account')]"));
        dropdown.click();

        //Navigate to my profile Page
        WebElement titleElement = waitt.waitForElementVisible(driver, By.xpath("//div[@class='page-title']//h1[text()='My Profile']"));
        System.out.println(titleElement.getText());

        //Change your personal info (Happy scenario)
        loginn.fullName(driver).clear();
        loginn.fullName(driver).sendKeys("Samar");
        loginn.phone(driver).clear();
        loginn.phone(driver).sendKeys("+201020186377");
        loginn.mail0(driver).clear();
        loginn.mail0(driver).sendKeys("yyhlwysmila@gmail.com");
        loginn.button(driver).click();


        WebElement succ_Mess = waitt.waitForElementVisible(driver, By.xpath("//div/p[text()='Data updated successfully']"));
        String actualResult_Edit = succ_Mess.getText();
        String expectedResult_Edit = "Data updated successfully";
        softAssert.assertEquals(actualResult_Edit, expectedResult_Edit, "Fail to Edit you profile");


        //To refer the page
        WebDriver.Navigation navigation = driver.navigate();
        driver.navigate().refresh();
        loginn.button(driver).click();
        waitt.waitForElementClickable(driver, By.className("btn-orange"));
        WebElement fail_Mess = waitt.waitForElementVisible(driver, By.xpath("//p[text()='Please enter a valid phone number']"));

        String actualResult_Editt = fail_Mess.getText();
        String expectedResult_Editt = "Data updated successfully";
        softAssert.assertEquals(actualResult_Editt, expectedResult_Editt, "Fail to Edit you profile");
        softAssert.assertAll();

    }

    @Test
    public void changePassword() {


        driver.get("https://go-bus.com/?lang=en");


        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        System.out.println(driver.getTitle());


        waitt.waitForElementVisible(driver, By.className("pm-btn"));
        WebElement _Acc = driver.findElement(By.className("pm-btn"));
        _Acc.click();
        WebElement dropdown = waitt.waitForElementVisible(driver, By.xpath("//ul/li/a[contains(text(),'My Account')]"));

        //using Actions to  hoover by mouse in the dropDown_List and navigate to another page.
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement myAccount = waitt.waitForElementClickable(driver, By.xpath("//ul//li/a[contains(text(),'My Account')]"));
        WebElement dropdownn = driver.findElement(By.xpath("//ul/li/a[contains(text(),'My Account')]"));
        dropdown.click();

        //User enter incorrect current password
        loginn.change_Password(driver).click();
        loginn.current_Pass(driver).sendKeys("122222222");
        loginn.new_Pass(driver).sendKeys("Samar_1972#");
        loginn.verfiy_Pass(driver).sendKeys("Samar_1972#");
        loginn.btn_Edit(driver).click();

        String expected = "Password Modified Successfully";
        waitt.waitForElementVisible(driver, By.xpath("//p[text()='Wrong password']"));
        WebElement edit_fail = driver.findElement(By.xpath("//p[text()='Wrong password']"));
        String actual = edit_fail.getText();
        softAssert.assertNotEquals(actual, expected, "Your current pass is incorrect");

        driver.navigate().refresh();


        loginn.current_Pass(driver).sendKeys("Samar_1972#");
        loginn.new_Pass(driver).sendKeys("Samar_1972#");
        loginn.verfiy_Pass(driver).sendKeys("Samar_1972#");
        loginn.btn_Edit(driver).click();

        String expectedSame_Pass = "- Please enter a different new password";
        WebElement warn = driver.findElement(By.xpath("//p[text()='Please enter a different new password']"));
        waitt.waitForElementVisible(driver, By.xpath("//p[text()='Please enter a different new password']"));
        String actuall = warn.getText();
        softAssert.assertEquals(actuall, expectedSame_Pass, "Please enter a different new password");
        softAssert.assertAll();


    }

    //Check My Bookings
    @Test
    public void numof_Bookings() {


        driver.get("https://go-bus.com/?lang=en");

        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        System.out.println(driver.getTitle());

        waitt.waitForElementVisible(driver, By.className("pm-btn"));
        WebElement _Acc = driver.findElement(By.className("pm-btn"));
        _Acc.click();
        WebElement dropdown = waitt.waitForElementVisible(driver, By.xpath("//a[text()='My Bookings']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement dropdownn = driver.findElement(By.xpath("//a[text()='My Bookings']"));
        dropdown.click();


        loginn.numOfBooking(driver).click();
        WebElement bookings = driver.findElement(By.xpath("//p[text()='No bookings available']"));
        String ActualBooking = bookings.getText();
        String ExpectedBookig = "No bookings available";
        softAssert.assertEquals(ActualBooking, ExpectedBookig, "Error!");
        //softAssert.assertAll();



    }

    @Test
    public void logout() {

        driver.get("https://go-bus.com/?lang=en");

        LoginPage loginn = new LoginPage(driver);
        loginn.btn(driver).click();
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        System.out.println(driver.getTitle());

        waitt.waitForElementVisible(driver, By.className("pm-btn"));
        WebElement _Acc = driver.findElement(By.className("pm-btn"));
        _Acc.click();
        WebElement dropdown = waitt.waitForElementVisible(driver, By.xpath("//a[text()='Sign Out']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement dropdownn = driver.findElement(By.xpath("//a[text()='Sign Out']"));
        dropdown.click();



    }


    @Test
    public void travel_Destination() {
        //Check Travel Destination in HomePage

        driver.get("https://go-bus.com/?lang=en");
        bookingPage.travel_Destination(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.hurghada());
        bookingPage.hurghada(driver).click();
        waitt.waitForElementVisible(driver, By.xpath("//H1[text()='Hurghada']"));


    }


    @Test
    public void travel_Destination_Fail() {
        //Check Travel Destination in HomePage
        try {


            driver.get("https://go-bus.com/?lang=en");
            bookingPage.travel_Destination(driver).click();
            waitt.waitForElementVisible(driver, bookingPage.alex());
            bookingPage.alex(driver).click();
            waitt.waitForElementVisible(driver, By.xpath("//H1[text()='Alexandria']"));
            String expected_Alex = "Alexandria";
            String actual_Alex = bookingPage.assert_Alex(driver).getText();
            softAssert.assertEquals(actual_Alex, expected_Alex, "Alex is not selected!");
            softAssert.assertAll();


        } catch (Exception e) {
            System.out.println("Actual Result not equal to : " + e.getMessage());
        }
    }

    @Test
    public void travel_Stations()  {
        //Check Travel Stations in HomePage
        try {

            driver.get("https://go-bus.com/?lang=en");
            // waitt.waitForElementVisible(driver,bookingPage.bus_Stations());
            bookingPage.travel_Stations(driver).click();
            waitt.waitForElementVisible(driver, bookingPage.bus_Stations());
            waitt.waitForElementVisible(driver, By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/a"));
            bookingPage.show_Map(driver).click();
            waitt.waitForElementVisible(driver, bookingPage.apperMap());



        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }


    }


    @AfterMethod
    public void end_Test() {
        driver.quit();

    }

}


