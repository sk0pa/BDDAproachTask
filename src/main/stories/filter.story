Meta:

Narrative:
As a user
I want to filter search results
So that I can easily find needed product

Scenario: Check price filter

Given I am on pn.com.ua
When I select category Компьютеры
And I select subcategory Мониторы
And I select minimum price 2000
And I select maximum price 5000
Then search result prices is between 2000 and 5000

Scenario: Check producer filter

Given I am on pn.com.ua
When I select category Компьютеры
And I select subcategory Мониторы
And I select producer ASUS
Then search result amount is equal to number beside producer
And search result names are start with ASUS

Scenario: Check search

Given I am on pn.com.ua
When I select category Компьютеры
And I select subcategory Мониторы
And I sort products by price
And I choose the first product in result
And I tap product name to search
Then search result amount is equal to 1
And search result name is equal to product name