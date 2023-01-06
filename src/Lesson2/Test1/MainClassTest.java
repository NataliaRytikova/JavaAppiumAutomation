package Lesson2.Test1;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationIUPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;


public class MainClassTest extends CoreTestCase {

    @Test
    public void testCompareArticleTitle()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        SearchPageObjest SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(search_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
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
        String search_line = "Java";
        String search_title = "Java (programming language)";
        SearchPageObjest SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeTFooter();
    }

    @Test
    public void testSaveArticlesToMyList()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        String name_of_folder = "Learning programming";
        SearchPageObjest SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(search_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleByNameElement(search_title);
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else
        {
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUIPageObject NavigationUIPageObject = NavigationIUPageObjectFactory.get(driver);
        NavigationUIPageObject.clickMyList();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        } else
        {
            MyListsPageObject.closeDialog();
        }
        MyListsPageObject.swipeByArticleToDelete(search_title);
    }

    @Test
    public void testSaveTwoArticlesToMyList()
    {
        String search_line1 = "Java";
        String search_line2 = "Appium";
        String search_title1 = "Java (programming language)";
        String search_title2 = "Appium";
        String name_of_folder = "Learning programming";
        SearchPageObjest SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line1);
        SearchPageObject.clickByArticleWithSubstring(search_title1);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleByNameElement(search_title1);
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else
        {
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();
        SearchPageObjest SearchPageObject2 = SearchPageObjectFactory.get(driver);
        SearchPageObject2.initSearchInput();
        SearchPageObject2.typeSearchLine(search_line2);
        SearchPageObject2.clickByArticleWithSubstring(search_title2);

        ArticlePageObject ArticlePageObject2 = ArticlePageObjectFactory.get(driver);
        ArticlePageObject2.waitForTitleByNameElement(search_title2);
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject2.addArticleToMyList(name_of_folder);
        } else
        {
            ArticlePageObject2.addArticleToMySaved();
        }
        ArticlePageObject2.closeArticle();

        NavigationUIPageObject NavigationUIPageObject = NavigationIUPageObjectFactory.get(driver);
        NavigationUIPageObject.clickMyList();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        } else
        {
            MyListsPageObject.closeDialog();
        }
        MyListsPageObject.swipeByArticleToDelete(search_title1);
        MyListsPageObject.waitForArticleToApearByTitle(search_title2);
        MyListsPageObject.waitForArticleToDissapearByTitle(search_title1);
    }


}