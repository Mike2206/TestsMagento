package Tests;
import Config.GlobalMethods;
import Config.Initial;
import Config.PageObjectPattern;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests extends Initial {
    //Config
    private Config.GlobalMethods GlobalMethods;
    private Config.PageObjectPattern PageObjectPattern;
    private Actions Builder;
    //Wariables
    private String urlAddress1 = "";
    private String urlAddress2 = "";
    private String urlAddress3 = "";
    private String userName = "AUTOMATION";
    private String userCompany = "AUTOMATION";
    private String emailAdress = "AUTOMATION@automation.pl";
    private String yourPhone = "444555666";
    private String message1 = "AUTOMATION script - Order a Quote";
    private String message2 = "AUTOMATION script - Contact Us";
    private String message3 = "AUTOMATION script - B2B Offer";
    private String message4 = "AUTOMATION script - B2C Offer";
    private String message5 = "AUTOMATION script - ERP Integration";
    private String message6 = "AUTOMATION script - UX and Analytics";
    private String message7 = "AUTOMATION script - Dedicated Apps";
    private String message8 = "AUTOMATION script - Domain To Be Audited";

    @BeforeTest
    public void setUpBeforeClass() {
        invokeBrowser();
        Builder = new Actions(driver);
        GlobalMethods = new GlobalMethods();
        PageObjectPattern = new PageObjectPattern();
    }

    @AfterTest
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @Test(priority = 1)
    public void checkTittle() {
        System.out.println("...Starting Test 1...");
        driver.get(urlAddress1);
        Assert.assertTrue(GlobalMethods.testTittle(""));
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
        PageObjectPattern.PricingModalCloseButton.click();
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
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
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
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ECommerceB2BTab)).click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message3);
        js.executeScript("window.scrollTo(0,5000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 5)
    public void b2cOffer() {
        System.out.println("...Starting Test 5...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ECommerceB2CTab)).click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message4);
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 6)
    public void erpIntegration() {
        System.out.println("...Starting Test 6...");
        js.executeScript("window.scrollTo(0,-4000)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ERPIntergrationTab)).click();
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message5);
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));

    }

    @Test(priority = 7)
    public void uXandAnalytics() {
        System.out.println("...Starting Test 7...");
        js.executeScript("window.scrollTo(0,-4000)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.UXandAnalyticsTab)).click();
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message6);
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 8)
    public void dedicatedApps() {
        System.out.println("...Starting Test 8...");
        js.executeScript("window.scrollTo(0,-4000)");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.DedicatedAppsTab)).click();
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message7);
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BTab, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 9)
    public void newsLetter() {
        System.out.println("...Starting Test 9...");
        js.executeScript("window.scrollTo(0,9000)");
        PageObjectPattern.NewsLetterEmailField.sendKeys(emailAdress);
        PageObjectPattern.YourConsentNewsletter.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.SignUpButton.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.ConfirmationTabNewsletter, "Confirm your e-mail in your e-mail client. Thank you!"));
    }

    @Test(priority = 10)
    public void userExpierienceAudit() {
        System.out.println("...Starting Test 10...");
        driver.get(urlAddress3);
        js.executeScript("window.scrollTo(0,1000)");
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.DomainToBeAuditedField.sendKeys(message8);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message8);
        Builder.release();
        Builder.moveToElement(PageObjectPattern.ConsentUserExpierienceAuditTab).click();
        Builder.perform();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.RequestUxAuditButton.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.ConfirmationTabUserExpierienceAudit, "Your message has been sent. Thank you!"));
    }

    @Test(priority = 11)
    public void checkTittlePL() {
        System.out.println("...Starting Test 11...");
        driver.get(urlAddress2);
        Assert.assertTrue(GlobalMethods.testTittle(""));
        boolean cookie = true;
        if (cookie) {
            gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.CookieDisclaimerAcceptButton)).click();
            System.out.println("Cookie Disclaimer zamknięty prawidłowo");
        }
    }

    @Test(priority = 12)
    public void orderAQuotePL() {
        System.out.println("...Starting Test 12...");
        PageObjectPattern.OrderAQuoteButtonMainSite.click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message1);
        js.executeScript("document.getElementById('pricing-modal').scrollTo(0,500)");
        Builder.moveToElement(PageObjectPattern.YourConsentCheckBoxWersjaPolska).click().build().perform();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckBoxWersjaPolska.isEnabled());
        PageObjectPattern.OrderAQuotationButton.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.ConfirmationMessageZamowWycene, "Twoja wiadomość została wysłana. Dziękujemy!"));
        PageObjectPattern.PricingModalCloseButton.click();
    }

    @Test(priority = 13)
    public void contactUsPL() {
        System.out.println("...Starting Test 13...");
        PageObjectPattern.KontaktTabPolishVersion.click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message2);
        js.executeScript("window.scrollTo(0,500)");
        Builder.moveToElement(PageObjectPattern.YourConsentCheckbox).click().build().perform();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.PrzyciskWyslijWiadomoscKontaktTab.click();
        js.executeScript("window.scrollTo(0,-500)");
    }

    @Test(priority = 14)
    public void b2bOfferPL() {
        System.out.println("...Starting Test 14...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ECommerceB2BTab)).click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message3);
        js.executeScript("window.scrollTo(0,5000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BOferta, "Twoja wiadomość została wysłana. Dziękujemy!"));
    }

    @Test(priority = 15)
    public void b2cOfferPL() {
        System.out.println("...Starting Test 15...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ECommerceB2CTab)).click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message4);
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BOferta, "Twoja wiadomość została wysłana. Dziękujemy!"));
    }

    @Test(priority = 16)
    public void erpIntegrationPL() {
        System.out.println("...Starting Test 16...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.ERPIntergrationTab)).click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message5);
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.SendButtonErpIntegracja.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BOferta, "Twoja wiadomość została wysłana. Dziękujemy!"));
    }

    @Test(priority = 17)
    public void uXandAnalyticsPL() {
        System.out.println("...Starting Test 17...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        gWait.until(ExpectedConditions.visibilityOf(PageObjectPattern.UXandAnalyticsTab)).click();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message5);
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.SendButtonErpIntegracja.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BOferta, "Twoja wiadomość została wysłana. Dziękujemy!"));
    }
    @Test(priority = 18)
    public void dedicatedAppsPL() {
        System.out.println("...Starting Test 18...");
        Builder.release();
        Builder.moveToElement(PageObjectPattern.OfferTabMainSite).clickAndHold();
        Builder.perform();
        PageObjectPattern.YourNameFieldOrderAQuoteTab.sendKeys(userName);
        PageObjectPattern.YourCompanyFieldOrderAQuoteTab.sendKeys(userCompany);
        PageObjectPattern.EmailFieldOrderAQuoteTab.sendKeys(emailAdress);
        PageObjectPattern.YourPhoneFieldOrderAQuoteTab.sendKeys(yourPhone);
        PageObjectPattern.MessageFieldOrderAQuoteTab.sendKeys(message7);
        js.executeScript("window.scrollTo(0,4000)");
        PageObjectPattern.YourConsentCheckboxB2BOfferTab.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.OrderAQuotationB2BOfferTab.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.SentMessageConfirmationB2BOferta, "Twoja wiadomość została wysłana. Dziękujemy!"));
    }

    @Test(priority = 19)
    public void newsLetterPL() {
        System.out.println("...Starting Test 19...");
        js.executeScript("window.scrollTo(0,8000)");
        PageObjectPattern.NewsLetterEmailFieldPL.sendKeys(emailAdress);
        PageObjectPattern.YourConsentNewsletterPL.click();
        Assert.assertTrue(PageObjectPattern.YourConsentCheckbox.isEnabled());
        PageObjectPattern.SignUpButtonPL.click();
        Assert.assertTrue(GlobalMethods.textInElement(PageObjectPattern.ConfirmationTabNewsletterPL, "Potwierdź Twój adres e-mail w Twojej skrzynce pocztowej. Dziękujemy!"));
    }
}

