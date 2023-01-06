package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;

public class iOSNavigationUIPageObject extends NavigationUIPageObject {
    static {
        MY_LIST_LINK = "xpath://XCUIElementTypeButton[@name='Saved']";;
    }

    public iOSNavigationUIPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
