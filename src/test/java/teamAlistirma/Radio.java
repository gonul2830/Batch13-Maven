package teamAlistirma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://kozmetik.avon.com.tr/");
        WebElement musteriGirisi= driver.findElement(By.xpath("//*[.='Müşteri Girişi']"));

        if(musteriGirisi.isDisplayed()){
            System.out.println("Step 1 PASS");
        } else {
            System.out.println("Step 1 FAİLED");
        }
         musteriGirisi.click();
        //WebElement accountButton = driver.findElement(By.className("CustomerViewHeader"));
        WebElement accountButton = driver.findElement(By.xpath("//*[.='ŞİMDİ ÜYE OL']"));
        accountButton.click();
        WebElement acountForm = driver.findElement(By.tagName("h1"));
if(acountForm.isDisplayed()){
    System.out.println("Step 2 PASS");
}else {
    System.out.println("Step 2 FAİLED");
}




    }
}
