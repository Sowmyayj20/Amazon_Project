package tests;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;

public class Amazon {
    WebDriver driver;
@BeforeTest
public void setUP(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    ChromeOptions options = new ChromeOptions();
    driver.get("https://www.amazon.com/");
}
    @Test

    public void First() {

        String text = driver.findElement(By.xpath("//span[@class=\"hm-icon-label\"]")).getText();
        Assert.assertEquals(text,"All");
        driver.findElement(By.id("icp-nav-flyout")).click();
        String add = driver.findElement(By.xpath("//span[@id=\"icp-language-subheading\"]")).getText();
        Assert.assertEquals(add,"Select the language you prefer for browsing, shopping, and communications.");
    }

@Test
public void search(){

    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("helmets");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    String text =driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
    Assert.assertEquals(text,"\"helmets\"");

}

@Test
    public void signin ()throws InterruptedException{

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("9148386385");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Sowmya@123");
        driver.findElement(By.id("signInSubmit")).click();
       Thread.sleep(3000);
        String user =driver.findElement(By.xpath("//h4[@class=\"a-alert-heading\"]")).getText();
        Assert.assertEquals(user,"Important Message!");

    }
    @Test

    public void giftcard(){

        driver.findElement(By.xpath("//input[@class=\"a-button-input\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc\"]")).click();
        String East=driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-base a-text-bold\"]")).getText();
                Assert.assertEquals(East,"Delivery Type");


    }
    @Test
    public void kart(){

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("9148386385");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Sowmya@123");
        driver.findElement(By.id("signInSubmit")).click();
        String user =driver.findElement(By.xpath("//h4[@class=\"a-alert-heading\"]")).getText();
        Assert.assertEquals(user,"Important Message!");
        driver.findElement(By.id("nav-cart")).click();

    }
    @Test
    public void negative(){
    String Log=driver.findElement(By.xpath("//span[@class=\"nav-line-2 nav-progressive-content\"]")).getText();
            Assert.assertEquals(Log,"India");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    }
    @Test

    public void negativetest(){

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).click();
        driver.findElement(By.id("continue")).click();
        String mul=driver.findElement(By.xpath("//span[@class=\"a-size-mini a-color-secondary\"]")).getText();
        Assert.assertEquals(mul, "© 1996-2023, Amazon.com, Inc. or its affiliates");

    }
   // @AfterTest
    public void TearDown(){
    driver.quit();
    }
}

