
public class AssociationAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Beverages berObj = new Beverages("Alcohol","Brown", "Sour");
		berObj.printBeveragesInfo();
		
		Fruits frOb = new Fruits("Grapes",100 );
		
		Juices juOb= new Juices("Sweet",10,"Thick Juice");
		
		Sugar1 suObj = new Sugar1("Fine", 50,"Madhur");
		
		Alcohol alObj = new Alcohol("Alcohol", "Red", "Sour", "Wine", "Belstar Cult Prosecco");
		
		Wine wineObjWine = alObj.alcoholicFermentation(frOb, juOb, suObj);
		wineObjWine.printWineInfo();
 		
		
	}

}

class Beverages
{
	String beverageType;
	String color;
	String taste;
	public Beverages(String beverageType, String color, String taste) {
		super();
		this.beverageType = beverageType;
		this.color = color;
		this.taste = taste;
	}
	
	void printBeveragesInfo()
	{
		System.out.println("****Beverage Info***");
		System.out.println("beverage type : "+beverageType);
		System.out.println("beverage color : "+color);
		System.out.println("beverage taste : "+taste);
	}
}

class Alcohol extends Beverages
{
	String alcoholType;
	String brand;
	
	public Alcohol(String beverageType, String color, String taste, String alcoholType, String brand) 
	{
		super(beverageType, color, taste);
		this.alcoholType = alcoholType;
		this.brand = brand;
	}

	//producesA					usesA	usesA			usesA		usesA
		//|							|			|			|				|
	Wine alcoholicFermentation(Fruits f,Juices j,Sugar1 s)
	{
		Wine wine = new Wine(1200,"Belstar Cult Prosecco",800);
		return wine;
	}
}

class Fruits
{
	String fruitName;
	int fruitQuantity;
	
	public Fruits(String fruitName, int fruitQuantity) {
		super();
		this.fruitName = fruitName;
		this.fruitQuantity = fruitQuantity;
	}
	
}

class Juices
{
	String flavour;
	int juiceQuantity;
	String quality;
	public Juices(String flavour, int juiceQuantity, String quality) {
		super();
		this.flavour = flavour;
		this.juiceQuantity = juiceQuantity;
		this.quality = quality;
	}
	
}

class Sugar1
{
	String sugarQuality;
	int quantity;
	String sugarBrand;
	public Sugar1(String sugarQuality, int quantity, String sugarBrand) {
		super();
		this.sugarQuality = sugarQuality;
		this.quantity = quantity;
		this.sugarBrand = sugarBrand;
	}
	
}

class Wine{
	float wineBottleCost;
	String wineBrand;
	float wineMakingCost;
	public Wine(float wineBottleCost, String wineBrand, float wineMakingCost) {
		super();
		this.wineBottleCost = wineBottleCost;
		this.wineBrand = wineBrand;
		this.wineMakingCost = wineMakingCost;
	}
	
	void printWineInfo()
	{
		System.out.println("***** Wine Info*****");
		System.out.println("Wine brand -: "+wineBrand);
		System.out.println("Wine Making Cost -: "+wineMakingCost);
		System.out.println("Wine Per bottle Cost -: "+wineBottleCost);
	}
}
