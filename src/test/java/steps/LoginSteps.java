package steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import runner.Driver;

public class LoginSteps {

    protected WebDriver driver;

    @Dado("que estou no sistema automationpractice")
    public void que_estou_no_sistema_automationpractice() {
        Driver webdriver = new Driver();
        driver = webdriver.webDriver();
    }

    @Quando("abrir tela de login")
    public void abrir_tela_de_login() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @Quando("preencher email {string}")
    public void preencher_login(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(email);
    }

    @Quando("preencher senha {string}")
    public void preencher_senha(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setPassword(password);
    }

    @Quando("realizar login")
    public void realizar_login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBtnLoginIn();
    }

    @Quando("realiza logout")
    public void realizar_logout() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickBtnSignOut();
    }

    @Então("o sistema encaminha para página my account do usuário {string}")
    public void o_sistema_encaminha_para_página_my_account_do_usuário(String user) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getTextBtnAccount().contains(user));
    }

    @Então("o sistema apresenta mensagem de login inválido")
    public void o_sistema_apresenta_mensagem_de_login_inválido() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.messageLoginInvalido());
    }

}
