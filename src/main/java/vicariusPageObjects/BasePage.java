package vicariusPageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillText(WebElement el, String text) {
        wait(el);
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        wait(el);
        el.click();
    }

    public void clear(WebElement el) {
        wait(el);
        el.clear();
    }

    public String getText(WebElement el) {
        wait(el);
        return el.getText();
    }

    public void wait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}


