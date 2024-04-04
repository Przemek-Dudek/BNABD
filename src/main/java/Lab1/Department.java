package Lab1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDept;

    private String dName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Long getIdDept() {
        return idDept;
    }

    protected Department() {}

    public Department(String dName) {
        this.dName = dName;
        employees = new ArrayList<>();
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void print() {
        System.out.println("Department name: " + this.dName);
        employees.forEach(Employee::print);
    }
}
