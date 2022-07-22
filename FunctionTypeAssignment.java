
public class FunctionTypeAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Electronics Price = new Electronics();
		Price.iphonePrice();
		Price.calculateTabPrice(20000, 40000);
		double TvPriceCalculated=Price.calculateTvPrice(3000,200.54);
		System.out.println("Tv Price is :"+TvPriceCalculated);
		double LaptopPriceCalculated=Price.calculateLaptopPrice();
		System.out.println("Laptop Price : "+LaptopPriceCalculated);
	}

}
class Electronics{
	void iphonePrice() {
		System.out.println("As per your Budget to buy");
		System.out.println("************************");
	}
	void calculateTabPrice(int x, int y) {
		int totalTabPrice= x+y;
		System.out.println("Tab Price :"+totalTabPrice);
		System.out.println("************************");
	}
	double calculateTvPrice(int x, double y)
	{
		System.out.println("Tv price");
		System.out.println("************************");
		return x+y;
	}
	double calculateLaptopPrice() {
		System.out.println("************************");
		return 4000*20.04;
	}
}
