package entities;

import jakarta.persistence.*;

@Entity
<<<<<<< HEAD
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "phone_number", nullable = false, length = 45)
=======
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "idCompany", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "phoneNumber", nullable = false, length = 45)
>>>>>>> cd8663f (Name of variables)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "address", length = 45)
    private String address;

    public Company() {
    }

    public Company(int id, String name, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
