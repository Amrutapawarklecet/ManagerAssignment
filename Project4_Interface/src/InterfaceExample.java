
interface Vehicle {

    void start();
}
class car implements Vehicle{

	@Override
	public void start() {
		System.out.println("Starts With Key");
		
	}
	 
	}
	

class scooter implements Vehicle{

	@Override
	public void start() {
		System.out.println("Starts With Kick");
		
	}
	 
	
	
}
class Launch{
	public static void main(String[] args) {
		car c=new car();
		c.start();
		scooter s=new scooter();
		s.start();
	}
}


