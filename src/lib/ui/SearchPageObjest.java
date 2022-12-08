package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPageObjest extends MainPageObject{

    private static final String
        SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
        SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
        SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']",
        SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
        SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']",
        CLEAR_SEARCH_RESULT = "org.wikipedia:id/search_src_text";
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
        this.waitForElementEndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search input element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking", 5);

    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementEndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),"Cannot find search result with substring " + substring,5);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON),"Cannot find search cancel button ",5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON),"Search cancel button is still present",5);
    }

    public void clickCanselSearch()
    {
        this.waitForElementEndClick(By.id(SEARCH_CANCEL_BUTTON),"Cannot find and click search cancel button ",5);
    }


    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementEndClick(By.xpath(search_result_xpath),"Cannot find and click search result with substring " + substring,5);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(By.xpath(SEARCH_RESULT_ELEMENT), "Cannot find anything by request", 15);
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result lable", 15);
    }

    public void assertThereIsNotResultLabel()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any results");
    }

    public void waitForClearResult()
    {
        this.waitForElementAndClear(By.id(CLEAR_SEARCH_RESULT), "Cannot clear search", 5);
    }

    public void waitForSearchResultsToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_RESULT_BY_SUBSTRING_TPL),"Search cancel button is still present",5);
    }

}
