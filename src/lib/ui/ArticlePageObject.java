package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON;
    public  ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    private static final String getSavedArticleXpathByTitle(String article_title)
    {
        return TITLE.replace("{TITLE}",article_title);
    }


    public WebElement waitForTitleByNameElement(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        return this.waitForElementPresent(article_xpath, "Cannot find article title on page", 15);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeTFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    50
            );
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Cannot find the end of article",
            70);
        }
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

    public void addArticleToMySaved()
    {
        this.waitForElementEndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find options to add article to reading list", 15);
    }

    public void closeArticle()
    {
        this.waitForElementEndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article",
                5
        );
    }
}
