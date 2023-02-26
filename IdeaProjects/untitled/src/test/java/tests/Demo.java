package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
    //testNG
        //selenium

        //open the browser and navigate to amazon.in
        //enter "mobiles" in search bar
        //click on search /enter key
        //mobiles should be displayed
        static WebDriver driver;
    @BeforeTest
     public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }




    @Test
       public static void testCase1(){

        driver.get("https://www.amazon.in/");

        By by = By.id("twotabsearchtextbox");//locators
        WebElement element = driver.findElement(by);
        element.sendKeys("mobiles");
        element.sendKeys(Keys.ENTER);
                String text = driver.findElement(By.xpath(" //span[@class='a-color-state a-text-bold']")).getText();

        Assert.assertEquals(text,"\"mobiles\"");

    }
    @Test
    public void textBox(){
        driver.get("https://leafground.com/input.xhtml");
        String xpathExpression;
        driver.findElement(By.xpath("//input[@id=\"j_idt88:name\"]"))
                .sendKeys("test users");
        driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt91\"]"))
                .sendKeys("India");
        String disabled = driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt93\"]"))
                .getAttribute("disabled");

        Assert.assertEquals(disabled,"true");
        driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt95\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt97\"]")).getAttribute("value");

    }
    @Test
    public void button(){
        driver.get("https://www.leafground.com/button.xhtml");
        driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt90\"]"))
                .click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.leafground.com/dashboard.xhtml"));
        driver.get("https://www.leafground.com/button.xhtml");
        Point point = driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt94\"]"))
                .getLocation();
        Assert.assertEquals(point.getX(),81);
        Assert.assertEquals(point.getY(),400);
        Dimension dimension = driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt94\"]"))
                .getSize();
        Assert.assertEquals(dimension.getWidth(),87);
        Assert.assertEquals(dimension.getHeight(),34);
        List<WebElement> buttons = driver
                .findElements(By.xpath("(//div[@class=\"card\"])[7]/button"));
        Assert.assertEquals(buttons.size(),4);
    }

    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml");
                Select dropDown = new Select(
                        driver.findElement(By.xpath("//select[@class=\"ui-selectonemenu\"]")));
                dropDown.selectByIndex(1);
                dropDown.selectByVisibleText("Playwright");
                driver.findElement(By.xpath("//div[@id=\"j_idt87:country\"]")).click();
            driver.findElement(By.xpath("//li[text()='India']")).click();
            driver.findElement(By.id("j_idt87:city")).click();
            Thread.sleep(2000);
            List<WebElement> cities = driver.findElements
                (By.xpath("//ul[@id=\"j_idt87:city_items\"]/li"));
            List<String> citiesString = Arrays.asList("Bengaluru", "Chennai", "Delhi");


            for(int i = 1; i < cities.size(); i++){
                Assert.assertEquals(cities.get(i).getText(),citiesString.get(i-1));
            }
    }
    @Test
    public void checkboxesTest() throws InterruptedException{
        driver.get("https://www.leafground.com/checkbox.xhtml");
        driver.findElement(By.xpath("//div[@id=\"j_id91\"]//div[2]")).click();
        String info = driver.findElement(By.xpath("//span[@class=\"ui-title\"]")).getText();
        Assert.assertEquals(info,"Checked");
        driver.findElements(By.xpath("//input[@name=\"j_idt87:j_idt91_input\"]")).get(0).click();
        Assert.assertEquals(info,"Unexpected");
        
    }
    @Test
    public void hyperlink(){
        driver.get("");
        String url = driver.findElement(By.xpath("(//div[@class=\"col-12\"])[2]//a"))
                .getAttribute("href");
        driver.findElements(By.xpath("//a[@href=\"/dashboard.xhtml\"]")).get(3).click();
        List<WebElement> list = driver.findElements(By.tagName("8"));
        Assert.assertEquals(list.size(),47);
    }

    @Test
    public void waitsTest(){
        driver.get("https://www.leafground.com/waits.xhtml");
        driver.findElement(By.xpath("//button[@name=\\\"j_idt87:j_idt89\\\"]")).click();
        Wait wait = new FluentWait(driver)
                .withTimeout(10,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

                wait.until(ExpectedConditions.invisibilityOf(
                        driver.findElement(By.xpath("//button[@name=\"j_idt87:j_idt90\"]"))));
       driver.findElement(By.xpath("//button[@name=\"j_idt87:j_idt90\"]")).click();
    }

    @Test
    public void tableTest(){
        driver.get("https://www.leafground.com/table.xhtml");
        WebElement table = driver.findElement(By.xpath("(//table[@role=\"grid\"])[2]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
                for(int i=0;i< rows.size();i++){
         WebElement row = rows.get(i);
         List<WebElement> column = row.findElements(By.tagName("td"));
                for(int j=0; j<column.size();j++){
                    System.out.println(column.get(j).getText());
                }
                }

    private void sendKeys() {
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
