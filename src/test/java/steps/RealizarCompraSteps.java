package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import runner.Driver;

public class RealizarCompraSteps {

    protected WebDriver driver;
    String produto = null;
    String priceProduct = null;

    @Dado("que acesso automationpractice")
    public void que_acesso_automationpractice() {
        Driver webdriver = new Driver();
        driver = webdriver.webDriver();
    }

    @Quando("realizar login com email {string} e senha {string}")
    public void E_realizar_login_com_credenciais_válidas_de_email_e_senha(String email, String senha){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setEmail(email);
        loginPage.setPassword(senha);
        loginPage.clickBtnLoginIn();
    }

    @Quando("adicionar produto {string} no carrinho")
    public void adicionar_produto_no_carrinho(String produto) {
        this.produto = produto;
        HomePage homePage = new HomePage(driver);
        homePage.clickAddToCart(produto);
    }

    @Quando("fazer checkout")
    public void fazer_checkout() throws InterruptedException {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        HomePage homePage = new HomePage(driver);


        priceProduct = shoppingCartPage.getPriceProduct();
        homePage.clickBtnCheckout();
    }

    @Quando("fazer checkout no shopping cart")
    public void fazer_checkout_no_shopping_cart() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickBtnCheckout();
    }

    @Quando("processar endereço")
    public void processar_endereço() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickBtnProceedToCheckout();
    }

    @Então("o produto adicionado consta no carrinho")
    public void o_produto_adicionado_consta_no_carrinho() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.checkProductAdded(produto);
    }

    @Quando("aceitar os termos de serviço")
    public void aceitar_os_termos_de_serviço() {
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.clickChkTermsOfService();
    }

    @Quando("processar transportadora")
    public void processar_transportadora() {
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.clickBtnProceedToCheckout();
    }

    @Quando("escolher a forma de pagamento {string}")
    public void escolher_a_forma_de_pagamento(String formaPagamento) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickPaymentMethod(formaPagamento);
    }

    @Quando("confirmar a ordem")
    public void confirmar_a_ordem() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickConfirmOrder();
    }

    @Então("gera confirmação de ordem")
    public void gera_confirmacao_de_ordem() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.confirmationOrder());
    }

    @Então("valida valor da ordem")
    public void valida_valor_da_ordem() throws InterruptedException {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(priceProduct, shoppingCartPage.getPriceOrder());
    }

    @Então("valida valor total da compra")
    public void valida_valor_total_da_compra() throws InterruptedException {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(priceProduct, shoppingCartPage.getPriceTotal());
    }
}
