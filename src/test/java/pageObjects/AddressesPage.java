package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {

    protected WebDriver driver;

    @FindBy(how = How.NAME, using = "processAddress")
    private WebElement btnProceedToCheckout;

    public AddressesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickBtnProceedToCheckout(){
        btnProceedToCheckout.click();
    }

}
