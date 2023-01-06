package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObjest;

public class AndroidSearchPageObject extends SearchPageObjest {
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
        CLEAR_SEARCH_RESULT = "id:org.wikipedia:id/search_src_text";
    }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
