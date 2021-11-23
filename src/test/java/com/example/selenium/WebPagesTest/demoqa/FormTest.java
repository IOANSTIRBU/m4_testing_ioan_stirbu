package com.example.selenium.WebPagesTest.demoqa;

import net.bytebuddy.jar.asm.ByteVector;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest extends BaseTest {

    //Constantes
    private static final String URL = "https://demoqa.com/automation-practice-form";
    private static final String NAME = "Juanito";
    private static final String LAST_NAME = "pepe";
    private static final String EMAIL = "micasa@mimi.co";
    private static final String NUMBER_PHONE = "5555555555";
    private static final String GENDER_MALE = "//label[@for='gender-radio-1']";
    private static final String DROP_DOWN = "//div[text()='Computer Science' and contains(@class, 'subjects-auto-complete__option')]";
    private static final String SELECTED_COMPUTER_SCIENCE = "//div[text()='Computer Science' and contains(@class, 'subjects-auto-complete__multi-value__label')]";
    private static final String HOBBIES_READING = "//label[@for='hobbies-checkbox-2']";
    private static final String HOBBIES_MUSIC = "//label[@for='hobbies-checkbox-3']";



    @DisplayName("Comprobando que se rellena correctamente los datos en el formulario")
    @Test
    void rellenarDatosTest() {

        //hideElement();

        obtenerUrl();

        nameLastNameTest();

        emailTest();

        radioTest();

        phoneNumberTest();

        birthDayTest();

        subjectTest();

        hobbiesTest();

        subirImagenTest();

        textAreaTest();

        scrollJs();


        closeModalTest();


    }


    private void obtenerUrl() {
        webdriver.get(URL);
    }

    private void scrollJs() {
        WebElement button = webdriver.findElement(By.xpath("//*[@id=\"submit\"]"));
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();

    }

    private void emailTest() {
        webdriver.findElement(By.id("userEmail")).sendKeys(EMAIL);
    }

    private void nameLastNameTest() {
        webdriver.findElement(By.id("firstName")).sendKeys(NAME);
        webdriver.findElement(By.id("lastName")).sendKeys(LAST_NAME);

    }

    private void radioTest() {
        webdriver.findElement(By.xpath(GENDER_MALE)).click();
    }

    private void phoneNumberTest() {
        webdriver.findElement(By.id("userNumber")).sendKeys(NUMBER_PHONE);
    }

    private void birthDayTest() {
        webdriver.findElement(By.id("dateOfBirthInput")).click();
        webdriver.findElement(By.cssSelector(".react-datepicker__day--023")).click();

    }

    private void subjectTest() {
        webdriver.findElement(By.id("subjectsInput")).sendKeys("P");

        webdriver.findElement(By.xpath(DROP_DOWN)).click();
        assertEquals(1,webdriver.findElements(By.xpath(SELECTED_COMPUTER_SCIENCE)).size());
    }

    private void hobbiesTest() {
        webdriver.findElement(By.xpath(HOBBIES_READING)).click();
        webdriver.findElement(By.xpath(HOBBIES_MUSIC)).click();
    }

    private void subirImagenTest() {
        String img = "C:\\Users\\Jony\\Java_CursoTesting\\M4-Project\\Selenium_Logo.png";

        WebElement subirImagen = webdriver.findElement(By.xpath("//*[@id=\"uploadPicture\"]"));
        subirImagen.sendKeys(img);

    }


    private void textAreaTest() {
        webdriver.findElement(By.id("currentAddress")).sendKeys("Mi casa Telefono de E.T");
    }




    private void closeModalTest() {
        assertTrue(webdriver.findElement(By.xpath("/html/body/div[4]/div/div")).isDisplayed());

        WebElement closeButton = webdriver.findElement(By.xpath("//*[@id=\"closeLargeModal\"]"));

        js.executeScript("arguments[0].scrollIntoView();", closeButton);
        closeButton.sendKeys(Keys.ENTER);

        new WebDriverWait(webdriver, Duration.ofSeconds(7))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));

        assertEquals(0, webdriver.findElements(By.xpath("/html/body/div[4]/div/div")).size());

        assertThrows(NoSuchElementException.class, () -> webdriver.findElement(By.xpath("/html/body/div[4]/div/div")));

    }


}
