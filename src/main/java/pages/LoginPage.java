package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
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

        email.sendKeys(user);

    }

    public void clickContinue() {

        continueBtn.click();

    }

    public void enterPassword(String pwd) {

        password.sendKeys(pwd);

    }

    public void clickSignIn() {

        signInBtn.click();

    }

}