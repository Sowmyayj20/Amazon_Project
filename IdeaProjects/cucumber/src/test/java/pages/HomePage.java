package pages;

import io.cucumber.java.tr.Ama;
import org.bouncycastle.cms.PasswordRecipientId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
private WebDriver driver;
        public HomePage(WebDriver driver){
    this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(id="twotabsearchtextbox")
        private WebElement searchBox;

        public WebElement getSearchBox() {
        return searchBox;
    }


        @FindBy(xpath="//span[@class=\"a-color-state a-text-bold\"]")
        private WebElement SearchResult;

       public WebElement getSearchResult() {
        return SearchResult;
    }
    //1
            @FindBy(xpath = "//span[@id=\"icp-language-subheading\"]")
            private WebElement Search;
            public WebElement getSearch(){
                return Search;
            }
            @FindBy(id="icp-nav-flyout")
            private WebElement Id;
            public WebElement getId(){
                    return Id;
            }
            @FindBy(xpath = "//span[@class=\"hm-icon-label\"]")
             private WebElement Abc;
            public WebElement getAbc() {
return Abc;
            }

            //3
            @FindBy(xpath="//h4[@class=\"a-alert-heading\"]")
              private WebElement Build;
            public WebElement getBuild(){
                return Build;
            }
            @FindBy(id="signInSubmit")
            private WebElement Sign;
            public WebElement getSign(){
                return Sign;
            }
            @FindBy(id="ap_password")
            private WebElement Pass;
            public WebElement getPass(){
                return Pass;
            }

            @FindBy(id="continue")
            private WebElement Continue;
            public WebElement getContinue(){
                return Continue;
            }
            @FindBy(id="ap_email")
        private WebElement Email;
        public WebElement getEmail(){
            return Email;
        }
        @FindBy(id = "nav-link-accountList")
        private WebElement List;
        public WebElement getList(){
            return List;
        }
        //4
        @FindBy(xpath = "//a[@href=\"/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc\"]")
        private WebElement Gift;
        public WebElement getGift(){
            return Gift;
        }
        @FindBy(xpath ="//input[@class=\"a-button-input\"]")
        private WebElement Shop;
        public WebElement getShop(){
            return Shop;
        }

        @FindBy(xpath ="//span[@class=\"a-size-base a-color-base a-text-bold\"]")
        private WebElement Amazon;
        public WebElement getAmazon(){
        return Amazon;
    }
    //6
        @FindBy(id="twotabsearchtextbox")
        private WebElement Negativee;
        public WebElement getNegativee(){
            return Negativee;
        }

        @FindBy(xpath = "//span[@class=\"nav-line-2 nav-progressive-content\"]")
        private WebElement Fact;
        public WebElement getFact(){
            return Fact;
        }
        //7
    @FindBy(xpath = "//span[@class=\"a-size-mini a-color-secondary\"]")
    private WebElement Unique;
        public WebElement getUnique(){
            return Unique;
        }
    @FindBy(id="continue")
    private WebElement Bar;
    public WebElement getBar(){
        return Bar;
    }
    @FindBy(id="ap_email")
    private WebElement Web;
    public WebElement getWeb(){
        return Web;
    }
    @FindBy(id = "nav-link-accountList")
    private WebElement Account;
    public WebElement getAccount(){
        return Account;
    }
}



