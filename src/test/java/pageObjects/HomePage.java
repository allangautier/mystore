package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement btnSignin;

    @FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout']")
    private WebElement btnCheckout;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSignIn(){
        btnSignin.click();
    }

    public void clickAddToCart(String produto){
        driver.findElement(By.xpath("//*[@id='homefeatured']/li/div/div/h5/a[contains(text(), '"+ produto +"')]/../../div/a/span")).click();
    }

    public void clickBtnCheckout(){
        btnCheckout.click();
    }

}
