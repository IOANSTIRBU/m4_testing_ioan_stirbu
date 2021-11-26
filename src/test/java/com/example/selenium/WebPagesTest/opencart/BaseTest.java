package com.example.selenium.WebPagesTest.opencart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    //Driver del navegador
    WebDriver webdriver;
    JavascriptExecutor js;

    @BeforeEach
    void setup() {
        //esta es la ruta del proyecto
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        //Driver de Navegador Opera
        webdriver = new ChromeDriver();
        js = (JavascriptExecutor) webdriver;
        webdriver.manage().window().maximize();
    }

    //Esto es para que se cierre el navegador una vez completado el test
    @AfterEach
    void tearDown() {
        webdriver.quit();

    }




}
