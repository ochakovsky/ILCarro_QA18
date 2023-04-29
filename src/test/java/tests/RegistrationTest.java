package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.dc.path.FastPathProducer;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationPositiveTest(){

        int i = (int)((System.currentTimeMillis() / 1000) % 3600);

        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("joe" + i + "@mail.com")
                .withPassword("$Aa123456");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckBox();
        app.getUser().submitForm();

    }
}
