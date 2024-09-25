package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class OrderPage {

    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор заголовка страницы заказа
    private By orderHeader = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]");

    //Метод проверки нахождения на странице заказа
    public void checkOrderPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement orderPage = wait.until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
    }


    //Локатор поля ввода имени
    public By nameField = By.xpath(".//div[2]/div[1]/input");

    //Локатор поля ввода фамилии
    public By surnameField = By.xpath(".//div[2]/div[2]/input");

    //Локатор поля выбора станции метро
    public By stationField = By.xpath(".//div[4]/div");

    //Локатор поля ввода телефона
    public By phoneField = By.xpath(".//div[5]/input");

    //Локатор кнопки "Далее"
    public By nextButton = By.xpath(".//div[2]/div[3]/button");

    //Локатор поля ввода даты
    public By dateField = By.className("react-datepicker-wrapper");

    //Локатор поля ввода срока аренды
    public By timeField = By.className("Dropdown-root");

    //Локатор кнопки "Заказать" в окне заказа
    public By orderButton = By.xpath(".//div[3]/button[2]");

    //Локатор кнопки подтверждения заказа
    public By confirmButton = By.xpath(".//button[text()='Да']");

    //Локатор окна при успешном заказе
    public By succesWindow = By.xpath(".//div[5]/div[1]");

    //Общий метод нажатия на элемент
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    //Общий метод ввода текста
    public void enterText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }


    //Выбор станции метро
    public void chooseStation(){
        Random station = new Random();
        int stationIndex = station.nextInt(225)+1;
        By stationList = By.xpath(".//div[2]/ul/li["+(stationIndex)+"]");
        WebElement thisStation = driver.findElement(stationList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", thisStation);
        driver.findElement(stationList).click();
    }

    //Метод выбора дня календаре
    public void chooseDate() {
        Random date = new Random();
        int weekIndex = date.nextInt(6)+1;
        int dayIndex = date.nextInt(7)+1;
        By dayList = By.xpath(".//div["+(weekIndex)+"][@class='react-datepicker__week']/div["+(dayIndex)+"]");
        driver.findElement(dayList).click();
    }

    //Метод для выбора срока аренды
    public void chooseTime() {
        Random anyRent = new Random();
        int timeIndex = anyRent.nextInt(7)+1;
        By anyTimeField = By.xpath(".//div[2]/div["+(timeIndex)+"][@class='Dropdown-option']");
        driver.findElement(anyTimeField).click();
    }




}

