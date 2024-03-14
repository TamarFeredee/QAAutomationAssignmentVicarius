package vicariusTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "/Users/tamarferede/Desktop/automation/drivers/chromedriver-mac-arm64 2/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.vicarius.io/sign/in");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
