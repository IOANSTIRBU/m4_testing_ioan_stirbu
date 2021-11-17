package com.example.selenium.WebPagesTest.orangehrm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {

    private static final String URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
    static final String USERNAME = "Admin";
    static final String PASSWORD = "admin123";

    //Driver del navegador
    WebDriver webdriver;
    JavascriptExecutor js;

    @BeforeEach
    void setup() {
        //esta es la ruta del proyecto
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/operadriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.opera.driver", url);
        //Driver de Navegador Opera
        webdriver = new OperaDriver();
        js = (JavascriptExecutor) webdriver;
        webdriver.manage().window().maximize();
    }

    //Esto es para que se cierre el navegador una vez completado el test
    @AfterEach
    void tearDown() {
        webdriver.quit();

    }

    void click(String id){
        webdriver.findElement(By.id(id)).click();
    }


    @DisplayName("Comprobando que nos podemos loguear en la pagina web")
    @Test
    void login(){
        webdriver.get(URL);

        webdriver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
        webdriver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);
        WebElement button = webdriver.findElement(By.id("btnLogin"));
        button.click();
    }




}
