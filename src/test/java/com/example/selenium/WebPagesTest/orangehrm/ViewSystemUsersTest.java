package com.example.selenium.WebPagesTest.orangehrm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

 class ViewSystemUsersTest extends BaseTest{

    private static final String URL = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";

    @DisplayName("Comprobando que se puede completar los datos en el System Users")
    @Test
    void SystemUsersTest(){
        login();
        webdriver.get(URL);
        WebElement input = webdriver.findElement(By.id("searchSystemUser_userName"));
        input.sendKeys("Aravind");

        webdriver.findElement(By.xpath("//select[@id='searchSystemUser_userType'] //option[@value='2']")).click();

        webdriver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys("Dominic Chase");

        webdriver.findElement(By.xpath("//select[@id='searchSystemUser_status'] //option[@value='1']")).click();

        webdriver.findElement(By.id("searchBtn")).click();

        webdriver.findElement(By.id("resetBtn")).click();

        assertEquals("OrangeHRM", webdriver.getTitle());


    }







}
