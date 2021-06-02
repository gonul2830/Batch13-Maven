package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C2_BeforeAfterAnnotations {
    WebDriver driver;
@Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Setup methodu calıstı");

    }
@After
    public void tearDown () throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("tearDown methodu calıstı");
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://google.com");
        System.out.println("Test01 methodu calıstı");

    }
    @Test
    public void test02() throws InterruptedException {

        driver.get("https://www.amazon.com");
        System.out.println("Test02 methodu calıstı");
    }
    @Test
    public void test03() throws InterruptedException {

        driver.get("https://www.facebook.com");
        System.out.println("Test03 methodu calıstı");

    }


}
