package Questions_About_Important;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa_scooter_praktikum_services.MainPage;
import ru.qa_scooter_praktikum_services.OrderPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestScooterOrder { // тут тесты на заказ самоката
    WebDriver driver; // локальная переменная driver
    MainPage mainPage;
    String[] set1 = {"Алексей", "Никитин","Российских Газовиков улица","Цветной бульвар","12345678901","07.02.2023","тут написан комментарий для курьера"};
    String[] set2 = {"Иван", "Иванов","улица Ленина","Лубянка","77777777777","29.04.2023","тут написан другой комментарий"};

    @Before // до теста, работа с вэб драйвером + задержка 5 сек
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // добавили централизованно ожидание в 5 секунд
        mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open();
    }

    public void checkScooterOrderWith(By button, String[] set){
        if (button ==  mainPage.orderButtonSecond) {
            WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button")); // Прокрути страницу до второй кнопки заказать
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }
        mainPage.clickAnObject(button);

        OrderPage orderPage = new OrderPage(driver); // инициализировали класс OrderPage
        orderPage.open(); // открыли страницу order -  заказа самоката
        orderPage.clickEnterName(); // нашли поле имя и кликнули на него
        orderPage.enterName(set[0]); // в поле имя передали "Алексей"
        orderPage.clickEnterLastName(); // нашли поле фамилия и кликнули по нему
        orderPage.enterLastName(set[1]); // в поле фамилия передали "Никитин"
        orderPage.clickEnterAddress(); // нашли поле адрес и кликнули по нему
        orderPage.enterAddress(set[2]); // в поле адрес передали "Российских Газовиков улица"
        orderPage.clickEnterMetroStation(); // нашли поле станция метро и кликнули по нему
        orderPage.enterMetroStation(set[3]); // в поле станция метро передали "Цветной бульвар" - ТЕСТ РАБОТАЕТ И БЕЗ ЭТОГО МЕТОДА!
        if (button ==  mainPage.orderButton) {
            orderPage.clickEnterTsvetnoyBoulevard();
        }else {
            orderPage.clickEnterLubyanka();
        }
        orderPage.clickEnterTelephone(); // нашли поле телефон и кликнули по нему
        orderPage.enterTelephone(set[4]); // в поле телефон передали "12345678901"
        orderPage.clickEnterNextButton(); // клик на кнопку далее
        orderPage.clickEnterWhenToBring(); // нашли поле Когда привезти самокат и кликнули по нему
        orderPage.enterWhenToBring(set[5]); // в поле Когда привезти самокат передали "07.02.2023"
        orderPage.clickEnterSeventhOfFebruaryDate(); // клик на 7 февраля в дата пикере
        orderPage.clickEnterRentalPeriod(); // клик на поле срок аренды
        orderPage.clickEnterRentalPeriodPerDay(); // клик на поле сутки в Срок аренды
        orderPage.clickEnterBlackPearl(); // клик на чекбокс черный жемчуг
        orderPage.clickEnterCommentCourier(); // клик на поле комментарий для курьера
        orderPage.enterCommentCourier(set[6]); // в поле комментарий для курьера ввели текст "тут написан комментарий для курьера"
        orderPage.clickEnterOrderButton(); // нажали на кнопку заказать
        orderPage.clickEnterButtonYes(); // нажали на кнопку да

        boolean isDisplayed = orderPage.isOrderСreated(); // проверка что заказ отображается
        assertTrue(isDisplayed);
    }


    @Test
    public void test1(){
        checkScooterOrderWith(mainPage.orderButton,set1);
    }

    @Test
    public void test2(){
        checkScooterOrderWith(mainPage.orderButtonSecond,set2);
    }

    @After // после теста
    public void tearDown(){ //метод для закрытия браузера по завершению теста
        driver.quit(); //  закрыть браузер
    }
}