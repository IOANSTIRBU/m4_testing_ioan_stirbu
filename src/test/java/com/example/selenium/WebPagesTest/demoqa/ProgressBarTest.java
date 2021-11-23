package com.example.selenium.WebPagesTest.demoqa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class ProgressBarTest extends BaseTest {

    private static final String URL = "https://demoqa.com/progress-bar";

    @Test
    void progressBar(){
        webdriver.get(URL);

        webdriver.findElement(By.xpath("//*[@id=\"startStopButton\"]")).click();

        new WebDriverWait(webdriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeContains(By.className("progress-bar"), "aria-valuenow", "100"));

        assertEquals("100%", webdriver.findElement(By.className("progress-bar")).getText());

        webdriver.findElement(By.xpath("//*[@id='resetButton']")).click();

        new WebDriverWait(webdriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeContains(By.className("progress-bar"), "aria-valuenow", "0"));

        assertEquals("0%", webdriver.findElement(By.className("progress-bar")).getText());



    }

}
