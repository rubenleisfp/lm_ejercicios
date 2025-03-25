package ad.ad_ud2_a_2_second_crud;

import java.util.List;

import ad.ad_ud2_a_2_second_crud.repository.impl.EmployeeJdbcDao;
import ad.ad_ud2_a_2_second_crud.repository.model.Employee;

public class App {


	public static void main(String[] args) {
		EmployeeJdbcDao employeeDao = new EmployeeJdbcDao();
		try {
			List<Employee> beginA = employeeDao.getAllEmployeesBeginA();
			System.out.println("BeginA:");
			beginA.forEach(x -> System.out.println(x));

			List<Employee> allEmployees = employeeDao.getAll();
			System.out.println("AllEmployees:");
			allEmployees.forEach(x -> System.out.println(x));

			System.out.println("EmployeesWithLessSalary:");
			List<Employee> employeesWithLessSalary = employeeDao.getEmployeesWithLessSalary(Double.parseDouble("3000"));
			employeesWithLessSalary.forEach(x -> System.out.println(x));
		} catch (Exception e) {
			System.out.println("Error conectando con la BBD" + e);
		}

	}
}
