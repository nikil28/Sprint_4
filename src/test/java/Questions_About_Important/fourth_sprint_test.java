package Questions_About_Important;

import io.github.bonigarcia.wdm.WebDriverManager;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class fourth_sprint_test { // тесты четвертого спринта
    WebDriver driver; // локальная переменная driver

    @Before // до теста, работа с вэб драйвером + задержка 5 сек
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // добавили централизованно ожидание в 5 секунд
    }

    @Test // сам тест тут
    public void checkTestCostOrderPayment() { // Проверить текст по нажатию кнопки Сколько это стоит? И как оплатить?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickPaymentСostButton(); // кликнуть на Сколько это стоит? И как оплатить?
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", driver.findElement(By.id("accordion__panel-0")).getText()); // проверить что текст правильный
    }

    @Test
    public void checkTextSeveralScooters() { // Проверить текст по нажатию кнопки Хочу сразу несколько самокатов! Так можно?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickSeveralScootersButton(); // кликнуть на Хочу сразу несколько самокатов! Так можно?
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", driver.findElement(By.id("accordion__panel-1")).getText()); // проверить что текст правильный
    }

    @Test
    public void checkTextCalculateRentalTime(){ // Проверить текст по нажатию кнопки Как рассчитывается время аренды?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickCalculateRentalTimeButton(); // кликнуть на Как рассчитывается время аренды?
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", driver.findElement(By.id("accordion__panel-2")).getText()); // проверить что текст правильный
    }

    @Test
    public void checkTextOrderScooterToday(){ //Проверить текст по нажатию кнопки Можно ли заказать самокат прямо на сегодня?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickOrderScooterTodayButton(); // кликнуть на Можно ли заказать самокат прямо на сегодня?
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", driver.findElement(By.id("accordion__panel-3")).getText()); // проверить что текст правильный
    }

    @Test
    public void checkTextExtendReturnOrder(){ // Проверить текст по нажатию кнопки Можно ли продлить заказ или вернуть самокат раньше?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickExtendReturnOrderButton(); // кликнуть на Можно ли продлить заказ или вернуть самокат раньше?
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", driver.findElement(By.id("accordion__panel-4")).getText()); // проверить что текст правильный
    }

    @Test
    public void checkTextChargingWithScooter(){ // Проверить текст по нажатию кнопки Вы привозите зарядку вместе с самокатом?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-5")); // Прокрути страницу до Вы привозите зарядку вместе с самокатом?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickChargingWithScooterButton(); // кликнуть на Вы привозите зарядку вместе с самокатом?
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", driver.findElement(By.id("accordion__panel-5")).getText()); // проверить что текст правильный
    }

    @Test
    public void checkTextCanCancelOrder() { // проверить текст нажатию кнопки Можно ли отменить заказ?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-6")); // Прокрути страницу до Можно ли отменить заказ?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickCanCancelOrderButton(); // кликнуть на Можно ли отменить заказ?
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", driver.findElement(By.id("accordion__panel-6")).getText());  // проверить что текст правильный
    }

    @Test
    public void checkTextOutsideMoscowRingRoad(){ // проверить текст нажатию кнопки Я жизу за МКАДом, привезёте?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-6")); // Прокрути страницу до Можно ли отменить заказ?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickOutsideMoscowRingRoadButton(); // кликнуть на Я жизу за МКАДом, привезёте?
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", driver.findElement(By.id("accordion__panel-7")).getText());  // проверить что текст правильный
    }

    @Test
    public void checkScooterOrderFirstSet() { // проверить заказ самоката - первый набор
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        mainPage.clickOrderButton(); // нажали кнопку заказать

        OrderPage orderPage = new OrderPage(driver); // инициализировали класс OrderPage
        orderPage.open(); // открыли страницу order -  заказа самоката
        orderPage.clickEnterName(); // нашли поле имя и кликнули на него
        orderPage.enterName("Алексей"); // в поле имя передали "Алексей"
        orderPage.clickEnterLastName(); // нашли поле фамилия и кликнули по нему
        orderPage.enterLastName("Никитин"); // в поле фамилия передали "Никитин"
        orderPage.clickEnterAddress(); // нашли поле адрес и кликнули по нему
        orderPage.enterAddress("Российских Газовиков улица"); // в поле адрес передали "Российских Газовиков улица"
        orderPage.clickEnterMetroStation(); // нашли поле станция метро и кликнули по нему
        orderPage.enterMetroStation("Цветной бульвар"); // в поле станция метро передали "Цветной бульвар" - ТЕСТ РАБОТАЕТ И БЕЗ ЭТОГО МЕТОДА!
        orderPage.clickEnterTsvetnoyBoulevard(); // кликнуть на "Цветной бульвар"
        orderPage.clickEnterTelephone(); // нашли поле телефон и кликнули по нему
        orderPage.enterTelephone("12345678901"); // в поле телефон передали "12345678901"
        orderPage.clickEnterNextButton(); // клик на кнопку далее
        orderPage.clickEnterWhenToBring(); // нашли поле Когда привезти самокат и кликнули по нему
        orderPage.enterWhenToBring("07.02.2023"); // в поле Когда привезти самокат передали "07.02.2023"
        orderPage.clickEnterSeventhOfFebruaryDate(); // клик на 7 февраля в дата пикере
        orderPage.clickEnterRentalPeriod(); // клик на поле срок аренды
        orderPage.clickEnterRentalPeriodPerDay(); // клик на поле сутки в Срок аренды
        orderPage.clickEnterBlackPearl(); // клик на чекбокс черный жемчуг
        orderPage.clickEnterCommentCourier(); // клик на поле комментарий для курьера
        orderPage.enterCommentCourier("тут написан комментарий для курьера"); // в поле комментарий для курьера ввели текст "тут написан комментарий для курьера"
        orderPage.clickEnterOrderButton(); // нажали на кнопку заказать
        orderPage.clickEnterButtonYes(); // нажали на кнопку да

        boolean isDisplayed = orderPage.isOrderСreated(); // проверка что заказ отображается
        assertTrue(isDisplayed);


    }

    @Test
    public void checkScooterOrderAnotherSet() { // проверить заказ самоката - другой набор
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button")); // Прокрути страницу до второй кнопки заказать
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickOrderButtonSecond(); // нажали кнопку заказать
        OrderPage orderPage = new OrderPage(driver); // инициализировали класс OrderPage
        orderPage.open(); // открыли страницу order -  заказа самоката
        orderPage.clickEnterName(); // нашли поле имя и кликнули на него
        orderPage.enterName("Иван"); // в поле имя передали "Алексей"
        orderPage.clickEnterLastName(); // нашли поле фамилия и кликнули по нему
        orderPage.enterLastName("Иванов"); // в поле фамилия передали "Никитин"
        orderPage.clickEnterAddress(); // нашли поле адрес и кликнули по нему
        orderPage.enterAddress("улица Ленина"); // в поле адрес передали "Российских Газовиков улица"
        orderPage.clickEnterMetroStation(); // нашли поле станция метро и кликнули по нему
        orderPage.enterMetroStation("Лубянка"); // в поле станция метро передали "Лубянка" - ТЕСТ РАБОТАЕТ И БЕЗ ЭТОГО МЕТОДА!
        orderPage.clickEnterLubyanka(); // кликнуть на "Лубянка"
        orderPage.clickEnterTelephone(); // нашли поле телефон и кликнули по нему
        orderPage.enterTelephone("77777777777"); // в поле телефон передали "77777777777"
        orderPage.clickEnterNextButton(); // клик на кнопку далее
        orderPage.clickEnterWhenToBring(); // нашли поле Когда привезти самокат и кликнули по нему
        orderPage.enterWhenToBring("29.04.2023"); // в поле Когда привезти самокат передали "29.04.2023"
        orderPage.clickEnterDate22ndApril(); // клик на 29 апреля в дата пикере
        orderPage.clickEnterRentalPeriod(); // клик на поле срок аренды
        orderPage.clickEnterRentalPeriodTwoDays(); // клика на срок аренды - двое суток
        orderPage.clickEnterGrayHopelessness(); // клик на чекбокс серая безысходность
        orderPage.clickEnterCommentCourier(); // клик на поле комментарий для курьера
        orderPage.enterCommentCourier("тут написан комментарий другой, не такой как в тесте выше"); // в поле комментарий для курьера ввели текст "тут написан комментарий другой, не такой как в тесте выше"
        orderPage.clickEnterOrderButton(); // нажали на кнопку заказать
        orderPage.clickEnterButtonYes(); // нажали на кнопку да

        boolean isDisplayed = orderPage.isOrderСreated(); // проверка что заказ отображается
        assertTrue(isDisplayed);


    }
 //  @After // после теста
 //  public void tearDown(){ //метод для закрытия браузера по завершению теста
 //      driver.quit(); //  закрыть браузер
 //   }
}
