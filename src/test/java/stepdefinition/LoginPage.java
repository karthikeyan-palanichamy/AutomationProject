package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import targets.pageobjects.LoginPageTarget;

@Test
public class LoginPage {


    public WebDriver driver;
   // WebElement form ;
   // private LoginPageTarget loginPageTarget;

    @BeforeClass
    public void setUp() {
        System.out.println("started");
        WebDriverManager.chromedriver().getWebDriver();
        System.out.println("chrome");
       driver = new ChromeDriver();
        System.out.println("end chrome");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I have entered the username and password")
    public void i_have_entered_the_username_and_password() throws InterruptedException {
        System.out.println("i_have_entered_the_username_and_password");
        Thread.sleep(5000);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(10000);
       // driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]")).sendKeys("Admin");
        WebElement form = driver.findElement(By.className("oxd-form"));
        WebElement username = form.findElement(By.name("username")); // Adjust 'name' to match your element
        WebElement password = form.findElement(By.name("password"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");// Adjust 'name' to match your element
        Thread.sleep(5000);
        System.out.println("i_click_on_the_submit_button");
        WebElement submitButton = form.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(10000);
        submitButton.click();
        Thread.sleep(10000);

    }
    @When("I click on the submit button")
    public void i_click_on_the_submit_button() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("i_click_on_the_submit_button");
    }
    @Then("I sould be able to login succesfully")
    public void i_sould_be_able_to_login_succesfully() {
        WebElement title=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]"));
        String tit=title.getText();
        System.out.println(tit);
        //  loginPageTarget.dashboard();
    }
}
