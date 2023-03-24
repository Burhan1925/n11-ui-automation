package com.n11.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.log4j.Logger;

public class BaseTest {

    public static Logger logger;
    public static WebDriver driver;
    public static String baseUrl = "https://www.n11.com";

    public BaseTest() {
        logger = Logger.getLogger(BaseTest.class);
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-translate");
        chromeOptions.addArguments("--start-");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--acceptInsecureCerts");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-plugins");
        chromeOptions.addArguments("--disable-blink-features");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-extensions");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }
    @After
    public void tearDown() {
       if (driver != null) {
           driver.close();
           driver.quit();
       }
    }
}
