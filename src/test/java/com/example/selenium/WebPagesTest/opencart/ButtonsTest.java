package com.example.selenium.WebPagesTest.opencart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonsTest extends BaseTest{

    private static final String URL1 = "https://www.opencart.com/";

    @DisplayName("Comprobamos que nos lleva correctamente a la pagina web  de descarga")
    @Test
    void buttonFreeDownloadTest(){
        webdriver.get(URL1);
        webdriver.findElement(By.xpath("//p[@class='hidden-xs'] //a[@class='btn btn-success btn-xl']")).click();

        assertEquals("Easy set-up by our hosting partner",webdriver.findElement(By.xpath("//div/div[1]/div[2]/div/h4")).getText());

    }

    @DisplayName("Comprobando que nos lleva a la web de View Demo")
    @Test
    void buttonViewDemoTest(){
        webdriver.get(URL1);
        webdriver.getCurrentUrl();

        webdriver.findElement(By.xpath("//p[@class='hidden-xs']//a[@class='btn btn-white btn-xl']")).click();

        assertEquals("OpenCart Demonstration", webdriver.findElement(By.tagName("h1")).getText());




    }


}
