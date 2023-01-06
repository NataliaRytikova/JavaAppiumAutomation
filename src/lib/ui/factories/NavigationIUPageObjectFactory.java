package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.NavigationUIPageObject;
import lib.ui.android.AndroidNavigationUIPageObject;
import lib.ui.ios.iOSNavigationUIPageObject;

public class NavigationIUPageObjectFactory
{
    public static NavigationUIPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUIPageObject(driver);
        }else {
            return new iOSNavigationUIPageObject(driver);
        }
    }
}
