package com.example.UC9EmployeePayroll;



import com.example.UC9EmployeePayroll.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
