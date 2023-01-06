package Lesson2.Test3;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObjest;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome()
    {
        if(Platform.getInstance().isAndroid())
        {
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStartedButton();
    }

}
