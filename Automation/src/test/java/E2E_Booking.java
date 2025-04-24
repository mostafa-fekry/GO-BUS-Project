import Pages.LoginPage;
import Pages.Waitt;
import Pages.bookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;



public class E2E_Booking {
    WebDriver driver;
    LoginPage loginn;
    SoftAssert softAssert = new SoftAssert();
    Waitt waitt = new Waitt();
    bookingPage bookingPage = new bookingPage();


    @BeforeMethod
    public void before_Test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }





    @Test
    public void one_Way_Booking() {
        driver.get("https://go-bus.com/?lang=en");

        // Click on one way trip
        bookingPage.oneway_Trip(driver).click();

        // Choose departure city (From: To)
        // From
        bookingPage.from(driver).click();
        bookingPage.departure_City();

        // To
        bookingPage.to_city(driver).click();
        bookingPage.return_City(driver).click();

        // Num of passengers
        driver.findElement(bookingPage.addPassenger()).click();

        // Choose date of trip
        bookingPage.travetDate(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.calender());
        bookingPage.selectDate(driver).click();

        // Show available trips
        bookingPage.showTrips(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.dataShow());

        // Choose bus Classes
        // Choose My Trip
        waitt.waitForElementClickable(driver, bookingPage.selectTrip());
        bookingPage.myTrip(driver).click();

        // Check the price
        waitt.waitForElementVisible(driver, By.xpath("//p[text()='1340.00']"));
        String expectedPrice = "1340.00 EGP";
        WebElement price = driver.findElement(bookingPage.price());
        String actualPrice = price.getText();
        softAssert.assertEquals(actualPrice, expectedPrice, "Not Match");

        bookingPage.btn_Book(driver).click();

        // Login
        LoginPage loginn = new LoginPage(driver);
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        waitt.waitForElementClickable(driver, By.className("btnSubmit"));

        // Navigate To Page Checkout Availability
        waitt.waitForElementVisible(driver, By.xpath("//h2[text()='Seats will be confirmed before payment']"));
        bookingPage.chechout(driver).click();
        softAssert.assertAll();
    }
    /*@AfterMethod
    public void endMethod(){
        driver.close();
    }

    @BeforeMethod
    public void before_Test2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();*/

   // }

    @Test
    public void round_Trip() {
        driver.get("https://go-bus.com/?lang=en");

        // Click on Round Trip
        bookingPage.round_Trip(driver).click();

        // Choose departure city (From: To)
        bookingPage.from(driver).click();
        bookingPage.departure_City();
        bookingPage.to_city(driver).click();
        bookingPage.return_City(driver).click();

        // Num of passengers
        driver.findElement(bookingPage.addPassenger()).click();

        // Choose date of Departure Trip
        bookingPage.travetDate(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.calender());
        bookingPage.selectDate(driver).click();

        // Choose date of Return Trip
        bookingPage.return_Date(driver).click();
        bookingPage.return_Calender(driver).click();
        bookingPage.dayOfReturn(driver).click();

        // Show available trips
        bookingPage.showTrips(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.dataShow());

        // Choose bus Classes
        waitt.waitForElementClickable(driver, By.xpath("//label[text()='Business Class DD']"));
        bookingPage.bus_Classes(driver).click();

        // Choose My Trip: (Departure and Return Trips)
        bookingPage.from_ReturnTrip(driver).click();
        waitt.waitForElementClickable(driver, By.xpath("(//h6[text()='Choose Trip'])[1]"));
        bookingPage.to_Return_Trip(driver).click();

        // Check the price
        String expectedPrice = "2420.00 EGP";
        waitt.waitForElementVisible(driver, By.xpath("//p[text()='2420.00']"));
        WebElement priceTrips = bookingPage.price_Two_Trips(driver);
        String actualPrice = priceTrips.getText();
        softAssert.assertEquals(actualPrice, expectedPrice, "Not Match");

        bookingPage.btn_Book(driver).click();

        // Login
        LoginPage loginn = new LoginPage(driver);
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        waitt.waitForElementClickable(driver, By.className("btnSubmit"));

        // Navigate To Page Checkout Availability
        waitt.waitForElementVisible(driver, By.xpath("//h2[text()='Seats will be confirmed before payment']"));
        driver.findElement(By.xpath("//button[text()='Check Availability']"));
        softAssert.assertAll();
    }

    @AfterMethod
    public void end() {

            driver.quit();
        }
    }




/*public class E2E_Booking {
    WebDriver driver;
    LoginPage loginn;
    SoftAssert softAssert = new SoftAssert();
    Waitt waitt = new Waitt();
    bookingPage bookingPage = new bookingPage();

    @BeforeTest
    public void before_Testt() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setupLoginPage() {
        loginn = new LoginPage(driver);
    }





    /*WebDriver driver;
    LoginPage loginn = new LoginPage(driver);

    SoftAssert softAssert = new SoftAssert();
    Waitt waitt = new Waitt();
    bookingPage bookingPage = new bookingPage();


    @BeforeTest

    public void before_Testt() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }*/


    /*@Test
    public void one_Way_Booking() {
        driver.get("https://go-bus.com/?lang=en");

        //Click on one way trip
        bookingPage.oneway_Trip(driver).click();

        //Choose departure city (From: To)
        //From
        bookingPage.from(driver).click();
        bookingPage.departure_City();

        //To
        bookingPage.to_city(driver).click();
        bookingPage.return_City(driver).click();
        //Num of passengers
        driver.findElement(bookingPage.addPassenger()).click();

        //Choose date of trip
        bookingPage.travetDate(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.calender());
        bookingPage.selectDate(driver).click();


        //To show available trips
        bookingPage.showTrips(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.dataShow());

        //Choose bus Classes

        // Choose My Trip
        waitt.waitForElementClickable(driver, bookingPage.selectTrip());
        bookingPage.myTrip(driver).click();
        //Check the price
        waitt.waitForElementVisible(driver, By.xpath("//p[text()='1340.00']"));
        String expectedd = "1340.00";
        WebElement pricee = driver.findElement(bookingPage.price());
        String aasertt_price = pricee.getText();
        softAssert.assertEquals(aasertt_price, expectedd, "Not Match");
        bookingPage.btn_Book(driver).click();

        //Login
        LoginPage loginn = new LoginPage(driver);
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        waitt.waitForElementClickable(driver, By.className("btnSubmit"));

        //Navigate To Page Checkout Availability
        waitt.waitForElementVisible(driver, By.xpath("//h2[text()='Seats will be confirmed before payment']"));
        bookingPage.chechout(driver).click();




    }
    @BeforeTest
    public void before_Test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }




    @Test
    public void round_Trip()  {

        driver.get("https://go-bus.com/?lang=en");

        //Click on Round Trip
        bookingPage.round_Trip(driver).click();

        //Choose departure city (From: To)
        //From
        bookingPage.from(driver).click();
        bookingPage.departure_City();

        //To
        bookingPage.to_city(driver).click();
        bookingPage.return_City(driver).click();
        //Num of passengers
        driver.findElement(bookingPage.addPassenger()).click();

        //Choose date of Departure Trip
        bookingPage.travetDate(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.calender());
        bookingPage.selectDate(driver).click();

        //Choose date of Return Trip
        bookingPage.return_Date(driver).click();
        bookingPage.return_Calender(driver).click();
        bookingPage.dayOfReturn(driver).click();

        //To show available trips
        bookingPage.showTrips(driver).click();
        waitt.waitForElementVisible(driver, bookingPage.dataShow());


        //Choose bus Classes
        waitt.waitForElementClickable(driver, By.xpath("//label[text()='Business Class DD']"));
        bookingPage.bus_Classes(driver).click();

        // Choose My Trip:(Departure and Return Trips)
        bookingPage.from_ReturnTrip(driver).click();
        waitt.waitForElementClickable(driver,By.xpath("(//h6[text()='Choose Trip'])[1]"));
        bookingPage.to_Return_Trip(driver).click();

        //Check the price
        String expectedd = "2420.00 EGP";
        waitt.waitForElementVisible(driver, By.xpath("//p[text()='2420.00']"));
        WebElement price_Trips = bookingPage.price_Two_Trips(driver);
        String aasertt_price = price_Trips.getText();
        softAssert.assertEquals(aasertt_price, expectedd, "Not Match");
        bookingPage.btn_Book(driver).click();

        //Login
        LoginPage loginn = new LoginPage(driver);
        loginn.login("yyhlwysmila@gmail.com", "Samar_1972#");
        waitt.waitForElementClickable(driver, By.className("btnSubmit"));

        //Navigate To Page Checkout Availability
        waitt.waitForElementVisible(driver, By.xpath("//h2[text()='Seats will be confirmed before payment']"));
        driver.findElement(By.xpath("//button[text()='Check Availability']"));
        softAssert.assertAll();

    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();}


        @AfterTest
            public void end(){
        driver.quit();
    }}*/






