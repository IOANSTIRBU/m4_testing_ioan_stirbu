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

        new WebDriverWait(webdriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("main-header")));

        assertEquals("Progress Bar", webdriver.findElement(By.xpath("//*[@id=\"progressBarContainer\"]/div[1]")).getText());

        webdriver.findElement(By.xpath("//*[@id=\"startStopButton\"]")).click();

          new WebDriverWait(webdriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("main-header")));

        assertEquals("Progress Bar", webdriver.findElement(By.xpath("//*[@id=\"progressBarContainer\"]/div[1]")).getText());


    }

}
