package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    protected WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "account")
    private WebElement btnAccount;

    @FindBy(how = How.CLASS_NAME, using = "logout")
    private WebElement btnLogout;

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTextBtnAccount(){
        return btnAccount.getText();
    }

    public void clickBtnSignOut(){
        btnLogout.click();
    }

}
