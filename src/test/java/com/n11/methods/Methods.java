package com.n11.methods;

import com.n11.driver.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsDriver;
    public Logger logger;


    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(org.openqa.selenium.NoSuchElementException.class);
        jsDriver = (JavascriptExecutor) driver;
        logger = Logger.getLogger(Methods.class);
    }

    public void isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getProducts(By by) {
        List<WebElement> links = driver.findElements(by);
        return links;
    }

    public void click(By by) {
        scrollWithAction(by);
        findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        WebElement element = findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public void clickWithText(String tag, String text) {
        click(By.xpath("//" + tag + "[text()='" + text + "']"));
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).perform();
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollWithAction(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public Select getSelectText(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelectText(by).selectByVisibleText(text);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }
}
