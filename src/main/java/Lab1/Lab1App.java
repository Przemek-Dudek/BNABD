package Lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Lab1App {
    public static void main(String[] args) {
        SpringApplication.run(Lab1App.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(Lab1App.class);

    @Bean
    public CommandLineRunner runner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            Employee janusz = new Employee("Janusz", "Nowakowski", new BigDecimal(2000), LocalDate.of(2024, 4, 4));
            Employee joanna = new Employee("Joanna", "Laskowska", new BigDecimal(4000), LocalDate.of(2022, 8, 20));
            Employee anna = new Employee("Anna", "Kowalska", new BigDecimal(3000), LocalDate.of(2021, 1, 12));
            Employee tomasz = new Employee("Tomasz", "Kowalski", new BigDecimal(5000), LocalDate.of(2020, 11, 19));

            employeeRepository.save(janusz);
            employeeRepository.save(joanna);
            employeeRepository.save(anna);
            employeeRepository.save(tomasz);


            //Zad 1
            System.out.printf("ZAD1\n");

            System.out.println("Customers found with findAll():");
            System.out.println("Id\tName\tLastName\tSalary\tEmployment date");
            employeeRepository.findAll().forEach(Employee::print);

            System.out.printf("\n");

            System.out.println("Customers found with findByFirstName(Janusz):");
            System.out.println("Id\tName\tLastName\tSalary\tEmployment date");
            employeeRepository.findByFirstName("Janusz").forEach(Employee::print);

            //Zad 2
            System.out.printf("\nZAD 2\n");

            System.out.println("Customers found with lastname starting with letter 'K'");
            System.out.println("Id\tName\tLastName\tSalary\tEmployment date");
            employeeRepository.findAllWhereNameLike("K%").forEach(Employee::print);

            //Zad 3
            System.out.printf("\nZAD 3\n");

            Department marketing = new Department("Marketing");
            Department hr = new Department("HR");

            departmentRepository.save(marketing);
            departmentRepository.save(hr);

            marketing.addEmployee(janusz);
            marketing.addEmployee(anna);
            hr.addEmployee(joanna);
            hr.addEmployee(tomasz);

            departmentRepository.save(marketing);
            departmentRepository.save(hr);

            departmentRepository.findAll().forEach(Department::print);


            departmentRepository.deleteAll();
            employeeRepository.deleteAll();
        };
    }
}
