package Lesson4.Test1;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;


public class MainClassTest extends CoreTestCase {


    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCompareArticleTitle()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(search_title);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title_article = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                title_article
        );

    }


    @Test
    public void testSwipeArticle()
    {
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeTFooter();
    }

    @Test
    public void testSaveArticlesToMyList()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        String name_of_folder = "Learning programming";
        SearchPageObjest SearchPageObject = new SearchPageObjest(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(search_title);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(search_title);

    }


}