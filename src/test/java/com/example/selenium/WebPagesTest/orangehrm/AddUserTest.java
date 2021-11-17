package com.example.selenium.WebPagesTest.orangehrm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AddUserTest extends BaseTest {

    private static final String URL = "https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser";


    @DisplayName("Comprobando que nos podemos loguear en la pagina web")
    @Test
    void loginSuccess() {
        webdriver.get(URL);

        webdriver.findElement(By.id("txtUsername")).sendKeys(USERNAME);

        webdriver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);

        click("btnLogin");

        assertEquals("System Users", webdriver.findElement(By.tagName("h1")).getText());
    }


    @DisplayName("Comprobando que se puede añadir un usuario correctamente")
    @Test
    void addUser(){
        login();
        webdriver.get(URL);

        webdriver.findElement(By.xpath("//select[@id='systemUser_userType'] //option[@value='1']")).click();

        webdriver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Cassidy Hope");

        webdriver.findElement(By.id("systemUser_userName")).sendKeys("ManoloFernando");

        webdriver.findElement(By.xpath("//select[@id='systemUser_status'] //option[@value='1']")).click();

        webdriver.findElement(By.id("systemUser_password")).sendKeys("Admin_Alice1234");

        webdriver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Admin_Alice1234");

        WebElement button = webdriver.findElement(By.xpath("//input[@id='btnSave']"));
        button.click();

        new WebDriverWait(webdriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        assertEquals("Add User", webdriver.findElement(By.tagName("h1")).getText());





    }

}
