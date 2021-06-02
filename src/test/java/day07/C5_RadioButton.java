package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C5_RadioButton {
    /*1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
https://www.facebook.com adresine gidin
“Create an Account” button’una basin
“radio buttons” elementlerini locate edin
Secili degilse cinsiyet butonundan size uygun olani secin

     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        WebElement guvenik = driver.findElement(By.xpath("(//button[@value='1'])[3]"));
        guvenik.click();
        //“Create an Account” button’una basin
     WebElement yeniKayit=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
      yeniKayit.click();
        // “radio buttons” elementlerini locate edin
        // Secili degilse cinsiyet butonundan size uygun olani secin
        WebElement radioKadin= driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
         //WebElement radioKadin= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
         if (!radioKadin.isSelected()){
            radioKadin.click();
        }
    }
}
