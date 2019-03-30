package turnConTest.com.turn;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;


public class EmployeeDAO {
	private static final HashMap<String,Employee> employee = new HashMap<String,Employee>();
	public static  HashMap<String, Employee> addEmployee( String userName) {
        String employeeName =userName;
        int size = employee.size();
        String employeeID = Integer.toString(size + 1);
        //LocalDateTime checkIn = LocalDateTime.now();
        LocalDateTime checkIn = Instant.now().atZone(ZoneId.of("America/Chicago")).toLocalDateTime();
        employee.put(employeeID, new Employee(employeeID, employeeName, checkIn));
        return employee;
   }
	public static  HashMap<String, Employee> addEmployee( String id, Employee e) {
        employee.put(id, e);
        return employee;
   }
	public static  Employee getEmployee( String id) {
        return employee.get(id);
   }
	public static  boolean isSameName( String name) {
		for (Employee employee1 : employee.values()) {
			if(employee1.getEmpName().toLowerCase().equals(name.trim().toLowerCase())) {
				return false;
			}
		}
        return true;
   }
	public static  HashMap<String, Employee> getEmployee( ) {
        return employee;
   }
	public static  HashMap<String, Employee> clearEmployee( ) {
		employee.clear();
        return employee;
   }
}
