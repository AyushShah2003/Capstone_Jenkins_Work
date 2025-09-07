/*package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    // ---------------------- Common ----------------------
    @Given("user launches browser")
    public void user_launches_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------------- Home ----------------------
    @When("user navigates to homepage")
    public void user_navigates_to_homepage() {
        driver.get("https://westfloridaahec.org/");
    }

    @When("user searches for {string}")
    public void user_searches_for(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='wrapper']/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[1]/label/input")));
        searchBox.sendKeys(keyword);

        driver.findElement(By.xpath("//*[@id='wrapper']/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input"))
              .click();
    }

    @When("user goes back to homepage")
    public void user_goes_back_to_homepage() {
        driver.navigate().back();
    }

    @When("user clicks banner and navigates back")
    public void user_clicks_banner_and_navigates_back() {
        WebElement banner = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='post-10']/div/div[1]/div/div/div/div[1]/div[1]/div/div/a/div/span/i")));
        banner.click();
        driver.navigate().back();
    }

    @Then("homepage test executed")
    public void homepage_test_executed() {
        System.out.println("Homepage test executed ✅");
    }

    // ---------------------- Programs ----------------------
    @When("user hovers on Programs menu")
    public void user_hovers_on_programs_menu() {
        WebElement programsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='menu-item-264']/a/span[1]")));
        actions = new Actions(driver);
        actions.moveToElement(programsMenu).perform();
    }

    @When("user clicks on Tobacco Free Florida")
    public void user_clicks_on_tobacco_free_florida() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu-item-344']/a/span"))).click();
        driver.navigate().back();
    }

    @When("user clicks on AHEC Scholars")
    public void user_clicks_on_ahec_scholars() {
        user_hovers_on_programs_menu();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu-item-280']/a/span"))).click();
        driver.navigate().back();
    }

    @When("user clicks on Healthy Aging")
    public void user_clicks_on_healthy_aging() {
        user_hovers_on_programs_menu();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu-item-534']/a/span"))).click();
        driver.navigate().back();
    }

    @When("user clicks on Covering Florida")
    public void user_clicks_on_covering_florida() {
        user_hovers_on_programs_menu();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu-item-1572']/a/span"))).click();
        driver.navigate().back();
    }

    @Then("Programs section test executed")
    public void programs_section_test_executed() {
        System.out.println("Programs section test executed ✅");
    }

    // ---------------------- Registration ----------------------
    @When("user navigates to registration page")
    public void user_navigates_to_registration_page() {
        driver.get("https://westfloridaahec.org/my-account/");
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.id("reg_username")).sendKeys(username + System.currentTimeMillis());
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        driver.findElement(By.id("reg_email")).sendKeys("test" + System.currentTimeMillis() + email);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.id("reg_password")).sendKeys(password);
    }

    @When("user clicks on register")
    public void user_clicks_on_register() {
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("register")));
        registerBtn.click();
    }

    @Then("registration test executed")
    public void registration_test_executed() {
        System.out.println("Registration test executed ✅");
    }

    // ---------------------- Login ----------------------
    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
        driver.get("https://westfloridaahec.org/my-account/");
    }

    @When("user enters login username {string}")
    public void user_enters_login_username(String loginUser) {
        driver.findElement(By.id("username")).sendKeys(loginUser);
    }

    @When("user enters login password {string}")
    public void user_enters_login_password(String loginPass) {
        driver.findElement(By.id("password")).sendKeys(loginPass);
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    }

    @Then("login test executed")
    public void login_test_executed() {
        System.out.println("Login test executed ✅");
    }

    // ---------------------- Contact Us ----------------------
    @When("user navigates to contact us page")
    public void user_navigates_to_contact_us_page() {
        driver.get("https://westfloridaahec.org/contact-us/");
    }

    @Then("contact us page test executed")
    public void contact_us_page_test_executed() {
        System.out.println("Contact Us Page test executed ✅");
    }

    // ---------------------- Cleanup ----------------------
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}*/
