package test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Employee{
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String name;
	public double salary;
}

public class StreamAPITest {
	
	public static void main(String args[]) {
		System.out.println("Stream API Test");
		
		
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Test 1");
		emp.setSalary(40000);
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Test 2");
		emp2.setSalary(50000);
		Employee emp3 = new Employee();
		emp3.setId(3);
		emp3.setName("Test 3");
		emp3.setSalary(60000);
		Employee emp4 = new Employee();
		emp4.setId(4);
		emp4.setName("Test 4");
		emp4.setSalary(60000);
		empList.add(emp);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		
		boolean allMatch = empList.stream().allMatch(e->e.getSalary() > 50000);
		System.out.println(" All Employee having salary more than 50000 "+ allMatch);
		
		boolean anyMatch = empList.stream().anyMatch(e->e.getSalary() > 50000 );
		System.out.println(" There are some employee whose salary is more than 50000 " + anyMatch);
		
		System.out.println("Printting employess whose salary is more than 50000");
		empList.stream().filter(e->e.getSalary() > 50000).forEach(e->System.out.println(e.getName()));
		
		System.out.println("Finding the first employee whose salary is more than 50000");
		Optional<Employee> optionalEmp = empList.stream().filter(e->e.getSalary() > 50000).findFirst();
		if(optionalEmp.isPresent()) {
			System.out.println(" First employee is " + optionalEmp.get().getName());
		}
		
		System.out.println("Finding any employee whose salary is more than 50000");
		Optional<Employee> optionalAny = empList.stream().filter(e->e.getSalary() > 50000).findAny();
		if(optionalAny.isPresent()) {
			System.out.println(" Employee is " + optionalEmp.get().getName());
		}
		System.out.println("Finding any employee whose salary is less than 30000");
		Optional<Employee> optionalAny30k = empList.stream().filter(e->e.getSalary() < 30000).findAny();
		if(optionalAny30k.isPresent()) {
			System.out.println(" Employee name : " + optionalAny30k.get().getName());
		} else if(optionalAny30k.isEmpty()) {
			System.out.println("No Employee is present whose salary is less 30000");
		}
		
		
		

		
		
	}

}
