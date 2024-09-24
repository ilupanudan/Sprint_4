package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.praktikum.pageobject.HomePage;
import ru.yandex.praktikum.pageobject.OrderPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestOrder extends TestSettings {

    private final String name;
    private final String surname;
    private final String phone;
    private final boolean isVisible;
    static By headerOrderButton = HomePage.getHeaderOrderButton();
    static By bottomOrderButton = HomePage.getBottomOrderButton();
    static By orderButton;



    public TestOrder(String name, String surname, String phone, By orderButton, boolean isVisible) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.orderButton = orderButton;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCredentials() {
        return Arrays.asList(new Object[][]{
                {"Илья", "Михалев", "89885762655", headerOrderButton, true},
                {"Екатерина", "Андренко", "89885556677", bottomOrderButton, true},
        });


    }

    @Test

    public void TestOrder() {

        HomePage objHomePage = new HomePage(driver);
        OrderPage objOrderPage = new OrderPage(driver);


        //Переходим к кнопке заказа (к той, что выдалась в Parameters)
        objHomePage.moveToElementOnHomePage(orderButton);

        //Нажимаем на кнопку заказа (на ту, что выдалась в Parameters)
        objHomePage.clickOnElement(orderButton);

        //Проверяем, что открылось окно заказа
        objOrderPage.checkOrderPage();

        //Нажимаем на поле ввода имени
        objOrderPage.clickOnElement(objOrderPage.nameField);

        //В поле ввода имени вносим данные из Parameters
        objOrderPage.enterText(objOrderPage.nameField, name);

        //Нажимаем на поле ввода фамилии
        objOrderPage.clickOnElement(objOrderPage.surnameField);

        //В поле ввода имени вносим данные из Parameters
        objOrderPage.enterText(objOrderPage.surnameField, surname);

        //Нажимаем на поле ввода станции метро
        objOrderPage.clickOnElement(objOrderPage.stationField);

        //Выбираем рандомную станцию метро
        objOrderPage.chooseStation();

        //Нажимаем на поле ввода телефона
        objOrderPage.clickOnElement(objOrderPage.phoneField);

        //Нажимаем на поле ввода телефона
        objOrderPage.enterText(objOrderPage.phoneField, phone);

        //Нажимаем на кнопку "Далее"
        objOrderPage.clickOnElement(objOrderPage.nextButton);

        //Нажимаем на поле ввода даты
        objOrderPage.clickOnElement(objOrderPage.dateField);

        //Выбираем рандомную дату в календаре
        objOrderPage.chooseDate();

        //Нажимаем на поле ввода времени аренды
        objOrderPage.clickOnElement(objOrderPage.timeField);

        //Выбираем рандомное время аренды
        objOrderPage.chooseTime();

        //Нажимаем на кнопку "Заказать"
        objOrderPage.clickOnElement(objOrderPage.orderButton);

        //Нажимаем на кнопку "Заказать"
        objOrderPage.clickOnElement(objOrderPage.confirmButton);



        assertEquals(isVisible, driver.findElement(objOrderPage.succesWindow).getText().contains("Заказ оформлен"));

    }
}