package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObjest;

public class iOSSearchPageObject extends SearchPageObjest {
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        CLEAR_SEARCH_RESULT = "id:Clear text";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
