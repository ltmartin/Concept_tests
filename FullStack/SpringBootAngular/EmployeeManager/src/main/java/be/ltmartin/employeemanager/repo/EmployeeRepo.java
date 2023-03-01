package be.ltmartin.employeemanager.repo;

import be.ltmartin.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(Long id);

    @Transactional
    void deleteEmployeeById(Long id);
}
