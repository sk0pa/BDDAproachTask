package BDDAproach.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Site extends FluentWebDriverPage {

    public Site(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

//    public int cartSize() {
//        String cartSize = within(secs(2)).div(id("cart")).getText().replace("Cart", "").trim();
//        if (cartSize.equals("")) {
//            return 0;
//        }
//        return Integer.parseInt(cartSize);
//    }

}
