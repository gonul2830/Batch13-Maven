package day08;

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

public class YoutubeAssertions {
    /*
    1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

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
        driver.close();
    }
    @Test   // ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    public void titleTest(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//*[.='I agree']")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);


    }
 @Test //○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    public void imageTest(){
     driver.get("https://www.youtube.com");
     driver.findElement(By.xpath("//*[.='I agree']")).click();
     WebElement logo = driver.findElement(By.id("logo-icon"));
     Assert.assertTrue(logo.isDisplayed());

 }
@Test // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    public void SearchBox (){
    driver.get("https://www.youtube.com");
    driver.findElement(By.xpath("//*[.='I agree']")).click();
    WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
    Assert.assertTrue(searchBox.isEnabled());
}
@Test //  ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        public void wrongTitleTest () {
    driver.get("https://www.youtube.com");
    driver.findElement(By.xpath("//*[.='I agree']")).click();
    String actualTitle = driver.getTitle();
    String unexpectedTitle="youtube";

    Assert.assertFalse(actualTitle.equals(unexpectedTitle));

}
}
