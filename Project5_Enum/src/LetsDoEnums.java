import java.util.logging.Level;


public class LetsDoEnums {
  enum Flavor{
	  Chocolate, Vanilla,Strawberry;
	  
	  public static void getVanilla() {
		  System.out.println(Flavor.Vanilla);
	  }
  }
	
	public static void main(String[] args) {
		Flavor flav=Flavor.Vanilla;
		flav.getVanilla();
		
		/*if(flav==flav.Vanilla) {
			System.out.println("It Is Vanilla");
		}
		else if(flav==flav.Chocolate) {
			System.out.println("It Is Chocolate");
		}
		else if(flav==flav.Strawberry) {
			System.out.println("It Is Strawberry");
		}*/
	}
}
	


