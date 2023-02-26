package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.BrowserManager;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private WebDriver driver;
    private BrowserManager browserManager;
    public Hooks(BrowserManager browserManager){
        this.browserManager=browserManager;
    }
    @Before
    public void setUP(){
        browserManager.setDriver();

    }
    @After(order=1)
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) browserManager.getDriver();
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }
    @After(order=0)
    public void TearDown(){
    browserManager.getDriver().quit();
    }
}
