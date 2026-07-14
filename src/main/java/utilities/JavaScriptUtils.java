package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private WebDriver driver;

    public JavaScriptUtils(WebDriver driver) {

        this.driver = driver;

    }

    public void click(WebElement element) {

        ((JavascriptExecutor) driver)

                .executeScript("arguments[0].click();", element);

    }

    public void scroll(WebElement element) {

        ((JavascriptExecutor) driver)

                .executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void setValue(WebElement element, String value) {

        ((JavascriptExecutor) driver)

                .executeScript("arguments[0].value=arguments[1];", element, value);

    }

}