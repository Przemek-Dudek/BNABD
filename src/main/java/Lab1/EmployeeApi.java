package Lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
    private EmployeeManager employeeManager;

    @Autowired
    public EmployeeApi(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/all")
    public Iterable<Employee> getAll() {
        return employeeManager.findAll();
    }

    @GetMapping("/id") //localhost:7777/api/employees/id?id=4
    public Optional<Employee> getById(@RequestParam Long id) {
        return employeeManager.findById(id);
    }

    @GetMapping(value = "/{employeeId}") //localhost:7777/api/employees/4
    public Optional<Employee> getId(@PathVariable("employeeId") Long employeeId) {
        return employeeManager.findById(employeeId);
    }

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeManager.save(employee);
    }

    @PutMapping("/upd")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeManager.save(employee);
    }

    @DeleteMapping("/del")
    public void deleteEmployee(@RequestParam Long id) {
        employeeManager.deleteById(id);
    }
}
