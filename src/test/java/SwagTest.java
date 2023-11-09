import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class SwagTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();

        profile.put("managed_default_content_settings",contentSettings);
        prefs.put("profile",profile);
        options.setExperimentalOption("prefs",prefs);
        driver = new ChromeDriver(options);
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test
    public void swagTest() {
        WebElement userNameInput = driver.findElement(By.cssSelector("#user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement itemButton = driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name"));
        itemButton.click();

        WebElement itemAddButton = driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]"));
        itemAddButton.click();

        WebElement backButton = driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]"));
        backButton.click();

        WebElement itemButton2 = driver.findElement(By.cssSelector("#item_0_title_link > .inventory_item_name"));
        itemButton2.click();

        WebElement itemAddButton2 = driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bike-light\"]"));
        itemAddButton2.click();

        WebElement backButton2 = driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]"));
        backButton2.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
