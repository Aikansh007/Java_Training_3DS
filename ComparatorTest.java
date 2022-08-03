//Java program to Sort ArrayList using Comparator

import java.util.*;

//create the Shop class
class Shop 
{
	int ProductNo;
	String name;
	int stock;
	
	public Shop(int productNo, String name, int stock)
	{
		super();
		ProductNo = productNo;
		this.name = name;
		this.stock = stock;
	}
}

class StockComparator implements Comparator<Shop>
{

	@Override
	public int compare(Shop o1, Shop o2) 
	{
		// TODO Auto-generated method stub
		if (o1.stock == o2.stock)
			return 0;
		else if (o1.stock > o2.stock)
			return 1;
		else
		return -1;
	}
}
public class ComparatorTest
{
	public static void main(String[] args)
	{
		// create the ArrayList object
		ArrayList<Shop> s = new ArrayList<Shop>();
		s.add(new Shop(218, "Pen", 520));
		s.add(new Shop(223, "Pencil", 213));
		s.add(new Shop(423, "Books", 101));
		s.add(new Shop(512, "Toy", 59));
		s.add(new Shop(723, "Bottle", 10));

		System.out.println("before sorting");
		for (Shop shop : s) 
		{
			System.out.println(shop.stock + " " + shop.name
							+ " " + shop.ProductNo);
		}
		System.out.println();

		System.out.println("After sorting(sorted by Stock)");

		// call the sort function
		Collections.sort(s, new StockComparator());
		for (Shop shop : s) 
		{
			System.out.println(shop.stock + " " + shop.name+ " " + shop.ProductNo);
		}
	}
}

