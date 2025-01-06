package ad.ad_ud2_a_2_second_crud.repository;

import java.util.List;

import ad.ad_ud2_a_2_second_crud.repository.model.Employee;

/**
 * Firmas con objetos limpios, desacoplado de JDBC o cualquier otra implementacion
 * 
 * El dia de mañana podría sustiuir la implementacion de JDBC por lectura de fichero p.ej
 * 
 */
public interface EmployeeDao extends GenericDao< Employee>{

	/**
	 * Obtiene todos los empleado cuya primera letra es A
	 * @return
	 * @throws Exception
	 */
	List<Employee> getAllEmployeesBeginA() throws Exception;

	/**
	 * Obtiene todos los empleados con una salario menor al recibido por argumetno
	 * 
	 * @param salaryCondition
	 * @return
	 * @throws Exception
	 */
	List<Employee> getEmployeesWithLessSalary(Double salaryCondition) throws Exception;

	

}
