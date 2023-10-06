import entities.Employee;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import queries.EmployeeQuery;
import java.sql.Date;
import java.util.List;

public class EmployeeTest {

    @Test
    @Description("Getting all employees from the database")
    public void getAllEmployees() {
        List<Employee> employees = new EmployeeQuery().getAllEmployee();
        Assert.assertTrue(employees != null && !employees.isEmpty());
    }

    @Test
    @Description("Getting employees by last name")
    public void getEmployeesByLastname() {
        String lastname = "Lopez";
        List<Employee> employees = new EmployeeQuery().getEmployeesByLastName(lastname);
        Assert.assertTrue(employees != null && !employees.isEmpty());
    }

    @Test
    @Description("Inserting a new employee into the database")
    public void insertNewEmployee() {
        int id = 100;
        String name = "Sumara";
        String lastName = "Lopez";
        String email = "sumloo@gmail.com";
        String phoneNumber = "32410933942";
        double salary = 4200;
        Date birthDate = java.sql.Date.valueOf("2000-01-31");
        int companyID = 5;

        EmployeeQuery employeeQuery = new EmployeeQuery();
        int employeeId = employeeQuery.insertEmployee(new Employee(id, name, lastName, email, phoneNumber, null, salary, birthDate, companyID));
        Assert.assertTrue(employeeId > 0);
    }

    @Test
    @Description("Updating an existing employee's information in the database")
    public void updateEmployee() {
        int id = 100;
        String name = "Gotenks";
        String lastName = "Gogeta";
        String email = "Gotenks@gmail.com";
        String phoneNumber = "3009876543";
        double salary = 8200;
        Date birthDate = java.sql.Date.valueOf("2000-02-29");
        int companyID = 5;

        EmployeeQuery employeeQuery = new EmployeeQuery();
        int updatedEmployeeID = employeeQuery.updateEmployeeInfo(id, name, lastName, email, phoneNumber, salary, birthDate, companyID);
        Assert.assertTrue(updatedEmployeeID > 0);
    }

    @Test
    @Description("Deleting an employee from the database")
    public void deleteEmployee() {
        int id = 100;

        EmployeeQuery employeeQuery = new EmployeeQuery();
        int deletedEmployeeID = employeeQuery.deleteEmployee(id);
        Assert.assertTrue(deletedEmployeeID > 0);

        Employee deletedEmployee = employeeQuery.getEmployeeByID(id);
        Assert.assertNull(deletedEmployee);
    }
}
