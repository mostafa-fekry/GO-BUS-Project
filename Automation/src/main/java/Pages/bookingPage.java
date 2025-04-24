package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bookingPage {


    public WebElement oneway_Trip(WebDriver driver) {
        WebElement one_Way = driver.findElement(By.xpath("//label[text()='One Way']"));
        return one_Way;
    }

    public WebElement showTrips(WebDriver driver) {
        WebElement button_ShowTrips = driver.findElement(By.xpath("//button[text()='Show Trips']"));
        return button_ShowTrips;
    }

    public By addPassenger() {
        return By.xpath("//i[text()='add']");
    }

    public WebElement travetDate(WebDriver driver) {

        return driver.findElement(By.className("tarvel-date"));
    }

    public By calender() {
        return By.xpath("//div[text()='April 2025']");
    }

    public WebElement selectDate(WebDriver driver) {
        WebElement select_Date = driver.findElement(By.xpath("//div[text()='30']"));
        return select_Date;
    }

    public WebElement from(WebDriver driver) {
        WebElement from_city = driver.findElement(By.xpath("(//div[@class='choose-trip']//div[contains(@class,'browse-select-component')])[1]"));
        return from_city;
    }

    public By departure_City() {
        return By.xpath("//li[text()='Cairo ( Tahrir )']");
    }

    public WebElement to_city(WebDriver driver) {
        WebElement to = driver.findElement(By.xpath("(//div[@class='choose-trip']//div[contains(@class,'browse-select-component')])[2]"));
        return to;
    }

    public WebElement return_City(WebDriver driver) {

        WebElement returncityy = driver.findElement(By.xpath("(//li[text()='Dahab'])[2]"));

        return returncityy;
    }

    public By dataShow() {
        return By.className("data-show-desktop");
    }

    public WebElement bus_Classes(WebDriver driver) {
        WebElement classes = driver.findElement(By.xpath("//label[text()='Business Class DD']"));

        return classes;
    }

    public WebElement myTrip(WebDriver driver) {
        WebElement trip = driver.findElement(By.xpath("(//h6[text()='Choose Trip'])[1]"));
        return trip;
    }

    public By selectTrip() {
        return By.xpath("(//h6[text()='Choose Trip'])[1]");
    }

    public By price() {
        return By.xpath("(//p[text()='1340.00'])[2]");

    }

    public WebElement price_Two_Trips(WebDriver driver) {
        WebElement twoTrips = driver.findElement(By.xpath("//p[text()='2420.00']"));
        return twoTrips;
    }

    public WebElement btn_Book(WebDriver driver) {
        WebElement book = driver.findElement(By.xpath("//a[text()='Book 2 Seats']"));
        return book;
    }


    public WebElement chechout(WebDriver driver) {
        WebElement check = driver.findElement(By.xpath("//button[contains(., 'Check Availability')]"));
        return check;

    }

    public WebElement round_Trip(WebDriver driver) {
        WebElement roundtrip = driver.findElement(By.xpath("//label[text()='Round Trip']"));
        return roundtrip;
    }

    public WebElement return_Date(WebDriver driver) {
        WebElement returnDatee = driver.findElement(By.xpath("(//div[@class='input datepicker tarvel-date'])[2]"));
        return returnDatee;
    }

    public WebElement return_Calender(WebDriver driver) {
        WebElement returnCalender = driver.findElement(By.xpath("//div[text()='May 2025']"));
        return returnCalender;
    }

    public WebElement dayOfReturn(WebDriver driver) {
        WebElement day_OfReturn = driver.findElement(By.xpath("(//div[text()='5'])[2]"));
        return day_OfReturn;
    }


    public WebElement from_ReturnTrip(WebDriver driver) {
        WebElement fromReturnTrip = driver.findElement(By.xpath("(//h6[text()='Choose Trip'])[1]"));
        return fromReturnTrip;
    }

    public WebElement to_Return_Trip(WebDriver driver) {
        WebElement toReturnTrip = driver.findElement(By.xpath("(//h6[text()='Choose Trip'])[1]"));
        return toReturnTrip;
    }

    public WebElement travel_Destination(WebDriver driver) {
        WebElement destination = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/header/div[2]/div/div[2]/div[2]/ul/li[2]"));
        return destination;
    }

    public WebElement hurghada(WebDriver driver) {
        WebElement hur = driver.findElement(By.xpath("//h3[text()='Hurghada']"));
        return hur;
    }

    public By hurghada() {
        return By.xpath("//h3[text()='Hurghada']");
    }

    public WebElement alex(WebDriver driver) {
        WebElement hur = driver.findElement(By.xpath("//h3[text()='Alexandria']"));
        return hur;
    }

    public By alex() {
        return By.xpath("//h3[text()='Alexandria']");
    }

    public WebElement assert_Alex(WebDriver driver) {
        WebElement Alexx = driver.findElement(By.xpath("(//div[@class='choose-trip']//div[contains(@class,'browse-select-component')])[2]"));

        return Alexx;
    }

    public WebElement travel_Stations(WebDriver driver) {
        WebElement destination = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/header/div[2]/div/div[2]/div[2]/ul/li[3]/a"));
        return destination;
    }

    public By bus_Stations() {
        return By.xpath("//h1[text()='GoBus Stations']");

    }

    public WebElement show_Map(WebDriver driver) {
        WebElement map = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/a"));
        return map;
    }

    public By apperMap() {
        return By.xpath("/html/body/div[2]/div[3]/div[8]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[10]/div[2]/div[2]/span[2]/span");
    }


}



