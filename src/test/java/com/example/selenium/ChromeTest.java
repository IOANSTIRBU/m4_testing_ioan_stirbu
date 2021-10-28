package com.example.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Configurando el Driver de  Google Chrome y haciendo algunos test")
public class ChromeTest {

    //Driver del navegador
    WebDriver webdriver;

    @BeforeEach
    void setup() {
        //esta es la ruta del proyecto
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        //Driver de Google Chrome
        webdriver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        webdriver.quit();

    }

    //Abriendo paginas Web

    @DisplayName("Abriendo pagina web de google chrome solo")
    @Test
    void abrirPagina_WebTest(){
        webdriver.get("https://www.google.es/");
        String title = webdriver.getTitle();
        assertEquals("Google",title);
    }

    @DisplayName("Abriendo la pagina web de game.es solo")
    @Test
    void AbrirPaginaGameTest(){
        webdriver.get("https://www.game.es/");
        String title = webdriver.getTitle();
        assertEquals("GAME.es - GAME.es Videojuegos, consolas, informática, merchandising y electrónica",title);

    }

    //Aplicando selectores sobre la pagina web de Game
    @DisplayName("Comprobando si funciona al hacer un h1 al tagName")
    @Test
    void tagNameSelectorTest(){
        webdriver.get("https://www.game.es/");

        WebElement h1 = webdriver.findElement(By.tagName("h1"));
        String h1text = h1.getText();
        assertEquals("GAME",h1text);
        sleep();
    }

    @DisplayName("Comprobando con el id")
    @Test
    void idSelectorTest(){
        webdriver.get("https://github.com/mozilla");

        WebElement repositories = webdriver.findElement(By.id("org-profile-repositories"));
        assertTrue(repositories.isDisplayed());

        String css = repositories.getAttribute("class");
        assertEquals("my-3", css);
        sleep();
    }

    @Test
    void classSelectorTest(){
        webdriver.get("https://www.game.es/");
        List<WebElement> elements = webdriver.findElements(By.className("navigation-item-link-title"));
        assertEquals(137,elements.size());
        sleep();
    }

    @Test
    void inputTest(){
        webdriver.get("https://seleniumbase.io/demo_page");

        WebElement input = webdriver.findElement(By.id("myTextInput"));
        // Enviar información al campo del formulario
        input.sendKeys("Texto desde selenium");

        sleep();

        // comprobar que el input tiene el texto introducido
        input = webdriver.findElement(By.id("myTextInput"));
        String inputValue = input.getAttribute("value");
        assertEquals("Texto desde selenium", inputValue);
    }

    @DisplayName("Comprobando si se puede poner algo en el buscador de DuckDuckGO ")
    @Test
    void testSearchDuckDuckGo2(){
        webdriver.get("https://duckduckgo.com/");
        WebElement input = webdriver.findElement(By.name("q"));
        input.sendKeys("game.es" + Keys.ENTER);

        // Prueba a limpiar el campo de búsqueda para realizar otra búsqueda:
        input = webdriver.findElement(By.name("q"));
        input.clear();
        input.sendKeys("youtube" + Keys.ENTER);

    }


    @DisplayName("Lo mismo que el buscador de DuckDuckGo pero con google")
    @Test
    void testSearchGoogle(){
        webdriver.get("https://www.google.es");
        // 1. aceptar terminos y condiciones
        //sleep();
        WebElement acceptButton = webdriver.findElement(By.xpath("//div[text() = 'Acepto']"));
        assertEquals("jyfHyd", acceptButton.getAttribute("class"));
        acceptButton.click();
        //sleep();
        // 2. realizar busqueda
        WebElement input = webdriver.findElement(By.name("q"));
        input.sendKeys("Selenium java examples");
        input.submit();
        System.out.println("fin del test");
    }





    /**
     * El metodo de "sleep()"
     * hara es que se quede la pagina web
     * sin cerrar unos segundos
     */
    private void sleep() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}
