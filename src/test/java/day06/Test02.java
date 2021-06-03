package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test02 {
    /*
    1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine “username” yazdirin
4. Password alanine “password” yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10”
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown (){
        //driver.close();
    }

    @Test
     public void test01(){
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("primary-button")).click();
        driver.findElement(By.xpath("(//*[.='Online Banking'])[2]")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.id("sp_amount")).sendKeys("20000");
       WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
              date.sendKeys("2020_09_10");
        driver.findElement(By.id("pay_saved_payees")).submit();

        WebElement succesfull = driver.findElement(By.xpath("//span[@title='$ 20000 payed to payee sprint']"));
        Assert.assertTrue(succesfull.isDisplayed());
     }

}
