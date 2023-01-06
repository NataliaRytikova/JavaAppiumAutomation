package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.SearchPageObjest;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.iOSSearchPageObject;

public class SearchPageObjectFactory
{
    public static SearchPageObjest get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        }else {
            return new iOSSearchPageObject(driver);
        }
    }
}
