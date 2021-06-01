package teamAlistirma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
 */
public class MavenHomeWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
     WebElement userNameButton = driver.findElement(By.id("user-name"));
     userNameButton.sendKeys("standard_user");
     WebElement passwordButton = driver.findElement(By.id("password"));
     passwordButton.sendKeys("secret_sauce");

     WebElement loginKey = driver.findElement(By.xpath("//input[@type='submit']"));
     loginKey.click();
     WebElement ilkResim = driver.findElement(By.className("inventory_item_img"));
     ilkResim.click();
     WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
     addToCart.click();
     WebElement alisverisSepeti = driver.findElement(By.className("shopping_cart_link"));
     alisverisSepeti.click();
    WebElement sepetinİcindekiUrun = driver.findElement(By.id("item_4_title_link"));
    String urun1= sepetinİcindekiUrun.getText();
    WebElement secilenUrun =driver.findElement(By.className("inventory_item_name"));
    String  urun2= secilenUrun.getText();
    if(urun1.equals(urun2)){
        System.out.println("Sectiginiz urun basarıyla sepete eklenmistir");
    }else {
        System.out.println("Sectiginiz urun sepete  EKLENMEMİSTİR");
    }

    }
}
