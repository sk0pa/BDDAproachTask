package BDDAproach.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.openqa.selenium.By.xpath;

public class SearchResult extends FluentWebDriverPage {

    public SearchResult(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void selectMinimumPrice(String price){
        link(xpath("//a[contains(@href,'fp1="+price+"')]")).click();
    }

    public void selectMaximumPrice(String price){
        link(xpath("//a[contains(@href,'fp2="+price+"')]")).click();
    }

    public int selectProducer(String producer){
        String amount = this.findElement(By.xpath("//a[text()='"+producer+"']/following-sibling::i[1]")).getText();
        amount = Pattern.compile("[^()]+").matcher(amount).group();
        int productNumber = Integer.valueOf(amount);
        link(xpath("//a[contains(@href, '?fo') and text()='"+producer+"']")).click();
        return productNumber;
    }

    public List<Integer> resultsPrices(){
        FluentWebElements pricesElements = divs(xpath("//div[@class='price']/strong"));
        List<Integer> prices = new ArrayList<Integer>();
        for(FluentWebElement element: pricesElements){
            String stPrice = element.getText().toString().replace(" ", "").replace("грн", "");
            prices.add(Integer.valueOf(stPrice));
        }
        return prices;
    }

    public int getResultNumber(){
        return Integer.valueOf(b(xpath("//div[@class='total']/b")).getText().toString());
    }

    public List<String> getResultsNames(){
        FluentWebElements elements = links(xpath("//div[@class='name']/a"));
        List<String> elementsNames = new ArrayList<String>();
        for(FluentWebElement element: elements){
            elementsNames.add(element.getText().toString());
        }
        return elementsNames;
    }

    public List<String> getProducersFromNames(){
        List<String> names = getResultsNames();
        List<String> results = new ArrayList<String>();
        for(String name: names){
            results.add(name.split("\\s+")[0]);
        }
        return results;
    }

    public void sortByPrice(){
        link(xpath("//a[contains(@href,'sort=price')]")).click();
    }

    public String getFirstResultName(){
        return link(xpath("//div[@class='name']/a")).getText().toString();
    }
}
