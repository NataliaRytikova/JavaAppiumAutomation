package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
    TITLE = "id:org.wikipedia:id/view_page_title_text",
    FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
    OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
    CLOSE_MY_LIST = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    public  ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeTFooter()
    {
        this.swipeUpToElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                50
        );
    }

    public void addArticleToMyList(String name_of_folder){
        this.waitForElementEndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementEndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to list",
                5
        );

        this.waitForElementEndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find button to save article",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find element to clear",
                5
        );

        this.waitForElementEndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find element to set value",
                5
        );

        this.waitForElementEndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find button to save article",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementEndClick(
                CLOSE_MY_LIST,
                "Cannot close article",
                5
        );
    }
}
