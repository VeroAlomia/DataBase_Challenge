import entities.Company;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import utils.crud.CompanyCrud;

public class CompanyTest {

    CompanyCrud companyCrud = new CompanyCrud();

    @Test
    @Description("Getting all companies")
    public void getAllCompanies() {
        companyCrud.getAllCompanies();
    }

    @Test
    @Description("Getting a company by name")
    public void getCompanyByName() {
        String name = "Only";
        companyCrud.getCompanyByName(name);
    }

    @Test
    @Description("Getting a company by ID")
    public void getCompanyById() {
        int id = 1;
        companyCrud.getCompanyById(id);
    }

    @Test
    @Description("Inserting a new company")
    public void insertNewCompany() {
        int id = 6;
        String name = "PriceSmart";
        String email = "carulla@carulla.com";
        String address = "Carrera 10 #20-30";
        String phone = "987654321";

        Company company = new Company(id, name, email, address, phone);
        System.out.println("Company Id: " + company.getId());
        System.out.println("Company name: " + company.getName());
        System.out.println("Company email: " + company.getEmail());
        System.out.println("Company phone: " + company.getPhoneNumber());
        System.out.println("Company address: " + company.getAddress());
        companyCrud.insertCompany(company);
        companyCrud.getCompanyById(id);
    }

    @Test
    @Description("Updating a company")
    public void updateCompany() {
        int id = 6;
        String name = "Carulla";
        String email = "carulla@carulla.com";
        String address = "Carrera 10 #20-30";
        String phone = "987654321";

        companyCrud.getCompanyById(id);
        companyCrud.updateCompany(id, name, email, address, phone);
        companyCrud.getCompanyById(id);
    }

    @Test
    @Description("Deleting a company")
    public void deleteCompany() {
        int id = 6;

        companyCrud.getCompanyById(id);
        companyCrud.deleteCompany(id);
        companyCrud.getCompanyById(id);
    }
}

