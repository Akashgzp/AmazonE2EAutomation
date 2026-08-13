package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

 // ==========================
    // Locators 
    // ==========================

    private By productList = By.xpath("//img[@alt='Noise Pro 6R 1.46\" AMOLED Smart Watch, 1000 NITS, Powered by AI Pro, Built-in GPS, Strava Integration, Stainless Steel Dial, Video Watch Faces, 3ATM, Emergency SOS, TWS Connectivity (Pure Titanium)']");

    private By secondProduct = By.xpath("(//div[@data-component-type='s-search-result'])[2]");

    private By productImages = By.xpath("//div[@data-component-type='s-search-result']//img[@class='s-image']");

    private By productTitleLinks = By.xpath("//div[@data-component-type='s-search-result']//h2/a");
    
 // Amazon India search page par products ke title text (span) ka robust locator
    private By productTitles = By.xpath("//div[contains(@data-component-type,'s-search-result')]//h2//span");

 // Amazon India ke unique pagination tag structure ko capture karne ke liye stable selector
    private By nextPage = By.xpath("//a[contains(@class, 's-pagination-next')]");
 // Amazon India ke standard pagination bottom bar mein 'Next' aur 'Previous' buttons ke relative selectors
  //  private By nextPage = By.xpath("//a[contains(@class, 's-pagination-next')]");
    private By previousPage = By.xpath("//a[contains(@class, 's-pagination-previous')]");
    private By sortDropdown1 = By.xpath("");

    private By brandFilter1 = By.xpath("");

    private By ratingFilter1 = By.xpath("");



    // ==========================
    // Methods
    // ==========================

    // TC061
    public void clickSecondProduct() {

        driver.findElement(secondProduct).click();

    }


    // TC062
    public int getDisplayedProductCount() {

        return driver.findElements(productList).size();

    }


//    // TC063
//    public boolean isProductImageDisplayed() {
//
//        return driver.findElements(productImages)
//                .get(0)
//                .isDisplayed();
//
//    }

 // TC063 Method Implementation
    public boolean isProductImageDisplayed() {
        List<WebElement> elements = driver.findElements(productImages);
        
        // Checklist to prevent IndexOutOfBoundsException if search layout fails or takes time to load
        if (!elements.isEmpty()) {
            return elements.get(0).isDisplayed();
        }
        return false;
    }

 // TC064: Updated Method with Explicit Sync Handling
    public void clickFirstProductTitle() {
        // Explicit wait lagayein taaki search grid page par load ho sake (Max 15 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(productTitleLinks));

        List<WebElement> productLinks = driver.findElements(productTitleLinks);
        
        if (!productLinks.isEmpty()) {
            WebElement firstProduct = productLinks.get(0);
            
            // Link visible aur clickable hone tak wait karein
            wait.until(ExpectedConditions.visibilityOf(firstProduct));
            
            // Hover action step
            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).perform();
            
            // Element successfully click karein
            firstProduct.click();
        } else {
            throw new RuntimeException("Automation Error: Amazon India search results page par koi bhi product link nahi mila.");
        }
    }

 // TC065: Pahle kuch products (jaise top 3 ya 5) ke text titles fetch karne ka method
    public List<String> getFirstFewProductTitles(int count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Synchronization issue se bachne ke liye titles ke visible hone ka wait karein
        wait.until(ExpectedConditions.presenceOfElementLocated(productTitles));

        List<WebElement> elements = driver.findElements(productTitles);
        List<String> titlesText = new ArrayList<>();

        // Jitne items mange hain (count), list size ke hisaab se safely loops run karein
        int limit = Math.min(elements.size(), count);
        for (int i = 0; i < limit; i++) {
            titlesText.add(elements.get(i).getText());
        }
        
        return titlesText;
    }

    // TC066: Target layout tak scroll karke seamlessly click karne ka method
    public void clickNextPage1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Element page layout me generate hone tak explicit wait lagayein
        WebElement nextBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(nextPage));
        
        // Sahi JavaScript array index syntax [0] use karein scroll karne ke liye
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", nextBtnElement);
        
        // Button target pointer ke dynamic aur clickable hone ka track wait complete karein
        wait.until(ExpectedConditions.elementToBeClickable(nextBtnElement));
        
        nextBtnElement.click();
    }



 // Puraane javascript error se bachne ke liye safe smooth scroll utility method
    private void scrollToElementAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        
        // Correct array arguments index handler applied [0]
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Step 1 helper: Page 2 par jaane ke liye
    public void clickNextPage() {
        scrollToElementAndClick(nextPage);
    }

    // TC067 Action: Page 2 se Previous page par wapas click karne ka method
    public void clickPreviousPage() {
        scrollToElementAndClick(previousPage);
    }


  
//    // TC067 Action: Page 2 se Previous page par wapas click karne ka method
//    public void clickPreviousPage() {
//        scrollToElementAndClick(previousPage);
//    }


    // TC068
    public boolean isSortDropdownDisplayed() {

        return driver.findElement(sortDropdown)
                .isDisplayed();

    }


    // TC069
    public boolean isBrandFilterDisplayed() {

        return driver.findElement(brandFilter)
                .isDisplayed();

    }


    // TC070
    public boolean isRatingFilterDisplayed() {

        return driver.findElement(ratingFilter)
                .isDisplayed();

    }

}