package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C6_BestBuyAssertion {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    /*
   1) Bir class oluşturun: BestBuyAssertions
   2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
       ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
       ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
       ○ logoTest => BestBuy logosunun görüntülendigini test edin
       ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    */
    @Test
    public void test(){
       driver.get("https://www.bestbuy.com/");
        String accualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(accualUrl,expectedUrl);
        String accutalTitle = driver.getTitle();
        String unExpectedWord= "Rest";
        Assert.assertFalse(accutalTitle.contains("Rest"));
        WebElement frnc = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(frnc.isDisplayed());

    }
}
