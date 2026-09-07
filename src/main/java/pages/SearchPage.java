package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // Constructor
    // =========================================================

    public SearchPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    // =========================================================
    // Locators - Search Result
    // =========================================================

    private By searchResults =
            By.xpath("//div[@data-component-type='s-search-result']");

    private By productList =
            By.xpath("//div[@data-component-type='s-search-result']");

    private By productTitles =
            By.xpath("//div[contains(@data-component-type,'s-search-result')]//h2//span");


    // =========================================================
    // Locators - Products
    // =========================================================

    private By firstProduct =
            By.xpath("(//div[@data-component-type='s-search-result']//a[.//img[@class='s-image']])[1]");

    private By secondProduct =
            By.xpath("(//div[@data-component-type='s-search-result']//a[.//img[@class='s-image']])[2]");

    private By firstProductImage =
            By.xpath("(//div[@data-component-type='s-search-result']//img[@class='s-image'])[1]");

    private By productImages =
            By.xpath("//div[@data-component-type='s-search-result']//img[@class='s-image']");

    private By productTitle =
            By.xpath(
                    "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[contains(text(),'Galaxy M07 Mobile (Black, 4GB RAM, 64GB Storage) |')]");

    private By productPrice =
            By.xpath(
                    "(//div[@data-component-type='s-search-result']//span[@class='a-price-whole'])[1]");


    // =========================================================
    // Locators - Sort
    // =========================================================

    private By sortDropdown =
            By.xpath("//span[@class='a-dropdown-prompt']");

    private By sortDropdownSelect =
            By.id("s-result-sort-select");

    private By lowToHigh =
            By.id("s-result-sort-select_1");

    private By highToLow =
            By.id("s-result-sort-select_2");


    // =========================================================
    // Locators - Filters
    // =========================================================

    private By brandFilter =
            By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='HP']");

    private By ratingFilter =
            By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']");


    // =========================================================
    // Locators - Pagination
    // =========================================================

    private By nextPage =
            By.xpath("//a[contains(@class, 's-pagination-next')]");

    private By previousPage =
            By.xpath("//a[contains(@class, 's-pagination-previous')]");


    // =========================================================
    // TC051
    // Verify Search Result Page
    // =========================================================

    public boolean isSearchResultPageDisplayed() {

        return driver.getTitle().contains("Samsung");
    }


    // =========================================================
    // TC052
    // Verify Search Results Displayed
    // =========================================================

    public boolean areSearchResultsDisplayed() {

        return !driver.findElements(searchResults).isEmpty();
    }


    // =========================================================
    // TC053
    // Get Product Count
    // =========================================================

    public int getProductCount() {

        return driver.findElements(searchResults).size();
    }


    // =========================================================
    // TC054
    // Click First Product
    // =========================================================

    public void clickFirstProduct() {

        WebElement product =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(firstProduct)
                );

        String productUrl = product.getAttribute("href");

        if (productUrl == null || productUrl.isEmpty()) {

            throw new RuntimeException(
                    "First product ka href nahi mila."
            );
        }

        driver.get(productUrl);
    }


    // =========================================================
    // TC055
    // Get Product Title
    // =========================================================

    public String getProductTitle() {

        WebElement title =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(productTitle)
                );

        return title.getText();
    }


    // =========================================================
    // TC056
    // Get Product Price
    // =========================================================

    public String getProductPrice() {

        WebElement price =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(productPrice)
                );

        return price.getText();
    }


    // =========================================================
    // TC057
    // Sort Low To High
    // =========================================================

    public void sortByLowToHigh() {

        wait.until(
                ExpectedConditions.elementToBeClickable(sortDropdown)
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(lowToHigh)
        ).click();
    }


    // =========================================================
    // TC058
    // Sort High To Low
    // =========================================================

    public void sortByHighToLow() {

        wait.until(
                ExpectedConditions.elementToBeClickable(sortDropdown)
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(highToLow)
        ).click();
    }


    // =========================================================
    // TC059
    // Select Brand Filter
    // =========================================================

    public void selectBrandFilter() {

        wait.until(
                ExpectedConditions.elementToBeClickable(brandFilter)
        ).click();
    }


    // =========================================================
    // TC060
    // Select Customer Rating Filter
    // =========================================================

    public void selectRatingFilter() {

        wait.until(
                ExpectedConditions.elementToBeClickable(ratingFilter)
        ).click();
    }


    // =========================================================
    // TC061
    // Click Second Product
    // =========================================================

    public void clickSecondProduct() {

        WebElement product =
                wait.until(
                        ExpectedConditions.elementToBeClickable(secondProduct)
                );

        product.click();
    }


    // =========================================================
    // TC062
    // Get Displayed Product Count
    // =========================================================

    public int getDisplayedProductCount() {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(productList)
        );

        return driver.findElements(productList).size();
    }


    // =========================================================
    // TC063
    // Verify Product Image
    // =========================================================

    public boolean isProductImageDisplayed() {

        List<WebElement> elements =
                driver.findElements(productImages);

        if (elements.isEmpty()) {

            return false;
        }

        return elements.get(0).isDisplayed();
    }


    // =========================================================
    // TC064
    // Click First Product Title
    // =========================================================

    public void clickFirstProductTitle() {

        WebElement firstProduct =
                wait.until(
                        ExpectedConditions.elementToBeClickable(firstProductImage)
                );

        firstProduct.click();
    }


    // =========================================================
    // TC065
    // Get First Few Product Titles
    // =========================================================

    public List<String> getFirstFewProductTitles(int count) {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(productTitles)
        );

        List<WebElement> elements =
                driver.findElements(productTitles);

        List<String> titlesText =
                new ArrayList<>();

        int limit =
                Math.min(elements.size(), count);

        for (int i = 0; i < limit; i++) {

            titlesText.add(
                    elements.get(i).getText()
            );
        }

        return titlesText;
    }


    // =========================================================
    // TC066
    // Click Next Page
    // =========================================================

    public void clickNextPage() {

        scrollToElementAndClick(nextPage);
    }


    // =========================================================
    // TC067
    // Click Previous Page
    // =========================================================

    public void clickPreviousPage() {

        scrollToElementAndClick(previousPage);
    }


    // =========================================================
    // Pagination Utility
    // =========================================================

    private void scrollToElementAndClick(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(locator)
                );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                element
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );

        element.click();
    }


    // =========================================================
    // TC068
    // Verify Sort Dropdown Displayed
    // =========================================================

    public boolean isSortDropdownDisplayed() {

        try {

            WebElement dropdown =
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    sortDropdownSelect
                            )
                    );

            return dropdown.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

}