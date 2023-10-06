package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="employees") // Changed table name to plural (employees)
public class Employee {

    @Id
    @Column(name="id_employee",nullable = false)
    private int id;

    @Column(name="first_name",nullable = false,length = 45)
    private String firstName;

    @Column(name="last_name",nullable = false,length = 45)
    private String lastName;

    @Column(name="email",nullable = false,length = 45)
    private String email;

    @Column(name="phone_number",nullable = false,length = 45)
    private String phoneNumber;

    @Column(name="address",length = 45)
    private String address;

    @Column(name="salary",nullable = false)
    private double salary;

    @Column(name="birth_date",nullable = false)
    private Date birthDate;

    @Column(name="id_company",nullable = false)
    private int idCompany;

    // Constructors

    public Employee(){
    }

    public Employee(int id, String firstName, String lastName, String email, String phoneNumber, String address, double salary, Date birthDate, int idCompany ){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.birthDate = birthDate;
        this.idCompany = idCompany;
    }

    // Getters and setters

    // For id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // For first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // For last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // For email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // For phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // For address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // For salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // For birth date
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // For company id
    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    // Additional method to get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Additional method to calculate age
    public int calculateAge() {
        // Add code to calculate age based on birthDate
        return 0; // Placeholder, replace with actual calculation
    }
}