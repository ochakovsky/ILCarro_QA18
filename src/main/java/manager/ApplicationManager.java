package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;
  HelperUser user;

    public HelperUser getUser() {
        return user;
    }

    public void init(){

      wd = new ChromeDriver();
//      wd.manage().window().maximize();
      wd.navigate().to("https://ilcarro.web.app/search");
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      user = new HelperUser(wd);
  }

  public void stop(){
//      wd.quit();
  }

}
