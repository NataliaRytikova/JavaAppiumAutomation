package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
    TITLE = "org.wikipedia:id/view_page_title_text",
    FOOTER_ELEMENT = "//*[@text='View page in browser']",
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    CLOSE_MY_LIST = "//android.widget.ImageButton[@content-desc='Navigate up']";
    public  ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeTFooter()
    {
        this.swipeUpToElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                50
        );
    }

    public void addArticleToMyList(String name_of_folder){
        this.waitForElementEndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5
        );

        this.waitForElementEndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to list",
                5
        );

        this.waitForElementEndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find button to save article",
                5
        );

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find element to clear",
                5
        );

        this.waitForElementEndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot find element to set value",
                5
        );

        this.waitForElementEndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot find button to save article",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementEndClick(
                By.xpath(CLOSE_MY_LIST),
                "Cannot close article",
                5
        );
    }
}
