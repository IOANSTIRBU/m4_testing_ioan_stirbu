package com.example.selenium.driversTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Configurando el Driver de Firefox y haciendo  test")
public class FirefoxTest {

    WebDriver webdriver;

    @BeforeEach
    void setup() {
        //esta es la ruta del proyecto
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/geckodriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.gecko.driver", url);
        //Driver de Navegador de Firefox
        webdriver = new FirefoxDriver();
    }

    @AfterEach
    void tearDown() {
        webdriver.quit();

    }

    @DisplayName("Abriendo pagina web de 3DJuegos ")
    @Test
    void abrirPagina_WebTest(){
        webdriver.get("https://www.3djuegos.com/");
        String title = webdriver.getTitle();
        assertEquals("3DJuegos - Todo en videojuegos PC, PS4, Xbox, Switch, Stadia, PS5, Android",title);
    }
}
