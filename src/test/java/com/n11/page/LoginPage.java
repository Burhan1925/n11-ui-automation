package com.n11.page;

import com.n11.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;
    Logger logger;

    public LoginPage() {
        methods = new Methods();
        logger = LogManager.getLogger(LoginPage.class);
    }

    // TestCase:1 --> Success Login Scenario
    public void login()
    {
        methods.isElementVisible(By.cssSelector(".btnSignIn"));
        methods.click(By.cssSelector(".btnSignIn"));
        methods.isElementVisible(By.id("email"));
        methods.sendKeys(By.id("email"),"javaautomationtest@gmail.com");
        methods.isElementVisible(By.id("password"));
        methods.sendKeys(By.id("password"),"1A2s3d..");
        methods.scrollWithAction(By.cssSelector("[title='Üye Ol']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.id("loginButton"));
        methods.click(By.id("loginButton"));
        methods.waitBySeconds(5);
        String getLoginText = methods.getText(By.cssSelector("[title='Hesabım']"));
        Assert.assertEquals("Başarılı giriş işlemi sağlanamadı.",getLoginText,"BA");
        logger.info("Giriş işlemi sağlandı.");
    }

    // TestCase:2 --> Empty E-Mail and Empty Password
    public void loginFailureOne()
    {
        methods.isElementVisible(By.cssSelector(".btnSignIn"));
        methods.click(By.cssSelector(".btnSignIn"));
        methods.isElementVisible(By.id("email"));
        methods.isElementVisible(By.id("password"));
        methods.scrollWithAction(By.cssSelector("[title='Üye Ol']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.id("loginButton"));
        methods.click(By.id("loginButton"));
        methods.waitBySeconds(2);
        String getLoginTextEmail = methods.getText(By.xpath("//div[text()='Lütfen e-posta adresinizi girin.']"));
        Assert.assertEquals("E-posta alanının boş kalmadığı görülür.",getLoginTextEmail,"Lütfen e-posta adresinizi girin.");
        String getLoginTextPassword = methods.getText(By.xpath("//div[text()='Bu alanın doldurulması zorunludur.']"));
        Assert.assertEquals("Password alanının boş kalmadığı görülür.",getLoginTextPassword,"Bu alanın doldurulması zorunludur.");
    }

    // TestCase:3 --> Empty E-Mail and Password
    public void loginFailureTwo()
    {
        methods.isElementVisible(By.cssSelector(".btnSignIn"));
        methods.click(By.cssSelector(".btnSignIn"));
        methods.isElementVisible(By.id("email"));
        methods.isElementVisible(By.id("password"));
        methods.sendKeys(By.id("password"),"1A2s3d..");
        methods.scrollWithAction(By.cssSelector("[title='Üye Ol']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.id("loginButton"));
        methods.click(By.id("loginButton"));
        methods.waitBySeconds(2);
        String getLoginTextEmail = methods.getText(By.xpath("//div[text()='Lütfen e-posta adresinizi girin.']"));
        Assert.assertEquals("E-posta uyarı mesajının eşleşmediği görülür.",getLoginTextEmail,"Lütfen e-posta adresinizi girin.");
    }

    // TestCase:4 --> E-Mail and Empty Password
    public void loginFailureThree()
    {
        methods.isElementVisible(By.cssSelector(".btnSignIn"));
        methods.click(By.cssSelector(".btnSignIn"));
        methods.isElementVisible(By.id("email"));
        methods.sendKeys(By.id("email"),"javaautomationtest@gmail.com");
        methods.isElementVisible(By.id("password"));
        methods.scrollWithAction(By.cssSelector("[title='Üye Ol']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.id("loginButton"));
        methods.click(By.id("loginButton"));
        methods.waitBySeconds(2);
        String getLoginTextPassword = methods.getText(By.xpath("//div[text()='Bu alanın doldurulması zorunludur.']"));
        Assert.assertEquals("Password uyarı mesajının eşleşmediği görülür.",getLoginTextPassword,"Bu alanın doldurulması zorunludur.");
    }

    // TestCase:5 --> E-Mail and Invalid Password
    public void loginFailureFour()
    {
        methods.isElementVisible(By.cssSelector(".btnSignIn"));
        methods.click(By.cssSelector(".btnSignIn"));
        methods.isElementVisible(By.id("email"));
        methods.sendKeys(By.id("email"),"***********");
        methods.isElementVisible(By.id("password"));
        methods.sendKeys(By.id("password"),"***********");
        methods.scrollWithAction(By.cssSelector("[title='Üye Ol']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.id("loginButton"));
        methods.click(By.id("loginButton"));
        methods.waitBySeconds(2);
        String getLoginTextPassword = methods.getText(By.xpath("//div[text()='Lütfen geçerli bir e-posta adresi girin.']"));
        Assert.assertEquals("Geçerli bir e-posta adresi girildi.",getLoginTextPassword,"Lütfen geçerli bir e-posta adresi girin.");
    }

    // TestCase:6 --> Password Character Count Invalid
    public void loginFailureFive()
    {
        methods.isElementVisible(By.cssSelector(".btnSignIn"));
        methods.click(By.cssSelector(".btnSignIn"));
        methods.isElementVisible(By.id("email"));
        methods.isElementVisible(By.id("password"));
        methods.sendKeys(By.id("password"),"**********************");
        methods.scrollWithAction(By.cssSelector("[title='Üye Ol']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.id("loginButton"));
        methods.click(By.id("loginButton"));
        methods.waitBySeconds(2);
        String getLoginTextEmail = methods.getText(By.xpath("//div[text()='Lütfen e-posta adresinizi girin.']"));
        Assert.assertEquals("E-posta alanının boş kalmadığı görülür.",getLoginTextEmail,"Lütfen e-posta adresinizi girin.");
        String getLoginTextPassword = methods.getText(By.xpath("//div[text()='Girilen değer en fazla 15 karakter olmalıdır.']"));
        Assert.assertEquals("Girilen password değeri 15 karakterden az girildi.",getLoginTextPassword,"Girilen değer en fazla 15 karakter olmalıdır.");
    }

}
