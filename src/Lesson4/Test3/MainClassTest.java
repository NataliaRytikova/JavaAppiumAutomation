package Lesson4.Test3;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class MainClassTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "adb80");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
        capabilities.setCapability("app", "/Users/n.rytikova/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {

        waitForElementEndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search…",
                "Cannot find 'Search…' input"
        );

        String search_line = "Java";

        waitForElementEndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find '" + search_line + "' input",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
                "Cannot find 'Java (programming language)' topic searching by " + search_line,
                15
        );
/*
        String title_before_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );
*/
        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                "Java (programming language)",
                title_after_rotation
        );
    }

    @Test
    public void titleSearch()
    {

        waitForElementEndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search…",
                "Cannot find 'Search…' input"
        );

        String search_line = "Java";

        waitForElementEndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find '" + search_line + "' input",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' input",
                10
        );

        String title = "Object-oriented programming language";

        assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Java (programming language)"
        );
    }



    private WebElement waitForElementPresent(By by, String error_message, long timeOutInSecond)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementEndSendKeys(By by, String value, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }



    private WebElement waitForElementEndClick(By by, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.click();
        return element;
    }

    private void assertElementHasText(By by, String text, String error_message) {

        WebElement element = waitForElementPresent(by, error_message, 10);
        String textElement = element.getText();

        Assert. assertEquals(
                error_message,
                text,
                textElement
        );
    }

    private void assertElementPresent(By by, String error_mesage)
    {
        if (driver.findElements(by).isEmpty()) {
            Assert.assertTrue(error_mesage, false);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        return  element.getAttribute(attribute);
    }

}