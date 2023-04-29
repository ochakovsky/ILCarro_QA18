package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if (app.getUser().isLogged())
            app.getUser().logOut();
    }
    @Test
    public void positiveTestLogin(){
        User data = new User().withEmail("qwertyu@uytrewq.com").withPassword("Aa123456@");
//        String email = "qwertyu@uytrewq.com";
//        String password = "Aa123456@";
        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void negativeTestWrongEmail(){
        String email = "qwertyuuytrewq.com";
        String password = "Aa123456@";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedFailed());
    }

    @Test
    public void negativeTestWrongPassword(){
        String email = "qwertyu@uytrewq.com";
        String password = "Aa123456";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedFailedPass());
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}
