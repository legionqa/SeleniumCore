import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestExample {
    static WebDriver webDriver;
    static Logger logger = LogManager.getLogger(TestExample.class);
    @BeforeAll
    public static void setup() {
        logger.info("BeforeAll");
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @AfterAll
    public static void tearDown() {
        logger.info("AfterAll");
        webDriver.quit();
    }


    @Test
    public void test() {
        System.out.println("Test");
        webDriver.get("https://www.google.com");
        Assertions.assertEquals("Google", webDriver.getTitle());
    }
}
