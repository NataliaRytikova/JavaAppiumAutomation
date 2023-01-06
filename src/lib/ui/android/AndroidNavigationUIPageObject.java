package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;

public class AndroidNavigationUIPageObject extends NavigationUIPageObject {
    static {
        MY_LIST_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";;
    }

    public AndroidNavigationUIPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
