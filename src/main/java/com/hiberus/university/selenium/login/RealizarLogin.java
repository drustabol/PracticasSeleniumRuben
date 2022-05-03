package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebElement element;
        String userProfile="C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);

        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        element= driver.findElement(By.id("user-name"));

        element.sendKeys("standard_user");

        element= driver.findElement(By.id("password"));

        element.sendKeys("secret_sauce");

        element= driver.findElement(By.id("login-button"));

        element.click();

        String url=driver.getCurrentUrl();

        if (url.equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) System.out.println("Tó bien");
        else System.out.println("No es correcto");
    }
}
