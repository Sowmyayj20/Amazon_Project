package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.BrowserManager;
import utils.QAprops;

import static java.awt.SystemColor.text;


public class StepDefinition {
    private WebDriver driver;
    HomePage homePage;
    String url;
    public StepDefinition(BrowserManager browserManager){

        this.driver=browserManager.getDriver();
    }

    @Given("user navigates to the browser's url tab")//11
    public void user_navigates_to_the_browser_s_url_tab() {


    }
    @When("user enters the url")
    public void user_enters_the_url() {
        homePage=new HomePage(driver);
        String add = homePage.getAbc().getText();
        Assert.assertEquals(add,"All");
        homePage.getId().click();

    }
    @Then("the chrome is launched")
    public void the_chrome_is_launched() {
        String add = homePage.getSearch().getText();
       Assert.assertEquals(add,"Select the language you prefer for browsing, shopping, and communications.");
    }


    @Given("the user navigates to the home page")//2
    public void the_user_navigates_to_the_home_page() {
        url = QAprops.getValue("url");
        driver.get(url);

    }
    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {

homePage=new HomePage(driver);
homePage.getSearchBox().sendKeys("helmets");
homePage.getSearchBox().sendKeys(Keys.ENTER);

    }
    @Then("the product result should be displayed")
    public void the_product_result_should_be_displayed() {
        String text=homePage.getSearchResult().getText();
        Assert.assertEquals(text,"\"helmets\"");

    }


    @Given("user navigates to the signin page here")//3
    public void user_navigates_to_the_signin_page_here() {
        url = QAprops.getValue("url");
        driver.get(url);
        homePage=new HomePage(driver);
       homePage.getList().click();

    }
    @When("the user enters phone number and password")
    public void the_user_enters_phone_number_and_password() {
        homePage=new HomePage(driver);
        homePage.getEmail().sendKeys("9148386385");
          homePage.getContinue().click();
          homePage.getPass().sendKeys("Sowmya@123");
          homePage.getSign().click();

    }
    @Then("user is able to signin")
    public void user_is_able_to_signin() throws InterruptedException {
        Thread.sleep(3000);

    }


    @Given("the user navigates to  home page")//4
    public void the_user_navigates_to_home_page() throws InterruptedException {
        url = QAprops.getValue("url");
        driver.get(url);
        homePage=new HomePage(driver);
        Thread.sleep(3000);

    }

    @When("the user is able to click on gift bar and navigate to gift section")
    public void the_user_is_able_to_click_on_gift_bar_and_navigate_to_gift_section() throws InterruptedException {
        homePage=new HomePage(driver);
        Thread.sleep(3000);
      homePage.getGift().click();
        homePage.getShop().click();
        Thread.sleep(3000);
    }
    @Then("the user is able to view the gifts")
    public void the_user_is_able_to_view_the_gifts(){

          String East=homePage.getAmazon().getText();
               Assert.assertEquals(East,"Delivery Type");
    }

    @Given("user navigates to the home page")//6
    public void user_navigates_to_the_home_page() {
        url = QAprops.getValue("url");
        driver.get(url);
        homePage=new HomePage(driver);
    }
    @When("user clicks on search bar without entering characters")
    public void user_clicks_on_search_bar_without_entering_characters() {
        homePage=new HomePage(driver);
        String Log=homePage.getFact().getText();
           Assert.assertEquals(Log,"India");
    }
    @Then("user is not able to find any answer")
    public void user_is_not_able_to_find_any_answer() {
        homePage.getNegativee().sendKeys(Keys.ENTER);
    }


    @Given("User is able to move to sign in page")//7
    public void user_is_able_to_move_to_sign_in_page() {
        url = QAprops.getValue("url");
        driver.get(url);
        homePage=new HomePage(driver);
    }
    @When("user doesnt enter any credentials in sign in page")
    public void user_doesnt_enter_any_credentials_in_sign_in_page() {
        homePage.getAccount().click();
       homePage.getWeb().click();
     homePage.getBar().click();
    }
    @Then("user is not able sign in")
    public void user_is_not_able_sign_in() {
        String mul=homePage.getUnique().getText();
          Assert.assertEquals(mul, "© 1996-2023, Amazon.com, Inc. or its affiliates");
    }



}
