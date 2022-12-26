package Lesson2.Test2;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObjest;
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends CoreTestCase {

    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testAmountNotEmptySearch()
    {
        String search_line = "Linkin Park discography";
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found several results",
                amount_of_search_results > 0
        );

    }

    @Test
    public void testAmountEmptySearch()
    {
        String search_line = "sgsgwrytjyet5y";
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNotResultLabel();

    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCanselSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testSearchAndSkip()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(search_title);
        SearchPageObject.waitForClearResult();
        SearchPageObject.waitForSearchResultsToDisappear();
    }

}