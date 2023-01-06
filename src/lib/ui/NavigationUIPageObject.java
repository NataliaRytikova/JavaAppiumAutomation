package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUIPageObject extends MainPageObject {
    protected static String
            MY_LIST_LINK;
    public NavigationUIPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        this.waitForElementEndClick(
                MY_LIST_LINK,
                "Cannot find navigation button to my list",
                5
        );
    }

}
