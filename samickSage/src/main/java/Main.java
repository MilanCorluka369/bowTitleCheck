import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "G:\\Dev & QA\\IT Bootcamp\\Materijal\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.strela.co.rs/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement prodavnicaBtn = driver.findElement
                (By.xpath("//*[@id='ctl00_RadMenu1']/ul/li[2]/a/span"));
        prodavnicaBtn.click();
        WebElement lukoviBowsNav = driver.findElement
                (By.xpath("//*[@id='ctl00_MainContent_GrupeRadTreeView']/ul/li[1]/div/span[3]"));
        lukoviBowsNav.click();

        WebElement bowElement = driver.findElement
                (By.xpath("//*[@id='ctl00_MainContent_ListView1_ctrl35_Panel1']/figure/a/img"));
        bowElement.click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated
                (By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"), "Samick"));
        System.out.println("Ime luka sadrzi rec 'Samick'.");

        driver.close();
    }
}
