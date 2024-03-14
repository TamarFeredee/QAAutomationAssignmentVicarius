package vicariusTests;

import org.testng.annotations.Test;
import vicariusPageObjects.VicariusFunctions;


public class VicariusTests extends BaseTest{
    @Test
    public void tc01_loginWithValidEmail() throws InterruptedException {
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.login();
    }

    @Test
    public void tc02_loginWithInvalidEmail() throws InterruptedException {
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.loginWithInvalidEmail();
    }

    @Test
    public void tc03_testFaqBtn() throws InterruptedException {
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.clickOnFrequentlyAskedQuestionsBtn();
    }

    @Test
    public void tc04_testFreeTrialSignUp(){
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.freeTrialSignUp();
    }

    @Test
    public void tc05_testFreeTrialSignUpErrors(){
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.freeTrialSignUpPageErrorsValidations();
    }

    @Test
    public void tc06_testFreeTrialSignUpErrors(){
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.productPageWatchDemo();
    }

    @Test
    public void tc07_testFreeTrialSignUpPasswordErrors(){
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.passwordErrorsValidation();
    }

    @Test
    public void tc08_testVBot(){
        VicariusFunctions vicariusFunctions = new VicariusFunctions(driver);
        vicariusFunctions.vBotWindow();
    }
}
