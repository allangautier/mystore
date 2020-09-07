package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    protected WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button/span[contains(text(), 'I confirm my order')]")
    private WebElement btnConfirmOrder;

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/p/a[@title='Proceed to checkout']")
    private WebElement btnCheckout;

    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Your order on My Store is complete.')]")
    private WebElement lblOrderConfirmation;

    @FindBy(how = How.XPATH, using = "//span[@class='price']/strong")
    private WebElement lblPrice;

    @FindBy(how = How.XPATH, using = "//div[@class='layer_cart_row']/span[@class='ajax_block_cart_total']")
    private WebElement lblPriceProduct;

    @FindBy(how = How.ID, using = "total_price")
    private WebElement lblPriceTotal;

    public ShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkProductAdded(String produto){
        boolean product = driver.findElement(By.xpath("//td[@class='cart_description']/p[@class='product-name']/a[contains(text(), '"+ produto +"')]")).isDisplayed();
        return product;
    }

    public String getPriceProduct() throws InterruptedException {
        Thread.sleep(2000);
        return lblPriceProduct.getText();
    }

    public String getPriceTotal() throws InterruptedException {
        Thread.sleep(2000);
        return lblPriceTotal.getText();
    }

    public void clickPaymentMethod(String paymentMethod){
        driver.findElement(By.xpath("//a[@title='"+ paymentMethod +"']")).click();
    }

    public void clickConfirmOrder(){
        btnConfirmOrder.click();
    }

    public void clickBtnCheckout(){
        btnCheckout.click();
    }

    public boolean confirmationOrder(){
        return lblOrderConfirmation.isDisplayed();
    }

    public String getPriceOrder() throws InterruptedException {
        Thread.sleep(2000);
        return lblPrice.getText();
    }

}
