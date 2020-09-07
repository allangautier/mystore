package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

    protected WebDriver driver;

    @FindBy(how = How.ID, using = "cgv")
    private WebElement chkTermsOfService;

    @FindBy(how = How.NAME, using = "processCarrier")
    private WebElement btnProceedToCheckout;

    public ShippingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickChkTermsOfService(){
        chkTermsOfService.click();
    }

    public void clickBtnProceedToCheckout(){
        btnProceedToCheckout.click();
    }

}
