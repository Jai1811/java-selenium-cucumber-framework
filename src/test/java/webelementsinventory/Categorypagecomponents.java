package webelementsinventory;

public enum Categorypagecomponents {

	productCategoryAccordian("//div[@class='full-grid-container']//div[@class='filtercomponent__category']")
	
	
	
	
	
	
;
	
	String strlocator;

	private Categorypagecomponents(String setstrlocator) {
		this.strlocator = setstrlocator;
	}

	public String getxpath() {
		return strlocator;
	}
}

