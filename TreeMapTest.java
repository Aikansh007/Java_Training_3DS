import java.util.*;
class Rocket
{
	int rocketNo;
	String rocketname;
	public Rocket(int rocketNo, String rocketname) {
		super();
		this.rocketNo = rocketNo;
		this.rocketname = rocketname;
	}
	@Override
	public String toString() {
		return "Rocket [rocketNo=" + rocketNo + ", rocketname=" + rocketname + "]";
	}
	
	
}
public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rocket rocket = new Rocket(106,"Agni");
		Rocket rocket2 = new Rocket(105,"Chandra yaan");
		Rocket rocket3 = new Rocket(101,"Yaan");
		
		TreeMap<Integer,Rocket> map = new TreeMap<Integer, Rocket>();
		map.put(2, rocket3);
		map.put(5, rocket2);
		map.put(9, rocket);
		
		for(Map.Entry m:map.entrySet())  
	      {  
	          System.out.println(m.getKey()+" "+m.getValue());      
	      } 
	
	}

}

