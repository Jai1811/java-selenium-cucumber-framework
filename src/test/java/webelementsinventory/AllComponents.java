package webelementsinventory;

public enum AllComponents {

	dragComponenthereParsys("//div[@data-text='Drag components here']"),
	insertnewComponentBtn("//button[@title='Insert component']"),
	enterKeywordstxtBox("//input[@placeholder='Enter Keyword']"),
	selectComponent("//coral-selectlist-item[text()='dummy']"),
	Componenttoedit("//div[@title='dummy']"),
	editableToolBarOptions("//div[@id='EditableToolbar']//button[@title='dummy']"),
	Dailogboxcheckbtn("//div[@class='cq-dialog-actions u-coral-pullRight']//button[@icon='check']"),
	imagedrpDown("//coral-tabview/coral-tablist[@class='coral3-TabList']//coral-tab"),
	dailogboxheader("//coral-dialog-header[@class='cq-dialog-header']"),
	folderSearch("//span[@class='coral-InputGroup-button']//button[@icon='folderSearch']"),
	KAWLinkToDialogBoxOption("//span//input[@name='./link/linkPath']"),
	KAWOpenInTab("//coral-select[@name='./link/target']//button"),
	KAWTextWIthLinkTitle("//input[@name='./title']"),
	KAWTextWITHLINKTitlePublished("//h1[@class='title__text title__text--h2 ']"),
	KAWCTABoxTitle("//input[@name='./ctaTitle']"),
	KAWCTABoxTitlePublished("//h3[@class='title__text calltoactionbox__title ']"),
	KAWSocialMediaLinkedList("//div[@title='KAW Social Media Linklist']"),
	KAWServiceAndWarrantyList("//div[@title='KAW List' and @data-path='/content/playground/autoro/it/jcr:content/root/footer/list-services']"),
	KAWAboutKawasakiList("//div[@title='KAW List' and @data-path='/content/playground/autoro/it/jcr:content/root/footer/list-about']"),
	KAWSocialMediaLinklist("//div[@data-path='/content/playground/autoro/it/jcr:content/root/footer/list-social-media']"),
	KAWFooterCTA("//div[@data-path='/content/playground/autoro/it/jcr:content/root/footer/ctacontainer']//div[@title='KAW CTA Component']"),
	KAWIMageimagedrpbox("//coral-fileupload[@class='coral-Form-field cq-FileUpload cq-droptarget coral3-FileUpload']"),
	KAWCookieNoticeandSettingslink("//div//div[@class='cookienotice__settings']/a")
	
	
	
	;
	
	String strlocator;

	private AllComponents(String setstrlocator) {
		this.strlocator = setstrlocator;
	}

	public String getxpath() {
		return strlocator;
	}
	
	
	
}
