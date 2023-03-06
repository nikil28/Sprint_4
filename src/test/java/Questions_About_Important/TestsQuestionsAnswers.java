package Questions_About_Important;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa_scooter_praktikum_services.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;


@RunWith(Parameterized.class)
public class TestsQuestionsAnswers { // тут тесты на вопросы-ответы
    private final String expectedString;
    private final String panelID;
    private final By selector;

    MainPage mainPage;
    static WebDriver driver;

    public TestsQuestionsAnswers(By selector, String expectedString, String panelID) {
        this.expectedString = expectedString;
        this.panelID = panelID;
        this.selector = selector;
    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // добавили централизованно ожидание в 5 секунд
        mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open();
        WebElement element = driver.findElement(By.id("accordion__heading-5")); // Прокрути страницу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Parameters
    public static Collection<Object[]> data() {
         MainPage mainPage = new MainPage(driver);
        return Arrays.asList(new Object[][]{
                {mainPage.paymentСostButton,"Сутки — 400 рублей. Оплата курьеру — наличными или картой.","accordion__panel-0"},
                {mainPage.severalScooters, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.","accordion__panel-1"},
                {mainPage.calculateRentalTime, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.","accordion__panel-2"},
                {mainPage.orderScooterToday, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.","accordion__panel-3"},
                {mainPage.extendReturnOrder, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.","accordion__panel-4"},
                {mainPage.chargingWithScooter, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.","accordion__panel-5"},
                {mainPage.canCancelOrder, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.","accordion__panel-6"},
                {mainPage.outsideMoscowRingRoad, "Да, обязательно. Всем самокатов! И Москве, и Московской области.","accordion__panel-7"},
        });
    }

    @Test
    public void check(){
        mainPage.clickAnObject(selector);
        assertEquals(expectedString, driver.findElement(By.id(panelID)).getText());
    }
    @After // после теста
    public void tearDown(){ //метод для закрытия браузера по завершению теста
        driver.quit(); //  закрыть браузер
    }

}