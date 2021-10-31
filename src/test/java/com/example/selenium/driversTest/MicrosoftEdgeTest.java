package com.example.selenium.driversTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Configurando el Driver de  Microsoft Edge y haciendo test")
public class MicrosoftEdgeTest {

    WebDriver webdriver;

    @BeforeEach
    void setup() {
        //esta es la ruta del proyecto
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/msedgedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.edge.driver", url);
        //Driver del Navegador de Microsoft Edge
        webdriver = new EdgeDriver();
    }

    @AfterEach
    void tearDown() {
        webdriver.quit();

    }

    @DisplayName("Abriendo pagina web de Udemy ")
    @Test
    void abrirPagina_WebTest(){
        webdriver.get("https://www.udemy.com/");
        String title = webdriver.getTitle();
        assertEquals("Cursos en línea: aprende de todo y a tu propio ritmo | Udemy",title);
    }
}
