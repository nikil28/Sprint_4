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

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

 //@RunWith(Parameterized.class)
 public class tests_questions_answers { // тут тесты на вопросы-ответы
 //private final String answer; // ответ
 //private final String expected; // ожидаем
 //public tests_questions_answers(String answer,String expected){ // конструктор класса tests_questions_answers
 //    this.answer = answer;
 //    this.expected = expected;
 //}
 //    @Parameterized.Parameters // добавили аннотацию
 //    public static Object[][] getText() {
 //          return new Object[][] {
 //            {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
 //            { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
 //    };
 //}

   //@Test
  //public void newTest(){
  //    MainPage mainPage = new MainPage(driver);
  //    mainPage.open();
  //    WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
  //    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
  //    //mainPage.clickPaymentСostButton(); // кликнуть на Сколько это стоит? И как оплатить?
  //    mainPage.clickAnObject(mainPage.paymentСostButton);
  //    mainPage.clickSeveralScootersButton(); // кликнуть на Хочу сразу несколько самокатов! Так можно?
  //    assertEquals(expected,driver.findElement(By.id("accordion__panel-0")).getText());
  //}


    WebDriver driver; // локальная переменная driver
     MainPage mainPage;

     public void parametrizedCheck(By selector, String expectedString, String panelID) { // Проверить текст по нажатию указанной в параметре кнопке
         WebElement element = driver.findElement(By.id("accordion__heading-5")); // Прокрути страницу
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
         mainPage.clickAnObject(selector);
         assertEquals(expectedString, driver.findElement(By.id(panelID)).getText()); // проверить что текст правильный
         System.out.print("тест прошел");
     }

    @Before // до теста, работа с вэб драйвером + задержка 5 сек
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // добавили централизованно ожидание в 5 секунд
        mainPage = new MainPage(driver);
        mainPage.open();
    }

//    @Test // сам тест тут
//    public void checkTestCostOrderPayment() { // Проверить текст по нажатию кнопки Сколько это стоит? И как оплатить?
//        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
//        mainPage.open(); // открыть главную страницу
//        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
////        mainPage.clickPaymentСostButton(); // кликнуть на Сколько это стоит? И как оплатить?
//        mainPage.clickAnObject(mainPage.paymentСostButton);
//        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", driver.findElement(By.id("accordion__panel-0")).getText()); // проверить что текст правильный
//        System.out.print("тест прошел");
//    }

    @Test
    public void check1(){
        parametrizedCheck(mainPage.paymentСostButton, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.","accordion__panel-0");
    }
     @Test
     public void check2(){
         parametrizedCheck(mainPage.severalScooters, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.","accordion__panel-1");
     }




//    public void checkTextSeveralScooters() { // Проверить текст по нажатию кнопки Хочу сразу несколько самокатов! Так можно?
//        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
//        mainPage.open(); // открыть главную страницу
//        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
////      mainPage.clickSeveralScootersButton(); // кликнуть на Хочу сразу несколько самокатов! Так можно?
//        mainPage.clickAnObject(mainPage.severalScooters);
//        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", driver.findElement(By.id("accordion__panel-1")).getText()); // проверить что текст правильный
//        System.out.print("тест прошел");
//    }

    @Test
    public void checkTextCalculateRentalTime(){ // Проверить текст по нажатию кнопки Как рассчитывается время аренды?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//      mainPage.clickCalculateRentalTimeButton(); // кликнуть на Как рассчитывается время аренды?
        mainPage.clickAnObject(mainPage.calculateRentalTime);
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", driver.findElement(By.id("accordion__panel-2")).getText()); // проверить что текст правильный
        System.out.print("тест прошел");
    }

    @Test
    public void checkTextOrderScooterToday(){ //Проверить текст по нажатию кнопки Можно ли заказать самокат прямо на сегодня?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//      mainPage.clickOrderScooterTodayButton(); // кликнуть на Можно ли заказать самокат прямо на сегодня?
        mainPage.clickAnObject(mainPage.orderScooterToday);
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", driver.findElement(By.id("accordion__panel-3")).getText()); // проверить что текст правильный
        System.out.print("тест прошел");
    }

    @Test
    public void checkTextExtendReturnOrder(){ // Проверить текст по нажатию кнопки Можно ли продлить заказ или вернуть самокат раньше?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-0")); // Прокрути страницу до Сколько это стоит? И как оплатить?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//      mainPage.clickExtendReturnOrderButton(); // кликнуть на Можно ли продлить заказ или вернуть самокат раньше?
        mainPage.clickAnObject(mainPage.extendReturnOrder);
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", driver.findElement(By.id("accordion__panel-4")).getText()); // проверить что текст правильный
        System.out.print("тест прошел");
    }

    @Test
    public void checkTextChargingWithScooter(){ // Проверить текст по нажатию кнопки Вы привозите зарядку вместе с самокатом?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-5")); // Прокрути страницу до Вы привозите зарядку вместе с самокатом?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//      mainPage.clickChargingWithScooterButton(); // кликнуть на Вы привозите зарядку вместе с самокатом?
        mainPage.clickAnObject(mainPage.chargingWithScooter);
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", driver.findElement(By.id("accordion__panel-5")).getText()); // проверить что текст правильный
        System.out.print("тест прошел");
    }

    @Test
    public void checkTextCanCancelOrder() { // проверить текст нажатию кнопки Можно ли отменить заказ?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-6")); // Прокрути страницу до Можно ли отменить заказ?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//      mainPage.clickCanCancelOrderButton(); // кликнуть на Можно ли отменить заказ?
        mainPage.clickAnObject(mainPage.canCancelOrder);
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", driver.findElement(By.id("accordion__panel-6")).getText());  // проверить что текст правильный
        System.out.print("тест прошел");
    }

    @Test
    public void checkTextOutsideMoscowRingRoad(){ // проверить текст нажатию кнопки Я жизу за МКАДом, привезёте?
        MainPage mainPage = new MainPage(driver); // инициализация класса MainPage
        mainPage.open(); // открыть главную страницу
        WebElement element = driver.findElement(By.id("accordion__heading-6")); // Прокрути страницу до Можно ли отменить заказ?
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//      mainPage.clickOutsideMoscowRingRoadButton(); // кликнуть на Я жизу за МКАДом, привезёте?
        mainPage.clickAnObject(mainPage.outsideMoscowRingRoad);
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", driver.findElement(By.id("accordion__panel-7")).getText());  // проверить что текст правильный
        System.out.print("тест прошел");
    }

   @After // после теста
     public void tearDown(){ //метод для закрытия браузера по завершению теста
      driver.quit(); //  закрыть браузер
   }
}
