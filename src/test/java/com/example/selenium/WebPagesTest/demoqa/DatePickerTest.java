package com.example.selenium.WebPagesTest.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DatePickerTest extends BaseTest {

    private static final String URL = "https://demoqa.com/date-picker";

    @DisplayName("Me comprueba que la fecha esta bien que no haya errores")
    @Test
    void datePickerTest() {
        webdriver.get(URL);
        WebElement input = webdriver.findElement(By.id("datePickerMonthYearInput"));
        String fecha_String = input.getAttribute("value");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate fecha = LocalDate.parse(fecha_String, formato);
        System.out.println(fecha.toString());
        System.out.println(LocalDate.now());

        assertEquals(fecha.toString(), LocalDate.now().toString());

        //Para poner la fecha manual
        String[] dateParts = fecha_String.split("/");
        System.out.println(Arrays.toString(dateParts));

        LocalDate webdate = LocalDate.of(
                Integer.parseInt(dateParts[2]),
                Integer.parseInt(dateParts[0]),
                Integer.parseInt(dateParts[1])
        );

        assertEquals(webdate.toString(), LocalDate.now().toString());

    }

    @DisplayName("Me comprueba que la hora que le he pasado es correcta")
    @Test
    void dateTimeTest() {
        webdriver.get(URL);
        WebElement input = webdriver.findElement(By.id("dateAndTimePickerInput"));
        input.click();

        WebElement tiempo = webdriver.findElement(By.xpath("//li[text() = '05:00']"));
        tiempo.click();

        input = webdriver.findElement(By.id("dateAndTimePickerInput"));
        String dateString = input.getAttribute("value");

        assertTrue(dateString.contains("5:00 AM"));

    }

}
