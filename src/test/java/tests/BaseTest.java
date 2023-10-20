package tests;

import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.RandomUtils;

import java.lang.reflect.Method;


@Listeners(TestNGListener.class)
public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static ApplicationManager app = new ApplicationManager();
    RandomUtils randomUtils = new RandomUtils();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void stop() {
        app.tearDown();
    }

    public void SignOutIflogin() {
        if (app.getUserHelper().btnSignOutExist()) {
            app.getUserHelper().SignOut();
        }
    }

    @BeforeMethod
    public void loggerBe4Method(Method method) {

        logger.info("start method: " + method.getName());
    }

    @BeforeMethod
    public void loggerAfterMethod(Method method) {

        logger.info("stop method: " + method.getName());
    }

}