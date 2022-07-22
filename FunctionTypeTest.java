
public class FunctionTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator myCalc = new Calculator();
		myCalc.fun1();
		
		myCalc.fun2(2,22.4f, 43.32);
		
		double add =myCalc.fun3('A', 56.35f, 34.56);
		System.out.println("additon of Function 3 "+add);
		
		double theDistanceBetweenSunAndEarth= myCalc.fun4();
		System.out.println("The Distance Between Sun And Earth "+TheDistanceBetweenSunAndEarth );
	}
	
}
class Calculator
{
	//1 func without arg and nothing return
	void fun1()
	{
		System.out.println("fun1 is doing some activity");
		System.out.println("------------------------");
	}
	//2 func with arg and nothing returned
	void fun2(int x, float y, double d)
	{
		System.out.println("fun2 is doing some activity");
		System.out.println("x "+x+" y "+y+" d "+d);
		System.out.println("------------------------");
	}
	//3 func with arg and value returned
	double fun3(char c, float y, double d)
	{
		System.out.println("fun3 is doing some activity");
		System.out.println("c "+c+" y "+y+" d "+d);
		System.out.println("------------------------");
		return y+d+6;
		
	}
	
	//4 func without arg and value returned
	double fun4() 
	{
		System.out.println("fun4 is doing some activity");
		System.out.println("------------------------");
		return 18600 * 480;
	}
	
	
}
