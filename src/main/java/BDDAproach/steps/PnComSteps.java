package BDDAproach.steps;

import BDDAproach.pages.Category;
import BDDAproach.pages.Home;
import BDDAproach.pages.PageFactory;
import BDDAproach.pages.SearchResult;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PnComSteps {
    private static int productAmount;
    private static String productName;

    private Category categoryPage;
    private Home home;
    private SearchResult searchResult;

    public PnComSteps(PageFactory pageFactory){
        categoryPage = pageFactory.newCategory();
        home = pageFactory.newHome();
        searchResult = pageFactory.newSearchResult();
    }

    @Given("I am on pn.com.ua")
    public void homepageOnPnComUa() {
        home.go();
    }

    @When("I select category $category")
    public void selectCategory(String category) {
        home.goToCategory(category);
    }

    @When("I select subcategory $category")
    public void selectSubCategory(String category) {
        categoryPage.goToSubCategory(category);
    }

    @When("I select minimum price $price")
    public void selectMinPrice(String price) {
        searchResult.selectMinimumPrice(price);
    }

    @When("I select maximum price $price")
    public void selectMaxPrice(String price) {
        searchResult.selectMaximumPrice(price);
    }

    @Then("search result prices is between $min and $max")
    public void verifyResultsPrices(Integer min, Integer max){
        List<Integer> prices = searchResult.resultsPrices();

        assertThat(prices, everyItem(greaterThan(min)));
        assertThat(prices, everyItem(lessThan(max)));
    }

    @When("I select producer $producer")
    public void selectProducer(String producer){
        productAmount = searchResult.selectProducer(producer);
    }

    @Then("search result amount is equal to number beside producer")
    public void verifyProductAmount(){
        assertThat(searchResult.getResultNumber(), equalTo(productAmount));
    }

    @Then("search result names are start with $producer")
    public void verifyProductNames(String producer){
        assertThat(searchResult.getProducersFromNames(), everyItem(equalTo(producer)));
    }

    @When("I sort products by price")
    public void sortByPrice(){
        searchResult.sortByPrice();
    }

    @When("I choose the first product in result")
    public void getFirstResult(){
        productName = searchResult.getFirstResultName();
    }

    @When("I tap product name to search")
    public void searchProduct(){
        home.search(productName);
    }

    @Then("search result amount is equal to $number")
    public void verifyProductAmount(Integer number){
        assertThat(searchResult.getResultNumber(), equalTo(number));
    }

    @Then("search result name is equal to product name")
    public void verifyFirstProductName(){
        assertThat(searchResult.getFirstResultName(), equalTo(productName));
    }

}
