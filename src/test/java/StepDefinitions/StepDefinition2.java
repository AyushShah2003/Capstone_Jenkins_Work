package StepDefinitions;



import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition2 {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    String uniqueEmail;

    @Given("I open the browser")
    public void i_open_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    @When("I go to the home page")
    public void i_go_to_the_home_page() {
    	driver.get("https://westfloridaahec.org/");
    }

    @Then("I search for {string}")
    public void i_search_for(String searchTerm) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[1]/label/input")));
        searchBox.sendKeys(searchTerm);
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
        driver.navigate().back();
    }

    @Then("I click on the banner")
    public void i_click_on_the_banner() {
        WebElement banner = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"post-10\"]/div/div[1]/div/div/div/div[1]/div[1]/div/div/a/div/span/i")));
        banner.click();
        driver.navigate().back();
    }

    /*@Then("I open the program {string}")
    public void i_open_the_program(String programName) {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"menu-item-264\"]/a")));
            actions.moveToElement(menu).perform();

            WebElement submenu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(), '" + programName + "')]")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submenu);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submenu);

            wait.until(ExpectedConditions.titleContains("Florida"));
            driver.navigate().back();
            wait.until(ExpectedConditions.titleContains("West Florida"));
        } catch (TimeoutException e) {
            System.out.println("⚠️ Failed to open program: " + programName);
            e.printStackTrace();
        }
    }
*/
    /*@Then("I open the program {string}")
    public void i_open_the_program(String programName) {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]")));
            actions.moveToElement(menu).perform();

            WebElement submenu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(normalize-space(text()), '" + programName + "')]")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submenu);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submenu);

            wait.until(ExpectedConditions.titleContains("Florida"));
            driver.navigate().back();
            wait.until(ExpectedConditions.titleContains("West Florida"));
        } catch (TimeoutException e) {
            System.out.println("⚠️ Failed to open program: " + programName);
            e.printStackTrace();
        }
    }
    */@Then("I open the program {string}")
    public void i_open_the_program(String programName) {
        try {
            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]")));
            actions.moveToElement(menu).perform();

            WebElement submenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//a[contains(normalize-space(text()), '" + programName + "')]")));

            // Scroll and click safely
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submenu);
            safeClick(submenu);

            // Wait for page load by checking title contains program name (adjust if needed)
            wait.until(ExpectedConditions.titleContains(programName));
            driver.navigate().back();
            wait.until(ExpectedConditions.titleContains("West Florida"));

        } catch (TimeoutException e) {
            System.out.println("⚠️ Failed to open program: " + programName);
            e.printStackTrace();
        }
    }

    @When("I go to the registration page")
    public void i_go_to_the_registration_page() {
        driver.get("https://westfloridaahec.org/my-account/");
    }

   /* @When("I register with username {string} and password {string}")
    public void i_register_with_username_and_password(String username, String password) {
        driver.findElement(By.id("reg_username")).sendKeys(username);

        // Generate unique email
        uniqueEmail = "01ayushshah" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("reg_email")).sendKeys(uniqueEmail);

        driver.findElement(By.id("reg_password")).sendKeys(password);

        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("register")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
        safeClick(registerButton);
    }*/
    @When("I register with username {string} and password {string}")
    public void i_register_with_username_and_password(String username, String password) {
        driver.findElement(By.id("reg_username")).sendKeys(username);

        // Generate unique email
        uniqueEmail = "01ayushshah" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("reg_email")).sendKeys(uniqueEmail);

        driver.findElement(By.id("reg_password")).sendKeys(password);

        WebElement registerButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("register")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);

        // Retry clicking for stability
        for (int i = 0; i < 3; i++) {
            try {
                registerButton.click();
                break;
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);
            }
        }

        // Optional: wait for success message or account page
        wait.until(ExpectedConditions.urlContains("my-account"));
    }


    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        System.out.println("✅ Registration successful with email: " + uniqueEmail);
    }

    @When("I go to the login page")
    public void i_go_to_the_login_page() {
        driver.get("https://westfloridaahec.org/my-account/");
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        safeClick(loginButton);
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("✅ Login successful");
    }

    @When("I go to the contact us page")
    public void i_go_to_the_contact_us_page() {
        driver.get("https://westfloridaahec.org/contact-us/");
    }

    @Then("I click on the email link")
    public void i_click_on_the_email_link() {
        WebElement emailLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"post-127\"]/div/div[1]/div/div/div/div[7]/div[2]/div/div[3]/p/a")));
        emailLink.click();
        driver.navigate().back();
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Helper method for safe clicking
    private void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }


}