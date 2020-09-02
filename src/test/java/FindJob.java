import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FindJob {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private ExpectedConditions ЕxpectedConditions;

    @Test
    public void Search() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.get("https://www.work.ua/ru/");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("QA Engineer");

        driver.findElement(By.xpath("//button[@id='sm-but']")).click();

        driver.findElement(By.xpath("//input[@class='js-main-region form-control']")).clear();

        driver.findElement(By.xpath("//input[@class='js-main-region form-control']")).sendKeys("Одесса");

        driver.findElement(By.xpath("//span[text()='Найти ']")).click();

        new WebDriverWait(driver, 15).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Senior Test Engineer (IntelliJ IDEA),')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Senior Test Engineer (IntelliJ IDEA),')]")).click();

        driver.findElement(By.xpath("(//a[contains(@class,'btn btn-default')])[3]")).click();

        wait.until(ЕxpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-control input-size-md']"))).sendKeys("Заика Екатерина");

        driver.findElement(By.xpath("(//input[@class='form-control input-size-md'])[2]")).sendKeys("zaikakaterina@yahoo.com");

        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\User\\Documents\\Hillel\\Заика Екатерина Владимировна.doc");

        wait.until(ЕxpectedConditions.elementToBeClickable(By.xpath("//div[@class='checkbox']//label"))).click();

        driver.findElement(By.xpath("//textarea[@id='addtext']")).sendKeys("Добрый день. Меня зовут Заика Екатерина. На данный момент прохожу курс обучения QA manual. " +
                "На сайте work.ua увидела Ваше объявление и решила обратиться с вопросом о возможном трудоустройстве в Вашей компании. Контакты указаны в резюме. Надеюсь на сотрудничество.");

        new WebDriverWait(driver, 15).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("submitbtn")));
        driver.findElement(By.id("submitbtn")).click();

    }
}
