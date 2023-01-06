package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://XCUIElementTypeStaticText[@name='Add or edit preferred languages']",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about data collected']",
    NEXT_LINK = "xpath://XCUIElementTypeStaticText[@name='Next']",
    GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']",
    SKIP = "xpath://XCUIElementTypeButton[@name='Skip']";


    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Cannot find 'Узнать подробнее о Википедии' link",10);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'Новые способы изучения'",10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
                "Cannot find 'Добавить или изменить предпочтительные языки' link",10);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Узнать подробнее о сборе данных' link",10);
    }

    public void clickNextButton()
    {
        this.waitForElementEndClick(NEXT_LINK,
                "Cannot find button 'Далее'",10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementEndClick(GET_STARTED_BUTTON,
                "Cannot find button 'Начать'",10);
    }

    public void clickSkip()
    {
        this.waitForElementEndClick(SKIP,
                "Cannot find button 'Пропустить'",10);
    }
}
