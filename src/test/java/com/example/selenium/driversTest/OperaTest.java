package com.example.selenium.driversTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Configurando el Driver de Opera y haciendo test")
public class OperaTest {

    //Driver del navegador
    WebDriver webdriver;

    @BeforeEach
    void setup() {
        //esta es la ruta del proyecto
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/operadriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.opera.driver", url);
        //Driver de Navegador Opera
        webdriver = new OperaDriver();
    }

    //Esto es para que se cierre el navegador
    @AfterEach
    void tearDown() {
        webdriver.quit();

    }

    @DisplayName("Abriendo pagina web de youtube ")
    @Test
    void abrirPagina_WebTest(){
        webdriver.get("https://www.youtube.com/");
        String title = webdriver.getTitle();
        assertEquals("YouTube",title);
    }


}
