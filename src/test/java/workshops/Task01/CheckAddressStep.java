package workshops.Task01;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

        WebElement addressesLink = driver.findElement(By.id("addresses-link"));
        addressesLink.click();

    }

    @When("user clicks on + Create new address option")
    public void userClicksOnCreateNewAddressOption() {
        // https://stackoverflow.com/a/9188374
        // checking if address with "home" alias exists
        Boolean checkAddress = driver.findElements(By.xpath("//article/div[@class='address-body']/h4[contains(text(), 'home')]")).size() > 0;
        System.out.println(checkAddress);
        // in case of finding an address - delete it
        if (checkAddress) {
            System.out.println("Address founded - address deleted");
            WebElement deleteAddress = driver.findElement(By.xpath("//article/div[@class='address-body']/h4[contains(text(), 'home')]/../../div[2]/a[2]"));
            deleteAddress.click();
        }
        // if it doesn't exist - add address
        WebElement addAddressLink = driver.findElement(By.xpath("//*[@id='content']/div[3]/a"));
        addAddressLink.click();
    }

    @When("user fills form with data {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsFormWithData(String alias, String address, String city, String zip_postal_code, String country, String phone) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement companyInput = driver.findElement(By.name("company"));
        WebElement vatNumberInput = driver.findElement(By.name("vat_number"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement addressComplementInput = driver.findElement(By.name("address2"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement zipPostalCodeInput = driver.findElement(By.name("postcode"));
        WebElement countryElement = driver.findElement(By.name("id_country"));
        Select countrySelect = new Select(countryElement);
        WebElement phoneInput = driver.findElement(By.name("phone"));

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipPostalCodeInput.sendKeys(zip_postal_code);
        countrySelect.selectByValue(country);
        phoneInput.sendKeys(phone);
    }

    @And("clicks Save button to add address")
    public void clicksSaveButtonToAddAddress() {
        WebElement saveAddressButton = driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button"));
        saveAddressButton.click();
    }

    @Then("new address is added and contains {string}, {string}, {string}, {string}, {string}, {string}")
    public void newAddressIsAddedAndContains(String alias, String address, String city, String zip_postal_code, String country, String phone) {
        WebElement newAlias = driver.findElement(By.xpath("//article/div[@class='address-body']/h4[contains(text(), 'home')]"));
        WebElement newAddress = driver.findElement(By.xpath("//article/div[@class='address-body']/h4[contains(text(), 'home')]/../address"));
        System.out.println(newAlias.getText());
        System.out.println(newAddress.getText());
        //TODO do zaimplementowania sprawdzenie poprawności dodanego adresu
    }
}
