package ad.ad_ud2_a_2_second_crud.repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ad.ad_ud2_a_2_second_crud.repository.EmployeeDao;
import ad.ad_ud2_a_2_second_crud.repository.model.Employee;

/**
 * Implementación del DAO mediante JDBC
 */
public class EmployeeJdbcDao  implements EmployeeDao {
	
	//TODO
	//private static final String SQL_SELECT_BEGIN_A = "Select * from EMPLOYEE where....;
	private static final String SQL_SELECT = "Select * from EMPLOYEE";


	
	@Override
	public List<Employee> getAll() throws Exception {
		return query(SQL_SELECT);
	}
	
	@Override
	public List<Employee> getEmployeesWithLessSalary(Double salaryCondition) throws Exception {
		List<Employee> result = new ArrayList<>();
		String SQL_SELECT = "Select * from EMPLOYEE WHERE SALARY < ?";

		try (Connection conn = DriverHelper.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
			preparedStatement.setDouble(1, salaryCondition);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = mapResultSet(resultSet);
				result.add(emp);
			}

		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}
	
	/**
	 * Funcion comun para aquellas queries sin criterios de busqueda
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	private List<Employee> query(String query) throws Exception {
		List<Employee> result = new ArrayList<>();
		try (Connection conn = DriverHelper.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee obj = mapResultSet(resultSet);
				result.add(obj);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}
	
	/**
	 * Mapea todos los objetos JDBC al objeto Java Empleado
	 * 
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private Employee mapResultSet(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("ID");
		String name = resultSet.getString("NAME");
		BigDecimal salary = resultSet.getBigDecimal("SALARY");
		Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		// Timestamp -> LocalDateTime
		emp.setCreatedDate(createdDate.toLocalDateTime());
		return emp;
	}



	@Override
	public Employee getById(int id) {
		return null;
	}

	@Override
	public void create(Employee t) {

	}

	@Override
	public void update(Employee t) {
		//TODO
	}

	@Override
	public void delete(int id) {
		//TODO
		
	}

}