package Orba.co;
import Config.GlobalMethods;
import Config.Initial;
import Config.PageObjectPattern;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrbaTest extends Initial {
    //Config
    private OrbaTest OrbaTest;
    private Config.GlobalMethods GlobalMethods;
    private Config.PageObjectPattern PageObjectPattern;
    private Actions Builder;
    //Wariables
    private String urlAddress1 = "https://orba.co/";
    private String urlAddress2 = "https://orba.pl/";
    private String userName = "AUTOMATIONORBA";
    private String userCompany = "AUTOMATIONORBA";
    private String emailAdress = "AUTOMATIONORBA@automation.pl";
    private String yourPhone = "444555666";
    private String message1 = "ORBAAUTOMATION script - Order a Quote";
    private String message2 = "ORBAAUTOMATION script - Contact Us";
    private String message3 = "ORBAAUTOMATION script - B2B Offer";
    private String message4 = "ORBAAUTOMATION script - B2C Offer";
    private String message5 = "ORBAAUTOMATION script - ERP Integration";
    private String message6 = "ORBAAUTOMATION script - UX and Analytics";
    private String message7 = "ORBAAUTOMATION script - Dedicated Apps";

    @BeforeSuite
    public void setUpBeforeClass() {
        invokeBrowser();
        Builder = new Actions(driver);
        OrbaTest = new OrbaTest();
        GlobalMethods = new GlobalMethods();
        PageObjectPattern = new PageObjectPattern();
    }

    @AfterSuite
    public void tearDown() {
        driver.manage().deleteAllCookies();
        //driver.close();
    }

    @Test(priority = 1)
    public void checkTittle() {
        System.out.println("...Starting Test 1...");
        driver.get(urlAddress1);
        Assert.assertTrue(GlobalMethods.testTittle("Home - Orba"));
    }

    @Test(priority = 2)
    public void orderAQuote() {
        System.out.println("...Starting Test 2...");
        PageObjectPattern.OrderAQuoteButtonMainSite.click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message1);
        PageObjectPattern.YourConsentCheckbox.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        js.executeScript("document.getElementById('pricing-modal').scrollTo(0,500)");
        PageObjectPattern.OrderAQuotationButton.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.MessageAfterOrderOrderAQuoteTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 3)
    public void contactUs() {
        System.out.println("...Starting Test 3...");
        driver.get((urlAddress1));
        Assert.assertTrue(GlobalMethods.testTittle("Home - Orba"));
        PageObjectPattern.ContactUsButtonMainPage.click();
        boolean cookie = true;
        if (cookie) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.CookieDisclaimerAcceptButton)).click();
            System.out.println("Cookie Disclaimer zamknięty prawidłowo");
        }
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message2);
        js.executeScript("window.scrollTo(0,500)");
        Builder.moveToElement(PageObjectPattern.YourConsentCheckbox).click();
        Builder.perform();
        PageObjectPattern.SendMessageButtonContactUsTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SendMessageContactUsTab, "Your message has been sent. Thank you"));
    }

    @Test(priority = 4)
    public void b2bOffer() {
        System.out.println("...Starting Test 4...");
        js.executeScript("window.scrollTo(0,-500)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite);
        Builder.perform();
        boolean topBar = true;
        if (topBar) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ECommerceB2BTab)).click();
        }
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message3);
        js.executeScript("window.scrollTo(0,5000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 5)
    public void b2cOffer() {
        System.out.println("...Starting Test 5...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite);
        Builder.clickAndHold(PageObjectPattern.OfferTabMainSite);
        Builder.perform();
        boolean topBar = true;
        if (topBar) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ECommerceB2CTab)).click();
        }
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message4);
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 6)
    public void erpIntegration() {
        System.out.println("...Starting Test 6...");
        js.executeScript("window.scrollTo(0,-4000)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).build().perform();
        Builder.clickAndHold(PageObjectPattern.OfferTabMainSite);
        Builder.perform();
        boolean topBar = true;
        if (topBar) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ERPIntergrationTab)).click();
        }
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message5);
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 7)
    public void uXandAnalytics() {
        System.out.println("...Starting Test 7...");
        js.executeScript("window.scrollTo(0,-4000)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).build().perform();
        Builder.clickAndHold(PageObjectPattern.OfferTabMainSite);
        Builder.perform();
        boolean topBar = true;
        if (topBar) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.UXandAnalytics)).click();
        }
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message6);
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 8)
    public void dedicatedApps(){
        System.out.println("...Starting Test 7...");
        js.executeScript("window.scrollTo(0,-4000)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).build().perform();
        Builder.clickAndHold(PageObjectPattern.OfferTabMainSite);
        Builder.perform();
        boolean topBar = true;
        if (topBar) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.DedicatedApps)).click();
        }
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message7);
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }
}


