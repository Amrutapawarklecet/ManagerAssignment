//static class loading
class StaticClass {
  public static void main(String args[]) {
	  StaticClass tc = new StaticClass();
  }
}

//Dynamic class loading
//Example code to illustrate forName() method 

public class DynamicClass { 
 public static void main(String[] args) throws ClassNotFoundException { 

     // get the Class instance using forName method 
     Class obj = Class.forName("java.lang.String"); 

     System.out.print("obj is an object of class: " + obj.toString()); 
 } 
}
