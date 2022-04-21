package workshops.Task02;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }

    @When("user selects {string} and {string}")
    public void userSelectsAnd(String arg0, String arg1) {
    }

    @When("user adds purchase to cart")
    public void userAddsPurchaseToCart() {
    }

    @When("user goes to checkout")
    public void userGoesToCheckout() {
    }

    @When("user confirms address")
    public void userConfirmsAddress() {
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
