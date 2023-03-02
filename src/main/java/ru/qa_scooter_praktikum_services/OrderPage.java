package ru.qa_scooter_praktikum_services; // класс для страницы для кого заказ

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private By orderName = By.xpath("//input[@placeholder='* Имя']") ; // найти поле имя
    private By orderLastName = By.xpath("//input[@placeholder='* Фамилия']") ; // найти поле фамилия
    private By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // найти поле адрес
    private By metroStation =  By.xpath("//input[@placeholder='* Станция метро']"); // найти поле станция метро
    private By telephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // найти поле телефон
    private By tsvetnoyBoulevard = By.xpath("//*[text()='Цветной бульвар']"); // найти поле Цветной бульвар
    private By lubyanka = By.xpath("//*[text()='Лубянка']"); // найти поле Лубянка
    private By nextButton = By.xpath("//*[text()='Далее']"); // найти кнопку далее
    private By whenToBring = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // найти поле Когда привезти самокат
    private By seventhOfFebruaryDate = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]"); // найти кнопку 7 февраля в дата пикер
    private By date22ndApril = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[6]"); // найти кнопку 29 февраля в дата пикер
    private By rentalPeriod = By.xpath("//*[text()='* Срок аренды']"); // найти поле Срок аренды
    private By rentalPeriodPerDay = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]"); // найти кнопку срок аренды сутки
    private By rentalPeriodTwoDays = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]"); // найти кнопку срок аренды двое суток
    private By blackPearl = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]/input"); // найти чекбокс черный жемчуг
    private By grayHopelessness = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]/input"); // найти чекбокс серая безысходность
    private By commentCourier = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input"); // найти поле комментарий для курьера
    private By orderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]"); // найти кнопку заказать
    private By buttonYes = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); // найти кнопку да
    private By orderСreated = By.xpath("//*[text()='Заказ оформлен']"); // заказ создан



    public OrderPage(WebDriver webDriver) { // конструктор...
        this.webDriver = webDriver;
    }
    private final WebDriver webDriver; // добавили веб драйвер

    public void open(){ //  метод открытия главной страницы
        webDriver.get("https://qa-scooter.praktikum-services.ru/order"); // открыть страницу сайта
    }

    public void clickEnterName(){ // метод клика на поле имя
        webDriver.findElement(orderName).click(); // нашли поле имя и кликнули на него
    }
    public void enterName(String name){ // метод ввода имени
        webDriver.findElement(orderName).sendKeys(name); // нашли поле и передали значение number - Имя
    }
    public void clickEnterLastName(){ // метод клика на поле фамилия
        webDriver.findElement(orderLastName).click(); // нашли поле фамилия и кликнули на него
    }
    public void enterLastName(String lastName){ // метод ввода фамилии
        webDriver.findElement(orderLastName).sendKeys(lastName); // нашли поле и передали значение lastName - Фамилия
    }
    public void clickEnterAddress(){ // метод клика на поле адрес
        webDriver.findElement(address).click(); // нашли поле адрес и кликнули на него
    }
    public void enterAddress(String nameAddress){ // Метод ввода адреса
        webDriver.findElement(address).sendKeys(nameAddress); // нашли поле и передали значение nameAddress - адрес
    }
    public void clickEnterMetroStation(){ // метод клика на поле станция метро
        webDriver.findElement(metroStation).click(); // нашли поле станция метро и кликнули на него
    }
    public void enterMetroStation(String nameMetroStation){ // метод ввода станции метро
        webDriver.findElement(metroStation).sendKeys(nameMetroStation); // нашли поле и передали значение nameMetroStation - станция метро
    }
    public void clickEnterTsvetnoyBoulevard(){ // метод клика на станцию метро "Цветной бульвар"
        webDriver.findElement(tsvetnoyBoulevard).click(); // нашли станцию метро "Цветной бульвар" и кликнули на нее
    }
    public void clickEnterLubyanka(){ // метод клика на станцию метро "Лубянка"
        webDriver.findElement(lubyanka).click(); // нашли станцию метро "Лубянка" и кликнули на нее
    }
    public void clickEnterTelephone(){ // метод клика на поле телефон
        webDriver.findElement(telephone).click(); // нашли поле телефон и кликнули на него
    }
    public void enterTelephone(String phoneNumber){ // метод ввода номера телефона
        webDriver.findElement(telephone).sendKeys(phoneNumber); // нашли поле и передали значение phoneNumber - номер телефона
    }
    public void clickEnterNextButton(){ // метод клика на кнопку Далее
        webDriver.findElement(nextButton).click(); // нашли кнопку и кликнули на нее
    }
    public void clickEnterWhenToBring(){ // метод клика на поле куда привезти самокат
        webDriver.findElement(whenToBring).click(); // нашли поле куда привезти самокат и кликнули на него
    }
    public void enterWhenToBring(String date){ // метод ввода даты
        webDriver.findElement(whenToBring).sendKeys(date); // нашли поле и передали значение date - Когда привезти самокат
    }
    public void clickEnterSeventhOfFebruaryDate(){ // метод клика на дату 7 февраля
        webDriver.findElement(seventhOfFebruaryDate).click();
    }
    public void clickEnterDate22ndApril(){ // метод клика на дату 29 апреля
        webDriver.findElement(date22ndApril).click(); //
    }
    public void clickEnterRentalPeriod(){ // метод клика на поле Срок аренды
        webDriver.findElement(rentalPeriod).click(); // нашли поле Срок аренды и кликнули по нему
    }
    public void clickEnterRentalPeriodPerDay(){ // метод клика на срок аренды - сутки
        webDriver.findElement(rentalPeriodPerDay).click(); // нашли срок аренды сутки и кликнули на него
    }
    public void  clickEnterRentalPeriodTwoDays(){ // метод клика на срок аренды - двое суток
        webDriver.findElement(rentalPeriodTwoDays).click(); // нашли срок аренды двое суток и кликнули на него
    }
    public void clickEnterBlackPearl(){ // метод клика на черный жемчуг
        webDriver.findElement(blackPearl).click(); // нашли кнопку черный жемчуг и нажали на нее
    }
    public void clickEnterGrayHopelessness(){ // метод клика на серая безысходность
        webDriver.findElement(grayHopelessness).click(); // нашли кнопку серая безысходность и нажали на нее
    }
    public void clickEnterCommentCourier(){ // метод клика на поле комментарий для курьера
        webDriver.findElement(commentCourier).click(); // нашли поле комментарий для курьера и кликнули на него
    }
    public void enterCommentCourier(String сomment){ // метод ввода комментария для курьера
        webDriver.findElement(commentCourier).sendKeys(сomment); // нашли поле и передали значение сomment - комментарий для курьера
    }
    public void clickEnterOrderButton(){ // метод нажатия на кнопку заказать
        webDriver.findElement(orderButton).click(); // нашли кнопку и нажали на нее
    }
    public void clickEnterButtonYes(){ // метод нажатия на кнопку да
        webDriver.findElement(buttonYes).click(); // нашли кнопку и нажали на нее
    }
    public boolean isOrderСreated(){ // метод что заказ создан
        return webDriver.findElement(orderСreated).isDisplayed();
    }

}
