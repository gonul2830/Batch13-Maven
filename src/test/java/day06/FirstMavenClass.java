package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();
        WebElement bulunanSonuc = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(bulunanSonuc.getText());
        // Thread.sleep(5000);
        WebElement ilkResim = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkResim.click();
        driver.navigate().back();


        List<WebElement> liste = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

       /* for (WebElement w : liste) {
            System.out.println(w.getText());
        }
        */

       // ya da böyle

        liste.stream().forEach(x-> System.out.println(x.getText()));

        driver.close();

    }

}
