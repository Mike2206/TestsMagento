package Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectPattern extends Initial {

    public PageObjectPattern(){
        PageFactory.initElements(driver,this);
    }

    //Order a quote
    @FindBy(xpath = "//*[@id=\"pricing-modal-link\"]")
    public WebElement OrderAQuoteButtonMainSite;
    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement YourNameFieldOrderAQuoteTab;
    @FindBy(xpath = "//*[@name=\"your_company\"]")
    public WebElement YourCompanyFieldOrderAQuoteTab;
    @FindBy(xpath = "//*[@name=\"your_email\"]")
    public WebElement EmailFieldOrderAQuoteTab;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    public WebElement YourPhoneFieldOrderAQuoteTab;
    @FindBy(xpath = "//*[@name=\"your-consent\"]")
    public WebElement YourConsentCheckbox;
    @FindBy(xpath = "//*[@id=\"message\"]")
    public WebElement MessageFieldOrderAQuoteTab;
    @FindBy(xpath = "//*[@id=\"pricing-modal\"]//input[contains(@class, 'wpcf7-submit')]")
    public WebElement OrderAQuotationButton;
    @FindBy(xpath = "//*[@id=\"wpcf7-f929-o2\"]//div[contains(@class, 'wpcf7-response-output')]")
    public WebElement MessageAfterOrderOrderAQuoteTab;

    //Contact Us
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[6]/a")
    public WebElement ContactUsButtonMainPage;
    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div")
    public WebElement CookieDisclaimerAcceptButton;
    @FindBy(xpath = "//*[@id=\"wpcf7-f1405-o1\"]/form/div[8]/input")
    public WebElement SendMessageButtonContactUsTab;
    @FindBy(xpath = "//*[@id=\"wpcf7-f1405-o1\"]//div[contains(@class, 'wpcf7-response-output')]")
    public WebElement SendMessageContactUsTab;

    //B2B Offer
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[1]/a")
    public WebElement OfferTabMainSite;
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[1]/div/ul/li[2]/a")
    public WebElement ECommerceB2BTab;
    @FindBy(xpath = "//*[@name=\"your-consent\"]")
    public WebElement YourConsentCheckboxB2BOfferTab;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/aside/div/div/form/div[9]/input")
    public WebElement OrderAQuotationB2BOfferTab;
    @FindBy(xpath = "//*[@id=\"wpcf7-f929-o1\"]//div[contains(@class, 'wpcf7-response-output')]")
    public WebElement SentMessageConfirmationB2BTab;

    //B2C Offer
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[1]/div/ul/li[3]/a")
    public WebElement ECommerceB2CTab;

    //ERP Integration
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[1]/div/ul/li[4]/a")
    public WebElement ERPIntergrationTab;

    //UX and Analytics
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[1]/div/ul/li[5]/a")
    public WebElement UXandAnalytics;

    //Dedicated Apps
    @FindBy(xpath = "//*[@id=\"nav\"]/div/div/div/ul/li[1]/div/ul/li[6]/a")
    public WebElement DedicatedApps;
}