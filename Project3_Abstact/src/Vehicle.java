

public abstract class Vehicle {

    abstract void start();
}
class car extends Vehicle{
	 
	@Override
	void start() {
		System.out.println("Starts With Key");
	}
	
}
class scooter extends Vehicle{
	 
	@Override
	void start() {
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

