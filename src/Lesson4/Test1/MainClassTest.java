package Lesson4.Test1;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void testFindElement()
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

        waitForElementEndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Appium",
                "Cannot find 'Appium' input",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='Automation for Apps']"),
                "Cannot find 'Automation for Apps' in description of article",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Title not found",
                20
        );


        swipeUpToElement(
                By.xpath("//*[@text='View page in browser']"),
                "Cannot find the end of article",
                20
        );


    }

    @Test
    public void saveArticlesToMyList()
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
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Java (programming language)']"),
                "Cannot find 'Java (programming language)' in description of article",
                5
        );
        waitForElementEndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to list",
                5
        );

        waitForElementEndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find button to save article",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find element to clear",
                5
        );

        String name_of_folder = "Learning programming";

        waitForElementEndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot find element to set value",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot find button to save article",
                5
        );

        waitForElementEndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article",
                5
        );
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

        waitForElementEndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find '" + search_line + "' input",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='JavaScript']"),
                "Cannot find 'JavaScript' in description of article",
                5
        );
        waitForElementEndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to list",
                5
        );

        waitForElementEndClick(
                By.xpath("//android.widget.TextView[@text='" + name_of_folder + "']"),
                "Cannot find list " + name_of_folder + " to save article",
                5
        );

        waitForElementEndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article",
                5
        );

        waitForElementEndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find my list",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find my list",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='JavaScript']"),
                "Cannot find saved article",
                5
        );

        swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='JavaScript']"),
                "Cannot find saved article",
                5
        );

        waitForElementEndClick(
                By.xpath("//*[@text='JavaScript']"),
                "Cannot find saved article",
                5
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

    private boolean waitForElementNotPresent(By by, String error_message, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
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

    private WebElement waitForElementAndClear(By by, String error_message, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        element.clear();
        return element;
    }


    private void assertElementHasText(By by, String text, String error_message) {

        WebElement element = waitForElementPresent(by, error_message, 10);
        //System.out.println(element);
        String textElement = element.getText();

        Assert. assertEquals(
                error_message,
                text,
                textElement
        );
    }

    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    protected void swipeUpQuick()
    {
        swipeUp(200);
    }

    protected void swipeUpToElement(By by, String error_message, int max_swipes)
    {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0){
            if (already_swiped > max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }

    }
    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x,middle_y)
                .release()
                .perform();

    }

}