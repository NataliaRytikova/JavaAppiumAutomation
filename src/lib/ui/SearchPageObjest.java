package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

abstract public class SearchPageObjest extends MainPageObject{

    protected static String
        TITLE,
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_CANCEL_BUTTON,
        SEARCH_RESULT_BY_SUBSTRING_TPL,
        SEARCH_RESULT_ELEMENT,
        SEARCH_EMPTY_RESULT_ELEMENT,
        CLEAR_SEARCH_RESULT;
    public  SearchPageObjest(AppiumDriver driver)
    {
        super(driver);
    }

    /* Templates method*/
    public static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* Templates method*/

    public void initSearchInput()
    {
        this.waitForElementEndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search input element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking", 5);

    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementEndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Cannot find search result with substring " + substring,5);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON,"Cannot find search cancel button ",5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"Search cancel button is still present",5);
    }

    public void clickCanselSearch()
    {
        this.waitForElementEndClick(SEARCH_CANCEL_BUTTON,"Cannot find and click search cancel button ",5);
    }


    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementEndClick(search_result_xpath,"Cannot find and click search result with substring " + substring,5);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(SEARCH_RESULT_ELEMENT, "Cannot find anything by request", 15);
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result lable", 15);
    }

    public void assertThereIsNotResultLabel()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    public void waitForClearResult()
    {
        this.waitForElementAndClear(CLEAR_SEARCH_RESULT, "Cannot clear search", 5);
    }

    public void waitForSearchResultsToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_RESULT_BY_SUBSTRING_TPL,"Search cancel button is still present",5);
    }

    public void assertElementTitlePresent()
    {
        this.assertElementPresent(TITLE, "We supposed not to find any results");
    }
}
