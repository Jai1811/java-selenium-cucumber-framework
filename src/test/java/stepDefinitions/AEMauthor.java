package stepDefinitions;

//import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Eyes;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import coeur.Properties;
import coeur.Reports;
import coeur.RestassuredApi;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fonctionscommunes.AEMFunctions;
import fonctionscommunes.Applitoolslib;
import fonctionscommunes.CommonFunction;
import io.github.bonigarcia.wdm.WebDriverManager;
import webelementsinventory.AEMPageObjects;
import webelementsinventory.AllComponents;
import webelementsinventory.HomePageComponents;

public class AEMauthor extends CommonFunction {


	ExtentTest reportTest;
	Applitoolslib initiateApplitoolslib = new Applitoolslib();
	Eyes eyes;
	RestassuredApi apiServices = new RestassuredApi();

	@Before
	public void init(Scenario scenario) {
WebDriverManager.chromedriver().setup();
		reportTest = Reports.getInstance(scenario.getName());
		try 
		{
		int code = apiServices.getData(Properties.getProperties("APIURL"));
		System.out.println("code : "+code);
		if(code==200)
		{
			System.out.println("RestFul services methods authetication is succesfull");
		}
		else
			System.out.println("RestFul services methods Authentication failed");
			
		}catch (Exception e) {
			
		}
		

	}
//"1.  \(.*)\"- RE
		
	@Given("^invokebrowser$")
	public void invokeBrowser() throws InterruptedException
	{
		cfinvokeBrowser();
	eyes = initiateApplitoolslib.setApplitoolsApikey();
	eyes.open(driver, "AEM","TEST CASE FOR APPLITOOLS CONFIGURATION");
		Reports.updateReportLog(LogStatus.INFO,"Invoking the browser", "Browser invoked sucessfully");
		
	}
	@And("^intialize aem author instance in \"([^\"]*)\" Environment$")
	public void intialize_aem_author_instance(String Environment) throws IOException {
		AEMFunctions.intializeAemAuthorInstance(Environment);
		Reports.updateReportLog(LogStatus.INFO, "Opening aem author instance","aem author instance opened sucessfull" );
	}
	@And("^Delete all cookies$")
	public void delete_all_cookies() {

		CommonFunction.deleteCookies();

	}
	@When("^enter \"([^\"]*)\" Credentials$")
	public void enter_Credentials(String Environment) throws IOException, InterruptedException {
		AEMFunctions.enterCredentials(Environment);
		Reports.updateReportLog(LogStatus.INFO, "Login to aem author instance", "Login to aem author instance successfull");
	}
	
	@Then("^navigate to aem home$")
	public void navigate_to_aem_home() throws IOException, InterruptedException {
		AEMFunctions.navigateToAemHome();
		Reports.updateReportLog(LogStatus.INFO, "Navigation to AEM Home", "Navigated to aem home successfully");
	}
	@Then("^navigate to tools$")
	public  void navidate_to_tools() {
		AEMFunctions.naviagateToTools();
		Reports.updateReportLog(LogStatus.INFO,"Navigation to aem tools" , "Successfully navigated to aem tools");
	}
	@Then("^navigate to sites$")
	public void navigate_to_sites() {
		AEMFunctions.navigateToSite();
		Reports.updateReportLog(LogStatus.INFO, "Navigating to aem site", "Successfullly navigated to aem site");
	}


	@Then("^select path \"([^\"]*)\"$")
	public void select_path(String arg) throws InterruptedException {
		AEMFunctions.selectPath(arg);
		Reports.updateReportLog(LogStatus.INFO, "Selecting the path "+arg, "Path "+arg+" selected successfully");
	}
	@Then("^select thumbnail at \"([^\"]*)\"$")
	public void select_thumbnail_at(String args) {
		AEMFunctions.selectThubnailAt(args);
		Reports.updateReportLog(LogStatus.INFO, "Selecting the thumbnail at the path "+args, "Thumbnail at "+args+" Selected succussfully");


	}
	@Then("^click on coralactionbar button \"([^\"]*)\"$")
	public void click_On_CoralActionBar_Button(String arg) {
		AEMFunctions.clickCoralActionBarButton(arg);
		Reports.updateReportLog(LogStatus.INFO, "Selecting the Coral action bar button "+arg, "Coral action bar button "+arg+" selected successfully");
	}
	@Then("^click pageinfobutton$")
	public void pageinfobutton() throws InterruptedException {
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.clickonpreviewineditor.getxpath()), "Clicking on Preview");
		AEMFunctions.clickOnPageInfoButton();
		Reports.updateReportLog(LogStatus.INFO, "Clicking on page info button", "Page info button clicked succesfully");

	}
	@Then("^click on particular pageinfobutton \"([^\"]*)\"$")

	public void click_on_particular_pageinfobutton(String arg1)

	{
		AEMFunctions.clickOnParticularPageInfoButton(arg1);
		Reports.updateReportLog(LogStatus.INFO, "Selecting the paticular page info button", "Page info button "+arg1+" selected succesfully");

	}

	@Then("^select and edit the particular page property$")
	public void select_The_particular_Page_Property(DataTable pageproperties) {
		AEMFunctions.selectEditDesiredPageProperties(pageproperties);
		Reports.updateReportLog(LogStatus.INFO, "Selecting and editing the particular page property", "Property edited succesfully");

	}
	@Then("^select the particular create option \"([^\"]*)\"$")
	public void select_the_particular_create_option(String arg2) throws InterruptedException
	{
		Thread.sleep(3000);
		AEMFunctions.selectTheParticularCreateOption(arg2);		
		Reports.updateReportLog(LogStatus.INFO, "Selecting the particular create option "+arg2, arg2+" option selected succesfully");

	}
	@Then("^select destinition path for live copy \"([^\"]*)\"$")
	public void select_destinition_path_for_live_copy(String arg) {
		AEMFunctions.selectLiveCopyDestinition(arg);
		Reports.updateReportLog(LogStatus.INFO, "Selecting the destinition path for creating the live copy as "+arg, arg+" Destinition selected successfully");

	}
	@Then("^create a live copy with title \"([^\"]*)\" and name \"([^\"]*)\"$")
	public void create_a_live_copy_with_title_and_name(String arg1, String arg2) throws InterruptedException {

		AEMFunctions.createLiveCopy(arg1, arg2);
		Reports.updateReportLog(LogStatus.INFO,"Creating a live copy with title:- "+arg1+" and name:- "+arg2, "Succesfully created a live copy with title "+arg1+" and name "+arg2);

	}
	@Then("^click on railtoggle button and select \"([^\"]*)\"$")
	public void click_on_railtoggle_button_select(String args) {
		AEMFunctions.clickOnRailToggleButtonAndSelect(args);
		Reports.updateReportLog(LogStatus.INFO, "Clicking on the railtoggle button and selecting "+args,"Successfully clicked on the railtoggle button and selected "+args);

	}
	@Then("^choose the template number (\\d+) \"([^\"]*)\"$")
	public void choose_the_template_number(int arg1, String arg2) throws InterruptedException {
		AEMFunctions.createPageChosingTemplate(arg1,arg2);
		Reports.updateReportLog(LogStatus.INFO, "Selecting the "+arg2+" for creating the page", "Succesfully selected the template "+arg2);
		Thread.sleep(2000);

	}
	@Then("^creating page with desired properties$")
	public void  creating_page_with_desired_properties(DataTable Propertiesmap) throws InterruptedException {
		AEMFunctions.creatingPageWithDesiredProperties(Propertiesmap);
		Reports.updateReportLog(LogStatus.INFO, "Creating page with filling the properties", "Page created succesfully by the filling all the mandatory properties");
	}
	@Then("^click on blueprint under references$")
	public void click_on_blueprint_under_references() {
		AEMFunctions.clickOnBluePrint();
		Reports.updateReportLog(LogStatus.INFO, "Clicking on blueprint under references", "Blueprint clicked successfully");

	}
	@Then("^select the livecopy to rollout blueprintchanges \"([^\"]*)\"$")
	public void select_LiveCopy_To_Rollout_BluePrintChnages(String arg) {
		AEMFunctions.rolloutChangesOnLiveCopy(arg);
		Reports.updateReportLog(LogStatus.INFO, "Rolling out changes from blueprint to live copy at "+arg,"Changes Rolled out successfully in the live copy at "+arg);


	}
	

	/////*******Kawasaki smoke test******///////
	@Then("^Verify if the following cookie message is geting displayed or not and Cookie notice and setting button is properly redirected$")
	public void verify_if_the_following_cookie_message_is_getting_displayed_or_not(DataTable cookiePropertiesmap) throws InterruptedException {
		List<Map<String, String>> propertiesforpage = cookiePropertiesmap.asMaps(String.class, String.class);
		String cookieMessage=CommonFunction.getWebElement(HomePageComponents.KAWCookiesPolicyText.getxpath()).getText();
		if(cookieMessage.equals(propertiesforpage.get(0).get("cookiepolicy"))) 
			Reports.updateReportLog(LogStatus.PASS, "To verify cookie message text is getting changed or not", "Cookie message is getting changed  as expected");
		else
			Reports.updateReportLog(LogStatus.FAIL, "To verify cookie message text is getting changed or not",Reports.addScreenCapture("Cookie message") );
		String LinkTitle=CommonFunction.getWebElement(AllComponents.KAWCookieNoticeandSettingslink.getxpath()).getText();
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",CommonFunction.getWebElement(AllComponents.KAWCookieNoticeandSettingslink.getxpath()), "Clicking on Cookie Notice and Settings");
		ArrayList<String> CookieNoticeScreen = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(CookieNoticeScreen.get(2));
		String CookieNoticeTitle = driver.getTitle();
		if(CookieNoticeTitle.contains(propertiesforpage.get(0).get("Cookie notice title"))) 
			Reports.updateReportLog(LogStatus.PASS, "To verify if the Cookie notice and settings link is getting redirected to the desired path or not", "Cookie notice and settings link is getting redirected to the desired path");
		else
			Reports.updateReportLog(LogStatus.FAIL, "To verify if the Cookie notice and settings link is getting redirected to the desired path or not", "Cookie notice and settings link is not getting redirected to the desired path");
	
	}
	@Then("^Click on cookie policy I agree button$")
	public void click_on_cookie_policy_i_agree_button() {
		eyes.checkElement(getWebElement(HomePageComponents.KAWCookiesPolicyAgreeBtn.getxpath()), 2000, "Cookie Button");
		try {
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", getWebElement(HomePageComponents.KAWCookiesPolicyAgreeBtn.getxpath()), "Clicking on I agree button");
			Reports.updateReportLog(LogStatus.PASS, "Clicking on I agree button", "I Agree button cliked succesfully");
		}catch (Exception e) {
			Reports.updateReportLog(LogStatus.FAIL, "Clicking on I agree button", "Unable to click the i agree button");
		}
		
	}
	@Then("^check if the CTA boxs are Present and displayed$")
	public void check_if_the_CTA_boxs_are_Present_and_displayed() throws InterruptedException {
		ArrayList<WebElement> homePageCTAboxes = new ArrayList<WebElement>();
		homePageCTAboxes.addAll(CommonFunction.getWebElements(HomePageComponents.KAWctaBoxesHomePage.getxpath()));
		try {
			CommonFunction.scrolltoElementAndHighLight(homePageCTAboxes.get(0));
			eyes.checkElement(homePageCTAboxes.get(0), 2000, "CTA BOX 1");
			CommonFunction.scrolltoElementAndHighLight(homePageCTAboxes.get(1));
			eyes.checkElement(homePageCTAboxes.get(0), 2000, "CTA BOX 2");
			CommonFunction.scrolltoElementAndHighLight(homePageCTAboxes.get(2));
			eyes.checkElement(homePageCTAboxes.get(0), 2000, "CTA BOX 3");
			Reports.updateReportLog(LogStatus.PASS, "To verify if the Help Me Choose,Configure Your Bike, Find a Dealer Near You are Present on the home Page", "CTA boxes Help Me Choose,Configure Your Bike, Find a Dealer Near You are Present on the home Page");

		}
		catch (Exception e) {
			Reports.updateReportLog(LogStatus.FAIL, "To verify if the Help Me Choose,Configure Your Bike, Find a Dealer Near You are Present on the home Page", Reports.addScreenCapture("CTA Boxes not found"));
		}
	}

	@Then("^check if the text with link component is present or not$")
	public void check_if_the_text_with_link_component_is_present_or_not() throws InterruptedException {
		ArrayList<WebElement> homePageCTAboxes = new ArrayList<WebElement>();
		homePageCTAboxes.addAll(CommonFunction.getWebElements(HomePageComponents.KAWtextWithLinkHomePage.getxpath()));
		try {
			CommonFunction.scrolltoElementAndHighLight(homePageCTAboxes.get(0));
			CommonFunction.scrolltoElementAndHighLight(homePageCTAboxes.get(1));
			Reports.updateReportLog(LogStatus.PASS, "To verify if the if the text with link components are present or not", "The text with link components are present");

		}
		catch (Exception e) {
			Reports.updateReportLog(LogStatus.FAIL, "To verify if the if the text with link components are present or not", Reports.addScreenCapture("Text with link component not found"));
		}
	}

	@Then("^check if the calender compopnent is present or not$")
	public void check_if_the_component_is_present_or_not()
	{

		try {
			CommonFunction.scrolltoElementAndHighLight(getWebElement(HomePageComponents.KAWCalender.getxpath()));
			Reports.updateReportLog(LogStatus.PASS, "To verify if the calender component is present on homepage or not","The calender component is present on the homepage");

		}
		catch (Exception e) {
			Reports.updateReportLog(LogStatus.FAIL, "To verify if the calender component is present on homepage or not",Reports.addScreenCapture("Calender not present"));
		}
	}
	@Then("^check if the footer component is present or not$")
	public void check_if_the_footer_component_is_present_or_not()
	{

		try {
			CommonFunction.scrolltoElementAndHighLight(getWebElement(HomePageComponents.KAWfooter.getxpath()));
			Reports.updateReportLog(LogStatus.PASS, "To verify if the footer component is present on homepage or not","The calender component is present on the homepage");

		}
		catch (Exception e) {
			Reports.updateReportLog(LogStatus.FAIL, "To verify if the footer component is present on homepage or not",Reports.addScreenCapture("Calender not present"));
		}
	}
	@Then("^click on each subnavigation sections and check one by one$")
	public void click_on_each_subnavigation_and_check_one_by_one() throws InterruptedException {

		ArrayList<WebElement> subNaviagtionsSections = new ArrayList<WebElement>();
		subNaviagtionsSections.addAll(CommonFunction.getWebElements(HomePageComponents.subnavigationHomePage.getxpath()));

		for(WebElement ele:subNaviagtionsSections) {
			try {
				CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", ele, ele.getText());;
				Thread.sleep(3000);
				Reports.updateReportLog(LogStatus.PASS, "To verify if the subnavigation "+ele.getText()+" is getting opened or not", "The subnavgation "+ele.getText()+" are getting opened successfully");
			}
			catch (Exception e) {
				Reports.updateReportLog(LogStatus.FAIL, "To verify if the subnavigation "+ele.getText()+" is getting opened or not",Reports.addScreenCapture("Subnavigation "+ele.getText()+" not clickable") );
			}
		}
	}
	@Then("^click on each subnavigation links and check one by one$")
	public void click_on_each_subnavigation_links_and_check_one_by_one() throws InterruptedException {

		ArrayList<WebElement> subNaviagtionsSections = new ArrayList<WebElement>();
		subNaviagtionsSections.addAll(CommonFunction.getWebElements(HomePageComponents.subnavigationHomePage.getxpath()));
		int i =0;
		int j= 0;

		for(WebElement elesections : subNaviagtionsSections) {
			//		elesections.click();
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", elesections, elesections.getText());
			Thread.sleep(1000);
			ArrayList<WebElement> subNaviagtionsLinks = new ArrayList<WebElement>();
			subNaviagtionsLinks.addAll(CommonFunction.getWebElements(HomePageComponents.subnavigationlinks.getxpath()));
			ArrayList<WebElement> linktextElement = new ArrayList<WebElement>();
			linktextElement.addAll(CommonFunction.getWebElements("//div[@class='subnav__contentContainer']//h3"));
			for(;i<linktextElement.size();i++) {
				try {
					String linkTitle = linktextElement.get(i).getText();
					if(linkTitle.equals("RIDEOLOGY")||linkTitle.equals("OUR HERITAGE")||linkTitle.equals("ICONIC MODELS")||linkTitle.equals("CONTACT")||linkTitle.equals("LEGAL")||linkTitle.equals("CUSTOMER FEEDBACK")||linkTitle.equals("SAFETY")||linkTitle.equals("FINANCE & INSURANCE")||linkTitle.equals("WARRANTY"))
					{	
						String linkURL= subNaviagtionsLinks.get(i+3).getAttribute("href");
						((JavascriptExecutor)driver).executeScript("window.open()");
						ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
						driver.switchTo().window(tabs.get(1)); 
						driver.get(linkURL);
						System.out.println(driver.getTitle().replaceAll("STAGE | ", ""));
						if(driver.getTitle().replaceAll("STAGE | ", "").equalsIgnoreCase("|"+linkTitle.replaceAll("\\s+", "")))
							Reports.updateReportLog(LogStatus.PASS, "To verify if the subnavigation link "+linkTitle+" is getting opened or not", "The subnavgation link "+linkTitle+" is getting opened successfully");
						else
							Reports.updateReportLog(LogStatus.FAIL, "To verify if the subnavigation link "+linkTitle+" is getting opened or not", "The subnavgation link "+linkTitle+" is not getting opened successfully");
						driver.close();
						driver.switchTo().window(tabs.get(0));
					}
					else 
					{	
						String linkURL= subNaviagtionsLinks.get(i).getAttribute("href");
						((JavascriptExecutor)driver).executeScript("window.open()");
						ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
						driver.switchTo().window(tabs.get(1)); 
						driver.get(linkURL);
						System.out.println(driver.getTitle().replaceAll("STAGE | ", ""));
						if(driver.getTitle().replaceAll("STAGE | ", "").equalsIgnoreCase("|"+linkTitle.replaceAll("\\s+", "")))
							Reports.updateReportLog(LogStatus.PASS, "To verify if the subnavigation link "+linkTitle+" is getting opened or not", "The subnavgation link "+linkTitle+" is getting opened successfully");
						else if(linkTitle.equals("NEWS & EXPERIENCE"))
						{	
							for(int k=0;k<=3;k++)
							{
								ArrayList<String> tabfornews = new ArrayList<String> (driver.getWindowHandles());
								driver.switchTo().window(tabfornews.get(0));
								ArrayList<WebElement>linkTitlesElements= new ArrayList<WebElement>();
								linkTitlesElements.addAll(CommonFunction.getWebElements("//*[@class='subnav__itemAbstract']"));
								String linktitle=linkTitlesElements.get(j).getText();
								driver.switchTo().window(tabfornews.get(1));
								if(("|"+linktitle.replaceAll("\\s+", "")).equals(driver.getTitle().replaceAll("STAGE | ", "")))
								{
									Reports.updateReportLog(LogStatus.PASS, "To verify if the subnavigation link "+linktitle+" is getting opened or not", "The subnavgation link "+linktitle+" is getting opened successfully");	
									driver.close();
									driver.switchTo().window(tabs.get(0));
								}
								else
									Reports.updateReportLog(LogStatus.FAIL, "To verify if the subnavigation link "+linktitle+" is getting opened or not", "The subnavgation link "+linktitle+" is not getting opened successfully");
								j++;
								String linkURLsublinks= subNaviagtionsLinks.get(i+k+1).getAttribute("href");
								((JavascriptExecutor)driver).executeScript("window.open()");
								tabfornews = new ArrayList<String> (driver.getWindowHandles());
								driver.switchTo().window(tabfornews.get(1)); 
								driver.get(linkURLsublinks);
							}
						}
						else
							Reports.updateReportLog(LogStatus.FAIL, "To verify if the subnavigation link "+driver.getTitle().replaceAll("STAGE | ", "")+" is getting opened or not", "The subnavgation link "+driver.getTitle().replaceAll("STAGE | ", "")+" is not getting opened successfully");
						driver.close();
						driver.switchTo().window(tabs.get(0));

					}

				}


				catch (Exception e) {

				}
			}
		}
	}
	@Then("^click on each subnavigation green links and check one by one$")
	public void click_on_each_subnavigation_green_links_and_check_one_by_one() throws InterruptedException {

		ArrayList<WebElement> subNaviagtionsSections = new ArrayList<WebElement>();
		subNaviagtionsSections.addAll(CommonFunction.getWebElements(HomePageComponents.subnavigationHomePage.getxpath()));
		int i =0;
		for(WebElement elesections : subNaviagtionsSections) {
			elesections.click();
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", elesections, elesections.getText());
			Thread.sleep(1000);
			ArrayList<WebElement> subNaviagtionsGreenLinks = new ArrayList<WebElement>();
			subNaviagtionsGreenLinks.addAll(CommonFunction.getWebElements(HomePageComponents.subnavigationGreenlinks.getxpath()));
			ArrayList<WebElement> greenlinktextElement = new ArrayList<WebElement>();
			greenlinktextElement.addAll(CommonFunction.getWebElements("//div[@class='subnav__contentFooter']"));
			for(;i<greenlinktextElement.size();i++) {
				try {
					String greenlinkTitle = greenlinktextElement.get(i).getText();
					String greenlinkURL= subNaviagtionsGreenLinks.get(i).getAttribute("href");
					((JavascriptExecutor)driver).executeScript("window.open()");
					ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1)); 
					driver.get(greenlinkURL);
					System.out.println(driver.getTitle().replaceAll("STAGE | ", ""));
					if(driver.getTitle().replaceAll("STAGE | ", "").contains("|"+greenlinkTitle.replaceAll("\\s+", "")))
						Reports.updateReportLog(LogStatus.PASS, "To verify if the subnavigation link "+greenlinkTitle+" is getting opened or not", "The subnavgation link "+greenlinkURL+" is getting opened successfully");
					else
						Reports.updateReportLog(LogStatus.FAIL, "To verify if the subnavigation link "+greenlinkTitle+" is getting opened or not", "The subnavgation link "+greenlinkURL+" is not getting opened successfully");
					driver.close();
					driver.switchTo().window(tabs.get(0));

					CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", elesections, elesections.getText());				
				}
				catch (Exception e) {

				}
			}
		}
	}
	@Then("^click on each footer links and check one by one$")
	public void click_on_each_footer_links_and_check_one_by_one() throws InterruptedException {
		ArrayList<WebElement> footerSectionLinks = new ArrayList<WebElement>();
		footerSectionLinks.addAll(CommonFunction.getWebElements(HomePageComponents.footerLinks.getxpath()));
		int i=0;
		for(;i<=3;i++) {
			String socialfooterlinktext=footerSectionLinks.get(i).getAttribute("title");
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", footerSectionLinks.get(i), footerSectionLinks.get(i).getText());
			Point p = new Point(0, 0);
			Dimension d =new Dimension(0, 0);
			ArrayList<String> footerLinkbrowserTab=CommonFunction.browserFuntions("Handles", p, d);
			driver.switchTo().window(footerLinkbrowserTab.get(1));
			String footerLinkPageTitle=driver.getTitle();
			if(footerLinkPageTitle.contains(socialfooterlinktext))
				Reports.updateReportLog(LogStatus.PASS, "To Verify Navgation of footer link to "+socialfooterlinktext, "The Footer link "+footerLinkPageTitle+" successfully navigated");
			else
				Reports.updateReportLog(LogStatus.FAIL, "To Verify Navgation of footer link to 	"+socialfooterlinktext, "The Footer link "+footerLinkPageTitle+" did not navigated succesfully");
			driver.close();
			driver.switchTo().window(footerLinkbrowserTab.get(0));	
		}
		for(i=4;i<17;i++) 
		{
			String hrefOtherFooterLinks= footerSectionLinks.get(i).getAttribute("href");
			String titleOfOtherFooterLinks= footerSectionLinks.get(i).getText();
			((JavascriptExecutor)driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1)); 
			driver.get(hrefOtherFooterLinks);
			Thread.sleep(2000);
			String footerLinksTitle =driver.getTitle().replaceAll("STAGE | ", "");
			if(footerLinksTitle.equals(("|"+titleOfOtherFooterLinks).replaceAll("\\s+", "")))
				Reports.updateReportLog(LogStatus.PASS, "To Verify Navgation of footer link to "+titleOfOtherFooterLinks, "The Footer link "+titleOfOtherFooterLinks+" successfully navigated");
			else
				Reports.updateReportLog(LogStatus.FAIL, "To Verify Navgation of footer link to "+titleOfOtherFooterLinks, "The Footer link "+titleOfOtherFooterLinks+" did not navigated succesfully");	
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}
	@Then("^click each accordian one by one and check the details on the product cards$")
	public void click_each_accordian_one_by_one_and_check_the_details_on_the_product_cards() {
		ArrayList<WebElement> allAccordians = new ArrayList<WebElement>();
		allAccordians.addAll(CommonFunction.getWebElements(webelementsinventory.Categorypagecomponents.productCategoryAccordian.getxpath()));
		for(WebElement accordian:allAccordians) 
		{	
			try
			{
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click", accordian , accordian.getAttribute("data-category"));
				Reports.updateReportLog(LogStatus.PASS,"To verify if the user is able to click on the accoridian or not", "The user is able to click on the accordian");
			}
			catch (Exception e) {
				Reports.updateReportLog(LogStatus.FAIL,"To verify if the user is able to click on the accoridian or not", "The user is not able to click on the accordian");
			}

		}
	}
	@Then("^add the component \"([^\"]*)\" to (\\d+)$")
	public void add_the_component(String componentName, int indexOfDragComponentName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ArrayList<WebElement> dragComponentsHere = new ArrayList<WebElement>();
		dragComponentsHere.addAll(CommonFunction.getWebElements(AllComponents.dragComponenthereParsys.getxpath()));
		WebElement parsystobeUsed = dragComponentsHere.get((indexOfDragComponentName));
		CommonFunction.scrolltoElementAndHighLight(parsystobeUsed);
		CommonFunction.actionsFromActionsclass(parsystobeUsed, "click", parsystobeUsed, 0, 0);
		try {
			Thread.sleep(2000);
			CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.insertnewComponentBtn.getxpath())), 5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AllComponents.insertnewComponentBtn.getxpath()), "ClickOnPlusBtn");
		CommonFunction.highlightClickEnterDeletetakeScreenshot(componentName, "Sendkeys",CommonFunction.getWebElement(AllComponents.enterKeywordstxtBox.getxpath()), "EnterKeyWordComponentSearch");
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AllComponents.selectComponent.getxpath().replaceAll("dummy", componentName)), "Adding "+componentName+" to page" );
		Reports.updateReportLog(LogStatus.INFO, "Adding the component "+componentName+" at the "+indexOfDragComponentName+" position", "");
	}

	@Then("^Select the component \"([^\"]*)\" and click on the desired editable toolbar option \"([^\"]*)\"$")
	public void click_on_the_desired_editable_toolbar_option(String componentName,String toolBarOption){
		ArrayList<WebElement> allEditablecomponents = new  ArrayList<WebElement> ();
		try {
			Thread.sleep(2000);
				CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.Componenttoedit.getxpath().replaceAll("dummy", componentName))), 5000);
			allEditablecomponents.addAll(CommonFunction.getWebElements(AllComponents.Componenttoedit.getxpath().replaceAll("dummy", componentName)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(WebElement editableElement: allEditablecomponents)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
			CommonFunction.actionsFromActionsclass(CommonFunction.getWebElement(AllComponents.Componenttoedit.getxpath().replaceAll("dummy", componentName)), "click", CommonFunction.getWebElement(AllComponents.Componenttoedit.getxpath().replaceAll("dummy", componentName)), 0, 0);
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click" ,CommonFunction.getWebElement(AEMPageObjects.togglesidepanelbtn.getxpath()) ,"Clicking on RailLeft");
			try {
				Thread.sleep(3000);
				CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.editableToolBarOptions.getxpath().replaceAll("dummy", toolBarOption))), 5000);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AllComponents.editableToolBarOptions.getxpath().replaceAll("dummy", toolBarOption )), "Desired Editable toolBar option "+toolBarOption+" selected ");
			if(componentName.equals("KAW Image")) 
			{
				try {
					Thread.sleep(2000);
					CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.KAWIMageimagedrpbox.getxpath())), 5000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				Reports.updateReportLog(LogStatus.INFO, "Configuring the "+componentName, "");
				CommonFunction.actionsFromActionsclass(CommonFunction.getWebElement(AEMPageObjects.damimage.getxpath()),"draganddrop", CommonFunction.getWebElement(AllComponents.KAWIMageimagedrpbox.getxpath()), 0, 0);
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",CommonFunction.getWebElement(AllComponents.Dailogboxcheckbtn.getxpath()) , "Checkbutton in dialog box");
				
			}
			else if(componentName.equals("KAW Text with Link"))
			{
				try {
					Thread.sleep(2000);
					CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.dailogboxheader.getxpath())), 5000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				Reports.updateReportLog(LogStatus.INFO, "Configuring the "+componentName, "");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Delete", CommonFunction.getWebElement(AllComponents.KAWTextWIthLinkTitle.getxpath()), "Deleting text");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(componentName, "Enter",CommonFunction.getWebElement(AllComponents.KAWTextWIthLinkTitle.getxpath()) , "adding TITLE To "+componentName+" component");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",CommonFunction.getWebElement(AllComponents.Dailogboxcheckbtn.getxpath()) , "Checkbutton in dialog box");

			}
			else if(componentName.equals("KAW CTA Box Component"))
			{
				try {
					Thread.sleep(2000);
					CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.dailogboxheader.getxpath())), 5000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				Reports.updateReportLog(LogStatus.INFO, "Configuring the "+componentName, "");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Delete", CommonFunction.getWebElement(AllComponents.KAWCTABoxTitle.getxpath()), "Deleting text");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(componentName, "Enter",CommonFunction.getWebElement(AllComponents.KAWCTABoxTitle.getxpath()) , "adding TITLE To "+componentName+" component");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",CommonFunction.getWebElement(AllComponents.Dailogboxcheckbtn.getxpath()) , "Checkbutton in dialog box");
			}
			else if(componentName.equals("KAW Calender Component"))
			{
				try {
					Thread.sleep(2000);
					CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.dailogboxheader.getxpath())), 5000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				Reports.updateReportLog(LogStatus.INFO, "Configuring the "+componentName, "");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Delete", CommonFunction.getWebElement(AllComponents.KAWTextWIthLinkTitle.getxpath()), "Deleting text");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(componentName, "Enter",CommonFunction.getWebElement(AllComponents.KAWTextWIthLinkTitle.getxpath()) , "adding TITLE To KAW TEXT WITH LINK TITLE component");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",CommonFunction.getWebElement(AllComponents.Dailogboxcheckbtn.getxpath()) , "Checkbutton in dialog box");	
			}
			else if(componentName.equals("KAW Social Media Linklist"))
			{
				try {
					Thread.sleep(2000);
					CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(CommonFunction.getWebElement(AllComponents.dailogboxheader.getxpath())), 5000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				ArrayList<WebElement> enterUrlSocialMedia = new ArrayList<WebElement>();
				enterUrlSocialMedia.addAll(CommonFunction.getWebElements(AllComponents.KAWLinkToDialogBoxOption.getxpath()));
				ArrayList<WebElement> openInTab = new ArrayList<WebElement>();
				openInTab.addAll(CommonFunction.getWebElements(AllComponents.KAWOpenInTab.getxpath()));

				for(WebElement enterURLSocialMedia:enterUrlSocialMedia) 
				{
					CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Delete", enterURLSocialMedia, "Deleting the URL");
					CommonFunction.highlightClickEnterDeletetakeScreenshot("https://www.facebook.com/", "Enter",enterURLSocialMedia, "Entering Link to URL");
					
				}
				Reports.updateReportLog(LogStatus.INFO, "Configuring the "+componentName, "");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",CommonFunction.getWebElement(AllComponents.Dailogboxcheckbtn.getxpath()) , "Checkbutton in dialog box");	
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}

		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click" ,CommonFunction.getWebElement(AEMPageObjects.togglesidepanelbtn.getxpath()) ,"Clicking on RailLeft");
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.previewbutton.getxpath()), "clicking on preview");
	}

	@Then("^Verify if the following properties for the component \"([^\"]*)\"$")
	public void Verify_the_following_properties_for_the_component(String componentName,DataTable pageproperties) {
		if(componentName.equals("KAW Text with Link")) 
		{

			CommonFunction.pageScrolling("DOWN");
			List<Map<String, String>> propertiesforpage = pageproperties.asMaps(String.class, String.class);
			ArrayList<WebElement> kawLinkWithTextTitles= new ArrayList<WebElement>(); 
			kawLinkWithTextTitles.addAll(CommonFunction.getWebElements(AllComponents.KAWTextWITHLINKTitlePublished.getxpath()));
			for(int i = 0;i<kawLinkWithTextTitles.size();i++){
				if(kawLinkWithTextTitles.get(i).getText().equals(propertiesforpage.get(0).get("link text title"))) 
					Reports.updateReportLog(LogStatus.PASS, "To verify KAW Text with link title", "To verify KAW Text with link title");
				else
					Reports.updateReportLog(LogStatus.FAIL, "To verify KAW Text with link title",Reports.addScreenCapture("KAW link with text") );	

			}
		}
		else if(componentName.equals("KAW CTA Box Component")) 
		{

			CommonFunction.pageScrolling("DOWN");
			List<Map<String, String>> propertiesforpage = pageproperties.asMaps(String.class, String.class);
			ArrayList<WebElement> kawLinkWithTextTitles= new ArrayList<WebElement>(); 
			kawLinkWithTextTitles.addAll(CommonFunction.getWebElements(AllComponents.KAWCTABoxTitlePublished.getxpath()));
			for(int i = 0;i<kawLinkWithTextTitles.size();i++){
				if(kawLinkWithTextTitles.get(i).getText().equals(propertiesforpage.get(0).get("KAW CTA Box Component title"))) 
					Reports.updateReportLog(LogStatus.PASS, "To verify KAW CTA BOX Title", "");
				else
					Reports.updateReportLog(LogStatus.FAIL, "To verify KAW CTA BOX Title",Reports.addScreenCapture("KAW link with text") );	

			}	
		}

	}
	@Then("^select the blueprint$")
	public void selectBlueprint() {
		AEMFunctions.selectCatalogBlueprint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("^select the catalog blueprint folder (\\d+)$")
	public void selectTheCatalogFolder(int arg){
		ArrayList<WebElement> catalogFolders= new ArrayList<WebElement>(); 
		catalogFolders.addAll(CommonFunction.getWebElements(AEMPageObjects.selectCatalogFolder.getxpath()));
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",catalogFolders.get(arg) , "Selecting the blueprint  catalog folder");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Then("^select the select button$")
	public void selectTheSelectButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.selectButton.getxpath()), "Clicking on the select button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Then("^select the particular category catalog (\\d+)$")
	public void selectTheparticularcategoryCatalog(int arg) {
		ArrayList<WebElement> catalogFolders= new ArrayList<WebElement>(); 
		catalogFolders.addAll(CommonFunction.getWebElements(AEMPageObjects.selectCatalogFolder.getxpath()));
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",catalogFolders.get(arg) , "Selecting the blueprint  catalog folder");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Then("^select the next button (\\d+)$")
	public void select_the_next_button(int arg1){
		
		ArrayList<WebElement> catalogFolders= new ArrayList<WebElement>(); 
		catalogFolders.addAll(CommonFunction.getWebElements(AEMPageObjects.selectNext.getxpath()));
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",catalogFolders.get(arg1) , "Selecting the next button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Then("^Enter the Title of the catalog \"([^\"]*)\" and Name of the catalog \"([^\"]*)\"$")
	public void EnterTitleAndNameOfTheCatalog(String title, String name) 
	{
		CommonFunction.highlightClickEnterDeletetakeScreenshot(title, "Enter",CommonFunction.getWebElement(AEMPageObjects.catalogTitle.getxpath()) , "Enter the title of the catalog");
		CommonFunction.highlightClickEnterDeletetakeScreenshot(name, "Enter",CommonFunction.getWebElement(AEMPageObjects.catalogName.getxpath()) , "Enter the name of the catalog");
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.clickOnCreate.getxpath()), "Selecting the blueprint  catalog folder");
		try {
			Thread.sleep(20000);
			CommonFunction.setWait("explicitwait", ExpectedConditions.elementToBeClickable(CommonFunction.getWebElement(AEMPageObjects.ClickODone.getxpath())), 30000);
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.ClickODone.getxpath()), "Selecting the blueprint  catalog folder");
		} catch (InterruptedException e) {
			System.out.println("Error in creating catalog");
			e.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("cannot reach AEM sites");
			e.printStackTrace();
		}
		
		
	}
	
//	
//	@After()
//	public void closeExecution() {
//		Reports.updateReportLog(LogStatus.INFO,"Closing browser", "Browser closed succesfully");
//		TestResultsSummary allTestResults=initiateApplitoolslib.collectTestResults();
//		System.out.println(allTestResults);
//		Reports.closeReport();
//		driver.quit();
//		
//		
//	}
	
}