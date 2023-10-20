package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver driver;
    UserHelper userHelper;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper = new UserHelper(driver);

        logger.info("navigated to the url: https://telranedu.web.app/home");
    }

    public void navigateToMainPage() {
        driver.navigate().to("https://telranedu.web.app/home");
    }
    public UserHelper getUserHelper() {

        return userHelper;
    }

    public void tearDown() {

        driver.quit();
    }

}
