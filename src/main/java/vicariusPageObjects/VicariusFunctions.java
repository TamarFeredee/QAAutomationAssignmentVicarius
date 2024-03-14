package vicariusPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.testng.AssertJUnit.assertEquals;

public class VicariusFunctions extends BasePage{

    //Login page
    @FindBy(css = "input.input-text")
    private WebElement email;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/form/div[3]/div/button")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/ul/li/div/div/div")
    private WebElement emailInstructionText;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div")
    private WebElement invalidEmailText;
    @FindBy(css = "a[href='https://customer-portal.vicarius.io/']")
    private WebElement faqBtn;
    @FindBy(className = "kb-search-section__title_inner")
    private WebElement faqPageTitleText;



//  VBot Window
    @FindBy(className = ".VizExNotificationBadge__Wrapper-c72ym-0.eXAzjr")
    private WebElement vBotBtn;
    @FindBy(className = ".VizExButton__NoSelect-rjjkil-1.cGMmRt")
    private WebElement startFreeTrialOption;
    @FindBy(className = ".VizExNotificationBadge__Wrapper-c72ym-0.eXAzjr")
    private WebElement vBotCloseBtn;



    //Sign-up free trial process
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/div[2]/a")
    private WebElement clickOnFreeTrialBtn;
    @FindBy(id = "input52")
    private WebElement firstName;
    @FindBy(id = "input54")
    private WebElement lastName;
    @FindBy(id = "input31")
    private WebElement workEmail;
    @FindBy(id = "input58")
    private WebElement company;
    @FindBy(css = ".btn.btn-primary.full-width")
    private WebElement continueBtn;
    @FindBy(id = "input83")
    private WebElement password;
    @FindBy(id = "input85")
    private WebElement confirmPassword;
    @FindBy(css = ".btn.btn-primary.full-width")
    private WebElement startFreeTrialBtn;
    @FindBy(className = ".heading.mb-4")
    private WebElement hoorayPageText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/form/section/div[1]/div/div[2]")
    private WebElement firstNameError;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/form/section/div[2]/div/div[2]")
    private WebElement lastNameError;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/form/section/div[3]/div/div[2]")
    private WebElement personalEmailError;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/form/section/div[4]/div")
    private WebElement companyError;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/form/section/div[1]/div/div[2]")
    private WebElement passwordError;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/form/section/div[2]/div/div[2]")
    private WebElement passwordNotMatchError;

    //Product
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section[1]/div/div/div[3]/div[2]/button")
    private WebElement watchDemoBtn;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/div/div/div/div[1]/button")
    private WebElement closeVideoBtn;


    public VicariusFunctions(WebDriver driver) { super(driver);}

    public void login() throws InterruptedException {
        clear(email);
        fillText(email, "newnemy@ae.io");
        click(loginBtn);
        String expectedMessage = "If the email address exists and is active, further instructions have been sent to your email address.";
        String actualMessage = getText(emailInstructionText);
        assertEquals(expectedMessage, actualMessage);
    }

    public void loginWithInvalidEmail() throws InterruptedException {
        clear(email);
        fillText(email, "tamat@gmail.com");
        click(loginBtn);
        String expectedErrorMessage = "Invalid email address try again or Get a Free Trial";
        String actualErrorMessage = getText(invalidEmailText);
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    public void vBotWindow(){
        click(vBotBtn);
        click(startFreeTrialOption);
        click(vBotCloseBtn);
    }

    public void clickOnFrequentlyAskedQuestionsBtn() throws InterruptedException {
        click(faqBtn);
        String expectedTextTitle = "Hello. How can we help you?";
        String actualTextTitle = getText(faqPageTitleText);
        assertEquals(expectedTextTitle, actualTextTitle);
    }


    public void freeTrialSignUp(){
        driver.get("https://www.vicarius.io/sign/in");
        click(clickOnFreeTrialBtn);
        fillText(firstName, "tamar");
        fillText(lastName, "ferede");
        fillText(workEmail, "newnemy@ae.io");
        fillText(company, "test");
        click(continueBtn);
        fillText(password, "Test5432!");
        fillText(confirmPassword, "Test5432!");
        click(startFreeTrialBtn);
        String expectedHoorayPageText = "Please check your email for verification link";
        String actualHoorayPageText = getText(hoorayPageText);
        assertEquals(expectedHoorayPageText, actualHoorayPageText);
    }

    public void freeTrialSignUpPageErrorsValidations(){
        driver.get("https://www.vicarius.io/sign/up");
        fillText(workEmail, "tamar@gmail.com");
        click(continueBtn);

        String expectedFirstNameError = "Field is required.";
        String actualFirstNameError = getText(firstNameError);
        assertEquals(expectedFirstNameError, actualFirstNameError);

        String expectedLastNameError = "Field is required.";
        String actualLastNameError = getText(lastNameError);
        assertEquals(expectedLastNameError, actualLastNameError);

        String expectedPersonalEmailError = "Can't be a personal email.";
        String actualPersonalEmailError = getText(firstNameError);
        assertEquals(expectedPersonalEmailError, actualPersonalEmailError);

        String expectedCompanyError = "Field is required.";
        String actualCompanyError = getText(companyError);
        assertEquals(expectedCompanyError, actualCompanyError);
    }

    public void passwordErrorsValidation(){
        driver.get("https://www.vicarius.io/sign/up");
        fillText(firstName, "tamar");
        fillText(lastName, "ferede");
        fillText(workEmail, "newnemy@ae.io");
        fillText(company, "test");
        click(continueBtn);
        fillText(password, "1");
        fillText(confirmPassword, "1");
        click(startFreeTrialBtn);
        String expectedPasswordError = "Must contain required characters.";
        String actualPasswordError = getText(passwordError);
        assertEquals(expectedPasswordError, actualPasswordError);

        fillText(password, "Test5432!");
        click(startFreeTrialBtn);

        String expectedNotMatchError = "Passwords do not match.";
        String actualNotMatchError = getText(passwordNotMatchError);
        assertEquals(expectedNotMatchError, actualNotMatchError);
    }

    public void productPageWatchDemo(){
        driver.get("https://www.vicarius.io/product");
        click(watchDemoBtn);
        click(closeVideoBtn);
    }

}
