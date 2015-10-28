package BDDAproach.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public Home newHome() {
        return new Home(webDriverProvider);
    }

    public Category newCategory() {
        return new Category(webDriverProvider);
    }

    public SearchResult newSearchResult() {
        return new SearchResult(webDriverProvider);
    }

}
