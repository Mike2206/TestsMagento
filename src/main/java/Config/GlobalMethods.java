package Config;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GlobalMethods extends Initial {
    private Config.PageObjectPattern PageObjectPattern;

    public GlobalMethods() {
        PageObjectPattern = new PageObjectPattern();
    }

    public boolean testTittle(String text) {
        boolean result;
        boolean tittle = driver.getTitle().equals(text);
        if (tittle) {
            result = true;
            System.out.println("Tittle is correct");
        } else {
            result = false;
            System.out.println("Tittle is incorrect");
        }
        return result;

    }

    public boolean textInElement(WebElement element, String text) {
        try {
            gWait.until(ExpectedConditions.textToBePresentInElement(element, text));
            System.out.println("Tekst został odnaleziony");
            return true;
        } catch (TimeoutException e1) {
            System.out.println("Tekst nie został odnaleziony w podanym czasie");
            return false;
        } catch (Exception e2) {
            System.out.println("Element nie został znaleziony.");
            System.out.println(e2.getMessage());
            System.out.println(e2.getStackTrace());
        }   return false;

    }
}

