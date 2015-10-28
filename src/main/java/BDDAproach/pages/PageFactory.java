package BDDAproach.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

//    public AdvancedSearch newAdvancedSearch() {
//        return new AdvancedSearch(webDriverProvider);
//    }

    public Home newHome() {
        return new Home(webDriverProvider);
    }

    public Category newCategory() {
        return new Category(webDriverProvider);
    }

    public SearchResult newSearchResult() {
        return new SearchResult(webDriverProvider);
    }
//
//    public CartContents newCartContents() {
//        return new CartContents(webDriverProvider);
//    }
//
//    public Buy newBuy() {
//        return new Buy(webDriverProvider);
//    }
//
//    public Treasury newTreasury() {
//        return new Treasury(webDriverProvider);
//    }

}
