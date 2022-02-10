import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.Signup;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    WebDriver driver;

    @Given("^user visits to the Signup page$")
    public void User_visits_to_the_Signup_page() throws Exception {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
    }
    @When("^user inputs invalid \"([^\"]*)\"$")
    public void user_inputs_invalid_password(String shortPassword)throws Exception  {
        Signup signup = new Signup(driver);
        signup.doSignup(shortPassword);
    }

    @Then("^user can not Signup$")
    public void User_not_able_to_Signup() {
        Signup signup = new Signup(driver);
        String text = signup.getFirstErrorMessage();
        Assert.assertEquals(text, "Use 8 characters or more for your password");

    }
    @When("^user enters invalid \"([^\"]*)\"$")
    public void user_enters_invalid_password(String weakPassword) throws Exception {
        Signup signup = new Signup(driver);
        signup.doSignup(weakPassword);
    }
    @Then("^user can not signup$")
    public void User_not_able_to_signup(){
        Signup signup = new Signup(driver);
        String text = signup.getSecondErrorMessage();
        Assert.assertEquals(text, "Please choose a stronger password. Try a mix of letters, numbers, and symbols.");
        driver.close();
    }
}
