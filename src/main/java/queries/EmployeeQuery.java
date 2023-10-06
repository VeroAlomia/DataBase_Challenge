package queries;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.sql.Date;
import java.util.List;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.sql.Date;
import java.util.List;

public class EmployeeQuery {

    private JpaManager jpaManager = new JpaManager();
    private EntityManager manager;
    private EntityTransaction transaction;

    public EmployeeQuery(){
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }

    public List<Employee> getAllEmployee() {
        List<Employee> listEmployee = manager.createQuery("FROM Employee", Employee.class).getResultList();
        return listEmployee;
    }

    public List<Employee> getEmployeesByLastName(String lastname){
        List<Employee> listEmployee = manager.createQuery("SELECT em FROM Employee em WHERE em.lastName = :lastname", Employee.class)
                .setParameter("lastname", lastname)
                .getResultList();
        return listEmployee;
    }

    public int insertEmployee(Employee employee){
        transaction.begin();

        manager.persist(employee);

        try{
            transaction.commit();
            return employee.getId();
        }catch (Exception e){
            transaction.rollback();
            System.out.println("Employee was not uploaded");
            return -1;
        }
    }

    public Employee getEmployeeByID(int id){
        Employee employee = manager.find(Employee.class, id);
        return employee;
    }

    public int updateEmployeeInfo(int id, String firstName, String lastName, String email, String phoneNumber, double salary, Date birthDate, int idCompany ){
        Employee employee = getEmployeeByID(id);

        if(employee != null){
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
            employee.setSalary(salary);
            employee.setBirthDate(birthDate);
            employee.setIdCompany(idCompany);

            transaction.begin();

            manager.merge(employee);

            try{
                transaction.commit();
                return employee.getId();
            }catch (Exception e){
                transaction.rollback();
                System.out.println("Database was not updated");
                return -1;
            }
        }else{
            System.out.println("Employee not found");
            return -1;
        }
    }

    public int deleteEmployee(int id){
        Employee employee = getEmployeeByID(id);

        if(employee != null){
            transaction.begin();
            manager.remove(employee);

            try{
                transaction.commit();
                return employee.getId();
            }catch (Exception e){
                transaction.rollback();
                System.out.println("Database was not updated");
                return -1;
            }
        }else{
            System.out.println("Employee was not found");
            return  -1;
        }
    }
}
