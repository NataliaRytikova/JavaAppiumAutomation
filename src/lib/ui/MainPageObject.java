package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.Platform;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeOutInSecond)
    {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeOutInSeconds)
    {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public WebElement waitForElementEndSendKeys(String locator, String value, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }



    public WebElement waitForElementEndClick(String locator, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.clear();
        return element;
    }


    public void assertElementHasText(String locator, String text, String error_message) {

        WebElement element = waitForElementPresent(locator, error_message, 10);
        //System.out.println(element);
        String textElement = element.getText();

        Assert. assertEquals(
                error_message,
                text,
                textElement
        );
    }

    public void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    public void swipeUpQuick()
    {
        swipeUp(400);
    }

    public void swipeUpToElement(String locator, String error_message, int max_swipes)
    {
        By by = this.getLocatorString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0){
            if (already_swiped > max_swipes){
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }

    }

    public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes)
    {
        int already_swiped = 0;
        while (!this.isElementLocateOnTheScreen(locator))
        {
            if(already_swiped > max_swipes){
                Assert.assertTrue(error_message, this.isElementLocateOnTheScreen(locator));
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    public boolean isElementLocateOnTheScreen(String locator)
    {
        int element_location_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 1).getLocation().getY();
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }

    public void clickElementToTheRightUpperCorner(String locator, String error_message)
    {
        WebElement element = this.waitForElementPresent(locator + "/..",error_message, 15);
        int right_x = element.getLocation().getX();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;
        int width = element.getSize().getWidth();

        int point_to_click_x = (right_x + width) - 3;
        int point_to_click_y = middle_y;

        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(point_to_click_x,point_to_click_y)).perform();

    }

    public void swipeElementToLeft(String locator, String error_message)
    {
        WebElement element = waitForElementPresent(
                locator,
                error_message,
                10
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(right_x, middle_y));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)));
        if (Platform.getInstance().isAndroid()){
            action.moveTo(PointOption.point(left_x,middle_y));
        } else
        {
            int offset_x = (-1 * element.getSize().getWidth());
            action.moveTo(PointOption.point(offset_x, middle_y));
        }

        action.release();
        action.perform();

    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message,timeoutInSeconds);
        return  element.getAttribute(attribute);
    }

    public void assertElementPresent(String locator, String error_mesage)
    {
        By by = this.getLocatorString(locator);
        if (driver.findElements(by).isEmpty()) {
            Assert.assertTrue(error_mesage, false);
        }
    }

    public int getAmountOfElements(String locator)
    {
        By by = this.getLocatorString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void assertElementNotPresent(String locator, String error_mesage)
    {
        By by = this.getLocatorString(locator);
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0)
        {
            String default_message = "An element '" + locator + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_mesage);
        }
    }

    By getLocatorString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        }else if (by_type.equals("id")){
            return By.id(locator);
        }else {
            throw
                    new IllegalArgumentException("Cannot get type of locator. Locator: " + locator_with_type);
        }
    }
}
