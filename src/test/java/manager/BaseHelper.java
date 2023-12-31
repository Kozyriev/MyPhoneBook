package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BaseHelper {

    Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    WebDriver driver;

    public BaseHelper(WebDriver driver) {

        this.driver = driver;
    }

    private WebElement findElementBase(By locator) {
        System.out.println(locator);
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {
        System.out.println(locator);
        return driver.findElements(locator);
    }
    public boolean isElementExist(By locator) {

        return findElementsBase(locator).size() > 0;
    }

    public void clickBase(By locator) {
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator) {
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text) {
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        return isTextEqualGetToStrings(expectedResult, actualResult);
        }

        public boolean isTextEqualGetToStrings(String expectedResult, String actualResult) {

            if (expectedResult.equals(actualResult)) {
                return true;
            } else {
                System.out.println("expected result: " + expectedResult +
                        "actual result: " + actualResult);
                return false;


        }
    }

    public void clickByXY(By locator, int down, int right) {
        Rectangle rect = findElementBase(locator).getRect();
        int x = rect.getX() + (rect.getWidth() / right);
        int y = (int) (rect.getY() + (rect.getHeight() / down));
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
    }

    public String getTextAlert(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText().toUpperCase().trim();

    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}