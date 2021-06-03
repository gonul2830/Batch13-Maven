package teamAlistirma;

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
/*
      1. Go to url https://www.zara.com/tr/
      2. Click on sign up
      3. Click on Register
      4. Type email
      5. Type password
      6. Re-type password
      7. Fill all req. sections
      8. Click on crete account
       */
public class Assertion {
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
    @Test
 public void zara () {
        driver.get("https://zara.com");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("(//*[.='LOG IN'])[2]")).click();
        driver.findElement(By.xpath("//span[.='CREATE ACCOUNT']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pirisauruspdf@gmail.com");
WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
password.click();
password.sendKeys("man1Adam");
WebElement repeatPassword = driver.findElement(By.xpath("//input[@name='passwordConfirm']"));
repeatPassword.click();
repeatPassword.sendKeys("man1Adam");
       WebElement name=  driver.findElement(By.xpath("//input[@name='firstName']"));
       name.click();
       name.sendKeys("Gonul");
       WebElement surname = driver.findElement(By.xpath("//input[@name='lastName']"));
       surname.click();
       surname.sendKeys("Taslak");
        driver.findElement(By.className("form-input-select__arrow")).click();
     WebElement address = driver.findElement(By.xpath("//input[@name='addressLines[0]']"));
     address.click();
     address.sendKeys("Polykleous 39 - C1");

     WebElement address2 = driver.findElement(By.xpath("//input[@name='addressLines[1]']"));
     address2.click();
     address2.sendKeys("Polykleous 39 - A1");

     WebElement posscode = driver.findElement(By.xpath("//input[@name='zipCode']"));
     posscode.click();
     posscode.sendKeys("11631");

     WebElement town = driver.findElement(By.xpath("//input[@name='city']"));
     town.click();
     town.sendKeys("Attika");

     WebElement tel = driver.findElement(By.xpath("(//input[@type='tel'])[2]"));
     tel.click();
     tel.sendKeys("6971586076");

     WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='newsletterCheck']"));
     checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        checkbox2.click();

       // WebElement create = driver.findElement(By.xpath("//span[.='Create Account']"));
       // create.click();

        WebElement personel = driver.findElement(By.className("form-input-radio__icon"));
        Assert.assertFalse(personel.isSelected());
        //driver.findElement(By.className("form-input-radio__icon")).click();
        WebElement business  =   driver.findElement(By.className("form-input-radio__icon"));
        Assert.assertFalse(business.isSelected());

 }
}
