package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class Test01 {
    /*
    1-Test01 isimli bir class olusturun
2- https://www.walmart.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5- Sayfa basliginin “Save” ifadesi icerdigini control edin
6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
7- URL in walmart.com icerdigini control edin
8-”Nutella” icin arama yapiniz
9- Kac sonuc bulundugunu yaziniz
10-Sayfayi kapatin

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.walmart.com/");
        driver.navigate().refresh();
        if(driver.getTitle().contains("Save")){
            System.out.println("Baslik Save iceriyor");
        } else {
            System.out.println("baslik Save icermiyor");
        }
        if(driver.getTitle().toLowerCase().equals("Walmart.com | Save Money.Live Better")){
            System.out.println("baslık verilen degere esit");
        } else {
            System.out.println("Baslik verilen degere esit degil");
        }
        String walmartUrl = driver.getCurrentUrl();
        if(walmartUrl.contains("walmart.com")){
            System.out.println("Url walmart.com iceriyor");
        } else {
            System.out.println("Url walmart.com icermiyor");
        }

        WebElement aramaKutusu = driver.findElement(By.id("global-search-input"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        WebElement arananSonucSayisi = driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(arananSonucSayisi.getText());
        driver.close();


    }
}
