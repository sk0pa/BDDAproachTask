package BDDAproach.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;

public class Home extends FluentWebDriverPage {

    public Home(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void go() {
        get("pn.com.ua");
    }

    public void search(String product) {
        input(id("edit-name-1")).sendKeys(product);
        input(id("edit-submit-1")).click();
    }

    public void goToCategory(String category) {
        link(linkText(category)).click();
    }
}
