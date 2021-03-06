package workshops.Task02;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class BuySweaterStep {

    private WebDriver driver;

    @Given("user is registered on {string} page")
    public void userIsRegisteredOnPage(String store) {
        // driver assignment
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        // creating new object with ChromeDriver
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

    @When("user picks Hummingbird Printed Sweater")
    public void userPicks() {
        WebElement productLink = driver.findElement(By.xpath("//*[@id='content']/section/div/article[2]/div/div[1]/h3/a"));
        productLink.click();
    }

    @When("user checks if there is {string} discount")
    public void userChecksIfThereIsDiscount(String arg0) {

        WebElement currentPrice = driver.findElement(By.xpath("//div[@class = 'current-price']/span"));
        WebElement regularPrice = driver.findElement(By.className("regular-price"));
        WebElement discountLabel = driver.findElement(By.className("discount-percentage"));

        System.out.println(currentPrice.getText());
        System.out.println(regularPrice.getText());
        System.out.println(discountLabel.getText());

        //convert string with first symbol removed to float
        float formattedRegularPrice = Float.parseFloat(regularPrice.getText().substring(1));
        System.out.println(formattedRegularPrice);

        float formattedCurrentPrice = Float.parseFloat(currentPrice.getText().substring(1));
        System.out.println(formattedCurrentPrice);

        float formattedDiscountLabel = Float.parseFloat(discountLabel.getText().substring(5,7));
        System.out.println(formattedDiscountLabel);

        float discountedPrice = formattedRegularPrice - ((formattedDiscountLabel/100)*formattedRegularPrice);
        // from stackoverflow "assert equals float"
        Assert.assertEquals(formattedCurrentPrice, discountedPrice, 0.0001);

    }

    @When("user selects {string} and {string}")
    public void userSelectsAnd(String size, String quantity) {
        WebElement sizeElement = driver.findElement(By.name("group[1]"));
        Select sizeSelect = new Select(sizeElement);
//        WebElement qtyInput = driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        sizeSelect.selectByVisibleText(size);
        WebElement qtyInput = driver.findElement(By.name("qty"));
//        qtyInput.clear();
        qtyInput.click();
        qtyInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        qtyInput.sendKeys(quantity);
    }

    @When("user adds purchase to cart")
    public void userAddsPurchaseToCart() {
        WebElement addToCartButton = driver.findElement(By.className("add-to-cart"));
        addToCartButton.click();
    }

    @When("user goes to checkout")
    public void userGoesToCheckout() throws InterruptedException {
        Thread.sleep(2200);
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
    public void userPicksDeliveryMethod() throws InterruptedException {
        WebElement continueSecondButton = driver.findElement(By.name("confirmDeliveryOption"));
        Thread.sleep(2000);
        continueSecondButton.click();
    }

    @When("user picks payment method")
    public void userPicksPaymentMethod() {
        WebElement payByCheckRadioButton = driver.findElement(By.id("payment-option-1"));
        payByCheckRadioButton.click();
    }

    @When("user clicks on order with an obligation to pay")
    public void userClicksOnOrderWithAnObligationToPay() throws InterruptedException {
        WebElement termsCheckbox = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        termsCheckbox.click();
        Thread.sleep(2000);
        WebElement SubmitButton = driver.findElement(By.xpath("//div[@id = 'payment-confirmation']/div/button"));
        SubmitButton.click();
    }

    @Then("takes screenshot")
    public void takesScreenshot() throws IOException {
        // from stackoverflow ????????
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("c:\\tmp\\screenshot.png"));
    }
}
