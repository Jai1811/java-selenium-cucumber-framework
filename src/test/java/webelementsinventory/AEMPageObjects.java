package webelementsinventory;

public enum AEMPageObjects {

	usernametxt("//*[@id='username']"), 
	passwordtxt("//*[@id='password']"),
	loginbutton("//*[@id='submit-button']"), 
	Navigationtxt("/*[@id='//*[@id='coral-id-3']/coral-panel-content/betty-titlebar/betty-titlebar-title/span"),
	toolsicon("//*[@title='Tools']"),
	sitestab("//div[@data-foundation-collection-navigator-href='/sites.html/content']"),
	sitepages("//coral-columnview-item[@data-foundation-picker-collection-item-text='/content/dummy']"), 
	

	selectpaththumbnail("//coral-columnview-item-thumbnail//img[contains(@src,'dummy')]"),
	

	createcoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='addCircle']"),
	editcoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='edit']"),
	propertiescoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='infoCircle']"),
	lockcoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='lockOn']"),
	unlockcoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='lockOff']"),
	copycoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='copy']"),
	movecoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='move']"),
	quickpublishcoralactionbarbtn("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='globe']"),
	morecoralactionbarbtn(""),
	managecoralactionbarbutton("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='globeClock']"),
	deletcoralactionbarbutton("//coral-actionbar-item[@class='coral3-ActionBar-item']//button[@icon='delete']"),
	
	
	

	createworkflow("//a[@icon='layersBringToFront']"),
	createversion("//a[@icon='layers']"),
	
	createpage("//a[@class='cq-siteadmin-admin-createpage foundation-collection-action coral-Link coral3-BasicList-item coral3-AnchorList-item']"),
	selecttemplatetomakethepage("//coral-masonry/coral-masonry-item"),
	createpagepropbasictitle("//input[@name='./jcr:title']"),
	createpagepropbasicname("//input[@name='pageName']"),
	createPageDescription("//div//textarea[@name='./jcr:description']"),
	cookiepolicytitle("//input[@name='./policyTitle']"),
	cookiepolicytxt("//div[@data-fieldlabel='Privacy policy text']"),
	cookiebtntext("//input[@name='./buttonText']"),
	clickonopenbtn("//button[@class='coral3-Button coral3-Button--primary']"),
	bikeconfigurator("//input[@name='./bikeConfiguratorPath']"),
		
	
	
	
	createsite("//a[@class='cq-siteadmin-admin-createsite foundation-collection-action coral-Link coral3-BasicList-item coral3-AnchorList-item']"),
	createlivecopy("//a[@icon='pages']"),
	destinitionpathforlivecopy("//coral-columnview-item[@data-foundation-collection-item-id='/content/dummy']"),
	next("//button[@data-foundation-wizard-control-action='next']"),
	titleforlivecopy("//input[@name='title']"),
	nameforlivecopy("//input[@name='label']"),
	clickonsubmit("//button[@type='submit']"),
	launch("//a[@class='cq-siteadmin-admin-createlivecopy foundation-collection-action coral-Link coral3-BasicList-item coral3-AnchorList-item'][2]"),
	languagecopy("//a[@class='cq-siteadmin-admin-createlanguagecopy foundation-collection-action coral-Link coral3-BasicList-item coral3-AnchorList-item']"),
	
	createCatalog("//a[@class='cq-siteadmin-admin-createcatalog foundation-collection-action coral-Link coral3-BasicList-item coral3-AnchorList-item']"),
	selectBlueprintCatalog("//div[@class='coral3-Card-wrapper']"),
	selectCatalogFolder("//coral-masonry//coral-masonry-item"),
	selectButton("//button[@icon='checkCircle']"),
	selectNext("//button[@variant='primary']"),
	catalogTitle("//input[@name='title']"),
	catalogName("//input[@name='label']"),
	clickOnCreate("//button[@type='submit']"),
	ClickODone("//button[@class='coral3-Button coral3-Button--secondary']"),
	aemTitle("//coral-shell-homeanchor-label"),
	
	
	editbutton("//button[@class='editor-GlobalBar-item js-editor-GlobalBar-layerCurrent editor-GlobalBar-layerCurrent js-editor-LayerSwitcherTrigger coral3-Button coral3-Button--minimal']"),
	previewbutton("//button[@data-layer='Preview']"),
	togglesidepanelbtn("//button[@title='Toggle Side Panel']"),
	
	pageinfobutton("//a[@title='Page Information']"),
	openproperties("//button[@title='Open Properties']"),
	startworkflow("//button[@title='Start Workflow']"),
	lockpage("//button[@title='Lock Page']"),
	publishpage("//button[@title='Publish Page']"),
	unpublishpage("//button[@title='Unpublish Page']"),
	edittemplate("//button[@title='Edit Template']"),
	viewaspublished("//button[@title='View as Published']"),
	viewasadmin("//button[@title='View in Admin']"),
	help("//button[@title='Help']"),
	
	pageproperties("//coral-tab"),
	
	railleftbutton("//coral-cyclebutton[@icon='railLeft']"),
	selectrailleftoption("//coral-selectlist-item[text()='dummy']"),
	clickonblueprintbtn("//section[@data-item-resource-type='wcm/msm/components/coral/references/blueprint']"),
	livecopyselectedreferencingbluprint("//section[@data-path='dummy']"),
	rolloutbtn("//button[@class='live-copy-rollout live-copy-action coral3-Button coral3-Button--block coral3-Button--secondary']"),
	rolloutscopebtn("//button[@class='cq-sites-references-rollout-dialog-submit coral3-Button coral3-Button--primary']"),
	clickonpreviewineditor("//button[@data-layer='Preview']"),
	
	
	damimage("//img[@class='cq-dd-image']")
	;
	
	
	
	

	
	
	
	String strlocator;

	private AEMPageObjects(String setstrlocator) {
		this.strlocator = setstrlocator;
	}

	public String getxpath() {
		return strlocator;
	}

}
