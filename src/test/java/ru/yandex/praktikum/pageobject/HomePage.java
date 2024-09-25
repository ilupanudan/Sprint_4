package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class HomePage {


    private final WebDriver driver;


    //Локатор для кнопки вопроса
    public By faqButton(int index){
        return By.id("accordion__heading-"+ index);

    }
    //Локатор для поля ответа
    private By faqField(int index){
        return By.id("accordion__panel-" + index);
    }


    //Метод ожидания загрузки кнопки вопроса
    public void checkButton(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement currentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(faqButton(index)));

    }

    //Метод перехода к элементу
    public void moveToButton(int index) {
        WebElement currentButton = driver.findElement(faqButton(index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentButton);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //Локатор для кук
    private final By acceptCookieButton = By.id("rcc-confirm-button");

    //Метод для кук
    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
        cookieButton.click();
    }

    //Метод для проверки и клика по кнопке со стрелкой
    public void clickFaqButton(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement faqButton = wait.until(ExpectedConditions.elementToBeClickable(faqButton(index)));
        driver.findElement(faqButton(index)).click();
    }

    //Метод получения текста из поля
    public String getTextFromButton(int index) {
        return driver.findElement(faqButton(index)).getText();
    }

    //Метод получения текста из поля
    public String getTextFromField(int index) {
        return driver.findElement(faqField(index)).getText();
    }

    //Общий метод проверки и нажатия на элемент (-добавил проверку на кликабельность.)
    public void clickOnElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    //Локатор верхней кнопки "Заказать"
    public static By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Локатор нижней кнопки "Заказать"
    public static By bottomOrderButton = By.xpath(".//div[5]/button");

    //Геттер для верхней кнопки
    public static By getHeaderOrderButton(){
        return headerOrderButton; }

    //Геттер для нижней кнопки
    public static By getBottomOrderButton(){
        return bottomOrderButton;}

    //Общий метод перехода к элементу
    public void moveToElementOnHomePage(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}




