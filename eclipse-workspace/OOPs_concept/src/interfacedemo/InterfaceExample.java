package interfacedemo;
interface Abc {
	public static final int A=10;
	public abstract void dis1();
}
interface Xyz {
	int B=10;
	void dis2();
}
interface Mno extends Abc,Xyz {
	int C=10;
	void dis3();
}
class Demo implements Abc ,Xyz{
	@Override
	public void dis2() {
		System.out.println("Xyz interface method");
	}
	@Override
	public void dis1() {
		System.out.println("Abc interface method");
	}
}
public class InterfaceExample {
	public static void main(String[] args) {		
		Demo obj = new Demo();
		obj.dis1();
		obj.dis2();
	}

}