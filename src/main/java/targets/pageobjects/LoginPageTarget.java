package targets.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageTarget {

private final WebDriver driver;

private By usernamelocator=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]");
private By passwordlocator=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]");
private By submitlocator=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]");
private By dhashboard=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]");

public LoginPageTarget(WebDriver driver){
    this.driver=driver;
}

public void enterusername(String username){
    WebElement usernameinput= driver.findElement(usernamelocator);
    usernameinput.sendKeys(username);
}
    public void enterpassword(String password){
        WebElement passwordinput= driver.findElement(passwordlocator);
        passwordinput.sendKeys(password);
    }
    public void submitbutton(){
        WebElement submitbuttonclick= driver.findElement(submitlocator);
        submitbuttonclick.click();
    }

    public void dashboard(){
        WebElement dashboardcheck= driver.findElement(dhashboard);
        dashboardcheck.isDisplayed();
    }
}
