package be.ltmartin.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagerApplication {

    public static void main(String[] args) {
        System.out.println("Corrio");
        SpringApplication.run(EmployeeManagerApplication.class, args);
    }

}
