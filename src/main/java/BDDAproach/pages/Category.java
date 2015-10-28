package BDDAproach.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import static org.openqa.selenium.By.linkText;

public class Category extends FluentWebDriverPage {

    public Category(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void goToSubCategory(String category) {
        link(linkText(category)).click();
    }

}
