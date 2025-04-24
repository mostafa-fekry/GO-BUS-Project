package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    Waitt waitt = new Waitt();
    WebDriver driver;
    private final By userEmail = By.name("user-email");
    private final By password = By.name("user-password");
    //private final By btn = By.className("login-btn");
    private final By sbmit = By.className("btnSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enter_UserEmail(String email) {

        driver.findElement(userEmail).sendKeys(email);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }


    public void clickLogin() {
        driver.findElement(sbmit).click();
    }


    public void login(String email, String pass) {
        waitt.waitForElementClickable(driver, By.name("user-email"));

        enter_UserEmail(email);
        enterPassword(pass);
        clickLogin();
    }


    public WebElement btn(WebDriver driver) {
        By login_btn = By.className("login-btn");
        WebElement login_btn_Ele = driver.findElement(login_btn);
        return login_btn_Ele;
    }


       /* public WebElement userNamePom(WebDriver driver) {
            By userEmail = By.name("user-email");
            WebElement user_EmailEle = driver.findElement(userEmail);
            return user_EmailEle;
        }


        public WebElement passwordPom(WebDriver driver) {
            By password=By.name("user-password");
            WebElement passwordEle=driver.findElement(password);
            return passwordEle;

        }*/

    public WebElement submitPom(WebDriver driver) {
        By submit = By.className("btnSubmit");
        WebElement submitEle = driver.findElement(submit);
        return submitEle;

    }

    public By erroMess() {
        return By.xpath("//h4/div[@class='error-validition']");
    }


    public WebElement fullName(WebDriver driver) {
        WebElement edit_FullName = driver.findElement(By.xpath("//div[@class='input-field']//input[@name='username']"));
        return edit_FullName;
    }

    public WebElement phone(WebDriver driver) {
        WebElement phoneNumber = driver.findElement(By.xpath("//div[@class='input-field']//input[@name='phone-number']"));
        return phoneNumber;
    }

    public WebElement mail0(WebDriver driver) {
        WebElement editEmail = driver.findElement(By.xpath("//div[@class='input-field']//input[@name='email']"));
        return editEmail;
    }

    public WebElement button(WebDriver driver) {
        WebElement orn_button = driver.findElement(By.className("btn-orange"));
        return orn_button;
    }


    public WebElement current_Pass(WebDriver driver) {
        WebElement currentPassword = driver.findElement(By.xpath("//input[@name='old_password']"));
        return currentPassword;
    }


    public WebElement new_Pass(WebDriver driver) {
        WebElement newPassword = driver.findElement(By.xpath("//input[@name='new_password']"));
        return newPassword;
    }

    public WebElement verfiy_Pass(WebDriver driver) {
        WebElement retype_Password = driver.findElement(By.xpath("//input[@name='verify_password']"));
        return retype_Password;
    }

    public WebElement btn_Edit(WebDriver driver) {
        WebElement edit = driver.findElement(By.xpath("//button[contains(@class, 'btn-orange')] "));
        return edit;
    }

    public WebElement change_Password(WebDriver driver) {
        WebElement changePass = driver.findElement(By.xpath("(//a[text()='Change Password'])[2] "));
        return changePass;
    }


    public WebElement numOfBooking(WebDriver driver) {
        WebElement bookking = driver.findElement(By.xpath("(//a[text()='My Bookings'])[2]"));
        return bookking;
    }


}



