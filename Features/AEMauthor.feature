#Author: jaivyas@98gmail.com
#Keywords Summary : Selenium_BDD_framework
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: To Automate AEM
  	
  I want to use this template for my feature file

  @ToPerformBasicAEMFunctions(AEMdataSetup)
  Scenario: [AEM][TO CREATE PAGE WITH DESIRED PROPERTIES] To Create any page with all the desired properties
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/romania"
    Then select path "europe/romania/it"
    Then select path "europe/romania/it/off-road"
    Then select path "europe/romania/it/off-road/atv"
    Then select thumbnail at "europe/romania/it/off-road/atv"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 1 "KAW Product Detail Page"
    Then creating page with desired properties
      | Title |  | Name  |  | Description           |
      | ATV-2 |  | atv-2 |  | This is a description |
    
  @addingacomponentandeditingit
  Scenario: [AEM][ADD COMPONENT] To add and a component to a page and edit it
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Testauthor" Environment
    When enter "Testauthor" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autostructure"
    Then select path "playground/autostructure/autohomepage"
    Then select thumbnail at "playground/autostructure/autohomepage"
    Then click on coralactionbar button "Edit"
    Then add the component "KAW Image" to 3
    Then Select the component "KAW Image" and click on the desired editable toolbar option "Configure"

  Scenario: [AEM][ROLLOUT BLUEPRINT CHANGES] To rollout changes from blueprint to live copy
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/ro"
    Then select thumbnail at "europe/ro/autoen2"
    Then click on railtoggle button and select "References"
    Then click on blueprint under references
    Then select the livecopy to rollout blueprintchanges "/content/europe/ro/autoen2"

  Scenario: [AEM][CREATE LIVE COPY] To Create a live copy
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Testauthor" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/ro"
    Then select path "europe/ro/it"
    Then select thumbnail at "europe/ro/it"
    Then click on coralactionbar button "create"
    Then select the particular create option "live copy"
    Then select destinition path for live copy "europe"
    Then select destinition path for live copy "europe/ro"
    Then select thumbnail at "europe/ro"
    Then create a live copy with title "automatedlivecopy2" and name "autoen2"

  Scenario: [AEM][TO EDIT PAGE PROPERTIES] To Edit Page Properties of an already created page and open the page
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/ro"
    Then select path "europe/ro/autoen"
    Then select thumbnail at "europe/ro/autoen"
    Then click on coralactionbar button "Properties"
    Then select and edit the particular page property
      | Title                             |  | Name                         |  | cookiepolicy                                                                                                                                                                                                                                                                                                                                                      |  | cookietitle   |  | cookiebtntext |
      | Automated Archieved Productedited |  | autoarchieved-productsedited |  | We use cookies to ensure that we give you the best experience on our website. By clicking Agree button, you allow us to use cookies. If you do not accept, it is passible that some parts of this website will not function correctly. However, if you would like to, you can charge your cookie settings at anytime. For more information see our Privacy Policy |  | cookie policy |  | cookiebtn     |
    Then select path "europe"
    Then select path "europe/ro"
    Then select path "europe/ro/autoen"
    Then select thumbnail at "europe/ro/autoen"
    Then click on coralactionbar button "edit"
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"

  Scenario: [AEM][TO EDIT A PAGE] To Edit an already created page
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/ro"
    Then select path "europe/ro/it"
    Then select path "europe/ro/it/bikes-and-vehicles"
    Then select path "europe/ro/it/bikes-and-vehicles/motorcross"
    Then select thumbnail at "europe/ro/it/bikes-and-vehicles/motorcross/motocross-1"
    Then click on coralactionbar button "Edit"

  Scenario: [AEM][TO ADD A COMPONENT TO A PAGE AND EDIT IT] To add and a component to a page and edit it
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/ro"
    Then select path "playground/ro/promotions"
    Then select thumbnail at "playground/ro/promotions"
    Then click on coralactionbar button "Edit"


    Scenario: [Data Setup][Create Kawasaki Site Pages]To create kawasaki Site Pages.
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Testauthor" Environment
    When enter "Testauthor" Credentials
    Then navigate to sites
    Then select thumbnail at "playground"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 0 "KAW Structure template"
    Then creating page with desired properties
      | Title |  | Name  |            
      | AutoStructure|  |autostructure|  
    Then select thumbnail at "playground/autostructure"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 0 "KAW Homepage template"
    Then creating page with desired properties
      | Title        || Name        || cookietitle ||cookiebtntext|| cookiepolicy |                                                                                                                                                                                                                                                                                                                                                       
      | AutoHomepage || autohomepage|| autocookie policy ||autocookiebtn||We use cookies to ensure that we give you the best experience on our website. By clicking "Agree" button, you allow us to use cookies. If you do not accept, it is passible that some parts of this website will not function correctly. However, if you would like to, you can charge your cookie settings at anytime. For more information see our Privacy Policy |
    Then select path "playground"
    Then select thumbnail at "playground/autostructure"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 1 "KAW Multilingual template"
    Then creating page with desired properties
      | Title        || Name        |                                                                                                                                                                                                                                                                                                                                                      
      | AutoMultilingualpage || automultilingualpage|  
    Then select thumbnail at "playground/autostructure/autohomepage"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 2 "KAW News overview template"
    Then creating page with desired properties
      | Title        || Name        |                                                                                                                                                                                                                                                                                                                                                      
      | Auto News & Experience || news-and-experience|
    Then select thumbnail at "playground/autostructure/autohomepage"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 0 "KAW About Overview template"
    Then creating page with desired properties
      | Title        || Name        |                                                                                                                                                                                                                                                                                                                                                      
      | Auto About Kawasaki|| about-kawasaki|
    Then select thumbnail at "playground/autostructure/autohomepage"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 0 "KAW About Overview template"
    Then creating page with desired properties
      | Title        || Name        |                                                                                                                                                                                                                                                                                                                                                      
      | Auto Support|| support|
    Then select thumbnail at "playground/autostructure/autohomepage"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 5 "KAW Structure template"
    Then creating page with desired properties
      | Title        || Name  	|                                                                                                                                                                                                                                                                                                                                                      
      | tools|| |
    Then select thumbnail at "playground/autostructure/autohomepage"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 5 "KAW Structure template"
    Then creating page with desired properties
      | Title        || Name  	|                                                                                                                                                                                                                                                                                                                                                      
      | meta|| |
    #Then select thumbnail at "playground/autostructure/autohomepage"
    #Then click on coralactionbar button "Create"
    #Then select the particular create option "page"
    #Then choose the template number 7 "KAW Redirect template"
    #Then creating page with desired properties
      #| Title || Name  	|                                                                                                                                                                                                                                                                                                                                                      
      #| More| | more |
    Then select path "playground/autostructure/autohomepage/news-and-experience"
    Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 0 "KAW News Overview Template"
    Then creating page with desired properties
      | Title        || Name  	|                                                                                                                                                                                                                                                                                                                                                      
      | Road-race|| road-race|
    Then select path "playground/autostructure/autohomepage/news-and-experience"
    Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 0 "KAW News Overview Template"
    Then creating page with desired properties
      | Title || Name  	|                                                                                                                                                                                                                                                                                                                                                      
      | Events|| events|
    Then select path "playground/autostructure/autohomepage/support"
    Then select thumbnail at "playground/autostructure/autohomepage/support"
    Then click on coralactionbar button "Create"
    Then select the particular create option "page"
    Then choose the template number 1 "KAW Content template with slide navigation"
    Then creating page with desired properties
      | Title || Name  	|                                                                                                                                                                                                                                                                                                                                                      
      | Legal|| legal   |
      Then select thumbnail at "playground/autostructure/autohomepage/meta"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 0 "KAW Content template"
      Then creating page with desired properties
        | Title || Name |
        | Thank-you|| thank-you|
      Then select thumbnail at "playground/autostructure/autohomepage/meta"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 0 "KAW Content template"
      Then creating page with desired properties
        | Title || Name |
        | Search results||search-results|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 0 "KAW Configurator iframe"
      Then creating page with desired properties
        | Title || Name |
        | BikeConfigurator||bikeconfigurator|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 2 "KAW Dealer finder template"
      Then creating page with desired properties
        | Title || Name |
        | Find a Dealer||find-a-dealer|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 4 "KAW Product comparision template"
      Then creating page with desired properties
        | Title || Name |
        |Comparision page ||comparision-page|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 1 "KAW content page template"
      Then creating page with desired properties
        | Title || Name |
        |Product comparision collector||product-comparision-collector|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 1 "KAW content page template"
      Then creating page with desired properties
        | Title || Name |
        |Shopping cart||shopping-cart|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 1 "KAW content page template"
      Then creating page with desired properties
        | Title || Name |
        |Take a kawasaki for a test ride||take-a-kawasaki-for-a-test-ride|
      Then select thumbnail at "playground/autostructure/autohomepage/tools"
      Then click on coralactionbar button "Create"
      Then select the particular create option "page"
      Then choose the template number 1 "KAW content page template"
      Then creating page with desired properties
        | Title || Name |
        |Wish list||wishlist|
    @KawasakiAuthoring
    Scenario: [Data Setup][Create KawasakiProduct catalogs]To create kawasaki product catalogs.
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Testauthor" Environment
    When enter "Testauthor" Credentials
    Then navigate to sites 
    Then select path "playground"
    Then select path "playground/autostructure"
    Then select path "playground/autostructure/autohomepage"
    Then select path "playground/autostructure/autohomepage/news-and-experience"
    Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "catalog"
    Then select the blueprint
    Then select the catalog blueprint folder 0
    Then select the catalog blueprint folder 1
    Then select the select button
    Then select the particular category catalog 3
    Then select the next button 0
    Then Enter the Title of the catalog "ATV/MULE" and Name of the catalog "off-road"
    Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "catalog"
    Then select the blueprint
    Then select the catalog blueprint folder 0
    Then select the catalog blueprint folder 1
    Then select the select button
    Then select the particular category catalog 4
    Then select the next button 0
    Then Enter the Title of the catalog "Motorcycles" and Name of the catalog "bikes-and-vehicles"
    Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "catalog"
    Then select the blueprint
    Then select the catalog blueprint folder 0
    Then select the catalog blueprint folder 1
    Then select the select button
    Then select the particular category catalog 2
    Then select the next button 0
    Then Enter the Title of the catalog "JetSki" and Name of the catalog "jetski"
     Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "catalog"
    Then select the blueprint
    Then select the catalog blueprint folder 0
    Then select the catalog blueprint folder 1
    Then select the select button
    Then select the particular category catalog 0
    Then select the next button 0
    Then Enter the Title of the catalog "Clothing & merchanside" and Name of the catalog "clothing-merchandise"
    Then select thumbnail at "playground/autostructure/autohomepage/news-and-experience"
    Then click on coralactionbar button "Create"
    Then select the particular create option "catalog"
    Then select the blueprint
    Then select the catalog blueprint folder 0
    Then select the catalog blueprint folder 1
    Then select the select button
    Then select the particular category catalog 1
    Then select the next button 0
    Then Enter the Title of the catalog "Parts and Accessories" and Name of the catalog "parts-and-accessories"
   
    
    
    
  
  @KawasakiHomePageSmokeTests
  Scenario: [Smoke][KAW Cookie]To Verify that the Cookie Notice is displayed as Expected or not.
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Verify if the following cookie message is geting displayed or not and Cookie notice and setting button is properly redirected
      | cookiepolicy                                                                                                                                                                                                                                                                                                                                                        |
      | We use cookies to ensure that we give you the best experience on our website. By clicking "Agree" button, you allow us to use cookies. If you do not accept, it is passible that some parts of this website will not function correctly. However, if you would like to, you can charge your cookie settings at anytime. For more information see our Privacy Policy |
    Then Click on cookie policy I agree button
   

  Scenario: [Smoke][KAW CTA Box] To verify that the 3 CTA boxes are displayed
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then check if the CTA boxs are Present and displayed
    

  Scenario: [Smoke][KAW Footer] To verify that all Footer links in the footer are clickable and opening as expected
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then click on each footer links and check one by one
    

  Scenario: [Smoke][KAW Subnavigation]To verify that all subnavigations links are clickable and opening as expected
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then click on each subnavigation links and check one by one
    

  Scenario: [Smoke][KAW Subnaviagtion GreenLinks]To verify that all green links in the subnaviagtions are clickable and opening as expected
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then click on each subnavigation green links and check one by one
    
  Scenario: [Smoke][KAW Footer] To verify that Footer component is present or not
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then check if the footer component is present or not
     

  Scenario: [Smoke][KAW Calender]To verify that Calender component is present or not
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then check if the calender compopnent is present or not
   

  Scenario: [Smoke][KAW Text and Link]To verify that Text and link Component is Present or not
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then Click on cookie policy I agree button
    Then check if the text with link component is present or not
    

  Scenario: [Smoke][KAW Cookie]To Verify that the Cookie Notice can be edited.
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/ro"
    Then select thumbnail at "europe/ro/autoen"
    Then click on coralactionbar button "properties"
    Then select and edit the particular page property
      | cookiepolicy                                                                                                                                                                                                                                                                                                                                                                                                  |
      | This is an automated change for Kawasaki :- We use cookies to ensure that we give you the best experience on our website. By clicking Agree button, you allow us to use cookies. If you do not accept, it is passible that some parts of this website will not function correctly. However, if you would like to, you can charge your cookie settings at anytime. For more information see our Privacy Policy |
    Then select thumbnail at "europe/ro/autoen"
    Then click on coralactionbar button "edit"
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    

  Scenario: [Smoke][KAW Cookie]To verify that Text and link Component is Present or not
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentials
    Then navigate to sites
    Then select path "europe"
    Then select path "europe/ro"
    Then select thumbnail at "europe/ro/autoen"
    Then click on coralactionbar button "edit"
    Then check if the text with link component is present or not
    

  @KawasakiRegressionforHomePage[6]
  Scenario: [Regression][KAW Footer Component]To Verify that footer component can be edited[HOMEPAGE].
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autoro"
    Then select path "playground/autoro/it"
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "Edit"
    Then Select the component "KAW Social Media Linklist" and click on the desired editable toolbar option "Configure"
    Then Select the component "KAW List" and click on the desired editable toolbar option "Configure"
    Then Select the component "KAW CTA BOX Component" and click on the desired editable toolbar option "Configure"
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    

  Scenario: [Regression][KAW TEXT WITH LINK Component]To Verify that more text with link component can be added to the page from a parsys[HOMEPAGE]
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autoro"
    Then select path "playground/autoro/it"
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "Edit"
    Then add the component "KAW Text with Link" to 3
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    Then Verify if the following properties for the component "KAW Text with Link"
      | link text title    |
      | KAW Text with Link |
    

  Scenario: [Regression][KAW CTA Box Component]To verify that Text and link Component is Present or not and can be configured[HOMEPAGE]
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autoro"
    Then select path "playground/autoro/it"
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "edit"
    Then Select the component "KAW CTA Box Component" and click on the desired editable toolbar option "Configure"
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    Then Click on cookie policy I agree button
    Then Verify if the following properties for the component "KAW CTA Box Component"
      | KAW CTA Box Component title |
      | KAW CTA Box Component       |
    

  Scenario: [Regression][KAW Text and Link]To verify that Text and link Component is Present or not and can be configured[HOMEPAGE]
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autoro"
    Then select path "playground/autoro/it"
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "edit"
    Then Select the component "KAW Text with Link" and click on the desired editable toolbar option "Configure"
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    Then Click on cookie policy I agree button
    Then Verify if the following properties for the component "KAW Text with Link"
      | link text title    |
      | KAW Text with Link |
    

  Scenario: [Regression][KAW Cookie Message]To Verify that the Cookie Notice can be edited[HOMEPAGE].
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autoro"
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "properties"
    Then select and edit the particular page property
      | Title                             |  | Name                         |  | cookiepolicy                                                                                                                                                                                                                                                                                                                                                            |  | cookietitle   |  | cookiebtntext |  | link text                          |  | link to                                     |
      | Automated Archieved Productedited |  | autoarchieved-productsedited |  | We use cookies 12345 to ensure that we give you the best experience on our website. By clicking Agree button, you allow us to use cookies. If you do not accept, it is passible that some parts of this website will not function correctly. However, if you would like to, you can charge your cookie settings at anytime. For more information see our Privacy Policy |  | cookie policy |  | cookiebtn     |  | Cookie notice & Settings automated |  | /content/playground/autoro/it/support/legal |
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "edit"
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    Then Verify if the following cookie message is geting displayed or not and Cookie notice and setting button is properly redirected
      | cookiepolicy                                                                                                                                                                                                                                                                                                                                                            |  | link text                          |  | Cookie notice title |
      | We use cookies 12345 to ensure that we give you the best experience on our website. By clicking Agree button, you allow us to use cookies. If you do not accept, it is passible that some parts of this website will not function correctly. However, if you would like to, you can charge your cookie settings at anytime. For more information see our Privacy Policy |  | Cookie notice & Settings automated |  | Cookie Notice       |
    

  Scenario: [Regression][KAW Calender Component]To Verify that  Calender component can be added to the page from a parsys
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Test" Environment
    When enter "Test" Credentials
    Then navigate to sites
    Then select path "playground"
    Then select path "playground/autoro"
    Then select path "playground/autoro/it"
    Then select thumbnail at "playground/autoro/it"
    Then click on coralactionbar button "Edit"
    Then add the component "KAW Calendar Component" to 3
    Then click pageinfobutton
    Then click on particular pageinfobutton "view as published"
    Then Verify if the following properties for the component "KAW Text with Link"
      | link text title    |
      | KAW Text with Link |
     

  @ProductCategoryPageSmokeStage
  Scenario: To Verify Product Card
    Given invokebrowser
    And Delete all cookies
    And intialize aem author instance in "Stage" Environment
    When enter "Stage" Credentialss
    When enter Credentials
    Then Click on cookie policy I agree button
    Then click each accordian one by one and check the details on the product cards
    

  @usingexamples
  Scenario Outline: To undestanding using the examples
    Then user enters the "<username>" and "<password>"

    #Examples with scenario outline makes the whole test case run for 2 times fully with different data
    Examples: 
      | username |  | password |
      | jai1811  |  | jai@123  |
