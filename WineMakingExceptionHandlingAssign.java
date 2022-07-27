
public class WineMakingExceptionHandlingAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Begin main...");
		WineMaking wineMakingObj = new WineMaking();
		try {
			wineMakingObj.StartWineProcess();
			wineMakingObj.SelectProcess();			
		}catch (WineProcessIsNotStartedException e) {
			// TODO: handle exception
			System.out.println("Problem : "+e);
		}
		System.out.println("End of main...");
	}

}

class  WineProcessIsNotStartedException extends Exception
{
	WineProcessIsNotStartedException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

class WineMaking
{
	boolean isGrapesAvailable = false;
	
	WineMaking() {
		// TODO Auto-generated constructor stub
		System.out.println("Wine in Making...But is it ready with Grapes ??????...");
	}
	
	void StartWineProcess()
	{
		if(isGrapesAvailable == false)
		{
			isGrapesAvailable = true;
		}
		System.out.println("Wine Making Process is On....");
	}
	
	void SelectProcess() throws WineProcessIsNotStartedException
	{
		if(isGrapesAvailable == false)
		{
			WineProcessIsNotStartedException wineProcessIsNotStartedEx = new WineProcessIsNotStartedException(" The Wine Making process is not Started yet due to Grapes' unavailability");
			throw wineProcessIsNotStartedEx;
		}
		System.out.println("Wine Process started....");
		Harvest();
		System.out.println("Wine is Ready ! Enjoyyyyyyyyyyyyyyyyy (-_-)...");
	}
	
	void Harvest()
	{
		for(int i =1;i<=10;i++)
		{
			System.out.println("Harvesting..."+i);
		}
		
		Destemming_And_Crushing ();
	}
	void Destemming_And_Crushing ()
	{
		for(int i =1;i<=8;i++)
		{
			System.out.println("\t Destemming_And_Crushing..."+i);
		}
		
		Pressing();
	}
	void Pressing()
	{
		for(int i =1;i<=6;i++)
		{
			System.out.println("\t\t Pressing..."+i);
		}
		Fermentation();
	}
	void Fermentation()
	{
		for(int i =1;i<=4;i++)
		{
			System.out.println("\t\t\t Fermentation..."+i);
		}
		Clarification();
	}
	void Clarification()
	{
		for(int i =1;i<=2;i++)
		{
			System.out.println("\t\t\t\t Clarification..."+i);
		}
		Aging_And_Bottling();
	}
	void Aging_And_Bottling()
	{
		for(int i =1;i<=1;i++)
		{
			System.out.println("\t\t\t\t\t Aging_And_Bottling..."+i);
		}
	}
	void StopWineProcess()
	{
		if(isGrapesAvailable == true)
		{
			isGrapesAvailable = false;
		}
		System.out.println("Wine Making Process is Stopped....");
	}
}