class Parent{
	int a=10;
	void display(){
		System.out.println("i am from parent");
	}
}

class Child extends Parent  {
	 int b=20;
	 void show(){
	 	System.out.println("i am from child");
	 }
}

class Inherit1 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.a);
		System.out.println(c.b);
		c.display();
		c.show();

	}
	
}
	


