package statickeyword;
class Info {
	int a;	// non static 
	static int b;
	void dis() {
		System.out.println("a "+a);
		System.out.println("b "+b);
	}
}
public class StaticExample1 {
	public static void main(String[] args) {
		Info i1 = new Info();		// heap memory 
		Info i2 = new Info();		// heap memory 
		i1.a=10;
		Info.b=20;
		i1.b=30;
		i2.a=40;
		Info.b=50;
		i2.b=60;
		i1.dis();		//a=10, b = 60
		i2.dis();		// a=40, b =60 
	}
}