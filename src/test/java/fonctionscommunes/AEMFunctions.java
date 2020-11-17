package fonctionscommunes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import coeur.Properties;
import cucumber.api.DataTable;
import webelementsinventory.AEMPageObjects;

public class AEMFunctions extends CommonFunction {



	public static void intializeAemAuthorInstance(String environment) throws IOException {

		if(environment.equals("Testauthor"))
			driver.get(Properties.getProperties("TestauthorURL").replaceAll("\"", ""));
		if(environment.equals("Stageauthor"))
			driver.get(Properties.getProperties("StageauthorURL").replaceAll("\"", ""));
		if(environment.equals("Testpublisher"))
			driver.get(Properties.getProperties("TestpublisherURL").replaceAll("\"", ""));
		if(environment.equals("Stagepublisher"))
			driver.get(Properties.getProperties("StagepublisherURL").replaceAll("\"", ""));

	}

	public static void enterCredentials(String environment) throws IOException, InterruptedException {
		if(environment.equals("Testauthor"))
		{
			CommonFunction.highlightClickEnterDeletetakeScreenshot((Properties.getProperties("Testusername")), "Enter",
					CommonFunction.getWebElement(AEMPageObjects.usernametxt.getxpath()), "Enterusername");
			CommonFunction.highlightClickEnterDeletetakeScreenshot((Properties.getProperties("Testpassword")), "Enter",
					CommonFunction.getWebElement(AEMPageObjects.passwordtxt.getxpath()), "Enterpassword");
		}
		if(environment.equals("Stageauthor")) {
			CommonFunction.highlightClickEnterDeletetakeScreenshot((Properties.getProperties("Stageusername")), "Enter",
					CommonFunction.getWebElement(AEMPageObjects.usernametxt.getxpath()), "Enterusername");
			CommonFunction.highlightClickEnterDeletetakeScreenshot((Properties.getProperties("Stagepassword")), "Enter",
					CommonFunction.getWebElement(AEMPageObjects.passwordtxt.getxpath()), "Enterpassword");
		}
		if(environment.equals("Testpublisher"))
		{
			CommonFunction.highlightClickEnterDeletetakeScreenshot((Properties.getProperties("Testusername")), "Enter",
					CommonFunction.getWebElement(AEMPageObjects.usernametxt.getxpath()), "Enterusername");
			CommonFunction.highlightClickEnterDeletetakeScreenshot((Properties.getProperties("Testpassword")), "Enter",
					CommonFunction.getWebElement(AEMPageObjects.passwordtxt.getxpath()), "Enterpassword");
		}
		if(environment.equals("Stagepublisher")) {
			
		}
		
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",
				CommonFunction.getWebElement(AEMPageObjects.loginbutton.getxpath()), "login");
	}
	public static void navigateToAemHome() throws IOException, InterruptedException {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(AEMPageObjects.Navigationtxt.getxpath())).getText(), "Navigation");

		} catch (Exception e) {
			System.out.println("Could not naviagte to home");
		}

	}
	public static void naviagateToTools() {
		try {
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.toolsicon.getxpath()), "Toolsicon");
		}
		catch(Exception e) {
			System.out.println("Could not navigate to tools");
		}
	}
	public static void navigateToSite() {
		try {
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",CommonFunction.getWebElement(AEMPageObjects.sitestab.getxpath()),"Sites");
		}catch (Exception e) {
			System.out.println("Could not move to site tab");
		}
	}

	public static void selectPath(String args2) throws InterruptedException {

		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",CommonFunction.getWebElement(AEMPageObjects.sitepages.getxpath().replaceAll("dummy",args2)) , args2);
		Thread.sleep(1000);
	}

	public static void selectThubnailAt(String args) {

		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.selectpaththumbnail.getxpath().replaceAll("dummy", args)) , "Selectthepage");

	}


	public static void clickCoralActionBarButton(String arg) {

		if(arg.equalsIgnoreCase("create"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createcoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("edit"))
		{
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.editcoralactionbarbtn.getxpath()),arg);
			Point p = new Point(0, 0);
			Dimension d = new Dimension(0, 0);
			ArrayList<String> Windows = null;
			try {
				Windows = CommonFunction.browserFuntions("Handles", p, d);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(Windows.get(1));
		}
		if(arg.equalsIgnoreCase("Properties"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.propertiescoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("Lock"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.lockcoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("unlock"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.unlockcoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("copy"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.editcoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("move"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.movecoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("quick publish"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.quickpublishcoralactionbarbtn.getxpath()),arg);
		if(arg.equalsIgnoreCase("manage publication"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.managecoralactionbarbutton.getxpath()),arg);
		if(arg.equalsIgnoreCase("delete"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.deletcoralactionbarbutton.getxpath()),arg);	

	}
	public static void clickOnPageInfoButton() throws InterruptedException 
	{

		WebElement element = CommonFunction.getWebElement(AEMPageObjects.pageinfobutton.getxpath());
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}
	public static void clickOnParticularPageInfoButton(String arg1)
	{
		if(arg1.equalsIgnoreCase("open properties"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.openproperties.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("start workflow"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.startworkflow.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("Lock page"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.lockpage.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("Publish page"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.publishpage.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("unpublish page"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.unpublishpage.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("edit template"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.edittemplate.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("view as published"))
		{
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.viewaspublished.getxpath()),arg1);
			Point p = new Point(0, 0);
			Dimension d = new Dimension(0, 0);
			ArrayList<String> Windows = null;
			try {
				Windows = CommonFunction.browserFuntions("Handles", p, d);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(Windows.get(2));
		}
		if(arg1.equalsIgnoreCase("view as Admin"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.viewasadmin.getxpath()),arg1);
		if(arg1.equalsIgnoreCase("help"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.help.getxpath()),arg1);
	}
	public static void selectEditDesiredPageProperties(DataTable pageproperties) {

		List<Map<String, String>> propertiesforpage = pageproperties.asMaps(String.class, String.class);

		ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
		particular_pageproperty.addAll(getWebElements(AEMPageObjects.pageproperties.getxpath()));

		for(int i=0;i<particular_pageproperty.size();i++)
		{
			String Property = particular_pageproperty.get(i).getText();
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", particular_pageproperty.get(i),Property);
			if(Property.equalsIgnoreCase("Basic")) {
				try {
					setWait("explicitwait", ExpectedConditions.visibilityOf(getWebElement(AEMPageObjects.createpagepropbasictitle.getxpath())), 5000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Delete",getWebElement(AEMPageObjects.createpagepropbasictitle.getxpath()), "Deleting page title");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("Title"),"Enter",getWebElement(AEMPageObjects.createpagepropbasictitle.getxpath()), "EnteringPageTitle");
			}	
			else if(Property.equalsIgnoreCase("Advanced")) {



			}
			else if(Property.equalsIgnoreCase("Thumbnail")) {



			}
			else if(Property.equalsIgnoreCase("Social Media")) {



			}
			else if(Property.equalsIgnoreCase("Cloud Services")) {



			}
			else if(Property.equalsIgnoreCase("Personalization")) {



			}
			else if(Property.equalsIgnoreCase("Permissions")) {



			}
			else if(Property.equalsIgnoreCase("Site Configurator")) {



			}
			else if(Property.equalsIgnoreCase("Cookie Configurator")) {
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Delete",getWebElement(AEMPageObjects.cookiepolicytitle.getxpath()), "Deleting page title");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("cookietitle"), "Enter", getWebElement(AEMPageObjects.cookiepolicytitle.getxpath()), "Entercookietitle");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Delete",getWebElement(AEMPageObjects.cookiepolicytxt.getxpath()), "Deleting page title");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("cookiepolicy"),"Enter",getWebElement(AEMPageObjects.cookiepolicytxt.getxpath()), "Enteringcookiepolicy");
				CommonFunction.highlightClickEnterDeletetakeScreenshot("","Delete",getWebElement(AEMPageObjects.cookiebtntext.getxpath()), "Deleting page title");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("cookiebtntext"),"Enter",getWebElement(AEMPageObjects.cookiebtntext.getxpath()), "Enteringbtnpolicy");


			}
			else if(Property.equalsIgnoreCase("User Sign-up Configuration")) {


			}
			else if(Property.equalsIgnoreCase("Promotion Configuration")) {


			}
			else if(Property.equalsIgnoreCase("Navigation Details")) {


			}
			else if(Property.equalsIgnoreCase("Live Copy")) {



			}



		}

		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", getWebElement(AEMPageObjects.clickonsubmit.getxpath()), "Clicking on create");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
	public static void selectLiveCopyDestinition(String arg) {

		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",CommonFunction.getWebElement(AEMPageObjects.destinitionpathforlivecopy.getxpath().replaceAll("dummy",arg)) , arg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	public static void createLiveCopy(String title, String name) throws InterruptedException {
		CommonFunction.setWait("explicitwait", ExpectedConditions.visibilityOf(getWebElement(AEMPageObjects.next.getxpath())),2000);


		ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
		particular_pageproperty.addAll(getWebElements(AEMPageObjects.next.getxpath()));
		WebElement selectednext = particular_pageproperty.get(0);
		CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",selectednext, "livecopynextbutton");

		CommonFunction.highlightClickEnterDeletetakeScreenshot(title,"Enter",getWebElement(AEMPageObjects.titleforlivecopy.getxpath()), "livecopytitle");
		CommonFunction.highlightClickEnterDeletetakeScreenshot(name,"Enter",getWebElement(AEMPageObjects.nameforlivecopy.getxpath()), "livecopytitle");
		CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",getWebElement(AEMPageObjects.clickonsubmit.getxpath()), "clickonsubmit");

	}


	public static void selectTheParticularCreateOption(String arg2) {

		if(arg2.equalsIgnoreCase("workflow"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createworkflow.getxpath()),arg2);
		if(arg2.equalsIgnoreCase("Version"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createversion.getxpath()),arg2);
		if(arg2.equalsIgnoreCase("page"))
		{
			ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
			particular_pageproperty.addAll(getWebElements(AEMPageObjects.createpage.getxpath()));
			WebElement selectedpageproperty = particular_pageproperty.get(1);
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",selectedpageproperty,arg2);
		}
		if(arg2.equalsIgnoreCase("site"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createsite.getxpath()),arg2);
		if(arg2.equalsIgnoreCase("live copy")) 
		{
			ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
			particular_pageproperty.addAll(getWebElements(AEMPageObjects.createlivecopy.getxpath()));
			WebElement selectedpageproperty = particular_pageproperty.get(1);
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",selectedpageproperty,arg2);
		}
		if(arg2.equalsIgnoreCase("launch"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createlivecopy.getxpath()),arg2);
		if(arg2.equalsIgnoreCase("language copy"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createlivecopy.getxpath()),arg2);
		if(arg2.equalsIgnoreCase("catalog"))
		{
			ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
			particular_pageproperty.addAll(getWebElements(AEMPageObjects.createCatalog.getxpath()));
			WebElement selectedpageproperty = particular_pageproperty.get(1);
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",selectedpageproperty,arg2);
		}
		if(arg2.equalsIgnoreCase("csv report"))
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",getWebElement(AEMPageObjects.createlivecopy.getxpath()),arg2);



	}
	public static void createPageChosingTemplate(int arg1, String arg2) throws InterruptedException {

		ArrayList<WebElement> templatechoices = new ArrayList<WebElement>();
		templatechoices.addAll(getWebElements(AEMPageObjects.selecttemplatetomakethepage.getxpath()));
		WebElement chosentemplate = templatechoices.get(arg1);
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click",chosentemplate, arg2);

		ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
		particular_pageproperty.addAll(getWebElements(AEMPageObjects.next.getxpath()));
		WebElement selectednext = particular_pageproperty.get(0);
		CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",selectednext, "choosetemplatenext");


	}
	public static void creatingPageWithDesiredProperties(DataTable pageproperties) throws InterruptedException {

		//		List<List<String>> pageProperties = pageproperties.raw();
		//		pageProperties.get(0).get(0);
		List<Map<String, String>> propertiesforpage = pageproperties.asMaps(String.class, String.class);
//		Map<String, String> mapofpageproperties = (Map<String, String>) pageproperties.asMaps(String.class, String.class);
//		for(Map<String, String> mapofpageproperties:pageproperties.asMaps(String.class, String.class)) {
//			
//			
//			
//		}

		ArrayList<WebElement> particular_pageproperty = new ArrayList<WebElement>();
		particular_pageproperty.addAll(getWebElements(AEMPageObjects.pageproperties.getxpath()));

		for(int i=0;i<particular_pageproperty.size();i++)
		{
			String Property = particular_pageproperty.get(i).getText();
			CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", particular_pageproperty.get(i),Property);
			if(Property.equalsIgnoreCase("Basic")) {
				setWait("explicitwait", ExpectedConditions.visibilityOf(getWebElement(AEMPageObjects.createpagepropbasictitle.getxpath())), 5000);
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("Title"),"Enter",getWebElement(AEMPageObjects.createpagepropbasictitle.getxpath()), "EnteringPageTitle");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("Name"),"Enter",getWebElement(AEMPageObjects.createpagepropbasicname.getxpath()), "EnteringPageName");
				try {
					CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("Description"),"Enter", getWebElement(AEMPageObjects.createPageDescription.getxpath()), "Enteringdescription");
				} catch (Exception e) {
					System.out.println("description not present");
				}
			}	
			else if(Property.equalsIgnoreCase("Advanced")) {



			}
			else if(Property.equalsIgnoreCase("Thumbnail")) {



			}
			else if(Property.equalsIgnoreCase("Social Media")) {



			}
			else if(Property.equalsIgnoreCase("Cloud Services")) {



			}
			else if(Property.equalsIgnoreCase("Personalization")) {



			}
			else if(Property.equalsIgnoreCase("Permissions")) {



			}
			else if(Property.equalsIgnoreCase("Site Configurator")) {



			}
			else if(Property.equalsIgnoreCase("Cookie Configurator")) {
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("cookietitle"), "Enter", getWebElement(AEMPageObjects.cookiepolicytitle.getxpath()), "Entercookietitle");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("cookiepolicy"),"Enter",getWebElement(AEMPageObjects.cookiepolicytxt.getxpath()), "Enteringcookiepolicy");
				CommonFunction.highlightClickEnterDeletetakeScreenshot(propertiesforpage.get(0).get("cookiebtntext"),"Enter",getWebElement(AEMPageObjects.cookiebtntext.getxpath()), "Enteringbtnpolicy");


			}
			else if(Property.equalsIgnoreCase("User Sign-up Configuration")) {


			}
			else if(Property.equalsIgnoreCase("Promotion Configuration")) {


			}
			else if(Property.equalsIgnoreCase("Navigation Details")) {


			}
			else if(Property.equalsIgnoreCase("Product Details"))
			{



			}


		}
		CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click",getWebElement(AEMPageObjects.clickonsubmit.getxpath()), "Clicking on Create to create a page");
		Thread.sleep(2000);
		setWait("explicitwait", ExpectedConditions.visibilityOf(getWebElement(AEMPageObjects.clickonopenbtn.getxpath())), 5000);
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", getWebElement(AEMPageObjects.clickonopenbtn.getxpath()), "Clicking on Open to open a page");
		Point p = new Point(0, 0);
		Dimension d = new Dimension(0, 0);
		ArrayList<String> Windows=CommonFunction.browserFuntions("Handles", p, d);
		driver.switchTo().window(Windows.get(0));
		Thread.sleep(2000);
		


	}
	public static void clickOnRailToggleButtonAndSelect(String args) {

		CommonFunction.highlightClickEnterDeletetakeScreenshot("","Click", CommonFunction.getWebElement(AEMPageObjects.railleftbutton.getxpath()), "Clicking railleft button");
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.selectrailleftoption.getxpath().replaceAll("dummy", args)), args);


	}
	public static void clickOnBluePrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.clickonblueprintbtn.getxpath()), "Clicking on blueprint button");

	}
	public static void rolloutChangesOnLiveCopy(String arg) {


		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.livecopyselectedreferencingbluprint.getxpath().replaceAll("dummy",arg)), "Clicking on live Copy option");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.rolloutbtn.getxpath()), "Clicking on Rollout");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.rolloutscopebtn.getxpath()), "Clicking on Rollout during scope");
	}
	public static void selectCatalogBlueprint() {
		CommonFunction.highlightClickEnterDeletetakeScreenshot("", "Click", CommonFunction.getWebElement(AEMPageObjects.selectBlueprintCatalog.getxpath()), "Selecting the ");

		
	}
	
	



























}
