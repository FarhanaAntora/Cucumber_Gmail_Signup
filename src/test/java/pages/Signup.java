package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
    public Signup(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(name = "username")
    WebElement userName;
    @FindBy(name = "Passwd")
    WebElement Password;
    @FindBy(name = "ConfirmPasswd")
    WebElement confirmPassword;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement btnNext;
    @FindBy(xpath = "//span[contains(text(),'Use 8 characters or more for your password')]")
    WebElement firstErrorMessage;
    @FindBy(xpath = "//span[contains(text(),'Please choose a stronger password. Try a mix of le')]")
    WebElement secondErrorMessage;
    public void doSignup( String password) throws InterruptedException {
        firstName.sendKeys("Urmi");
        lastName.sendKeys("Orin");
        userName.sendKeys("urmiorin57");
        Password.sendKeys(password);
        confirmPassword.sendKeys(password);
        btnNext.click();

    }
    public String getFirstErrorMessage(){
        return firstErrorMessage.getText();
    }
    public String getSecondErrorMessage(){
        return secondErrorMessage.getText();
    }
}

