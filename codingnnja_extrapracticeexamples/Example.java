package codingnnja_extrapracticeexamples;


class Parent {
	static void display() {
		System.out.println("Super class");
	}
}

public class Example extends Parent {
	static void display()  {
		      System.out.println("Sub class");
		   }

	public static void main(String[] args) {
		Parent obj = new Example();
	
		obj.display();
	}
}


