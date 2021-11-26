package com.example.selenium.WebPagesTest.opencart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListOpenCart extends BaseTest{

    private final String URL1 = "https://www.opencart.com/index.php?route=cms/demo";

    private final String URL2 = "https://demo.opencart.com/admin/";

    @DisplayName("Comprobamos la lista de elementos que hay en la pagina seleccionada")
    @Test
    void listDisplaysTest(){
        webdriver.get(URL1);
        List<WebElement> displays = webdriver.findElements(By.cssSelector("#cms-demo > div.container > div"));
        displays.get(0).click();
    }


        @DisplayName("Comprobamos que se puede ghacer click en el boton de Login")
        @Test
        void buttonLoginTest(){
            webdriver.get(URL2);
            webdriver.findElement(By.xpath("//div[@class='text-right']//button")).click();
            assertEquals("Dashboard", webdriver.findElement(By.cssSelector("#content > div.page-header > div > h1")).getText());
        }

}
