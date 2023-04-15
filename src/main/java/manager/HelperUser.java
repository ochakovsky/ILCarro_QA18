package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitForm(){
        click(By.xpath("//button[contains(.,'alla')]"));
    }

    public boolean isLoggedSuccess(){
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
//        return (wd.findElements(By.xpath("//h2[.='Logged in success']")).size() > 0);
        return wd.findElement(By.xpath("//h2[.='Logged in success']")).getText().contains("success");
    }

    public boolean isLoggedFailed(){
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.=\"It'snot look like email\"]")));
        return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");
    }

    public boolean isLoggedFailedPass() {
        return isElementPresent(By.xpath("//h2[.='\"Login or Password incorrect\"']"));
    }
    public void clickOkButton(){
        if (isElementPresent(By.xpath("//button[.='Ok']"))){
            click(By.xpath("//button[.='Ok']"));
        }
    }

    public void logOut(){
        click(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }


    public void openRegistrationForm(){
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
    }

    public void clickCheckBox(){

    }
}
