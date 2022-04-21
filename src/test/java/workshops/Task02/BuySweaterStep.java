package workshops.Task02;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BuySweaterStep {

    private WebDriver driver;

    @Given("user is registered on {string} page")
    public void userIsRegisteredOnPage(String store) {
        // driver assignment
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        // creating new object with ChromeDriverem
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(store);        // driver assignment
    }

    @When("user signs in the account")
    public void userSignsInTheAccount() {
        WebElement signInLink = driver.findElement(By.className("user-info"));
        signInLink.click();

        WebElement email = driver.findElement(By.name("email"));
        WebElement passwd = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("submit-login"));
        email.sendKeys("zofia@test.com");
        passwd.sendKeys("qwerty");
        loginBtn.click();
    }

    @When("user goes to homepage")
    public void userGoesToHomepage() {
        WebElement homePageLink = driver.findElement(By.className("logo"));
        homePageLink.click();
    }

    @When("user picks {string}")
    public void userPicks(String arg0) {
        WebElement productLink = driver.findElement(By.xpath("//*[@id='content']/section/div/article[2]/div/div[1]/h3/a"));
        productLink.click();
    }

    @When("user checks if there is {string} discount")
    public void userChecksIfThereIsDiscount(String arg0) {
        //TODO: calculate discount
        WebElement currentPrice = driver.findElement(By.xpath("//div[@class = 'current-price']/span"));
        WebElement regularPrice = driver.findElement(By.className("regular-price"));
        WebElement discountLabel = driver.findElement(By.className("discount-percentage"));

        System.out.println(currentPrice.getText());
        System.out.println(regularPrice.getText());
        System.out.println(discountLabel.getText());
    }

    @When("user selects {string} and {string}")
    public void userSelectsAnd(String size, String quantity) {
        WebElement sizeElement = driver.findElement(By.name("group[1]"));
        Select countrySelect = new Select(sizeElement);
        WebElement qtyInput = driver.findElement(By.name("qty"));

        countrySelect.selectByVisibleText(size);
        qtyInput.clear();
        qtyInput.sendKeys(quantity);
    }

    @When("user adds purchase to cart")
    public void userAddsPurchaseToCart() {
        WebElement addToCartButton = driver.findElement(By.className("add-to-cart"));
        addToCartButton.click();
    }

    @When("user goes to checkout")
    public void userGoesToCheckout() throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkoutFirstButton = driver.findElement(By.xpath("//div[@class = 'cart-content-btn']/a"));
        checkoutFirstButton.click();

        WebElement checkoutSecondButton = driver.findElement(By.xpath("//*[@id='main']/div/div[2]/div[1]/div[2]"));
        checkoutSecondButton.click();
    }

    @When("user confirms address")
    public void userConfirmsAddress() {
        WebElement continueFirstButton = driver.findElement(By.className("continue"));
        continueFirstButton.click();
    }

    @When("user picks delivery method")
    public void userPicksDeliveryMethod() {
    }

    @When("user picks payment method")
    public void userPicksPaymentMethod() {
    }

    @When("user clicks on order with an obligation to pay")
    public void userClicksOnOrderWithAnObligationToPay() {
    }

    @Then("takes screenshot")
    public void takesScreenshot() {
    }
}
