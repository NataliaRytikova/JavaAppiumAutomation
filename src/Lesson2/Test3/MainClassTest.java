package Lesson2.Test3;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObjest;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        SearchPageObjest SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(search_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();

        this.rotateScreenLandscape();

        String title_after_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_after_rotation,
                title_after_second_rotation
        );
    }



    @Test
    public void testTitleSearch()
    {
        String search_line = "Java";
        String search_title = "Java (programming language)";
        SearchPageObjest SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(search_title);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        SearchPageObject.assertElementTitlePresent();
    }
}