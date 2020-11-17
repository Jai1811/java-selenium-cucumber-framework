package webelementsinventory;


public enum HomePageComponents {

	KAWCookiesPolicyText("//div[@class='cookienotice__container container']//div[@class='cmp-text']"),
	KAWCookiesPolicyAgreeBtn("//div[@class='cookienotice__accept']//a[@class='button__link button--primary']"),
	KAWctaBoxesHomePage("//div[@class='calltoactionbox__container']"),
	KAWtextWithLinkHomePage("//div[@class='textwithlink__container cmp-text']"),
	KAWCalender("//div[@data-component='Calendar']"),
	KAWfooter("//div[@class='footer__section']"),
	subnavigationHomePage("//nav[@class='cmp-navigation cmp-navigation--inline navigation']//a"),
	subnavigationlinks("//div[@class='subnav__contentContainer']//a"),
	subnavigationGreenlinks("//div[@class='subnav__contentFooter']//a"),
	footerLinks("//div[@class='footer__section']//a")
	
	
	
	
	
	;
	
	String strlocator;

	private HomePageComponents(String setstrlocator) {
		this.strlocator = setstrlocator;
	}

	public String getxpath() {
		return strlocator;
	}
}
