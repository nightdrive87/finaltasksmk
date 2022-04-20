package workshops.Task01;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckAddressStep {

    private WebDriver driver;

    @Given("user has an account on {string} store")
    public void userHasAnAccountOnStore(String store) {
        // driver assignment
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        // creating new object with ChromeDriverem
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(store);
    }

    @When("user logs into account")
    public void userLogsIntoAccount() {
        WebElement signInLink = driver.findElement(By.className("user-info"));
        signInLink.click();

        WebElement email = driver.findElement(By.name("email"));
        WebElement passwd = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("submit-login"));
        email.sendKeys("zofia@test.com");
        passwd.sendKeys("qwerty");
        loginBtn.click();
    }

    @When("user clicks on Addresses module")
    public void userClicksOnAddressesModule() {

    }

    @When("user clicks on + Create new address option")
    public void userClicksOnCreateNewAddressOption() {
    }

    @When("user fills form with data {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsFormWithData(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
    }

    @And("clicks Save button to add address")
    public void clicksSaveButtonToAddAddress() {
    }

    @Then("new address is added and contains {string}, {string}, {string}, {string}, {string}, {string}")
    public void newAddressIsAddedAndContains(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
    }
}
