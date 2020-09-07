package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    @FindBy(how = How.ID, using = "email")
    private WebElement lblEmail;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement lblPassword;

    @FindBy(how = How.XPATH, using = "//*[@id='SubmitLogin']")
    private WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//li[contains(text(), 'Authentication failed.')]")
    private WebElement lblMessageLoginInvalido;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setEmail(String email){
        lblEmail.sendKeys(email);
    }

    public void setPassword(String password){
        lblPassword.sendKeys(password);
    }

    public void clickBtnLoginIn(){
        btnLogin.click();
    }

    public boolean messageLoginInvalido() throws InterruptedException {
        Thread.sleep(2000);
        return lblMessageLoginInvalido.isDisplayed();
    }

}
