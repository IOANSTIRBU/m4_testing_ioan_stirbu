package com.example.selenium.WebPagesTest.orangehrm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
 class DeleteUserTest extends BaseTest{

     private static final String URL = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";

     @DisplayName("Comprobando que nos podemos loguear en la pagina web")
     @Test
     void loginSuccess() {
         webdriver.get(URL);

         webdriver.findElement(By.id("txtUsername")).sendKeys(USERNAME);

         webdriver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);

         click("btnLogin");

         assertEquals("System Users", webdriver.findElement(By.tagName("h1")).getText());
     }

     @Test
     void deleteUserTableTest(){
         login();
         webdriver.get(URL);

         //Eliminara el username de "software" aviso
         webdriver.findElement(By.xpath("//table[@id='resultTable']//input[@value='46']")).click();

         webdriver.findElement(By.xpath("//input[@id='btnDelete']")).click();

         WebElement modalWindow = webdriver.findElement(By.id("dialogDeleteBtn"));
         modalWindow.click();
         assertEquals("OrangeHRM", webdriver.findElement(By.tagName("h3")).getText());

     }
 }
