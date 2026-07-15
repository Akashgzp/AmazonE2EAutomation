package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    @FindBy(id="ap_email_login")
    WebElement email;

    @FindBy(xpath="//input[@type='submit']")
    WebElement continueBtn;

    @FindBy(id="ap_password")
    WebElement password;

    @FindBy(id="signInSubmit")
    WebElement signInBtn;

    public void enterEmail(String user) {

        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(user);
    }

    public void clickContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
    }

    public void enterPassword(String pwd) {

        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pwd);
    }

    public void clickSignIn() {

        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();
    }
}