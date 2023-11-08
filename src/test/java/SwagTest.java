import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class TestSDETNewExample {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();

        contentSettings.put("cookies",2);
        profile.put("managed_default_content_settings",contentSettings);
        prefs.put("profile",profile);
        options.setExperimentalOption("prefs",prefs);

// Создаём новый объект класса ChromeDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void oracleTest() {
        driver.get("https://docs.oracle.com/javase/8/docs/api/overview-summary.html");
        driver.manage().window().setSize(new Dimension(874, 884));
//        WebElement button = driver.findElement(By.cssSelector("body > div:nth-child(17) > div.mainContent > div > div.pdynamicbutton > a.call"));
//        button.click();
        driver.findElement(By.cssSelector("#allclasses_navbar_top a")).click();
        {
            WebElement element = driver.findElement(By.linkText("AbstractBorder"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.linkText("Array")).click();
        driver.findElement(By.linkText("Static Methods")).click();
        driver.findElement(By.linkText("Concrete Methods")).click();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
