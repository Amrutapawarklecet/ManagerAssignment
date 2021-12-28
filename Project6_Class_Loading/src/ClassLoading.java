class Base{
	int x=10;
	static int y=20;
	void show() {
		System.out.println("show of Base");
	}
	static void disp() {
		System.out.println("disp of Base");
	}
}

class Child extends Base{
	int x=100;
	static int y=200;
	void show() {
		System.out.println("show of Child");
	}
	static void disp() {
		System.out.println("disp of Child");
	}
}
public class ClassLoading {

	public static void main(String[] args) {
		try {
			java.util.Scanner s=new java.util.Scanner(System.in);
			System.out.println("Enter the name of class");
			String name=s.next();
			Class c=Class.forName(name);
			Base b=(Base)c.newInstance();
			b.show();
			b.disp();
			System.out.println(b.x);
			System.out.println(b.y);
		}
		catch(Exception e) {
			System.out.println("Enter the name of class to be loaded...");
		}

	}

}
