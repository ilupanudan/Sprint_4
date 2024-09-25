package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.praktikum.pageobject.HomePage;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;



public class BaseTest {

    protected WebDriver driver;
    final static String HOMEURL = "https://qa-scooter.praktikum-services.ru/";


    @Before
    public void run() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-search-engine-choice-screen", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        //FirefoxOptions options = new FirefoxOptions();                      //Раскомментить для Firefox
        //options.addArguments("--no-sandbox","--disable-search-engine-choice-screen" , "--disable-dev-shm-usage");
        //driver = new FirefoxDriver(options);

        //Переходим по URL
        driver.get(HOMEURL);
        HomePage objHomePage = new HomePage(driver);
        //Ожидаем прогрузки страницы
        driver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));
        //Скликиваем окно кук
        objHomePage.acceptCookies();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

