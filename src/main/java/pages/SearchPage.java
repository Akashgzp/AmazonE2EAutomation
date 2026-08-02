package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    
 // =========================
    // Locators (Tum fill karna)
    // =========================

    private By searchResults = By.id("twotabsearchtextbox");

    private By firstProduct = By.xpath("//img[@alt='Samsung Galaxy M56 5G Mobile (Black, 8GB RAM, 128GB Storage)| Segment Slimmest | Gorilla Glass Victus+ | 10 Bit HDR Video...']");

    private By productTitle = By.xpath("//span[contains(text(),'Galaxy M56 5G Mobile (Black, 8GB RAM, 128GB Storag')]");

    private By productPrice = By.xpath("//span[normalize-space()='25,999']");

    private By sortDropdown = By.xpath("//span[@class='a-dropdown-prompt']");

    private By lowToHigh = By.id("s-result-sort-select_1");

    private By highToLow = By.id("s-result-sort-select_2");

    private By brandFilter = By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='HP']");

    private By ratingFilter = By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']");



    // =========================
    // Methods
    // =========================

    // TC051
    public boolean isSearchResultPageDisplayed() {

        return driver.getTitle().contains("Samsung");

    }


    // TC052
    public boolean areSearchResultsDisplayed() {

        return driver.findElements(searchResults).size() > 0;

    }


    // TC053
    public int getProductCount() {

        return driver.findElements(searchResults).size();

    }


    // TC054
    public void clickFirstProduct() {

        driver.findElement(firstProduct).click();

    }


    // TC055
    public String getProductTitle() {

        return driver.findElement(productTitle).getText();

    }


    // TC056
    public String getProductPrice() {

        return driver.findElement(productPrice).getText();

    }


    // TC057
    public void sortByLowToHigh() {

        driver.findElement(sortDropdown).click();

        driver.findElement(lowToHigh).click();

    }


    // TC058
    public void sortByHighToLow() {

        driver.findElement(sortDropdown).click();

        driver.findElement(highToLow).click();

    }


    // TC059
    public void selectBrandFilter() {

        driver.findElement(brandFilter).click();

    }


    // TC060
    public void selectRatingFilter() {

        driver.findElement(ratingFilter).click();

    }


}