package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='W']";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
