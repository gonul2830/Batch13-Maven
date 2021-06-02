package day07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class C3_BeforeClassAfterClass {

    static WebDriver driver;
    @BeforeClass  // classdan once calisir (statik olmasi gerekir)
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("setup calisti");
    }
    @AfterClass // classdan sonra calisir (statik olmasi gerekir)
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("teardown calisti");
    }
    @Test
    public void test01()  {
        driver.get("https://techproeducation.com");
        System.out.println("1.method calisti");
    }
    @Test
    public void test02() {
        driver.get("https://amazon.com");
        System.out.println("2.method calisti");
    }
    @Test
    public void test03() {
        driver.get("https://facebook.com");
        System.out.println("3.method calisti");
    }
}
