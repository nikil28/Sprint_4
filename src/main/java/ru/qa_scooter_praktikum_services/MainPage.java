package ru.qa_scooter_praktikum_services; // класс для главной страницы

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MainPage {
    public MainPage(WebDriver webDriver) { // конструктор...
        this.webDriver = webDriver;
    }
    private final WebDriver webDriver; // добавили веб драйвер
    private By orderButton = By.className("Button_Button__ra12g"); // найти кнопку заказать
    private By orderButtonSecond = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button"); // найти вторую кнопку заказать внизу страницы
    private By paymentСostButton = By.id("accordion__heading-0"); // найти кнопку Сколько это стоит ? и как оплатить?
    private By pricePerDayAndChoiceOfPayment = By.id("accordion__panel-0"); // Найти строку Сутки -400 рублей. Оплата курьеру - наличные или картой
    private By severalScooters = By.id("accordion__heading-1"); // найти кнопку Хочу сразу несколько самокатов! Так можно?
    private By oneOrderOneScooter = By.id("accordion__panel-1"); // найти строку Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private By calculateRentalTime = By.id("accordion__heading-2"); // найти кнопку Как рассчитывается время аренды?
    private By rentalTimeCalculationExample = By.id("accordion__panel-2"); // найти строку Допустим, вы оформляете заказ на 8 мая...
    private By orderScooterToday = By.id("accordion__heading-3"); // найти кнопку Можно ли заказать самокат прямо на сегодня?
    private By onlyStartingTomorrow = By.id("accordion__panel-3"); // Найти строку Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private By extendReturnOrder = By.id("accordion__heading-4"); // найти кнопку Можно ли продлить заказ или вернуть самокат раньше?
    private By cantRenewOrder = By.id("accordion__panel-4"); // Найти строку Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private By chargingWithScooter = By.id("accordion__heading-5"); // найти кнопку Вы привозите зарядку вместе с самокатом?
    private By scooterFullyCharged = By.id("accordion__panel-5"); // найти поле Самокат приезжает к вам с полной зарядкой...
    private By canCancelOrder = By.id("accordion__heading-6"); // найти кнопку Можно ли отменить заказ?
    private By cancelUntilDelivered = By.id("accordion__panel-6"); // найти строку Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private By outsideMoscowRingRoad = By.id("accordion__heading-7"); // найти кнопку Я жизу за МКАДом, привезёте?
    private By scootersMoscowAndRegion = By.id("accordion__panel-7"); // найти строку Да, обязательно. Всем самокатов! И Москве, и Московской области.



    public void open(){ //  метод открытия главной страницы
        webDriver.get("https://qa-scooter.praktikum-services.ru/"); // открыть главную страницу сайта
    }

    public void clickOrderButton() { // метод нажатия на кнопку заказать
        webDriver.findElement(orderButton).click(); // нашли кнопку заказать и нажали на неё
    }
    public void clickOrderButtonSecond(){ // метод нажатия на вторую кнопку заказать внизу страницы
        webDriver.findElement(orderButtonSecond).click(); // нашли вторую кнопку заказать и нажали на неё
    }

    public void clickPaymentСostButton(){ // метод нажмите кнопку Сколько это стоит ? и как оплатить?
        webDriver.findElement(paymentСostButton).click(); // нашли кнопку и кликнули
    }
       public void clickSeveralScootersButton(){ // метод нажмите  кнопку Хочу сразу несколько самокатов! Так можно?
           webDriver.findElement(severalScooters).click(); // нашли кнопку и кликнули
    }
    public void clickCalculateRentalTimeButton(){ // метод нажмите кнопку Как рассчитывается время аренды?
        webDriver.findElement(calculateRentalTime).click(); // нашли кнопку и кликнули
    }
    public void clickOrderScooterTodayButton(){ // метод нажмите кнопку Можно ли заказать самокат прямо на сегодня?
        webDriver.findElement(orderScooterToday).click(); // нашли кнопку и кликнули
    }
    public void clickExtendReturnOrderButton(){ // метод нажмите кнопку Можно ли продлить заказ или вернуть самокат раньше?
        webDriver.findElement(extendReturnOrder).click(); // нашли кнопку и кликнули
    }
    public void clickChargingWithScooterButton(){ // метод нажмите кнопку Вы привозите зарядку вместе с самокатом?
        webDriver.findElement(chargingWithScooter).click(); // нашли кнопку и кликнули
    }
    public void clickCanCancelOrderButton(){ // метод нажатия на кнопку Можно ли отменить заказ?
        webDriver.findElement(canCancelOrder).click();
    }

    public void clickOutsideMoscowRingRoadButton() { // метод нажмите кнопку Я жизу за МКАДом, привезёте?
          webDriver.findElement(outsideMoscowRingRoad).click(); // нашли кнопку и кликнули
    }

}

