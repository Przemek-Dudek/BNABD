package Lab1;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository  extends CrudRepository<Department, Long> {
    Department findDepartmentBydName(String dName);
}
