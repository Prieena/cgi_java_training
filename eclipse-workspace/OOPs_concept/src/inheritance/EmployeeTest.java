package inheritance;

public class EmployeeTest {

	public static void main(String[] args) {
//		Employee emp1 = new Employee();
//		emp1.readEmp();
//		emp1.disEmp();

		Manager mgr = new Manager();
		//mgr.readEmp();
		mgr.readMgr();
		
		//mgr.disEmp();
		mgr.disMgr();
	}

}