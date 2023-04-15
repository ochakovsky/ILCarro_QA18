package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}
